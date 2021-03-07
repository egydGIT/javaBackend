create schema if not exists activitytracker default character set utf8 collate UTF8_HUNGARIAN_CI;

create user 'activitytracker'@'localhost' identified by 'activitytracker';
grant all on *.* to 'activitytracker'@'localhost'; 

CREATE TABLE `activities` (
	id BIGINT AUTO_INCREMENT,
	start_time TIMESTAMP, 
	activity_desc VARCHAR(255), 
	activity_type VARCHAR(255), 
	PRIMARY KEY (id)
);

SELECT * FROM `activities`; 

DROP TABLE `activities`;

-- DELETE FROM `activities` WHERE 1;
