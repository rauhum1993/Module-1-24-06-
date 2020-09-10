package dao.dao_contract;

import model.Contract;
import model.Service;

import java.util.List;

public interface IDAOContract {
    List<Contract> showListContract();

    void create(Contract contract) ;
}
