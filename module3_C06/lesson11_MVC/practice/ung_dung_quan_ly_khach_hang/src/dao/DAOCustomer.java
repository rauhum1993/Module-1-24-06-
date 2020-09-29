package dao;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOCustomer implements IDAOCustomer {
    private static Map<String,Customer> customerMap;

    static {
        customerMap =new HashMap<>();
        customerMap.put("1",new Customer("1","Dat","dat09@gmail.com","Da Nang"));
        customerMap.put("2",new Customer("2","Hai","Hai@gmail.com","Da Nang"));
        customerMap.put("3",new Customer("3","Quang","Quang@gmail.com","Da Nang"));
        customerMap.put("4",new Customer("4","Tung","Tung@gmail.com","Da Nang"));
        customerMap.put("5",new Customer("5","Nhat","Nhat@gmail.com","Da Nang"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }

    @Override
    public Customer findByID(String id) {
        return customerMap.get(id);
    }

    @Override
    public void update(String id, Customer customer) {
        customerMap.put(id, customer);

    }

    @Override
    public void remove(String id) {
        customerMap.remove(id);
    }
}
