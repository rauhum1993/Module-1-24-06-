package bo.bo_customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface IBOCustomer {

    List<Customer> showListCustomer();

    void createCustomer(Customer customer);

    void insertCutomer(Customer customer) throws SQLException;

    Customer findByID(int id);

    void update(Customer customer);

    void delete(int id);

    List<Customer> searchByName(String name);


}
