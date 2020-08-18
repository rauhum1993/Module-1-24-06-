drop database if exists manage_library;
create database manage_library;
use manage_library;

create table category(
	category_id int primary key,
    category_name varchar(500) 	
);

create table books(
	book_id int primary key,
    book_name char,
    producer char,
    author char,
    year_of_manufacture year,
    price_book double check (price_book>0) ,
    number_of_publications int 	check (number_of_publications >1 ),
    image_book blob,
    category_id int not null,
    foreign key (category_id) references manage_library.category(category_id)
    
);
create table students (
	student_id int primary key ,
    student_name varchar(50),
    address varchar(500),
     email varchar (50),
    image_student blob
);

create table borrow_order(
	student_id int  ,
    foreign key (student_id) references manage_library.students(student_id),
    book_id int ,
    foreign key(book_id) references manage_library.books(book_id),
    date_borrow date,
    date_return date
);