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
        String error = null;
//        PrintWriter writer =response.getWriter();
        try{
        first = Float.parseFloat(request.getParameter("first"));
         second = Float.parseFloat(request.getParameter("second"));
         option= request.getParameter("option");


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


           } catch (Exception e) {

         error=  "Enter the wrong format";

           }
        if(second!=0){
            request.setAttribute("first",first);
            request.setAttribute("second",second);
            request.setAttribute("result",result);

            request.setAttribute("option",option);
            error = "no errors";
            request.setAttribute("error",error);
        } else {
            error = "error divided by 0";
            request.setAttribute("first",first);
            request.setAttribute("second",second);
            request.setAttribute("option",option);
            request.setAttribute("error",error);
        }


            request.getRequestDispatcher("/result.jsp").forward(request,response);


//        writer.println("<html>");
//        writer.println("<h1>First operand: " + first+ "</h1>");
//        writer.println("<h1>Second operand:" + second+ "</h1>");
//        writer.println("<h1>Calculator: " + option+ "</h1>");
//        writer.println("<h1>Result: " + result + "</h1>");
//        writer.println("</html>");


    }
}
