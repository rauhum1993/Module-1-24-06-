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

@WebServlet(name = "CustomerServlet",urlPatterns = {"","/cutomer"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Mai", "21/10/1996", "Da Nang", "anh/anh6.jpg"));
        customerList.add(new Customer("Ha", "10/10/1996", "Vinh", "anh/anh5.jpg"));
        customerList.add(new Customer("Hien", "03/10/1996", "Hue", "anh/anh8.jpg"));
        customerList.add(new Customer("Trang", "14/10/1996", "Ha Tinh", "anh/anh9.jpg"));

        request.setAttribute("list", customerList);
        request.getRequestDispatcher("/view.jsp").forward(request,response);
    }
}
