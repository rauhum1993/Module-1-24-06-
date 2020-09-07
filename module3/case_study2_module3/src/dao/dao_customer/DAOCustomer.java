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
    private static final String SELECT_ALL_CUSTOMER = "select* from customer";
    private static final String CREATE_NEW_CUSTOMER = "INSERT INTO customer" + "  (customer_id,customer_type_id,customer_name," +
            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?,?,?,?,?,?,?,?,?);";
    private static final String INSERT_CUTOMER_SQL = "INSERT INTO customer" + "  (customer_id,customer_type_id,customer_name," +
            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_CUSTOMER_BY_ID = "select customer_id,customer_type_id,customer_name,customer_birthday," +
            "customer_gender,customer_id_card,customer_phone,customer_email,customer_address from customer where customer_id =?";
    private static final String EDIT_CUSTOMER = "UPDATE customer SET customer_type_id = ?, customer_name = ?, " +
            "customer_birthday = ?,customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?," +
            " customer_address = ? WHERE customer_id = ?;";

    private static String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id=?";

    private static String SEARCH_NAME_CUSTOMER = "select*from customer where customer_name like ?";

    @Override
    public List<Customer> showListCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Customer_id");
                int typeId = rs.getInt("customer_type_id");
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                int gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");


                customerList.add(new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address));

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

    @Override
    public void insert(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_CUTOMER_SQL);
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

    }

    @Override
    public Customer findByID(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int typeID = rs.getInt("customerTypeId");
                String name = rs.getString("customerName");
                String birthday = rs.getString("customerBirthday");
                int gender = rs.getInt("customerGender");
                String idCard = rs.getString("customerIdCard");
                String phone = rs.getString("customerPhone");
                String email = rs.getString("customerEmail");
                String address = rs.getString("customerAddress");
                customer = new Customer(id, typeID, name, birthday, gender, idCard, phone, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(EDIT_CUSTOMER);
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customer.getCustomerId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_NAME_CUSTOMER);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Customer_id");
                int typeId = rs.getInt("customer_type_id");
                String nameCustomer = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                int gender = rs.getInt("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");


                customerList.add(new Customer(id, typeId, nameCustomer, birthday, gender, idCard, phone, email, address));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}


