package controller;

import bo.bo_contract.BOContract;
import bo.bo_service.BOService;
import model.Contract;
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

@WebServlet(name = "ContractServlet",urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private BOContract boContract= new BOContract();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                try {
                    createContract(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                listContract(request, response);
                break;
        }

    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id =request.getParameter("id");
        String contractStartDate =request.getParameter("contractStartDate");
        String contractEndDate =request.getParameter("contractEndDate");
        String contractDeposit =request.getParameter("contractDeposit");
        String contractTotalMoney =request.getParameter("contractTotalMoney");
        String employeeId =request.getParameter("employeeId");
        String customerId =request.getParameter("customerId");
        String serviceId =request.getParameter("serviceId");

        Contract contract =new Contract(id,contractStartDate,contractEndDate,contractDeposit,contractTotalMoney,
                employeeId,customerId,serviceId);
        boContract.create(contract);
        request.setAttribute("notification","Success One more contract");
        List<Contract> contractList = boContract.showListContract();

        request.setAttribute("listContract", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/contract-list.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "create":
                showCreateContract(request,response);
                break;
            default:
                listContract(request,response);
                break;
        }
    }

    private void showCreateContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("contract/contract-create.jsp");
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = boContract.showListContract();

        request.setAttribute("listContract", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/contract-list.jsp");
        dispatcher.forward(request,response);
    }
}
