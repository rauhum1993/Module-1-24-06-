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
    foreign key (role_id) references role(role_id) on delete cascade,
	level_id int ,
	foreign key (level_id) references level(level_id) on delete cascade,
	part_id int	,
	foreign key (part_id) references part(part_id) on delete cascade,
    birthday date not null,
    id_card varchar(45) not null ,
    salary int not null,
    phone_number varchar(45) not null,
    email varchar(45) not null,
    address varchar(45) not null
);

create table type_customer(
	type_customer_id int primary key,
    type_customer_name varchar(45) not null
);
create table customer(
	customer_id int primary key,
    type_customer_id int ,
    foreign key (type_customer_id) references type_customer(type_customer_id) on delete cascade,
    name_customer varchar(45) not null,
    birthday date not null,
    id_card  varchar(45) not null,
    phone_number  varchar(45) not null,
    email  varchar(45) not null,
    address  varchar(45) not null
);

create table rental_type(
	rental_type_id int primary key,
    rental_type_name varchar(45) not null,
    price int not null
);
create table type_service(
	type_service_id int primary key,
    type_service_name varchar(45) not null
);
create table service(
	service_id int primary key,
    service_name varchar(45) not null,
    the_area int not null,
    floors int not null,
    max_people int not null,
    rental_costs int not null,
    rental_type_id int,
	foreign key (rental_type_id) references rental_type(rental_type_id) on delete cascade,
    type_service_id int,
	foreign key (type_service_id) references type_service(type_service_id) on delete cascade,
    status varchar(45) not null
);

create table accompanied_service(
	accompanied_service_id int primary key,
    accompanied_service_name varchar(45) not null,
    price_accompanied_service int not null,
    numbers int not null,
    availability varchar(45) not null
    
);

create table contract(
	contract_id int primary key,
	staff_id int,
    foreign key (staff_id) references staff(staff_id) on delete cascade,
	customer_id int ,
    foreign key (customer_id) references customer(customer_id) on delete cascade,
    service_id int,
    foreign key (service_id) references service(service_id) on delete cascade,
	contracting_date date not null,
	end_date date not null,
    deposits int not null,
    total_money int not null
);

create table detailed_contract(
	detailed_contract_id int primary key,
	contract_id int,
	foreign key (contract_id) references contract(contract_id) on delete cascade,
    accompanied_service_id int,
    foreign key (accompanied_service_id) references accompanied_service(accompanied_service_id) on delete cascade,
    numbers int not null
);

