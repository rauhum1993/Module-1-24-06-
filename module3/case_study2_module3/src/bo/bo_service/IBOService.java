package bo.bo_service;


import model.Service;


import java.sql.SQLException;
import java.util.List;

public interface IBOService {
    List<Service> showListService();


    void create(Service service) throws SQLException;

}
