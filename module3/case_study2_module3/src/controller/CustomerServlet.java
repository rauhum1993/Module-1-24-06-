package controller;

import bo.bo_customer.BOCustomer;
import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private BOCustomer boCustomer = new BOCustomer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":

                    insertCustomer(request, response);

                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateCustomer(request, response);
                break;
            case "edit":
                showEditForm(request, response);
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                listCustomer(request, response);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int typeID = Integer.parseInt(request.getParameter("type_id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("customer_birthday");
        int gender = Integer.parseInt(request.getParameter("customer_gender"));
        String idCard = request.getParameter("customer_id_card");
        String phone = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");
        Customer customer = new Customer(id, typeID, name, birthday, gender, idCard, phone, email, address);
        boCustomer.insertCutomer(customer);
        response.sendRedirect("/customer");

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("WEB-INF/customer/customer-create.jsp");

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = boCustomer.showListCustomer();

        request.setAttribute("listCustomer", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/customer-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
    }
}
