package dao.dao_contract;

import dao.BaseDAO;
import model.Contract;
import model.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOContract implements IDAOContract {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_CONTRACT = "select* from contract";

    private static final String CREATE_NEW_CONTRACT = "INSERT INTO contract" + "  (" +
            "contract_id,contract_start_date,contract_end_date,contract_deposit,\n" +
            "          contract_total_money,employee_id,customer_id,service_id) VALUES " +
            " (?,?,?,?,?,?,?,?);";


    @Override
    public List<Contract> showListContract() {
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CONTRACT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("contract_id");
                String contractStartDate = rs.getString("contract_start_date");
                String contractEndDate = rs.getString("contract_end_date");
                String contractDeposit = rs.getString("contract_deposit");
                String contractTotalMoney = rs.getString("contract_total_money");
                String employeeId = rs.getString("employee_id");
                String customerId = rs.getString("customer_id");
                String serviceId = rs.getString("service_id");

                contractList.add(new Contract(id,contractStartDate,contractEndDate,contractDeposit,contractTotalMoney,
                        employeeId,customerId,serviceId));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  contractList;
    }

    @Override
    public void create(Contract contract) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_CONTRACT);
            preparedStatement.setString(1,contract.getContractId());
            preparedStatement.setString(2,contract.getContractStartDate());
            preparedStatement.setString(3,contract.getContractEndDate());
            preparedStatement.setString(4,contract.getContractDeposit());
            preparedStatement.setString(5,contract.getContractTotalMoney());
            preparedStatement.setString(6,contract.getEmployeeId());
            preparedStatement.setString(7,contract.getCustomerId());
            preparedStatement.setString(8,contract.getServiceId());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
