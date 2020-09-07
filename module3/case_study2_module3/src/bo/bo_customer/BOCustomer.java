package bo.bo_customer;

import dao.dao_customer.DAOCustomer;
import dao.dao_customer.IDAOCustomer;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public class BOCustomer implements IBOCustomer {

    IDAOCustomer idaoCustomer= new DAOCustomer();

    @Override
    public List<Customer> showListCustomer() {
        return idaoCustomer.showListCustomer();
    }

    @Override
    public void createCustomer(Customer customer) {

    }

    @Override
    public void insertCutomer(Customer customer) throws SQLException {
        this.idaoCustomer.insert(customer);
    }

    @Override
    public Customer findByID(int id) {
        return idaoCustomer.findByID(id);

    }

    @Override
    public void update(Customer customer) {
        idaoCustomer.update(customer);
    }

    @Override
    public void delete(int id) {
        idaoCustomer.delete(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return idaoCustomer.searchByName(name);
    }
}
