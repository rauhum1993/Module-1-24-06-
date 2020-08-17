
create table contacts
(contact_id int(11) not null auto_increment,
last_name varchar(30) not null,
first_name varchar(25),
birthday Date,
constraint contacts_pk Primary key (contact_id)

);

alter  table contacts add info varchar(255) default 'mai ben nhau ban nhe' ;
insert into contacts(last_name,birthday,info) values('quang covid','1996.04.01','big cityboy');
alter table contacts rename haiquayxe;
alter table contacts modify first_name varchar(10) not null;
alter table haiquayxe change column info info_customer varchar(200) not null;
alter table haiquayxe drop age;
alter table haiquayxe add age int(3) not null after first_name;
insert haiquayxe (last_name,age,info_customer) values ('mai thuy','18','bay va lac');
select*from haiquayxe;

