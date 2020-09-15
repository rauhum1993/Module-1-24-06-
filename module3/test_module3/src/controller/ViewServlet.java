package controller;

import bo.BOProduct;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ViewServlet",urlPatterns = "/view")
public class ViewServlet extends HttpServlet {
    private BOProduct boProduct = new BOProduct();

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
                    insertProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                updateProduct(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String numbers = request.getParameter("numbers");
        String color = request.getParameter("color");
        String status = request.getParameter("status");
        String category = request.getParameter("category");

        Product product = new Product(id,name,price,numbers,color,status,category);
        boProduct.update(product);
        List<Product> productList = boProduct.showListProduct();
        request.setAttribute("notification1", "Successfully Edit ");
        request.setAttribute("listProduct", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view.jsp");
        dispatcher.forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id =request.getParameter("id");
        String name =request.getParameter("name");
        String price =request.getParameter("price");
        String numbers =request.getParameter("numbers");
        String color =request.getParameter("color");
        String status =request.getParameter("status");
        String category =request.getParameter("category");

        Product product= new Product(id,name,price,numbers,color,status,category);
        boProduct.insertProduct(product);
        request.setAttribute("notification1", "Successfully Added 1 Product");
        List<Product> productList = boProduct.showListProduct();
        request.setAttribute("listProduct", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "create":
                showCreateProduct(request, response);
                break;
            case "edit":
                showEditProduct(request, response);
                break;
            case "delete":
                showDeleteProduct(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;

            default:
                listProduct(request, response);
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList;
        String value = request.getParameter("search");
        productList = boProduct.searchByName(value);
        request.setAttribute("notification3", "Search Results");
        request.setAttribute("listProduct", productList);
        try {
            request.getRequestDispatcher("view/view.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boProduct.delete(id);
        List<Product> productList = boProduct.showListProduct();
        request.setAttribute("notification2", "Successfully Delete 1 Product");
        request.setAttribute("listProduct",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product extingEmployee = boProduct.findByID(id);
        if (extingEmployee == null) {
            request.setAttribute("message", "Not Found");
        } else {
            request.setAttribute("editProduct", extingEmployee);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/product-edit.jsp");

        dispatcher.forward(request  , response);
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("view/product-create.jsp");
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Product> productList = boProduct.showListProduct();
        request.setAttribute("listProduct", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view.jsp");
        dispatcher.forward(request, response);
    }
}
