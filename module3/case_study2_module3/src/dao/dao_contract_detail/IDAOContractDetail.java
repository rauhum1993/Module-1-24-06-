package dao.dao_contract_detail;

import model.Contract;
import model.ContractDetail;

import java.util.List;

public interface IDAOContractDetail {
    List<ContractDetail> showListContractDetail();

    void create(ContractDetail contractDetail) ;
}
