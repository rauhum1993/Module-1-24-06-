drop database if exists manage_libraly;
create database manage_libraly;

use manage_libraly;
create table books(
	book_code char ,
    book_name char,
    producer char,
    author char,
    year_of_manufacture year,
    price_book double check (price_book>0) ,
    number_of_publications int 	check (number_of_publications >1 ),
    image varchar(500)
    
);
create table students (
	student_number varchar(15) not null primary key,
    student_name varchar(50),
    address varchar(500),
     email varchar (50),
    image varchar(500)
);

create table borrow_order;
create table category;
