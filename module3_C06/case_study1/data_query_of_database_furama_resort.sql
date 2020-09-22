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

select customer_name,count(*) as number_of_reservations
from customer
	 join contract on contract.customer_id = customer.customer_id
	 join type_customer on type_customer.type_customer_id  = customer.type_customer_id
 where type_customer.type_customer_name = 'Diamond'
group by customer_name76
order by  number_of_reservations;
		
-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, 
-- TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và 
-- Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào 
-- chưa từng đặt phòng cũng phải hiển thị ra).

	select customer.customer_id,customer_name,customer.type_customer_id,
			contract.contract_id,service_name,contracting_date,end_date,
            sum(rental_costs+ accompanied_service.numbers *price) as sum_money
    from  customer
		left join contract on contract.customer_id = customer.customer_id
		left join service on service.service_id = contract.service_id
 		left join contract_details on contract_details.contract_id = contract.contract_id
 		left join accompanied_service 
 			on accompanied_service.accompanied_service_id = contract_details.accompanied_service_id
         group by customer.customer_id   
           ;
        
-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ
--    chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
        
        select service.service_id,service_name,the_area,rental_costs,type_service.type_service_name
        from service
			left join contract on contract.service_id =service.service_id
             join type_service on type_service.type_service_id= service.type_service_id
		where ( contract.contracting_date not between '2019-01-01' and '2019-03-31') 
			and service_name not in ( select service_name
					from service
						inner join contract on contract.service_id =service.service_id
						inner join type_service on type_service.type_service_id= service.type_service_id
					where  (contract.contracting_date  between '2019-01-01' and '2019-03-31'));
 
 --   7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất
--      cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng
--      đặt phòng  trong năm 2019.

	select  service.service_id,service_name,the_area,max_people,rental_costs,type_service.type_service_name
    from service
			left join contract on contract.service_id =service.service_id
             join type_service on type_service.type_service_id= service.type_service_id	
	where ( contract.contracting_date like '2018%')
	and contract.contracting_date not in ( 
    select contract .contracting_date 
    from contract
    where contract.contracting_date like '2019%')
    group by service_id;

         --  8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
--  Cách 1: 
select distinct customer.customer_name
from customer;

-- Cách 2: 

select customer.customer_name
from customer
group by customer.customer_name;

-- Cách 3:

select customer.customer_name
from customer
union 
select customer.customer_name
from customer;

  
	-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có 
-- bao nhiêu khách hàng thực hiện đặt phòng.

select  substr(contract.contracting_date,6,2) as 'tháng trong năm 2019' ,
		count(contract.contract_id) as 'số lần đặt'
from contract 
where contract.contracting_date like '2019%'
group by substr(contract.contracting_date ,6,2);
          
-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển
--  thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên
--  việc count các IDHopDongChiTiet).

select contract.contract_id,contracting_date,end_date,deposits,numbers
from contract
	left join contract_details on contract_details.contract_id = contract.contract_id;
	
    -- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select customer.customer_id,customer_name,accompanied_service.accompanied_service_id,accompanied_service_name,accompanied_service.price,
		accompanied_service.numbers,availability
 from  accompanied_service
	left join contract_details on contract_details.accompanied_service_id = accompanied_service.accompanied_service_id
    left join contract on contract.contract_id= contract_details.contract_id
    left join customer on customer.customer_id = contract.customer_id
    left join type_customer on type_customer.type_customer_id = customer.type_customer_id
where type_customer.type_customer_id = '1'
	and (customer.address = 'Vinh' or customer.address = 'Quãng Ngãi' );
    
        
-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- 			(được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng
--  			cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.    
    
    select contract.contract_id ,staff_name,customer.customer_name,customer.phone_number,service_name,contract_details.numbers,deposits 
    from contract
		left join staff on  staff.staff_id = contract.staff_id
		left join customer on customer.customer_id = contract.customer_id
		left join service on contract.service_id = service.service_id
		left join contract_details on contract_details.contract_id = contract.contract_id
	where  (contract.contracting_date >= '2019/10/01' and contract.contracting_date <= '2019/12/31') 
     and (customer.customer_name not in (
					select customer.customer_name
					from contract
						left join staff on  staff.staff_id = contract.staff_id
						left join customer on customer.customer_id = contract.customer_id
						left join service on contract.service_id = service.service_id
						left join contract_details on contract_details.contract_id = contract.contract_id
					where  (contract.contracting_date between '2019/01/01' and '2019/06/30')) ) ;		
	
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
--  (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
create or replace view amount_service as
select accompanied_service.accompanied_service_id,accompanied_service_name,
		accompanied_service.price,accompanied_service.numbers,accompanied_service.availability,
        count( contract_details.accompanied_service_id) as amount_contract_details
from accompanied_service
		left join contract_details on contract_details.accompanied_service_id = accompanied_service.accompanied_service_id
		left join contract on contract.contract_id = contract_details.contract_id
		left join customer on customer.customer_id = contract.customer_id
group by accompanied_service.accompanied_service_name;

 select *
 from amount_service
 where amount_service.amount_contract_details=
	(select max(amount_service.amount_contract_details)
    from amount_service);
    
--  14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.   
select accompanied_service.accompanied_service_id,accompanied_service_name,
		accompanied_service.price,accompanied_service.numbers,accompanied_service.availability,
        count( contract_details.accompanied_service_id) as amount_contract_details
from accompanied_service
		left join contract_details on contract_details.accompanied_service_id = accompanied_service.accompanied_service_id
		left join contract on contract.contract_id = contract_details.contract_id
		left join customer on customer.customer_id = contract.customer_id
group by accompanied_service.accompanied_service_name        
having amount_contract_details='1';
-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, 
-- SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select furama.staff.staff_id,furama.staff.staff_name,
		furama.staff_level.level_name,furama.location.location_name,
        furama.staff.phone_number,furama.staff.staff_address
from furama.contract
inner join furama.staff 
			on furama.staff.staff_id =furama.contract.staff_id
inner join  furama.staff_level
			on furama.staff_level.level_id= furama.staff.level_id
inner join furama.location
			on furama.location.locatinon_id=furama.staff.locatinon_id
where  year(furama.contract.contracting_date) in (2018,2019)
group by furama.staff.staff_id
having count(furama.contract.contract_id)<4;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

delete furama.staff
from furama.staff
	left join furama.contract on staff.staff_id = contract.staff_id
where staff.staff_id not in 
		(select contract.staff_id 
			from contract
			where ( year(contract.contracting_date) in (2017,2018,2019)));
            

select *
from staff;

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 
-- là lớn hơn 10.000.000 VNĐ.

update customer
set customer.customer_type_id=1
where customer.customer_id in
(	select customer.customer_id
	from
			(	select customer.customer_id
				from customer
                inner join contract on customer.customer_id =contract.customer_id
                where customer.customer_type_id =2 and year(contract.contracting_date) =(2019)
                group by customer.customer_id
                having sum(contract.total_money)>= 10000000) as temp);