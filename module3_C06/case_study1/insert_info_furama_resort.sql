use furama_resort;
-- 1. Thêm bản ghi cho bảng vị trí nhân viên
insert into role(role_id,role_name)
	values 	('1','Giám Đốc'),
			('2','Quản Lý'),
			('3','Giám Sát'),
			('4','Chuyên Viên'),
			('5','Phục Vụ'),
			('6','Lễ Tân');
            
 -- 2. Thêm bản ghi cho bảng Trình độ nhân viên           
 insert into level(level_id,level_name) 
	values 	('1','Sau đại học'),
			('2','Đại học'),
			('3','Cao Đẳng'),
			('4','Trung Cấp');
            
-- 3. Thêm bản ghi cho bảng Bộ phận nhân viên        
insert into part(part_id,part_name)   
       values 	('1','Quản lý'),
			('2','Phục Vụ'),
			('3','Hành chính'),
			('4','Sale - Markerting');
-- 4. Thêm bản ghi cho bảng Nhân viên       
insert into staff(staff_id,staff_name,role_id,level_id,part_id,birthday,id_card,salary,phone_number,email,address)   
       values 	('1','Khánh','1','1','1','1993-11-06','187320118','50000000','0396692526','khanh@gmail.com','Vinh'),
				('2','Hải','2','4','2','2000-01-30','163320115','40000000','0248359526','hai@gmail.com','Hà Tĩnh'),
				('3','Nguyen van sy Tùng','3','1','4','1996-09-28','187320147','30000000','0300692526','tung@gmail.com','Quãng Ngãi'),
				('4','Đạt','4','2','3','1991-10-12','187320487','30000000','0347812526','dat@gmail.com','Đà Nẵng'),
				('5','Chương','5','3','3','1988-04-20','187320365','60000000','0396358526','chuong@gmail.com','đà nẵng'),
				('6','Toàn','2','2','2','1988-06-30','187480365','45000000','0396245526','chuong@gmail.com','Nghệ An'),
				('7','Nhật','4','2','1','1998-12-20','187248365','30000000','0393698526','Nhat@gmail.com','Quãng Bình'),
				('8','Hoàng','6','4','4','1997-11-14','187320223','20000000','0336666526','hoang@gmail.com','đà Nẵng');
-- 5. Thêm bản ghi cho bảng Loại Khách Hàng
      insert into type_customer(type_customer_id,type_customer_name)   
       values 	('1','Diamond'),
				('2','Platinium'),
				('3','Gold'),
				('4','Silver'),
				('5','Member');
-- 6. Thêm bản ghi cho bảng  Khách Hàng 
	insert into customer(customer_id,type_customer_id,customer_name,birthday,id_card,phone_number,email,address)   
       values 	('1','1','Mai','1996-12-12','1897564231','0325684789','mai@gmail.com','Đà Nẵng'),
				('2','5','Trang','1997-10-20','1894586231','032965489','trang@gmail.com','Quãng Ngãi'),
				('3','3','Ngọc Anh','1995-06-12','1893658931','0320258789','NgocAnh@gmail.com','Huế'),
				('4','2','Ngân','1995-06-12','1893658931','0320258789','ngan@gmail.com','Quãng ngãi'),
				('5','4','Hà','1995-06-12','1893658931','0320266689','ha@gmail.com','Bình Định'),
				('6','5','Hiền','1994-06-12','189336581','0333358789','hien@gmail.com','đà nẵng'),
				('7','1','Thu','1993-06-12','1893269931','032555789','thu@gmail.com','Đông Lào'),
				('11','1','Ngọc','1996-06-12','1894569931','032555789','ngoc@gmail.com','Đông campuchia'),
				('12','1','Phương Anh','1999-06-12','1894569931','032555789','anh@gmail.com','Nghệ An'),
				('8','2','Giang','1998-06-12','1893658931','0235258789','giang@gmail.com','Hà nội'),
				('9','3','Hải','2000-06-12','1835898931','032666689','hai@gmail.com','Vinh'),
				('10','4','Linh','2003-06-12','1893444931','0325558789','linh@gmail.com','đà Nẵng');
-- 7. Thêm bản ghi cho bảng	Kiểu thuê	
	insert into rent_type
		values 	('1','Thuê Theo Năm','100000000'),
				('2','Thuê Theo Tháng','20000000'),
				('3','Thuê Theo Ngày','500000'),
				('4','Thuê Theo Giờ','100000');
-- 8. 	Thêm bản ghi cho bảng Loại dịch vụ			
      insert into type_service  
		values 	('1','Villa'),
				('2','House'),
				('3','Room');
-- 9.	Thêm bản ghi cho bảng  dịch vụ	
		 insert into service  	
			values 	('1','Hoàng Đế','80','3','4','10000000','3','1','Còn Phòng'),
					('2','Nhà Vua','50','2','5','5000000','3','2','Còn Phòng'),
					('3','Như ở nhà','30','1','6','3000000','2','3','Còn Phòng');
-- 10.   Thêm bản ghi cho bảng dich vụ đi kèm
	 insert into accompanied_service
		values 	('1','massage','200000','2','Còn cung cấp'),
				('2','karaoke','200000','3','Còn cung cấp'),
				('3','fast food','100000','4','Còn cung cấp'),
				('4','Nước khoáng','20000','5','Còn cung cấp'),
				('5','Xe di chuyển','200000','2','Còn cung cấp');
 -- 11.  Thêm bản ghi cho bảng Hợp đồng
	 insert into contract (`contract_id`, `staff_id`, `customer_id`, `service_id`, `contracting_date`, `end_date`, `deposits`, `total_money`)
		values 	('1','4','3','2','2018-11-12','2019-03-12','60000000','100000000'),
				('2','3','6','1','2019-11-12','2020-06-30','70000000','60000000'),
				('3','2','1','3','2020-03-12','2020-10-12','80000000','80000000'),
				('4','5','5','1','2020-06-12','2020-12-24','30000000','120000000'),
				('5','2','12','3','2017-03-12','2020-10-12','40000000','150000000'),
				('6','4','11','3','2017-03-12','2019-10-12','50000000','20000000'),
				('7','3','11','3','2020-03-12','2020-10-12','40000000','10000000'),
				('8','7','10','2','2018-11-12','2020-08-12','50000000','70000000');
  -- 12.  Thêm bản ghi cho bảng Hợp đồng Chi tiết  
		insert into contract_details (`contract_details_id`, `contract_id`, `accompanied_service_id`, `numbers`)
				values 	('1','1','1','2'),
						('2','3',null,'3'),
						('3','2','5','4'),
						('4','4',null,'6'),
						('5','5','2','1'),
						('6','6','4','3'),
						('7','7','2','3'),
						('8','4','3','3');
				