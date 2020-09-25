import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/view")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first=0;
        float second =0;
        String option =null;
        float result =0;
        PrintWriter writer =response.getWriter();
        try{
        first = Float.parseFloat(request.getParameter("first"));
         second = Float.parseFloat(request.getParameter("second"));
         option= request.getParameter("option");
        result = 0;

       if (option.equals("addition")){
           result= first+second;
       } else
       if (option.equals("subtraction")){
           result= first-second ;
       } else     if (option.equals("multiplication")) {
           result = first * second;

       } else

               if (option.equals("division")) {
                   result = first / second;
               }
           } catch (ArithmeticException aExp){
            writer.println("<html>");
            writer.println("<h1 style=\"color: red\">error divided by 0</h1>");
            writer.println("<html>");
           } catch (Exception e) {
            writer.println("<html>");
            writer.println("<h1 style=\"color: red\" >Enter the wrong format</h1>");
            writer.println("<html>");
           }




        writer.println("<html>");
        writer.println("<h1>First operand: " + first+ "</h1>");
        writer.println("<h1>Second operand:" + second+ "</h1>");
        writer.println("<h1>Calculator: " + option+ "</h1>");
        writer.println("<h1>Result: " + result + "</h1>");
        writer.println("</html>");


    }
}
