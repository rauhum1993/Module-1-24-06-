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
}
