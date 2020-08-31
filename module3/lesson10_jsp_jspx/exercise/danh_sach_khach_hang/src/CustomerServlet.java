import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/listCustomer")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List <Customer> customerList =new ArrayList<>();
;
        customerList.add( new Customer("Khanh","2019/03/12","Vinh"," src=imagae_customer/anh1.jpg"));
        customerList.add( new Customer("Hai","2019/03/12","Vinh","src=imagae_customer/anh2.jpg"));
        customerList.add( new Customer("Tung","2019/03/12","Vinh","src=imagae_customer/anh3.jpg"));
        customerList.add( new Customer("Khanh","2019/03/12","Vinh","src=imagae_customer/anh4.jpg"));

        request.setAttribute("ListCustomer",customerList);
        request.getRequestDispatcher("display_list.jsp").forward(request, response);
    }
}
