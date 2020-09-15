package bo;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IBOProduct {
    List<Product> showListProduct();

    void insertProduct(Product product) throws SQLException;

    Product findByID(String id);

    void update(Product product);

    void delete(String id);

    List<Product> searchByName(String name);
}
