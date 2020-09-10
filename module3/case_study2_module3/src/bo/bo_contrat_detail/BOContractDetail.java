package bo.bo_contrat_detail;

import dao.dao_contract_detail.DAOContractDetail;
import dao.dao_contract_detail.IDAOContractDetail;
import model.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public class BOContractDetail implements IBOContractdetail {
    IDAOContractDetail idaoContractDetail=new DAOContractDetail();
    @Override
    public List<ContractDetail> showListContractDetail() {
        return idaoContractDetail.showListContractDetail();
    }

    @Override
    public void create(ContractDetail contractDetail) throws SQLException {
        idaoContractDetail.create(contractDetail);
    }
}
