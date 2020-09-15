package bo;

import dao.DAOProduct;
import dao.IDAOProduct;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class BOProduct implements IBOProduct {
    IDAOProduct idaoProduct = new DAOProduct();
    @Override
    public List<Product> showListProduct() {
        return idaoProduct.showListProduct();
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        idaoProduct.create(product);
    }

    @Override
    public Product findByID(String id) {

        return idaoProduct.findByID(id);
    }

    @Override
    public void update(Product product) {
            idaoProduct.update(product);
    }

    @Override
    public void delete(String id) {
        idaoProduct.delete(id);
    }

    @Override
    public List<Product> searchByName(String name) {

        return idaoProduct.searchByName(name);
    }
}
