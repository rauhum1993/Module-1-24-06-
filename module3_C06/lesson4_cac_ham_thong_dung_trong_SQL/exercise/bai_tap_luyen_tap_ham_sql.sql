drop database if exists lesson4_module3;
create database lesson4_module3;
use lesson4_module3;

create table exercise (
	id int ,
    ten varchar(45),
    tuoi int,
    khoa_hoc varchar(45),
    so_tien int 
);
insert into exercise (id,ten,tuoi,khoa_hoc,so_tien)
	values	('1','Hoang','21','CNTT','4000000'),
			('2','Viet','19','DTVT','320000'),
			('3','Thanh','18','KTDN','400000'),
			('4','Nhan','19','CK','450000'),
			('5','Huong','20','TCNH','500000'),
			('5','Huong','20','TCNH','200000');
  select *
  from exercise;
  
 --  - Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
  select *
  from exercise
  where ten='Huong';
  
 --  - Viết câu lệnh lấy ra tổng số tiền của Huong
  select ten, sum(so_tien) 'tong_tien'
  from exercise
  where ten='Huong';
  -- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
    select id,ten
	from exercise
	group by ten;
  