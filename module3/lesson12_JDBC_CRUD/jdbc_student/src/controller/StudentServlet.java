package controller;

import bo.IStudentBO;
import bo.StudentBO;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private IStudentBO studentBO =new StudentBO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "create":
                insertStudent(request, response);
                break;

            default:
                listStudent(request,response);
                break;

        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) {
        String id =request.getParameter("id");
        String name =request.getParameter("name");
        String address =request.getParameter("address");
        Student student = new Student(id,name,address);
        studentBO.insertStudent(student);
//        response.sendRedirect("/student");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "create":
                goCreateNewStudent(request,response);
                break;
            default:

                break;


        }
    }

    private void goCreateNewStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("student/create.jsp");
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentBO.sellectAllStudent();
        request.setAttribute("listStudent",studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        dispatcher.forward(request,response);
    }




}
