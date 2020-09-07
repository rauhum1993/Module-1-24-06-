package dao.dao_customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface IDAOCustomer {
    List<Customer> showListCustomer();

    void create(Customer customer) ;

    void insert(Customer customer) throws SQLException;

}
