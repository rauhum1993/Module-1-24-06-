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
    staff_email varchar (45),
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
	customer_name varchar (255),
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
-- 1.	Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.
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
  insert into furama.staff(staff_id,staff_name,locatinon_id,level_id,part_id,staff_birthday,staff_id_card,salary,phone_number,staff_email,staff_address)
  values (1,'Khanh',1,1,1,'1993/11/06',187320118,50000000,'khanh@xsmb.com','0396692526','nghệ an'),
   (2,'Hải',2,1,1,'2000/11/06',18754260,30000000,'0236692526','hai@xsmb.com','hà tĩnh'),
   (3,'Tùng',2,2,3,'1996/11/06',18754260,30000000,'0236692526','tungvietlot@xsmb.com','hà tĩnh'),
   (4,'Hiên',3,4,4,'1986/06/06',18754260,30000000,'0236692526','hien@xsmb.com','hà tĩnh'),
   (5,'Đạt',3,4,4,'1986/06/06',18754260,30000000,'0236692526','dat1994@xsmb.com','hà tĩnh'),
   (6,'Hiền',3,4,4,'1986/06/06',18754260,30000000,'0236692526','hienxam@xsmb.com','hà tĩnh'),
   (7,'Mai',3,4,4,'1986/06/06',18754260,30000000,'0236692526','maivanthuy@xsmb.com','hà tĩnh'),
   (8,'Hà',3,4,4,'1986/06/06',18754260,30000000,'0236692526','ha@xsmb.com','hà tĩnh'),
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
 (2,2, 'Hoàng','1993/06/12','1862359256','0352623659','hoangrapper@xsmb.com','Quảng Ngãi'),
 (3,1, 'Tùng','1995/12/12','1862359256','0352623659','tungvietlot@xsmb.com','Vinh'),
 (4,3, 'Mai','1998/12/12','1862359256','0352623659','maithuy@xsmb.com','Quảng Ngãi'),
 (5,2, 'Hải','1994/12/12','1862359256','0352623659','quaytay@xsmb.com','Quảng Trị'),
 (6,2, 'Trung','1991/12/12','1862359256','0352623659','trungjava@xsmb.com','Đà Nẵng'),
 (7,4, 'Tiến','1999/12/12','1862359256','0352623659','tienbom@xsmb.com','Đà Nẵng'),
 (8,5, 'Tuấn','1999/12/12','1862359256','0352623659','tienbom@xsmb.com','Đà Nẵng'),
 (79,5, 'Trung','1999/12/12','1862359256','0352623659','Hienbom@xsmb.com','Đà Nẵng');
 
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
values('1', 'massage', '300', '11', 'khả dụng'),
('2', 'karaoke ', '250', '6', 'khả dụng'),
('3', 'đồ ăn', '100', '15', 'khả dụng'),
('4', 'nước uống', '75', '5', 'khả dụng'),
('5', 'xe', '500', '9', 'khả dụng');

-- Add new contract-- 
insert into furama.contract(contract_id,staff_id,customer_id,service_id,contracting_date ,end_date,down_payment,total_money)
values('1', '1', '6', '1', '2020-12-12', '2020-05-30', '1000', '10000'),
('2', '1', '4', '1', '2020-03-12', '2020-12-30', '1000', '10000'),
('3', '1', '3', '1', '2018-04-12', '2020-08-30', '1000', '30000000'),
('4', '6', '2', '1', '2019-12-20', '2020-09-30', '1000', '10000'),
('5', '6', '1', '2', '2020-07-11', '2020-10-30', '1000', '45000000'),
('6', '6', '2', '2', '2020-11-12', '2020-11-30', '1000', '20000000'),
('7', '6', '1', '2', '2020-10-12', '2020-01-30', '1000', '10000'),
('8', '1', '3', '3', '2019-11-12', '2020-06-30', '1000', '10000'),
('9', '1', '4', '3', '2019-12-30', '2020-07-30', '1000', '65000000'),
('10', '1', '2', '3', '2020-01-12', '2020-08-30', '1000', '10000');

-- Add new contract_details-- 
insert into furama.contract_details(contract_details_id,contract_id,accompanied_service_id,contract_details_amount)
values('1', '1', '1', '1'),
('2', '2', '2', '2'),
('3', '3', '2', '3'),
('4', '4', '4', '1'),
('5', '5', '5', '2'),
('6', '6', '2', '3'),
('7', '7', '2', '1'),
('8', '8', '3', '2'),
('9', '9', '4', '3'),
('10', '10', '3', '1');


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

-- *5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu,
-- NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: 
--  ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các
--  Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/


select customer.customer_id,customer.customer_name,customer_type.customer_type_name,
	contract.contract_id,service.service_name, contract.contracting_date,contract.end_date,
    service.rental_cost+ (accompanied_service.accompanied_service_amount * accompanied_service.price) as 'Total Money'
