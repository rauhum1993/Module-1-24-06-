package controller;

import dao.IUserDAO;
import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"", "/servlet"})
public class UserServlet extends HttpServlet {
    IUserDAO iUserDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        iUserDAO.deleteUser(id);

        List<User> userList = this.iUserDAO.selectAllUsers();
        request.setAttribute("list", userList);
        request.setAttribute("message", "Delete a user with id=  " + id);
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(id, name, email, country);
        iUserDAO.insertUserStore(newUser);

        List<User> userList = this.iUserDAO.selectAllUsers();
        request.setAttribute("list", userList);
        request.setAttribute("message", "create new user ");
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);

    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(id, name, email, country);
        iUserDAO.updateUser(newUser);

        List<User> userList = this.iUserDAO.selectAllUsers();
        request.setAttribute("list", userList);
        request.setAttribute("message", "Update user with id= " + id);
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "search":
                showSearchForm(request, response);
                break;
            case "Sort By Name":
                sortByName(request, response);
                break;
            case "permision":
                addUserPermision(request, response);
                break;
            case "test-without-tran":

                testWithoutTran(request, response);
                break;
            case "test-use-tran":

                testUseTran(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }

    private void testUseTran(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iUserDAO.insertUpdateUseTransaction();
        List<User> userList = iUserDAO.selectAllUsers();
        request.setAttribute("list", userList);
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        iUserDAO.insertUpdateWithoutTransaction();
        List<User> userList = iUserDAO.selectAllUsers();
        request.setAttribute("list", userList);
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User( "10","kienhoang", "kienhoang@gmail.com","viet nam");

        int[] permision = {1, 2, 4};

        iUserDAO.addUserTransaction(user,permision);

        List<User> userList = iUserDAO.selectAllUsers();
        request.setAttribute("list", userList);
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);

    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = this.iUserDAO.sortByName();
        request.setAttribute("list", userList);
        request.setAttribute("message", "Sort user by  name  ");
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<User> userList = this.iUserDAO.searchByCountry(name);
        request.setAttribute("list", userList);
        request.setAttribute("message", "Search user with country = " + name);
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/create.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = iUserDAO.getUserById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/view/edit.jsp").forward(request, response);

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = iUserDAO.selectUser(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/view/delete.jsp").forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = this.iUserDAO.selectAllUsers();
        request.setAttribute("list", userList);
        request.getRequestDispatcher("/view/list.jsp").forward(request, response);
    }
}
