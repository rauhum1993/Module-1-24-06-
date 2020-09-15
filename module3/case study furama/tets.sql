drop database if exists products;
create database products;
use products;
create table category (
	category_name varchar(45) primary key
);
create table product (
	id varchar(45),
	name_product varchar(45) ,
    price varchar(45),
    numbers varchar(45),
    color varchar(45),
    status_product varchar(45),
    category_name varchar(45),
    foreign key (category_name) references products.category(category_name) on delete cascade
    );
insert into category(category_name )
	values  ('iphone'),
			('television'),
			('samsung');
insert into  product (id,name_product,price,numbers,color,status_product,category_name)
	values 		('1','Iphone 6','799.6','15','Yello','USA','iphone'),	
				('2','Iphone 8','899.6','15','Red','USA','iphone'),	
				('3','Iphone 7','1099.6','12','Blue','USA','iphone'),	
				('4','ss galaxy 10 ','1599.6','15','White','China','samsung'),	
				('5','Smart tv ss','1899.6','10','Yello','China','television'),
				('6','Iphone 11','2000.5','4','Black','USA','iphone'),
				('7','Iphone 11','3000.15','5','Red','USA','iphone');
			select * 
            from product;