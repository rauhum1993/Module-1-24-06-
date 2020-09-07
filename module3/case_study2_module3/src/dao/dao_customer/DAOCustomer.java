package dao.dao_customer;

import dao.BaseDAO;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCustomer implements IDAOCustomer {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_CUSTOMER = "select* from fumara.student";
    private static final String CREATE_NEW_CUSTOMER = "INSERT INTO furama_wbe.cutomer" + "  (customer_id,customer_type_id,customer_name," +
            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?,?,?,?,?,?,?,?,?);";


    @Override
    public List<Customer> showListCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("Customer_id");
                int typeId = rs.getInt("customer_type_id");
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                int gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");


                customerList.add(new Customer(id,typeId,name,birthday,gender,idCard,phone,email,address));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void create(Customer customer) {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setInt(2, customer.getCustomerTypeId());
            preparedStatement.setString(3, customer.getCustomerName());
            preparedStatement.setString(4, customer.getCustomerBirthday());
            preparedStatement.setInt(5, customer.getCustomerGender());
            preparedStatement.setString(6, customer.getCustomerIdCard());
            preparedStatement.setString(7, customer.getCustomerPhone());
            preparedStatement.setString(8, customer.getCustomerEmail());
            preparedStatement.setString(9, customer.getCustomerAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
