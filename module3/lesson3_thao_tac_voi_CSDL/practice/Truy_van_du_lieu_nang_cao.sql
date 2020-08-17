drop database if exists classicmodels;
create database classicmodels;
use classicmodels;

create table productlines (
productline char not null primary key,
text_description varchar(255),
html_descriptinon varchar(255),
image varchar(255)

);
create table products (
product_code char  primary key ,
prduct_name char,
product_scale char,
product_vendor char,
product_description char,
quantityln_stock int ,
buy_price double,
MSRP char,
product_line char ,
foreign key(product_line)references productlines(productline)

);