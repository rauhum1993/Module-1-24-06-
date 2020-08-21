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

-- Add new location--
insert into furama.location (locatinon_id,location_name)
values (1, 'giám đốc') ,
 (2, 'quản lý') ,
 (3, 'giám sát'),
 (4, 'chuyên viên'),
 (5, 'phục vụ'),
 (6, 'lễ tân');
 
 --  Add new staff_level-- 
 insert into furama.staff_level(level_id,level_name) 
 values (1, 'sau đại học'),
  (2, ' đại học'),
  (3, ' cao đẳng'),
  (4,'trung cấp');
 

  -- Add new part-- 
  insert into furama.part(part_id,part_name)
  values (1,'quản lý'),
  (2, ' hành chính'),
  (3, ' sale - marketing'),
  (4, ' phục vụ');
  
  -- Add new staff --  
  insert into furama.staff(staff_id,staff_name,locatinon_id,level_id,part_id,staff_birthday,staff_id_card,salary,phone_number,staff_address)
  values (1,'Khanh',1,1,1,'1993/11/06',187320118,50000000,'0396692526','nghệ an'),
   (2,'Hải',2,1,1,'2000/11/06',18754260,30000000,'0236692526','hà tĩnh'),
   (3,'Tùng',2,2,3,'1996/11/06',18754260,30000000,'0236692526','hà tĩnh'),
   (4,'Hiên',3,4,4,'1986/06/06',18754260,30000000,'0236692526','hà tĩnh'),
   (5,'Đạt',3,4,4,'1986/06/06',18754260,30000000,'0236692526','hà tĩnh'),
   (6,'Hiền',3,4,4,'1986/06/06',18754260,30000000,'0236692526','hà tĩnh'),
   (7,'Mai',3,4,4,'1986/06/06',18754260,30000000,'0236692526','hà tĩnh'),
   (8,'Hà',3,4,4,'1986/06/06',18754260,30000000,'0236692526','hà tĩnh'),
   (9,'Phương Trinh',6,4,4,'1986/06/06',18754260,30000000,'0236692526','hà tĩnh'),
   (10,'Ngọc Trinh',6,4,4,'2000/11/06',18754260,30000000,'0236692526','hà tĩnh');

-- Add new customer_type-- 
insert into furama.customer_type(customer_type_id,customer_type_name) 
 values (1, 'Diamond'),
  (2, 'Platinium'),
  (3, 'Gold'),
  (4,'Silver'),
  (5,'Menber');
  
  -- Add new customer-- 
  
insert into furama.customer(customer_id,customer_type_id,customer_name,customer_birthday ,
	customer_id_card ,customer_phone_number,customer_email,customer_address) 
 values (1,1, 'Chương','1989/12/12','1862359256','0352623659','chuong3cay@xsmb.com','Quảng Trị'),
 (2,3, 'Hoàng','1993/06/12','1862359256','0352623659','hoangrapper@xsmb.com','Quảng Nam'),
 (3,1, 'Tùng','1995/12/12','1862359256','0352623659','tungvietlot@xsmb.com','Nghệ AN'),
 (4,3, 'Mai','1998/12/12','1862359256','0352623659','maithuy@xsmb.com','Quảng Ngãi'),
 (5,1, 'Hải','1994/12/12','1862359256','0352623659','quaytay@xsmb.com','Quảng Trị'),
 (6,2, 'Trung','1991/12/12','1862359256','0352623659','trungjava@xsmb.com','Đà Nẵng'),
 (7,4, 'Tiến','1999/12/12','1862359256','0352623659','tienbom@xsmb.com','Đà Nẵng');
 
-- Add new rental_type-- 
insert into furama.rental_type(	rental_type_id,rental_type_name ,price )
values('1', 'cặp đôi', '3000'),
('2', 'gia đình', '2000'),
('3', 'theo đoàn', '1000');

-- Add new service_type-- 
insert into furama.service_type(service_type_id,service_type_name )
values('1', 'villa'),
('2', 'house'),
('3', 'room');

-- Add new service-- 

