package controller;

import bo.bo_service.BOService;
import model.Customer;
import model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private BOService boService= new BOService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        try {
            switch (actionUser) {
                case "create":
                    insertService(request, response);
                    break;

                default:
                    listService(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int serviceArea = Integer.parseInt(request.getParameter("serviceArea"));
        double serviceCost = Double.parseDouble(request.getParameter("serviceCost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("serviceMaxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOrtherConvenienve = request.getParameter("descriptionOrtherConvenienve");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(id, name, serviceArea, serviceCost, serviceMaxPeople, rentTypeId
                , serviceTypeId, standardRoom, descriptionOrtherConvenienve,poolArea,numberOfFloors);
        boService.create(service);
        request.setAttribute("notification","Thanh Cong Them 1 Service");
        List<Service> serviceList = boService.showListService();
        request.setAttribute("listService", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/service-list.jsp");
        dispatcher.forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "create":
                showCreateService(request,response);
                break;
            default:
                listService(request,response);
                break;
        }
    }

    private void showCreateService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("service/service-create.jsp");
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = boService.showListService();

        request.setAttribute("listService", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/service-list.jsp");
        dispatcher.forward(request,response);
    }


}
