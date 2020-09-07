package dao.dao_customer;

import model.Customer;

import java.util.List;

public interface IDAOCustomer {
    List<Customer> showListCustomer();

    void create(Customer customer) ;
}
