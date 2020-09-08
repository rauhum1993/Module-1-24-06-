package bo.bo_service;

import dao.dao_service.DAOService;
import dao.dao_service.IDAOService;
import model.Service;

import java.sql.SQLException;
import java.util.List;

public class BOService implements IBOService {
    IDAOService idaoService = new DAOService();
    @Override
    public List<Service> showListService() {
        return idaoService.showListService();
    }


    @Override
    public void create(Service service) throws SQLException {
        idaoService.create(service);
    }
}
