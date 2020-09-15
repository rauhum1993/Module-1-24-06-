package bo.bo_employee;

import dao.dao_employee.DAOEmployee;
import dao.dao_employee.IDAOEmployee;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public class BOEmployee implements IBOEmployee {
    IDAOEmployee idaoEmployee =new DAOEmployee();
    @Override
    public List<Employee> showListEmployee() {

        return idaoEmployee.showListEmployee();
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        idaoEmployee.create(employee);
    }

    @Override
    public Employee findByID(String id) {
      return  idaoEmployee.findByID(id);

    }

    @Override
    public void update(Employee employee) {
        idaoEmployee.update(employee);
    }

    @Override
    public void delete(String id) {
        idaoEmployee.delete(id);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return idaoEmployee.searchByName(name);
    }
}
