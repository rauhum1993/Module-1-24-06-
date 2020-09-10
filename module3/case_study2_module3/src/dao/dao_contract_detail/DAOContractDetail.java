package dao.dao_contract_detail;

import dao.BaseDAO;
import model.Contract;
import model.ContractDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOContractDetail implements IDAOContractDetail {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_CONTRACT_DETAIL = "select* from contract_detail";

    private static final String CREATE_NEW_CONTRACT_DETAIL = "INSERT INTO contract_detail" + "  (" +
            "contract_detail_id,contract_id,attach_service_id,quantity) VALUES " +
            " (?,?,?,?);";

    @Override
    public List<ContractDetail> showListContractDetail() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String contractDetailId =rs.getString("contract_detail_id");
                String contractId =rs.getString("contract_id");
                String attachServiceId =rs.getString("attach_service_id");
                String quantity =rs.getString("quantity");

                contractDetailList.add(new ContractDetail(contractDetailId,contractId,attachServiceId,quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetailList;
    }

    @Override
    public void create(ContractDetail contractDetail) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_CONTRACT_DETAIL);
            preparedStatement.setString(1,contractDetail.getContractDetailID());
            preparedStatement.setString(2,contractDetail.getContractID());
            preparedStatement.setString(3,contractDetail.getAttachServiceID());
            preparedStatement.setString(4,contractDetail.getQuantity());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