from    customer
left join customer_type
on customer_type.customer_type_id = customer.customer_type_id
left join contract
on contract.customer_id = customer.customer_id
left join service
on service.service_id= contract.service_id
left join contract_details
on contract_details.contract_id = contract.contract_id
left join accompanied_service
on accompanied_service.accompanied_service_id = contract_details.accompanied_service_id;

--  6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả 
-- các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select service.service_id, service.service_name, service.the_area, service.rental_cost,
	service_type.service_type_name
from service
left join service_type
on service_type.service_type_id = service.service_type_id
left join contract 
on contract.service_id = service.service_id	
where contract.contracting_date <> ('2019/01/%' 
									   and '2019/02/%'
									   and '2019/03/%');
	

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được
--  Khách hàng đặt phòng  trong năm 2019.

select service.service_id,service.service_name, service.the_area,service.people_number,service.rental_cost,service_type.service_type_name
from service
left join service_type
on service_type.service_type_id= service.service_type_id
left join contract
on contract.service_id =service.service_id
where ( contract.contracting_date like '2018%')
	and contract.contracting_date not in ( 
    select contract .contracting_date 
    from contract
    where contract.contracting_date like '2019%');
    
    
--  8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
--  Cách 1: 
select customer.customer_name
from customer;

-- Cách 2: 

select customer.customer_name
from customer
group by customer.customer_name;

-- Cách 3:

select customer.customer_name
from customer
union 
select customer.customer_name
from customer;



-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có 
-- bao nhiêu khách hàng thực hiện đặt phòng.

select  substr(contract.contracting_date,6,2) as 'tháng trong năm 2019' ,
		count(contract.contract_id) as 'số lần đặt'
from contract 
where contract.contracting_date like '2019%'
group by substr(contract.contracting_date ,6,2);



-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển
--  thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên
--  việc count các IDHopDongChiTiet).

use furama;
select furama.contract.contract_id,furama.contract.contracting_date,furama.contract.end_date,furama.contract.down_payment,furama.contract_details.contract_details_amount
from furama.contract
left join furama.contract_details on furama.contract_details.contract_id = furama.contract.contract_id;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select furama.customer.customer_name, furama.accompanied_service.accompanied_service_id,furama.accompanied_service.accompanied_service_name,
furama.accompanied_service.price,furama.accompanied_service.accompanied_service_amount,furama.accompanied_service.availability
from furama.accompanied_service
left join furama.contract_details on furama.accompanied_service.accompanied_service_id = furama.contract_details.accompanied_service_id
	left join furama.contract on furama.contract.contract_id = furama.contract_details.contract_id
    left join furama.customer on furama.customer.customer_id =furama.contract.customer_id
    left join furama.customer_type on furama.customer_type.customer_type_id= furama.customer.customer_type_id
    where furama.customer_type.customer_type_id=1 
		and ( furama.customer.customer_address = 'Vinh'
        or furama.customer.customer_address = 'Quảng Ngãi')
	group by furama.customer.customer_name;		
    
