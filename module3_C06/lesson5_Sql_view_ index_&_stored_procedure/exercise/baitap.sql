-- Bước 1: Tạo cơ sở dữ liệu demo-- 

drop database if exists demo;
create database demo;
use demo;

-- Bước 2: Tạo bảng Products với các trường dữ liệu sau:-- 
create table products(
	id int,
    product_code varchar(45),
    product_name varchar(45),
    product_price double,
    product_amout double,
    product_desccription varchar(45),
    product_status varchar(45)
    
);

-- Chèn một số dữ liệu mẫu cho bảng Products.-- 
insert into demo.products(id,product_code,product_name,product_price,product_amout,product_desccription,product_status)
 values (1,'nike37','giay nike' ,300000,400000,'USA', 'Stocking' ),
 (2,'adidas38','giay adidas' ,500000,900000,'China', 'Out of stock' ),
 (3,'puma45','áo puma' ,200000,600000,'Italy', 'Stocking' ),
 (4,'bitis78','giay bitis' ,600000,900000,'Viet nam', 'Out of stock' ),
 (5,'Thượng Đình 29','giay Thượng Đình' ,80000,85000,'Đông lào', 'Stocking' );
 
select*
from products;

explain select *
from products
where product_code= 'puma45';

-- Bước 3:-- 

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)-- 
create unique index index_code  on Products(product_code);


-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)-- 

create index index_name_price  on Products(product_name,product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào -- 
-- So sánh câu truy vấn trước và sau khi tạo index-- 

explain select *
from products
where product_code= 'puma45';


explain select*
from products
where product_name ='giay Thượng Đình' and product_price='product_price';

-- Bước 4:-- 
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.-- 

create view products_view as 
select product_code,product_name,product_price,product_amout,product_desccription,product_status
from products;

-- Tiến hành sửa đổi view : -- 
update 	products_view
set product_code= 'ahihi'
where 	product_name= 'giay bitis' ;

-- Tiến hành xoá view-- 
drop view products_view;

-- Bước 5:-- 
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product-- 

DELIMITER //
DROP PROCEDURE IF EXISTS `all_info_product`//
create procedure all_info_product()
begin
	select*
    from products;
    
end //
DELIMITER ;
add_new_product
-- Tạo store procedure thêm một sản phẩm mới--
DELIMITER //
DROP PROCEDURE IF EXISTS `add_new_product`//
create procedure add_new_product(in id int,in product_code varchar(45) ,in product_name varchar(45),
in product_price double,in product_amout double ,in product_desccription varchar(45) ,
in  product_status varchar(45))
begin
	insert into products (id,product_code,product_name,product_price,product_amout,product_desccription,product_status)
    values (id,product_code,product_name,product_price,product_amout,product_desccription,product_status);
    
end //
DELIMITER ;

-- Tạo store procedure sửa thông tin sản phẩm theo id-- 
DELIMITER //
DROP PROCEDURE IF EXISTS `edit_info_product`//
create procedure edit_info_product(in id1 int, in status_product1 varchar(45))
begin
	update products
	set product_status= status_product1
	where id= id1;
end //
DELIMITER ;

-- Tạo store procedure xoá sản phẩm theo id -- 
DELIMITER //
DROP PROCEDURE IF EXISTS `delete_info_product`//
create procedure delete_info_product(in id1 int)
begin
		delete from products
        where id=id1;
end //
DELIMITER ;
