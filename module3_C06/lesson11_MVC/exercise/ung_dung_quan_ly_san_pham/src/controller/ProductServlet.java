package controller;

import bo.ProductBO;
import bo.ProductBOImpl;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = {"","/servlet"})
public class ProductServlet extends HttpServlet {
        ProductBO productBO = new ProductBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if(actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        productBO.remove(id);
        List<Product> productList = productBO.findAll();

        request.setAttribute("list", productList);
        request.getRequestDispatcher("/view/list.jsp").forward(request,response);

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String producer = request.getParameter("producer");
        Product product = productBO.findByID(id);

        if (product == null) {
            request.setAttribute("message", "Not found Product");
        } else {
            product.setName(name);
            product.setPrice(price);
            product.setProducer(producer);
            productBO.update(id, product);
            request.setAttribute("product", product);
            request.setAttribute("message", "Product information was updated");



        }
        List<Product> productList= this.productBO.findAll();
        request.setAttribute("list",productList);
        request.getRequestDispatcher("/view/list.jsp").forward(request,response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String producer = request.getParameter("producer");


        Product product = new Product(id, name, price, producer);
        productBO.save(product);
        request.setAttribute("message","New product was created");

        List<Product> customerList = productBO.findAll();
        request.setAttribute("list", customerList);
        request.getRequestDispatcher("/view/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if(actionUser == null){
            actionUser = "";
        }
        switch (actionUser){
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
            case "search":
                searchbyname(request,response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void searchbyname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<Product> productList = new ArrayList<>();

        for (Product product : productBO.findAll()) {
            if ((product.getName().toLowerCase()).contains(name.toLowerCase())) {
                productList.add(product);
            }
        }
        if (!productList.isEmpty()) {
            request.setAttribute("list", productList);

        } else {
            request.setAttribute("message", "File Not Found");
        }

        request.getRequestDispatcher("/view/list.jsp").forward(request,response);

    }

    private void showviewform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productBO.findByID(id);
        List<Product> productList =new ArrayList<>();
        productList.add(product);
        if (product==null){
            request.setAttribute("message","Not found Customer");
        } else {

            request.setAttribute("list", productList);
            request.setAttribute("message","Found Product");
            request.getRequestDispatcher("/view/list.jsp").forward(request,response);
        }

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productBO.findByID(id);
        if (product==null){
            request.setAttribute("message","Not found Product");
        } else {
            request.setAttribute("product",product);
        }
        request.getRequestDispatcher("/view/delete.jsp").forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productBO.findByID(id);
        if (product==null){
            request.setAttribute("message","Not found Product");
        } else {
            request.setAttribute("product",product);
        }
        request.getRequestDispatcher("/view/edit.jsp").forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/create.jsp").forward(request,response);
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList= this.productBO.findAll();
        request.setAttribute("list",productList);
        request.getRequestDispatcher("/view/list.jsp").forward(request,response);

    }
}
