import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet",urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("productDescription");
        float listPrice = Float.parseFloat(request.getParameter("listPrice"));
        float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));

        float discountAmount = listPrice * discountPercent* 1/100;

       PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>ProductDescription: " + productDescription+ "</h1>");
        writer.println("<h1>ListPrice: " + listPrice+ "</h1>");
        writer.println("<h1>DiscountPercent: " + discountPercent+ "</h1>");
        writer.println("<h1>DiscountAmount: " + discountAmount+ "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
