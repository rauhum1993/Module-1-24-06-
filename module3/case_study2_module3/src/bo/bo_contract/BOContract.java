package bo.bo_contract;

import dao.dao_contract.DAOContract;
import dao.dao_contract.IDAOContract;
import model.Contract;

import java.sql.SQLException;
import java.util.List;

public class BOContract implements IBOContract {
    IDAOContract idaoContract = new DAOContract();
    @Override
    public List<Contract> showListContract() {
       return idaoContract.showListContract();
    }

    @Override
    public void create(Contract contract) throws SQLException {
        idaoContract.create(contract);
    }
}
