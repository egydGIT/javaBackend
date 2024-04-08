/*
AltGr7 : `azonosito` 
Shift1:  'adat'

F9 - futtatás
Ctrl F9 - kijelölt futtatása

F5 - frissítés
*/

CREATE DATABASE `tagdij`;																/* tagdij adatbázis létrehozás: */

USE `tagdij`;


/* befiz tábla:
 azon azonosito ami egyedileg azonsitja a befizetot SZAM
 datum eeee.ho.nap. oo:pp:mm
 osszeg SZAM
 --> utólag: `ugyfel_azon`
*/

CREATE TABLE `befiz` (  																/* befiz tábla + oszlop fejlécek létrehozása */
	`azon` INT(10) UNSIGNED NOT NULL,
	`datum` DATETIME NOT NULL,
	`osszeg` INT(10) UNSIGNED NOT NULL
);

ALTER TABLE `befiz` ADD `ugyfel_azon` INT(10) UNSIGNED NOT NULL;			            /* befiz tábla módosítás, oszlop hozzáadás */

/*DROP TABLE `befiz`;*/																	/* befiz tábla törlése */

SELECT * FROM `befiz`;																	/* befiz tábla kiíratás 'konzolra' */
																						/* befiz tábla minden oszlopának kiválasztása */

INSERT INTO `befiz` VALUES (1001, '2010.12.05 16:15:25', 60000, 9001); /*Otto*/			/* befiz tábla feltöltése adatokkal */
INSERT INTO `befiz` VALUES (1002, '2010.12.05 16:15:25', 5000, 9001);  /*Otto*/
INSERT INTO `befiz` VALUES (1003, '2010.12.06 16:15:25', 6000, 9002);  /*Agi*/
INSERT INTO `befiz` VALUES (1004, '2010.10.08 16:00:25', 160000, 9006); /*Marci*/
INSERT INTO `befiz` VALUES (1005, '2011.10.10 16:15:25', 6000, 9004); /*Peter*/

UPDATE `befiz` SET `ugyfel_azon` = 9009 WHERE `azon` = 1001 OR `azon` = 1002;			/* befiz táblában cella módosítás */

/*DELETE FROM `tagdij`.`befiz` WHERE  `azon`=1001 AND `datum`='2010-12-05 16:15:25' AND `osszeg`=60000 LIMIT 1;*/       /* adott sor törlése */
/*DELETE FROM `befiz` WHERE 1;*/																						/* összes sor törlése */



/* ugyfel tábla:																			
  azon egyedi azonositja a befizetot SZAM 10
  nev STRING 30
*/

/*
1001, 'Otto'
1002, 'Agi'
1003, 'Tamas'
*/


CREATE TABLE `ugyfel` (															/* ugyfel tábla létrehozás */
	`azon` INT(10) UNSIGNED NOT NULL,
	`nev` VARCHAR(30) NOT NULL
);

SELECT * FROM `ugyfel`;

INSERT INTO `ugyfel` VALUES (9001, 'Otto');
INSERT INTO `ugyfel` VALUES (9002, 'Agi');
INSERT INTO `ugyfel` VALUES (9004, 'Peter');
INSERT INTO `ugyfel` VALUES (9005, 'Tamas');
INSERT INTO `ugyfel` VALUES (9006, 'Marci');

SELECT * FROM `befiz`;															/* 1. befiz tábla - minden oszlopának kiválasztása */
SELECT `azon`, `osszeg` FROM `befiz`;										    /* 2.	   			- biz. oszlopának kiválasztása -> oszlopra szűr*/
SELECT `azon`, `osszeg` FROM `befiz` WHERE `osszeg` > 10000;		            /* 2...ahol összeg nagyobb, mint 10e -> sorra és oszlopra szűr*/
SELECT * FROM `befiz` WHERE `osszeg` < 10000;							        /* 1...ahol összeg kisebb, mint 10e */
SELECT * FROM `befiz` WHERE `osszeg` < 10000 AND `azon` = 1005 OR `azon` = 1003;
SELECT `azon`, `osszeg`  FROM `befiz` WHERE `osszeg` < 10000 AND `azon` = 1005 OR `azon` = 1003;
/*     oszlop neve             tábla        szűrő feltételek */

/*Lekerdesezhez hasznos fuggvenyek*/
SELECT COUNT(azon) FROM `befiz`;                                    /*sorok összeszámolása - csak ha adott oszlop: NOT NULL*/
SELECT COUNT(azon) FROM `befiz` WHERE `osszeg` < 10000;				/*összeszámol - aggregáló fv.*/
SELECT SUM(osszeg) FROM `befiz` WHERE `osszeg` < 10000;				/*összead*/
SELECT AVG(osszeg) FROM `befiz` WHERE `osszeg` < 10000;				/*átlagol*/
SELECT MAX(osszeg) FROM `befiz` WHERE `osszeg` < 10000;
SELECT MIN(osszeg) FROM `befiz` WHERE `osszeg` < 10000;
SELECT MIN(osszeg) AS `minimum`, MAX(osszeg) AS `maximum` FROM `befiz`;     /* AS: alias, álnév */

SELECT * FROM `befiz` WHERE `osszeg` < 10000 AND `azon` <= 1003;
SELECT * FROM `befiz` WHERE `osszeg` < 10000 OR `azon` <= 1003;

SELECT * FROM `befiz` ORDER BY `datum` DESC;								/*sorba rendez - csökk*/
SELECT * FROM `befiz` GROUP BY `datum` ORDER BY `datum` DESC;               /*csoportosít --> feltételek sorrendje!!*/
SELECT * FROM `befiz` WHERE `osszeg` < 10000 GROUP BY `osszeg`;
SELECT * FROM `befiz` WHERE `datum` LIKE '2010-12-05%';                     /*keresés hasonlóság alapján: % */
SELECT * FROM `befiz` WHERE `datum` LIKE '%10-10%' AND `datum` NOT LIKE '2010%';


