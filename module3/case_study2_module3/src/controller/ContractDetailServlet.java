package controller;

import bo.bo_contract.BOContract;
import bo.bo_contrat_detail.BOContractDetail;
import model.Contract;
import model.ContractDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet",urlPatterns = "/contractDetail")
public class ContractDetailServlet extends HttpServlet {

    private BOContractDetail boContractDetail= new BOContractDetail();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                try {
                    createContractDetail(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                listContractDetail(request, response);
                break;
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String contractDetailID = request.getParameter("contractDetailID");
        String contractID = request.getParameter("contractID");
        String attachServiceID = request.getParameter("attachServiceID");
        String quantity = request.getParameter("quantity");

        ContractDetail contractDetail= new ContractDetail(contractDetailID,contractID,attachServiceID,quantity);
        boContractDetail.create(contractDetail);
        request.setAttribute("notification","Success One more contract detail");
        List<ContractDetail> contractDetailList = boContractDetail.showListContractDetail();

        request.setAttribute("listContractDetail", contractDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/contrat-detail-list.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }

        switch (actionUser) {
            case "create":
                showCreateContractDetail(request,response);
                break;
            default:
                listContractDetail(request,response);
                break;
        }
    }

    private void showCreateContractDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("contract/contract-detail-create.jsp");
    }


    private void listContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ContractDetail> contractDetailList = boContractDetail.showListContractDetail();

        request.setAttribute("listContractDetail", contractDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/contrat-detail-list.jsp");
        dispatcher.forward(request,response);
    }
}
