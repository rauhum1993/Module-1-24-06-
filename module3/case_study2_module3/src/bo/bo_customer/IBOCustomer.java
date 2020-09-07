package bo.bo_customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface IBOCustomer {

    List<Customer> showListCustomer();

    void createCustomer(Customer customer);

    void insertCutomer(Customer customer) throws SQLException;
}
