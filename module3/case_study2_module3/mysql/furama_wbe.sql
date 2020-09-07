drop database if exists furama_wbe;
create database furama_wbe;
use furama_wbe;

create table role (
		role_id int primary key,
        role_name varchar(255)
    );
create table user (
		username varchar(255) primary key,
        password varchar(255)
    );
create table user_role (
		role_id int ,
        foreign key (role_id) references furama_wbe.role(role_id),
        username varchar(255),
		foreign key (username) references furama_wbe.user(username)
    );    
    
create table position (
		position_id int primary key,
        position_name varchar(45)
    );
create table education_degree(
	education_degree_id int primary key,
    education_degree_name varchar(45)
);    
create table division(
	division_id int,
    division_name varchar(45)
);    

create table employee(
	employee_id int primary key auto_increment,
	employee_name varchar(45),
    employee_birthday date,
    employee_salary double,
    employee_id_card varchar(45),
	employee_phone varchar(45),
    employee_email varchar(45),
    employee_address varchar(45),
    position_id int,
	foreign key (position_id) references furama_wbe.position(position_id),
	education_degree_id int,
    foreign key (education_degree_id) references furama_wbe.education_degree(education_degree_id),
    division_id int,
    foreign key (division_id) references furama_wbe.division(division_id),
	username varchar(255),
	foreign key (username) references furama_wbe.user(username)
);    

create table customer_type (
		customer_type_id int primary key,
        customer_type_name varchar(45)
    );
    
create table customer (
		customer_id int primary key,
        customer_type_id int,
		foreign key (customer_type_id) references furama_wbe.customer_type(customer_type_id),
        customer_name varchar(45),
        customer_birthday date,
        customer_gender bit(1),
        customer_id_card varchar(45),
        customer_phone varchar(45),
        customer_email varchar(45),
        customer_address varchar(45)

    );
    
    create table service_type (
		service_type_id int primary key,
        service_type_name varchar(45)
    );
     create table rent_type (
		rent_type_id int primary key,
        rent_type_name varchar(45),
        rent_type_cost double
    );
    create table service (
		service_id int primary key,
        service_name varchar(45),
        service_area int,
        service_cost double,
        service_max_people int,
        rent_type_id int,
        foreign key (rent_type_id) references furama_wbe.rent_type(rent_type_id),
        service_type_id int,
		foreign key (service_type_id) references furama_wbe.service_type(service_type_id),
        standard_room varchar(45),
        description_orther_convenienve varchar(45),
        pool_area double,
        number_of_floors int
    );

 create table attach_service (
		attach_service_id int primary key,
        attach_service_name varchar(45),
        attach_service_cost double,
        attach_service_unit int,
        attach_service_status va
    );