package dao.dao_employee;

import dao.BaseDAO;
import model.Customer;
import model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOEmployee implements IDAOEmployee {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_EMPLOYEE = "select* from employee";

    private static final String CREATE_NEW_EMPLOYEE = "INSERT INTO employee" + "  (employee_id,employee_name,employee_birthday,employee_salary,employee_id_card,employee_phone,\n" +
            "\t\temployee_email,employee_address,position_id,education_degree_id,division_id,username)  VALUES " +
            " (?,?,?,?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_EMPLOYEE_BY_ID = "select employee_id,employee_name,employee_birthday,employee_salary,employee_id_card,employee_phone,\n" +
            "\t\temployee_email,employee_address,position_id,education_degree_id,division_id,username from employee where employee_id =?";

    private static String DELETE_EMPLOYEE_BY_ID = "delete from employee where employee_id=?";

    private static String SEARCH_NAME_EMPLOYEE = "select*from employee where employee_name like ?";

    private static String UPDATE_EMPLOYEE = "update employee set employee_name = ?,employee_birthday = ?, " +
            "employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ? ," +
            "position_id = ?, division_id = ?, education_degree_id = ?, username = ? where employee_id=?;";
    @Override
    public List<Employee> showListEmployee() {
       List<Employee> employeeList =new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    String id = rs.getString("employee_id");
                    String employeeName = rs.getString("employee_name");
                    String employeeBirthday = rs.getString("employee_birthday");
                    String employeeSalary = rs.getString("employee_salary");
                    String employeeIdCard = rs.getString("employee_id_card");
                    String employeePhone = rs.getString("employee_phone");
                    String employeeEmail = rs.getString("employee_email");
                    String employeeAddress = rs.getString("employee_address");
                    String positionId = rs.getString("position_id");
                    String educationDegreeId = rs.getString("education_degree_id");
                    String divisionId = rs.getString("division_id");
                    String username = rs.getString("username");
                employeeList.add(new Employee(id,employeeName,employeeBirthday,employeeSalary,employeeIdCard,
               employeePhone,employeeEmail,employeeAddress,positionId,educationDegreeId,divisionId,username ));

                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return  employeeList;
    }

    @Override
    public void create(Employee employee) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_EMPLOYEE);
            preparedStatement.setString(1,employee.getEmployeeId());
            preparedStatement.setString(2,employee.getEmployeeName());
           preparedStatement.setString(3,employee.getEmployeeBirthday());
            preparedStatement.setString(4,employee.getEmployeeSalary());
            preparedStatement.setString(5,employee.getEmployeeIdCard());
            preparedStatement.setString(6,employee.getEmployeePhone());
            preparedStatement.setString(7,employee.getEmployeeEmail());
            preparedStatement.setString(8,employee.getEmployeeAddress() );
            preparedStatement.setString(9,employee.getPositionID());
            preparedStatement.setString(10,employee.getEducationDegreeID());
            preparedStatement.setString(11,employee.getDivisionID());
            preparedStatement.setString(12,employee.getUsername());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findByID(String id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){

                String name =rs.getString("employee_name");
                String birthday =rs.getString("employee_birthday");
                String salary =rs.getString("employee_salary");
                String idCard =rs.getString("employee_id_card");
                String phone =rs.getString("employee_phone");
                String email =rs.getString("employee_email");
                String address =rs.getString("employee_address");
                String positionID =rs.getString("position_id");
                String degreeID =rs.getString("education_degree_id");
                String divisionID =rs.getString("division_id");
                String username =rs.getString("username");
            employee=new Employee(id,name,birthday,salary,idCard,phone,email,address,positionID,degreeID,divisionID,username);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_EMPLOYEE);


            preparedStatement.setString(1,employee.getUsername());
            preparedStatement.setString(2,employee.getEmployeeBirthday());
            preparedStatement.setString(3,employee.getEmployeeIdCard());
            preparedStatement.setString(4,employee.getEmployeeSalary());
            preparedStatement.setString(5,employee.getEmployeePhone());
            preparedStatement.setString(6,employee.getEmployeeEmail());
            preparedStatement.setString(7,employee.getEmployeeAddress());
            preparedStatement.setString(8,employee.getPositionID());
            preparedStatement.setString(9,employee.getDivisionID());
                preparedStatement.setString(10,employee.getEducationDegreeID());
            preparedStatement.setString(11,employee.getUsername());
            preparedStatement.setString(12,employee.getEmployeeId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_EMPLOYEE_BY_ID);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_NAME_EMPLOYEE);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String id =rs.getString("employee_id");
                String employeeName =rs.getString("employee_name");
                String employeeBirthday =rs.getString("employee_birthday");
                String employeeSalary =rs.getString("employee_salary");
                String employeeIdCard =rs.getString("employee_id_card");
                String employeePhone =rs.getString("employee_phone");
                String employeeEmail =rs.getString("employee_email");
                String employeeAddress =rs.getString("employee_address");
                String positionId =rs.getString("position_id");
                String educationDegreeId =rs.getString("education_degree_id");
                String divisionId =rs.getString("division_id");
                String username =rs.getString("username");

                employeeList.add(new Employee(id,employeeName,employeeBirthday,employeeSalary,employeeIdCard,employeePhone,
                        employeeEmail,employeeAddress,positionId,educationDegreeId,divisionId,username));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  employeeList;
    }
}
