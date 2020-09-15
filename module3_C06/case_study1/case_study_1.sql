drop database if exists furama_resort;
create database furama_resort;
use furama_resort;

create table role(
	role_id int primary key,
    role_name varchar(45) not null
);
create table level(
	level_id int primary key,
    level_name varchar(45) not null
);
create table part(
	part_id int primary key,
    part_name varchar(45) not null
);

create table staff(
	staff_id int primary key,
	role_id int,
    foreign key (role_id) references role(role_id) ,
	level_id int ,
	foreign key (role_id) references role(role_id),
	part_id int	,
    staff_part varchar(45) not null,
    birthday date,
    staff_id_card varchar(45)
    
);

