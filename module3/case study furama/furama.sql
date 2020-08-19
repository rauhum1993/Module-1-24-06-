drop database if exists furama;
create database furama;
use furama;

create table location (
	locatinon_id int primary key,
	location_name varchar(45)
);

 create table staff_level (
	level_id int primary key,
    level_name varchar (45)
); 

create table part (
	part_id int primary key,
    part_name varchar (45)
);

create table staff (
	staff_id int primary key,
    staff_name varchar (45),
    locatinon_id int ,
    foreign key (locatinon_id) references location(locatinon_id),
    level_id int,
    foreign key (level_id) references staff_level(level_id),
    part_id int,
    foreign key (part_id) references part(part_id),
    staff_birthday date,
    staff_id_card varchar(45),
    salary double,
    phone_number varchar(45),
    staff_address varchar(45)
);

create table customer_type (
	customer_type_id int primary key,
    customer_type_name varchar (45)
);

create table customer (
	customer_id int primary key,
    customer_type_id int,
	foreign key (customer_type_id) references customer_type(customer_type_id),
	customer_name varchar (45),
    customer_birthday date,
    customer_id_card varchar(45),
    customer_phone_number varchar(45),
    customer_email varchar(45),
    customer_address varchar(45)
);

create table rental_type (
	rental_type_id int primary key,
    rental_type_name varchar (45),
    price int
);

create table service_type (
	service_type_id int primary key,
    service_type_name varchar (45)
);

create table service (
	service_id int primary key,
    service_name varchar (45),
    the_area int,
    floor_number int,
    people_number int,
    rental_cost int,
    rental_type_id int,
    foreign key (rental_type_id) references rental_type(rental_type_id),
    service_type_id int,
	foreign key (service_type_id) references service_type(service_type_id),
    service_status varchar(45)
);

create table accompanied_service (
	accompanied_service_id int primary key,
	accompanied_service_name varchar (45),
	price int,
    accompanied_service_amount int,
    availability  varchar (45)
);

create table contract (
	contract_id int primary key,
	staff_id int ,
	foreign key (staff_id) references staff(staff_id),
	customer_id int,
	foreign key (customer_id) references customer(customer_id),
    service_id int,
    foreign key (service_id) references service(service_id),
    contracting_date date,
    end_date date,
    down_payment double,
    total_money double
);

create table contract_details (
	contract_details_id int primary key,
	contract_id int,
	foreign key (contract_id) references contract(contract_id),
	accompanied_service_id int,
    foreign key (accompanied_service_id) references accompanied_service(accompanied_service_id),
    contract_details_amount int
);






