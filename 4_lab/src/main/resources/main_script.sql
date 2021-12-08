SET foreign_key_checks = 0;

CREATE DATABASE IF NOT EXISTS rizhko;
USE rizhko;


DROP TABLE IF EXISTS aircraft;
DROP TABLE IF EXISTS airport;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS flights;
DROP TABLE IF EXISTS model;
DROP TABLE IF EXISTS pilot;

create table aircraft
(
	id_aircraft int auto_increment primary key,
    company_id int null,
	expiration_date date not null,
	date_of_commissioning date not null,
    model_id int null
) Engine InnoDB;

create table airport
(
	id_airport int auto_increment primary key,
	`name` varchar(45) not null,
    city_id int not null
) engine InnoDB;

create table city
(
	id_city int auto_increment primary key,
	`name` varchar(30) not null,
	country varchar(45) not null,
	post_number varchar(15) not null,
	year_of_foundation char(4) null
) engine InnoDB;

create table company
(
	id_company int auto_increment primary key,
	year_of_foundation char(4) not null,
    city_id int not null
) engine InnoDB;

create table flights
(
	flight_number int auto_increment primary key,
    aircraft_id int null,
	departure_time datetime null,
	arrival_time datetime null,
    arrival_airport_id int null,
    departure_airport_id int null
) engine InnoDB;

create table model
(
	id_model int auto_increment primary key,
    `name` varchar(20) not null,
	max_speed varchar(45) not null,
	passenger_capacity int not null,
	width varchar(45) not null,
	length varchar(45) not null,
	height varchar(45) not null
) engine InnoDB;

create table pilot
(
	id_pilot int auto_increment primary key,
    aircraft_id int null,
    company_id int null,
    `name` varchar(45) not null,
    licence_number varchar(45) not null,
    surname varchar(45) not null,
    year_of_employment char(4) not null
) engine InnoDB;






alter table aircraft
	add constraint FK_aircraft_company
    foreign key (company_id)
    references company (id_company),
    
    add constraint FK_aircraft_model
    foreign key (model_id)
    references model (id_model);
    
alter table airport
	add constraint FK_airport_city
    foreign key (city_id)
    references city (id_city);
    
alter table company
	add constraint FK_company_city
    foreign key (city_id)
    references city (id_city);
    
alter table flights
	add constraint FK_flights_aircraft
    foreign key (aircraft_id)
    references aircraft (id_aircraft),
    
    add constraint FK_flights_arrival_airport
    foreign key (arrival_airport_id)
    references airport (id_airport),
    
    add constraint FK_flights_departure_airport
    foreign key (departure_airport_id)
    references airport (id_airport);
    
alter table pilot
	add constraint FK_pilot_aircraft
    foreign key (aircraft_id)
    references aircraft (id_aircraft),
    
    add constraint FK_pilot_company
    foreign key (company_id)
    references company (id_company);
    



insert into model(`name`, max_speed, passenger_capacity, width, length, height) values
	('Arc-101', '50 miles/hour', 50, '20 metres', '40 metres', '5 metres'),
	('Arc-102', '60 miles/hour', 50, '20 metres', '40 metres', '5 metres'),
	('Arc-103', '70 miles/hour', 50, '20 metres', '40 metres', '5 metres'),
	('Arc-106', '72 miles/hour', 50, '20 metres', '40 metres', '5 metres'),
	('Mah-101', '23 miles/hour', 40, '20 metres', '30 metres', '5 metres'),
	('Mah-102', '34 miles/hour', 40, '20 metres', '30 metres', '5 metres'),
	('Mah-103', '40 miles/hour', 40, '20 metres', '30 metres', '5 metres'),
	('Lor-101', '90 miles/hour', 20, '20 metres', '35 metres', '5 metres'),
	('Lor-201', '150 miles/hour', 20, '20 metres', '35 metres', '5 metres'),
	('Lor-104', '100 miles/hour', 20, '20 metres', '35 metres', '5 metres');
    
insert into city(`name`, country, post_number, year_of_foundation) values
	('Lviv', 'Ukraine', '79000', '1256'),
	('Kyiv', 'Ukraine', '80000', '0482'),
	('Copenhagen', 'Denmark', '00000', '2132'),
	('Avalon', 'England', '00400', '0000'),
	('Wales', 'England', '00400', '0000'),
	('Madrid', 'Spain', '00420', '0300'),
	('Avalon', 'England', '00400', '0000'),
	('Avalon', 'England', '00400', '0001'),
	('Paris', 'France', '00200', '0100'),
	('Avalon', 'England', '00400', '0000');
    
insert into company(year_of_foundation, city_id) values
	('1991', 1),
	('1994', 2),
	('1990', 3),
	('1891', 3),
	('1971', 7),
	('1973', 10),
	('2001', 6),
	('2020', 5),
	('2019', 4),
	('1758', 8);
    
insert into airport(`name`, city_id) values
	('Galytskyi', 1),
	('Shevshenko', 2),
	('Traktora', 3),
	('International', 4),
	('Paradox', 5),
	('Apple', 6),
	('Microsoft', 7),
	('SpaceX', 8),
	('Roshen', 9),
	('Nice', 10);


insert into aircraft(expiration_date, date_of_commissioning, model_id, company_id) values
	('2011-01-01', '2001-01-10', 1, 3),
	('2011-02-01', '2001-01-09', 2, 3),
	('2011-03-01', '2001-01-08', 3, 4),
	('2011-04-01', '2001-01-07', 4, 5),
	('2011-05-01', '2001-01-06', 5, 5),
	('2011-06-01', '2001-01-05', 6, 3),
	('2011-07-01', '2001-01-04', 7, 2),
	('2011-08-01', '2001-01-03', 8, 3),
	('2011-09-01', '2001-01-02', 9, 10),
	('2011-10-01', '2001-01-01', 10, 7);

insert into flights(departure_time, arrival_time, arrival_airport_id, departure_airport_id) values
	('2010-12-05 15:32:21', '2010-12-06 15:32:21', 1, 2),
	('2010-12-01 15:32:21', '2010-12-06 15:32:21', 7, 2),
	('2010-12-03 15:32:21', '2010-12-06 15:32:21', 3, 5),
	('2010-11-15 15:32:21', '2010-12-08 15:32:21', 1, 6),
	('2010-11-30 15:32:21', '2010-12-08 15:32:21', 10, 2),
	('2010-11-12 15:32:21', '2010-12-03 15:32:21', 1, 2),
	('2010-11-22 15:32:21', '2010-12-02 15:32:21', 5, 4),
	('2010-11-05 15:32:21', '2010-12-01 15:32:21', 2, 7),
	('2010-11-25 15:32:21', '2010-12-02 15:32:21', 1, 3),
	('2010-11-05 15:32:21', '2010-12-01 15:32:21', 9, 8);

insert into pilot(`name`, licence_number, surname, year_of_employment, aircraft_id, company_id) values
	('Oleg', '30010023', 'Param', '2003', 1, 1),
	('Ostap', '30010024', 'Rizhko', '2003', 2, 2),
	('Bogdan', '30010025', 'Diduh', '2003', 3, 5),
	('Yeva', '30010026', 'Car', '2003', 4, 9),
	('Yaroslav', '30010027', 'Lys', '2003', 5, 1),
	('Maks', '30010028', 'Demk', '2003', 6, 6),
	('Marko', '30010029', 'Kruchok', '2003', 7, 1),
	('Pavlo', '30010030', 'Tanos', '2003', 8, 8),
	('Vika', '30010031', 'Arto', '2003', 9, 6),
	('Kate', '30010032', 'Teres', '2003', 10, 2);

