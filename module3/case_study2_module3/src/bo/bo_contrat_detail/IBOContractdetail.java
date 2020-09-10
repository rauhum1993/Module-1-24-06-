package bo.bo_contrat_detail;

import model.Contract;
import model.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface IBOContractdetail {
    List<ContractDetail> showListContractDetail();


    void create(ContractDetail contractDetail) throws SQLException;
}
