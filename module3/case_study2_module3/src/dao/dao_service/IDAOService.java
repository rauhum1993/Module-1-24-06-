package dao.dao_service;


import model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IDAOService {
    List<Service> showListService();

    void create(Service service) ;


}
