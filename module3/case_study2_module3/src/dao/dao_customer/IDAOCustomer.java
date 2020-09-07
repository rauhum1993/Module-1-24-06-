package dao.dao_customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface IDAOCustomer {
    List<Customer> showListCustomer();

    void create(Customer customer) ;

    void insert(Customer customer) throws SQLException;

    Customer findByID(int id);

    void update(Customer customer);

    void delete(int id);

    List<Customer> searchByName(String name);


}
