drop database if exists manage_libraly;
create database manage_libraly;
use manage_libraly;

create table category(
	category_id int primary key,
    category_name varchar(500) 	
);

create table books(
	book_id int  primary key,
    book_name char,
    producer char,
    author char,
    year_of_manufacture year,
    price_book double check (price_book>0) ,
    number_of_publications int 	check (number_of_publications >1 ),
    image varchar(500),
    category_id int not null,
    foreign key (category_id) references manage_libraly.category(category_id)
    
);
create table students (
	student_id int primary key ,
    student_name varchar(50),
    address varchar(500),
     email varchar (50),
    image varchar(500)
);

create table borrow_order(
	student_id int  ,
    foreign key (student_id) references manage_libraly.students(student_id),
    book_id int ,
    foreign key(book_id) references manage_libraly.books(book_id),
    date_borrow date,
    date_return date
);


