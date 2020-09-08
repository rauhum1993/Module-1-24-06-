use furama_wbe;
insert into furama_wbe.customer_type (customer_type_id,customer_type_name ) 
	values 	(1,'Diamond'),
			(2,'Platinium'),
			(3,'Gold'),
			(4,'Silver'),
			(5,'Member');

insert into furama_wbe.customer (customer_id,customer_type_id,customer_name,customer_birthday,
customer_gender,customer_id_card,customer_phone,customer_email,customer_address)
	values 	(1,1,'Hải','1968-12-20',b'1',18730113,039336258,'haiquacustomer_addressytay@gmail.com','Hà Tĩnh' ),
			(2,3,'Tùng','1995-11-16',b'0',18452213,069876258,'tungquayxe@gmail.com','Quảng Bình' ),
			(3,3,'Hoàng','1997-06-20',b'1',196320113,037936588,'hoangno@gmail.com','Đà Nẵng' );
            
            
insert into furama_wbe.rent_type (rent_type_id,rent_type_name,rent_type_cost)
		values 	(1,'hour',300000),
				(2,'day',1000000),
				(3,'mont',150000000),
				(4,'year',150000000);
insert into furama_wbe.service_type (service_type_id,service_type_name)    
		values 	(1,'Villa'),
				(2,'House'),
				(3,'Room');
	
            
insert into furama_wbe.service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,
	service_type_id,standard_room,description_orther_convenienve,pool_area,number_of_floors)	
		values		('1','Villa','150','250000',10,2,3,'Vip','Free',20.0,5),
					('2','Villa','200','300000',5,1,1,'Vip','Free',20.0,5),
					('3','House','120','150000',4,2,3,'Normal','Free',20.0,5),
					('4','Room','100','150000',5,1,3,'Normal','Free',40.0,5),
					('5','House','150','150000',6,4,1,'Normal','Free',20.0,5);
            
	select *
    from service;