insert into furama.service (service_id ,service_name ,the_area,floor_number,
people_number,rental_cost,rental_type_id,service_type_id,service_status)
values ('1', 'mer viila', '200', '3', '5', '100000', '1', '1', 'còn phòng'),
('2', 'king villa', '180', '3', '5', '90000', '2', '1', 'còn phòng'),
('3', 'beautifuly villa', '160', '3', '5', '80000', '3', '1', 'còn phòng'),
('4', 'luxury villa', '140', '3', '5', '70000', '2', '2', 'còn phòng'),
('5', 'fleur house', '120', '3', '5', '60000', '1', '2', 'còn phòng'),
('6', 'jhon house', '100', '3', '5', '50000', '2', '2', 'còn phòng'),
('7', 'ocean house', '80', '3', '5', '40000', '3', '3', 'còn phòng'),
('8', '301 room', '60', '3', '5', '30000', '1', '3', 'còn phòng'),
('9', '302 room', '55', '3', '5', '20000', '2', '3', 'còn phòng'),
('10', '303 room', '50', '3', '5', '10000', '3', '1', 'còn phòng'),
('11', '304 room', '50', '3', '5', '10000', '3', '1', 'còn phòng');

--  Add new accompanied_service-- 
insert into furama.accompanied_service (accompanied_service_id,accompanied_service_name,price,
accompanied_service_amount,availability)
values('1', 'massage', '300', '1', 'khả dụng'),
('2', 'karaoke ', '250', '1', 'khả dụng'),
('3', 'đồ ăn', '100', '1', 'khả dụng'),
('4', 'nước uống', '75', '1', 'khả dụng'),
('5', 'xe', '500', '1', 'khả dụng');

-- Add new contract-- 
insert into furama.contract(contract_id,staff_id,customer_id,service_id,contracting_date ,end_date,down_payment,total_money)
values('1', '1', '6', '1', '2020-12-12', '2020-12-30', '1000', '10000'),
('2', '1', '4', '1', '2020-12-12', '2020-12-30', '1000', '10000'),
('3', '1', '3', '1', '2018-12-12', '2020-12-30', '1000', '10000'),
('4', '6', '2', '1', '2019-12-12', '2020-12-30', '1000', '10000'),
('5', '6', '1', '2', '2020-12-12', '2020-12-30', '1000', '10000'),
('6', '6', '2', '2', '2020-12-12', '2020-12-30', '1000', '10000'),
('7', '6', '1', '2', '2020-12-12', '2020-12-30', '1000', '10000'),
('8', '1', '3', '3', '2018-12-12', '2020-12-30', '1000', '10000'),
('9', '1', '4', '3', '2019-12-12', '2020-12-30', '1000', '10000'),
('10', '1', '2', '3', '2020-12-12', '2020-12-30', '1000', '10000');

-- Add new contract_details-- 
insert into furama.contract_details(contract_details_id,contract_id,accompanied_service_id,contract_details_amount)
values('1', '1', '1', '1'),
('2', '2', '2', '2'),
('3', '3', '3', '3'),
('4', '4', '4', '1'),
('5', '5', '5', '2'),
('6', '6', '1', '3'),
('7', '7', '2', '1'),
('8', '8', '3', '2'),
('9', '9', '4', '3'),
('10', '10', '5', '1');


-- 2. hiển thị nhân viên bắt đầu bằng H,T,K tối đa 15 ký tự
select*from furama.staff
where staff_name LIKE ('K%') or staff_name LIKE ('H%') or staff_name LIKE ('T%') 
and  LENGTH(staff_name) <= 15;

-- 3.Hiển thị thông tin của tất cả khách hàng 
-- có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select*from furama.customer
where DATEDIFF(CURDATE(), customer.customer_birthday) / 365 between 18 and 50 
and 
customer_address in ('Đà Nẵng','Quảng Trị');

--  4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
--  Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
--  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select customer.customer_name , count(contract.contract_id) as 'number_of_reservations'
from  customer
right join contract on customer.customer_id = contract.contract_id
where customer.customer_id = 1
group by customer.customer_id;

