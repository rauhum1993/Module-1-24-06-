drop database if exists code_gym_course;
create database code_gym_course;
use code_gym_course;

create table course2020(
	id int ,
    student_name char(255),
    age int,
    course char(255),
    price double 
);

insert into course2020 (id,student_name,age,course,price) values (1,'Hoang',21,'CNTT',400000);
insert into course2020 (id,student_name,age,course,price) values (2,'Viet',19,'DTVT',320000);
insert into course2020 (id,student_name,age,course,price) values (3,'Thanh',18,'KTDN',400000);
insert into course2020 (id,student_name,age,course,price) values (4,'Nhan',19,'CK',450000);
insert into course2020 (id,student_name,age,course,price) values (5,'Huong',20,'TCNH',500000);
insert into course2020 (id,student_name,age,course,price) values (5,'Huong',20,'TCNH',200000);

-- 1.Hiển thị toàn bộ bảng-- 
select*
from code_gym_course.course2020;

-- 2.Viết câu lệnh hiện thị tất cả các dòng có tên là Huong-- 
select *
from code_gym_course.course2020 
where course2020.student_name='Huong';

-- 3. Viết câu lệnh lấy ra tổng số tiền của Huong-- 
select student_name, sum(price) as sum_price 
from course2020
where student_name='Huong';

-- 4.Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp-- 

-- cách 1: sử dụng group by.-- 
select student_name 
from course2020 
group by student_name;

-- cách 2: sử dụng distinct-- 
select distinct student_name
from course2020;




