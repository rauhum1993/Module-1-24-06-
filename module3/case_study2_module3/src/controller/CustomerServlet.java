package controller;

import bo.bo_customer.BOCustomer;
import commom.Validate;
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


    // Set invalid message
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
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "search":
                searchByName(request,response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList;
        String value = request.getParameter("search");
        customerList = boCustomer.searchByName(value);
        request.setAttribute("listCustomer", customerList);
        try {
            request.getRequestDispatcher("customer/customer-list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int typeID = Integer.parseInt(request.getParameter("typeID"));
            String name = request.getParameter("name");
            String birthday = request.getParameter("birthday");
            int gender = Integer.parseInt(request.getParameter("gender"));
            String idCard = request.getParameter("IDCard");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");

            Customer book = new Customer(id, typeID, name, birthday, gender, idCard, phone, email, address);
            boCustomer.update(book);
            List<Customer> customerList = boCustomer.showListCustomer();
            request.setAttribute("listCustomer", customerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer-list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        boolean check = true;
        if (!Validate.checkCode(String.valueOf(id))){
            request.setAttribute("messageID",ID_INVALID);
            check=false;
        }
        if (!Validate.checkInteger(String.valueOf(typeID))){
            request.setAttribute("messageTypeID",INTEGER_INVALID);
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
        if(check){
            boCustomer.insertCutomer(customer);

            request.setAttribute("notification",NOTIFICATION);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer-list.jsp");
            dispatcher.forward(request, response);
        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer-create.jsp");
            dispatcher.forward(request, response);
        }







    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer extingCustomer = boCustomer.findByID(id);
        if (extingCustomer == null) {
            request.setAttribute("message", "Not Found");
        } else {
            request.setAttribute("editCustomer", extingCustomer);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer-edit.jsp");
        dispatcher.forward(request , response);
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("customer/customer-create.jsp");

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = boCustomer.showListCustomer();

        request.setAttribute("listCustomer", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boCustomer.delete(id);
        List<Customer> customerList = boCustomer.showListCustomer();
        request.setAttribute("listCustomer",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/customer-list.jsp");
        dispatcher.forward(request, response);
    }
}
