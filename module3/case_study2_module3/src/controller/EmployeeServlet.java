package controller;

import bo.bo_customer.BOCustomer;
import bo.bo_employee.BOEmployee;
import commom.Validate;
import model.Customer;
import model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private BOEmployee boEmployee = new BOEmployee();
//    public static String REGEX_ID_KH="^KH-\\d{4}$";
//    public static String REGEX_ID_DV="^DV-\\d{4}$";
//    public static final String REGEX_PHONE_NUMBER = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$";
//    public static final String REGEX_EMAIL= "^(\\w{3,}@\\w+\\.\\w+)$";
//    public static final String REGEX_ID_CARD = "^\\d{9}$";
//    public static final String REGEX_INTEGER= "^[-]*\\d+$";
//    public static final String REGEX_DOUBLE= "^[-]*\\d+([.]\\d+)?$";
//    public static final String REGEX_20= "^[2-9]\\d(\\.?(\\d*))|([1-9][0-9]\\d+(\\.?(\\d*)))$";
//    public static final String REGEX_ID= "^(\\d{3}-\\d{2}-\\d{2})|([A-Z]{3}-[A-Z]{2}-[A-Z]{2})$";

    private static final String ID_INVALID = "The ID must be as format 'KH-XXXX'";
    private static final String NAME_INVALID = "The name not valid";
    private static final String BIRTHDAY_INVALID = "The birthday must made the age not less than 18";
    private static final String CARD_ID_INVALID = "The ID card number is not valid";
    private static final String EMAIL_INVALID = "The email is not valid";
    private static final String PHONE_INVALID = "The phone number must have 10 or 11 digits";
    private static final String INTEGER_INVALID = "The number is not valid";
    private static final String DOUBLE_INVALID = "The number is not valid";
    private static final String NOTIFICATION = "More success";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                try {
                    insertEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                updateUser(request, response);
                break;
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String salary = request.getParameter("salary");
        String idCard = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String employeeAddress = request.getParameter("employeeAddress");
        String positionID = request.getParameter("positionID");
        String educationDegreeID = request.getParameter("educationDegreeID");
        String divisionID = request.getParameter("divisionID");
        String username = request.getParameter("username");

        Employee employee = new Employee(id,name,birthday,salary,idCard,phone,email,employeeAddress,
                positionID,educationDegreeID,divisionID,username);
        boolean check = true;
//        if (!Validate.checkCode(id)){
//            request.setAttribute("messageID",ID_INVALID);
//            check=false;
//        }
        if (!Validate.checkName(name)){
            request.setAttribute("messageName",NAME_INVALID);
            check=false;
        }
        if (!Validate.checkInteger(salary)){
            request.setAttribute("messageID",INTEGER_INVALID);
            check=false;
        }

        if (!Validate.checkPhoneNumber(phone)){
            request.setAttribute("messagePhone",PHONE_INVALID);
            check=false;
        }
        if (!Validate.checkBirthday(birthday)){
            request.setAttribute("messageBirthday",BIRTHDAY_INVALID);
            check=false;
        }
        if (!Validate.checkEmail(email)){
            request.setAttribute("messageEmail",EMAIL_INVALID);
            check=false;
        }
        if (!Validate.checkIdCard(idCard)){
            request.setAttribute("messageIDCard",CARD_ID_INVALID);
            check=false;
        }
        if (check) {
            boEmployee.insertEmployee(employee);
            request.setAttribute("notification", "successfully added 1 employee");
            List<Employee> employeeList = boEmployee.showListEmployee();
            request.setAttribute("listEmployee", employeeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employee-list.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employee-create.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String salary = request.getParameter("salary");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String positionID = request.getParameter("positionID");
        String educationDegreeID = request.getParameter("educationDegreeID");
        String divisionID = request.getParameter("divisionID");
        String username = request.getParameter("username");

        Employee employee= new Employee(id,name,birthday,salary,idCard,phone,email,address,positionID,educationDegreeID,divisionID,username);
        boEmployee.update(employee);
        List<Employee> employeeList = boEmployee.showListEmployee();
        request.setAttribute("listEmployee", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employee-list.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "create":
                showCreateEmployee(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "search":
                searchByName(request,response);
                break;
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void showCreateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("employee/employee-create.jsp");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Employee extingEmployee = boEmployee.findByID(id);
        if (extingEmployee == null) {
            request.setAttribute("message", "Not Found");
        } else {
            request.setAttribute("editEmployee", extingEmployee);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employee-edit.jsp");

        dispatcher.forward(request  , response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boEmployee.delete(id);
        List<Employee> employeeList = boEmployee.showListEmployee();
        request.setAttribute("listEmployee",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employee-list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList;
        String value = request.getParameter("search");
        employeeList = boEmployee.searchByName(value);
        request.setAttribute("listEmployee", employeeList);
        try {
            request.getRequestDispatcher("employee/employee-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = boEmployee.showListEmployee();

        request.setAttribute("listEmployee", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employee-list.jsp");
        dispatcher.forward(request, response);
    }
}
