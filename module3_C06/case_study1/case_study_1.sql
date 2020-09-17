drop database if exists furama_resort;
create database furama_resort;
use furama_resort;

-- 1. Tạo bảng vị trí nhân viên
create table role(
	role_id int primary key,
    role_name varchar(45) not null
);

-- 2. Tạo bảng trình độ nhân viên
create table level(
	level_id int primary key,
    level_name varchar(45) not null
);

-- 3. Tạo bảng bộ phận của nhân viên
create table part(
	part_id int primary key,
    part_name varchar(45) not null
);

-- 4. Tạo bảng  nhân viên
create table staff(
	staff_id int primary key,
    staff_name varchar(45) not null,
	role_id int,
    foreign key (role_id) references role(role_id) on delete cascade ,
	level_id int ,
	foreign key (level_id) references level(level_id) on delete cascade,
	part_id int	,
    foreign key (part_id) references part(part_id) on delete cascade,
    birthday date,
	id_card varchar(45) not null,
    salary varchar(45) not null,
	phone_number  varchar(45) not null,
	email  varchar(45) not null,
	address  varchar(45) not null
);

-- 5. Tạo bảng loại khách hàng
create table type_customer(
	type_customer_id int primary key,
    type_customer_name varchar(45) not null
);

-- 6. Tạo bảng khách hàng
create table customer(
	customer_id int primary key,
    type_customer_id int ,
	foreign key (type_customer_id) references type_customer(type_customer_id) on delete cascade,
    customer_name varchar(45) not null,
    birthday date not null,
    id_card varchar(45) not null,
    phone_number varchar(45) not null,
    email varchar(45) not null,
    address varchar(45) not null
);

-- 7. Tạo bảng kiểu thuê
create table rent_type(
	rent_type_id int primary key,
    rent_type_name varchar(45) not null,
    rent_type_price int not null
);

-- 8. Tạo bảng loại dịch vụ
create table type_service(
	type_service_id int primary key,
	type_service_name varchar(45) not null
  
);

-- 9. Tạo bảng dịch vụ
create table service(
	service_id int primary key,
	service_name varchar(45) not null,
    the_area int not null,
    floors int not null,
    max_people varchar(45) not null,
    rental_costs varchar(45) not null,
    rent_type_id int ,
    foreign key (rent_type_id) references rent_type(rent_type_id) on delete cascade,
    type_service_id int,
	foreign key (type_service_id) references type_service(type_service_id) on delete cascade,
     status varchar(45) not null
);

-- 10. Tạo bảng dịch vụ đi kèm
create table accompanied_service(
	accompanied_service_id int primary key,
	accompanied_service_name varchar(45) not null,
    price int not null,
    numbers int not null,
    availability varchar(45) not null
  
);
-- 11. Tạo bảng hợp đồng
create table contract(
	contract_id int primary key,
	staff_id int ,
    foreign key (staff_id) references staff(staff_id) on delete cascade,
	customer_id int ,
    foreign key (customer_id) references customer(customer_id) on delete cascade,
	service_id int ,
    foreign key (service_id) references service(service_id) on delete cascade,
	contracting_date date not null,
	end_date date not null,
    deposits int not null,
    total_money int not null
    
);

-- 12. Tạo bảng hợp đồng chi tiết
create table contract_details(
	contract_details_id int primary key,
    contract_id int ,
	foreign key (contract_id) references contract(contract_id) on delete cascade,
    accompanied_service_id int ,
	foreign key (accompanied_service_id) references accompanied_service(accompanied_service_id) on delete cascade,
    numbers int not null
);

