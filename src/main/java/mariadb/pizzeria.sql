CREATE DATABASE `pizzeria`;

USE `pizzeria`;



CREATE TABLE `pizza` (                          -- megszorítások:
	`pizza_id` INT NOT NULL,
	`pizza_name` VARCHAR(100) NOT NULL UNIQUE,      -- nem lehet ismétlődés
	`pizza_price` FLOAT NOT NULL,                   -- nem lehet null érték
	PRIMARY KEY (`pizza_id`)                        -- elsődleges kulcs
);
-- AUTO_INCREMENT: db generál azonosítót
-- DEFAULT: alapértelmezett érték
-- CHECK: bevitt adat ellenőrzése
-- INDEX: oszlopokra lehet tenni, gyorsítótáras kereséshez
-- FOREIGN KEY:

SELECT * FROM `pizza`;

INSERT INTO `pizza` VALUES(1001, 'margherita', 1500.00);
INSERT INTO `pizza` VALUES(1002, 'sonkás', 1700.00);      -- nem rendelték még
INSERT INTO `pizza` VALUES(1003, 'négysajtos', 1830.00);
INSERT INTO `pizza` VALUES(1004, 'sonka-gomba', 1970.00);
INSERT INTO `pizza` VALUES(1005, 'tonhalas', 1950.00);
INSERT INTO `pizza` VALUES(1006, 'vegetáriánus', 1300.00);



CREATE TABLE `customers` (
	`customer_id` INT NOT NULL, 
	`customer_name` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`customer_id`)
);

SELECT * FROM `customers`;

INSERT INTO `customers` VALUES(9001, 'Mici Mackó');
INSERT INTO `customers` VALUES(9002, 'Róbert Gida');
INSERT INTO `customers` VALUES(9003, 'Tigris');
INSERT INTO `customers` VALUES(9004, 'Bagoly');
INSERT INTO `customers` VALUES(9005, 'Malacka');  -- nem rendelt még




CREATE TABLE `order` (
	`order_id` INT NOT NULL, 
	`customer_id` INT NOT NULL, 
	`pizza_id` INT NOT NULL, 
	`order_date` DATE, 
	PRIMARY KEY (`order_id`)
);

SELECT * FROM `order`;

INSERT INTO `order` VALUES (3001, 9004, 1006, '2021.02.15');
INSERT INTO `order` VALUES (3002, 9003, 1004, '2021.02.16');
INSERT INTO `order` VALUES (3003, 9001, 1001, '2021.02.20');
INSERT INTO `order` VALUES (3004, 9004, 1003, '2021.02.20');
INSERT INTO `order` VALUES (3005, 9002, 1005, '2021.02.20');
INSERT INTO `order` VALUES (3006, 9001, 1003, '2021.02.25');
INSERT INTO `order` VALUES (3007, 9003, 1006, '2021.02.26');
INSERT INTO `order` VALUES (3008, 9003, 1008, '2021.03.02');  -- nincs ilyen pizza
INSERT INTO `order` VALUES (3009, 9007, 1001, '2021.03.04');  -- nincs ilyen customer



/* Írj lekérdezéseket a következőkre: */
--Listázd ki az összes vásárlót név szerint csökkenősorrendben! 
SELECT * FROM `customers` ORDER BY `customer_name` DESC; 

--Listázd ki az összes vásárlót, de csak a nevüket, az azonosítójuk nem kell. 
SELECT `customer_name` FROM `customers`; 

--Listázd ki a pizzákat áruk szerint emelkedősorrendben! 
SELECT * FROM `pizza` ORDER BY `pizza_price` ASC ; 

--Listázd ki a legdrágább pizzát! 
SELECT * FROM `pizza` 
	WHERE `pizza_price` = 
		(SELECT MAX(`pizza_price`) FROM `pizza`);
		
SELECT `pizza_name`, MAX(`pizza_price`) FROM `pizza` ;  /* nem jó */

SELECT * FROM `pizza` ORDER BY `pizza_price` DESC LIMIT 1; /* sorrendezi + limit*/ 


--       JOIN 
-- A ---> C <--- B   adatok két külön táblában 
-- a.id <---> b.id	sorokat egymáshoz kell rendelni
-- 001 <-----> 001	illesztési oszlop mentén A tabla sorait hozzárendeli B tábla soraihoz

-- INNER - kettő metszete
-- lEFT - bal oldalihoz bővítjük a jobb oldali táblát, balból minden benne van, jobból csak ami balhoz rendelhető
-- RIGHT 
-- FULL OUTHER JOIN

--          JOIN 
-- pizza ---> C <--- order
-- pizza.id <---> pizza.id
-- 1001 <-----------> 1001

SELECT * FROM `pizza` AS p  
	RIGHT JOIN `order` AS o 
		ON p.pizza_id = o.pizza_id; 

SELECT * FROM `pizza` WHERE pizza_price > 1750
	UNION 																		-- FULL OUTHER JOIN helyett
		SELECT * FROM `pizza` WHERE pizza_name LIKE '%a%';                          -- mindkét táblában meglévő adatot egyszer
                                                                                    -- csak az egyik táblában meglévőt is egyszer

SELECT * FROM `pizza` AS p  
	LEFT JOIN `order` AS o 
		ON p.pizza_id = o.pizza_id 
UNION ALL                                                                           -- mindkét táblában meglévő adatot kétszer is kiírja
SELECT * FROM `pizza` AS p                                                          -- csak az egyik táblában meglévőt is egyszer
	RIGHT JOIN `order` AS o 
		ON p.pizza_id = o.pizza_id; 
		
SELECT pizza_price, pizza_name FROM 
	(`pizza` AS p  JOIN `order` AS o 
		ON p.pizza_id = o.pizza_id)
		ORDER BY pizza_price desc LIMIT 1;

--Átlagosan mekkora értékben rendeltek az emberek? 
SELECT AVG(p.pizza_price) FROM `pizza` AS p JOIN `order` AS o ON p.pizza_id = o.pizza_id;
SELECT AVG(p.pizza_price) FROM `pizza` p , `order` o WHERE p.pizza_id = o.pizza_id;

--Számold meg, mennyi vásárló van, akinek a nevében van ’a’ betű! 
SELECT COUNT(`customer_name`)  FROM `customers` WHERE `customer_name` LIKE '%a%';

--Listázd ki azokat a pizzákat, amik 1700 forintnál drágábbak vagy van a nevükben ’a’ betű. 
SELECT `pizza_name`, `pizza_price` FROM `pizza` WHERE `pizza_price` > 1700.00 OR `pizza_name` LIKE '%a%';

--Listázd ki az emberek neveit, akik pizzát rendeltek, és azt, hogy mikor rendelték a pizzát. 
SELECT customer_name, order_date FROM `customers` AS c JOIN `order` AS o ON c.customer_id = o.customer_id;

--Listázd ki a pizzarendelések dátumát és azt, hogy melyik dátumon milyen nevűpizzát rendeltek! 
SELECT order_date, pizza_name FROM `order` AS o JOIN `pizza` AS p ON o.pizza_id = p.pizza_id;



