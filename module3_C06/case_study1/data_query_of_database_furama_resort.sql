use furama_resort;
-- 1.Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các 
-- ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * 
from staff
where 	staff_name like 'H%' 
		or staff_name like 'K%'
		or staff_name like 't%'
      and length(staff_name) <15;
      
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở 
-- “Đà Nẵng” hoặc “Quảng Trị”.
select *
from customer 
where (year(now())-year(birthday))>18
	and	(year(now())-year(birthday))<54
    and ( address = 'da nang' or address = 'Quãng Ngãi');
    
--  4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị
-- được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có
--  Tên loại khách hàng là “Diamond”.

select *,count(*) as number_of_reservations
from customer
	 join contract on contract.customer_id = customer.customer_id
	 join type_customer on type_customer.type_customer_id  = customer.type_customer_id
 where type_customer.type_customer_name = 'Diamond'
group by customer_name
order by  number_of_reservations;
		
-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, 
-- TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và 
-- Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào 
-- chưa từng đặt phòng cũng phải hiển thị ra).

	select customer.customer_id,customer_name,customer.type_customer_id,
			contract.contract_id,service_name,contracting_date,end_date,
            (rental_costs+ accompanied_service.numbers *price) as sum_money
    from  customer
		left join contract on contract.customer_id = customer.customer_id
		left join service on service.service_id = contract.service_id
 		left join contract_details on contract_details.contract_id = contract.contract_id
 		left join accompanied_service 
 			on accompanied_service.accompanied_service_id = contract_details.accompanied_service_id
      group by customer_name
        ;
        
-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ
--    chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
        
        select service.service_id,service_name,the_area,rental_costs,type_service.type_service_name
        from service
			inner join contract on contract.service_id =service.service_id
            inner join type_service on type_service.type_service_id= service.type_service_id
		where  contract.contracting_date not between '2019-01-01' and '2019-03-31';
         
           
	
          

	