package dao.dao_service;

import dao.BaseDAO;
import model.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOService implements IDAOService {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_SERVICE = "select* from service";

    private static final String CREATE_NEW_SERVICE = "INSERT INTO service" + "  (" +
            "service_id,service_name,service_area,service_cost," +
            "service_max_people,rent_type_id,service_type_id,standard_room," +
            "description_orther_convenienve,pool_area,number_of_floors) VALUES " +
            " (?,?,?,?,?,?,?,?,?,?,?);";


    @Override
    public List<Service> showListService() {
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_SERVICE);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("service_id");
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                double cost = rs.getDouble("service_cost");
                int maxPeople = rs.getInt("service_max_people");
                int rentTypeId = rs.getInt("rent_type_id");
                int serviceTypeId = rs.getInt("service_type_id");
                String standardRoom = rs.getString("standard_room");
                String descriptionOrtherConvenienve = rs.getString("description_orther_convenienve");
                double poolArea = rs.getDouble("pool_area");
                int numberOfFloors = rs.getInt("number_of_floors");

                serviceList.add(new Service(id, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, descriptionOrtherConvenienve,
                        poolArea, numberOfFloors));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }



        @Override
    public void create(Service service) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_SERVICE);
                preparedStatement.setInt(1,service.getServiceId());
                preparedStatement.setString(2,service.getServiceName());
                preparedStatement.setInt(3,service.getServiceArea());
                preparedStatement.setDouble(4,service.getServiceCost());
                preparedStatement.setInt(5,service.getServiceMaxPeople());
                preparedStatement.setInt(6,service.getRentTypeId());
                preparedStatement.setInt(7,service.getServiceTypeId());
                preparedStatement.setString(8,service.getStandardRoom());
                preparedStatement.setString(9,service.getDescriptionOrtherConvenienve());
                preparedStatement.setDouble(10,service.getPoolArea());
                preparedStatement.setInt(11,service.getNumberOfFloors());

                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


}
