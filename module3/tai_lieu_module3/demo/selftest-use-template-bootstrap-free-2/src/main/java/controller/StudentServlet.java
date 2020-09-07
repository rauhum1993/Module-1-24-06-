package controller;

import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/studentServlet"})
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // List from DAO
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "Tien", "04/09/2020", 8));
        studentList.add(new Student(2, "Hung", "03/07/1999", 4));


        request.setAttribute("studentListAbc", studentList);
        request.getRequestDispatcher("/test-list.jsp").forward(request, response);
    }
}
