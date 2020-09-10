package bo.bo_contract;

import model.Contract;
import model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IBOContract {
    List<Contract> showListContract();


    void create(Contract contract) throws SQLException;
}
