package dao.dao_employee;

import model.Customer;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IDAOEmployee {
    List<Employee> showListEmployee();

    void create(Employee employee) ;


    Employee findByID(String id);

    void update(Employee employee);

    void delete(String id);

    List<Employee> searchByName(String name);
}
