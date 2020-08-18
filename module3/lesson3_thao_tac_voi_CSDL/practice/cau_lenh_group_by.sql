use classicmodels;
select status from orders 
group by status;

select status, COUNT(*) as 'So luong status'
from orders
group by status;

select status, Sum(orderdetails.quantityOrdered*orderdetails.priceEach) as  amount
from orders 
inner join orderdetails on orderdetails.orderNumber=orders.orderNumber
group by status;
