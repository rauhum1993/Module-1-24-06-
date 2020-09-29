package dao;

import model.Customer;

import java.util.List;

public interface IDAOCustomer {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findByID(String id);

    void  update(String id,Customer customer);

    void  remove(String id);
}
