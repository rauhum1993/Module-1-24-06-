package dao;

import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProduct implements IDAOProduct {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_PRODUCT = "select * from product";

    private static final String CREATE_NEW_PRODUCT= "INSERT INTO product" + "  (id,name_product,price,numbers,color,status_product,category_name)" +
            " VALUES " + " (?,?,?,?,?,?,?);";

    private static String DELETE_PRODUCT_BY_ID = "delete from product where id=?";
    private static String SEARCH_NAME_PRODUCT = "select * from product where name_product like ?";

    private static String UPDATE_PRODUCT = "update product set name_product = ?, " +
            "price = ?, numbers = ?, color = ?, status_product = ?, category_name = ? where id=?;";

    private static final String SELECT_PRODUCT_BY_ID = "select id,name_product,price,numbers,color,status_product,category_name from product where id =?";
    @Override
    public List<Product> showListProduct() {
        List<Product> productList = new ArrayList<>();

        try {
          PreparedStatement  preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet rs = preparedStatement.executeQuery();
//            ma_mat_bang,trang_thai,dien_tich,tang,loai_van_phong,gia_tien,ngay_bat_dau,ngay_ket_thuc)
            while (rs.next()) {
                String id = rs.getString("id");
                String nameProduct = rs.getString("name_product");
                String price = rs.getString("price");
                String numbers = rs.getString("numbers");
                String color = rs.getString("color");
                String statusProduct = rs.getString("status_product");
                String categoryName = rs.getString("category_name");

                productList.add(new Product(id, nameProduct, price, numbers, color, statusProduct, categoryName));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void create(Product product) {
        try {
            PreparedStatement  preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_PRODUCT);
            preparedStatement.setString(1, product.getID());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getPrice());
            preparedStatement.setString(4, product.getNumbers());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getStatus());
            preparedStatement.setString(7, product.getCategory());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findByID(String id) {
        Product product=null;
        try {
            PreparedStatement  preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name_product");
                String price = rs.getString("price");
                String numbers = rs.getString("numbers");
                String color = rs.getString("color");
                String statusProduct = rs.getString("status_product");
                String categoryName = rs.getString("category_name");

                product = new Product(id,name,price,numbers,color,statusProduct,categoryName);



            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(Product product) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(UPDATE_PRODUCT);

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getNumbers());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getStatus());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.setString(7, product.getID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_PRODUCT_BY_ID);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_NAME_PRODUCT);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String nameProduct = rs.getString("name_product");
                String price = rs.getString("price");
                String numbers = rs.getString("numbers");
                String color = rs.getString("color");
                String statusProduct = rs.getString("status_product");
                String categoryName = rs.getString("category_name");

                productList.add(new Product(id,nameProduct,price,numbers,color,statusProduct,categoryName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
