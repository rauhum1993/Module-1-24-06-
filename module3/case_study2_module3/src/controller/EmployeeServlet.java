package controller;

import bo.bo_customer.BOCustomer;
import bo.bo_employee.BOEmployee;
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
         boEmployee.insertEmployee(employee);
        request.setAttribute("notification","successfully added 1 employee");
        List<Employee> employeeList = boEmployee.showListEmployee();

        request.setAttribute("listEmployee", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employee-list.jsp");
        dispatcher.forward(request, response);

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