-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- 			(được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng
--  			cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.    

-- select furama.contract.contract_id, furama.staff.staff_name, furama.customer.customer_name, furama.customer.customer_phone_number,
-- furama.service.service_name, count(furama.accompanied_service.accompanied_service_id) , count(furama.accompanied_service.accompanied_service_amount)
-- from furama.contract
-- left join furama.staff on furama.staff.staff_id = furama.contract.staff_id
-- 	left join furama.customer on furama.customer.customer_id = furama.contract.customer_id
-- 	left join furama.service on furama.customer.service_id = furama.service.customer_id
-- 	left join furama.contract_details on furama.contract_details.contract_id = furama.contract.contract_id
--  where (( furama.contract.contracting_date >= '2019/10/01' 
-- 	 and furama.contract.contracting_date =< '2019/12/31')
-- 	 and (furama.contract.contracting_date not between '2019/01/01' and '2019/06/30') )
-- group by 	furama.contract.contract_id		

select furama.contract.contract_id, furama.staff.staff_name, furama.customer.customer_name, furama.customer.customer_phone_number,
 furama.service.service_name, count(furama.contract_details.accompanied_service_id) , furama.contract.down_payment
 from furama.contract
left join furama.staff on  furama.staff.staff_id = furama.contract.staff_id
	left join furama.customer on furama.customer.customer_id = furama.contract.customer_id
	left join furama.service on furama.contract.service_id = furama.service.service_id
	left join furama.contract_details on furama.contract_details.contract_id = furama.contract.contract_id
where  (furama.contract.contracting_date >= '2019/10/01' and furama.contract.contracting_date <= '2019/12/31') 
     and (furama.contract.contracting_date not between '2019/01/01' and '2019/06/30') 
group by 	furama.contract.contract_id	;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
--  (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

create or replace view amount_service as
select	furama.accompanied_service.accompanied_service_id,
		furama.accompanied_service.accompanied_service_name,
		furama.accompanied_service.accompanied_service_amount,
		furama.accompanied_service.price,
		furama.accompanied_service.availability,
		count( furama.contract_details.accompanied_service_id) as amount_contract_details
 from furama.accompanied_service
 left join furama.contract_details 
	on furama.accompanied_service.accompanied_service_id=furama.contract_details.accompanied_service_id
 left join furama.contract 
	on furama.contract.contract_id =furama.contract_details.contract_id
 left join furama.customer
	on furama.contract.customer_id= furama.customer.customer_id
 group by furama.accompanied_service.accompanied_service_name;
 
 select *
 from amount_service
 where furama.amount_service.amount_contract_details=
	(select max(furama.amount_service.amount_contract_details)
    from furama.amount_service);
    
--  14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
 -- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.   
	
select furama.contract.contract_id,furama.service_type.service_type_name,
		furama.accompanied_service.accompanied_service_name,
        count(furama.contract_details.accompanied_service_id) as amount
from furama.contract_details
inner join furama.contract 
			on furama.contract.contract_id =furama.contract_details.contract_id
inner join furama.accompanied_service
			on furama.accompanied_service.accompanied_service_id =furama.contract_details.accompanied_service_id
inner join furama.service
			on furama.service.service_id = furama.contract.service_id
inner join furama.service_type
			on furama.service_type.service_type_id = furama.service.service_type_id
group by furama.contract_details.accompanied_service_id
having 	amount=1;	

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, 
-- SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select furama.staff.staff_id,furama.staff.staff_name,
		furama.staff_level.level_name,furama.location.location_name,
        furama.staff.phone_number,furama.staff.staff_address
from furama.contract
inner join furama.staff 
			on furama.staff.staff_id =furama.contract.staff_id
inner join  furama.staff_level
			on furama.staff_level.level_id= furama.staff.level_id
inner join furama.location
			on furama.location.locatinon_id=furama.staff.locatinon_id
where  year(furama.contract.contracting_date) in (2018,2019)
group by furama.staff.staff_id
having count(furama.contract.contract_id)<4;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

delete furama.staff
from furama.staff
	left join furama.contract on staff.staff_id = contract.staff_id
where staff.staff_id not in 
		(select contract.staff_id 
			from contract
			where ( year(contract.contracting_date) in (2017,2018,2019)));
            

select *
from staff;

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 
-- là lớn hơn 10.000.000 VNĐ.

update customer
set customer.customer_type_id=1
where customer.customer_id in
(	select customer.customer_id
	from
			(	select customer.customer_id
				from customer
                inner join contract on customer.customer_id =contract.customer_id
                where customer.customer_type_id =2 and year(contract.contracting_date) =(2019)
                group by customer.customer_id
                having sum(contract.total_money)>= 10000000) as temp);
			
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).    

   delete furama.customer
   from furama.customer
   where customer.customer_id in 
			( 	select customer.customer_id
				from  ( 
						select customer.customer_id
                        from furama.customer
                        inner join furama.contract on customer.customer_id = contract.customer_id
                        where year(contract.contracting_date) < '2016' and (contract.customer_id not in 
								(	select customer_id
									from furama.contract
                                    where	year(contract.contracting_date) >= '2016'))) as temp )	;
  use furama;    
  -- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
  
  update furama.accompanied_service
  set furama.accompanied_service.price=furama.accompanied_service.price*2
  where furama.accompanied_service.accompanied_service_id in(	
				select furama.accompanied_service.accompanied_service_id
				from ( 
						select furama.accompanied_service.accompanied_service_id
                        from furama.accompanied_service
                        inner join furama.contract_details on furama.accompanied_service.accompanied_service_id = furama.contract_details.accompanied_service_id
                        inner join furama.contract on furama.contract .contract_id=furama.contract_details.contract_id
                        where year(furama.contract.contracting_date)=(2019)
                        group by furama.accompanied_service.accompanied_service_id
                        having	count(furama.accompanied_service.accompanied_service_id)>10) as temp);
select *
from furama.accompanied_service;		

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,
--  thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, 
-- NgaySinh, DiaChi.			

select furama.staff.staff_id,furama.staff.staff_name,furama.staff.staff_email,furama.staff.staff_birthday,
		furama.staff.staff_address
from furama.staff
union
select furama.customer.customer_id,furama.customer.customer_name,furama.customer.customer_email,furama.customer.customer_birthday,
			furama.customer.customer_address
from furama.customerusers ;