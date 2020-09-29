package controller;

import dao.DAOCustomer;
import dao.IDAOCustomer;
import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controller.ViewServlet",urlPatterns = {"/servlet"})
public class ViewServlet extends HttpServlet {
    private IDAOCustomer idaoCustomer = new DAOCustomer();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        idaoCustomer.remove(id);
        List<Customer> customerList = idaoCustomer.findAll();

        request.setAttribute("list", customerList);
        request.getRequestDispatcher("/views/view.jsp").forward(request,response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = idaoCustomer.findByID(id);

        if (customer == null) {
            request.setAttribute("message", "error-404.jsp");
        } else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            idaoCustomer.update(id, customer);
            request.setAttribute("customer", customer);
            request.setAttribute("message", "Customer information was updated");



        }
        List<Customer> customerList = idaoCustomer.findAll();

        request.setAttribute("list", customerList);
        request.getRequestDispatcher("/views/view.jsp").forward(request,response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");


        Customer customer = new Customer(id, name, email, address);
        idaoCustomer.save(customer);
        request.setAttribute("message","New customer was created");
        List<Customer> customerList = idaoCustomer.findAll();

        request.setAttribute("list", customerList);
        request.getRequestDispatcher("/views/view.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                showviewform(request,response);
                break;
            default:
                listCustomers(request, response);
                break;
        }

    }

    private void showviewform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer customer = idaoCustomer.findByID(id);
        List<Customer> customerList =new ArrayList<>();
        customerList.add(customer);
        if (customer==null){
            request.setAttribute("message","Not found Customer");
        } else {

            request.setAttribute("list", customerList);
            request.setAttribute("message","Found Customer");
            request.getRequestDispatcher("/views/view.jsp").forward(request,response);
        }

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer customer = idaoCustomer.findByID(id);
        if (customer==null){
            request.setAttribute("message","Not found Customer");
        } else {
            request.setAttribute("customer",customer);
        }
        request.getRequestDispatcher("/views/delete.jsp").forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        Customer customer = idaoCustomer.findByID(id);
        if (customer==null){
            request.setAttribute("message","Not found Customer");
        } else {
            request.setAttribute("customer",customer);
        }
        request.getRequestDispatcher("/views/edit.jsp").forward(request,response);

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/create.jsp").  forward(request,response);
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = idaoCustomer.findAll();

        request.setAttribute("list", customerList);
        request.getRequestDispatcher("/views/view.jsp").forward(request,response);
    }
}
