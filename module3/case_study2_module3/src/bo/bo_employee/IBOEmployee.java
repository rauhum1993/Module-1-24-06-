package bo.bo_employee;

import model.Customer;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IBOEmployee {
    List<Employee> showListEmployee();

    void insertEmployee(Employee employee) throws SQLException;

    Employee findByID(String id);

    void update(Employee employee);

    void delete(String id);

    List<Employee> searchByName(String name);

}
