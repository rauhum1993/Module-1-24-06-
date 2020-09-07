package bo.bo_customer;

import model.Customer;

import java.util.List;

public interface IBOCustomer {

    List<Customer> showListCustomer();

    void createCustomer(Customer customer);
}
