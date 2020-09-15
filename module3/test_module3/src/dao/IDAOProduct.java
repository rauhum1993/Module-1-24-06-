package dao;

import model.Product;

import java.util.List;

public interface IDAOProduct {
    List<Product> showListProduct();

    void create(Product product) ;


    Product findByID(String id);

    void update(Product product);

    void delete(String id);

    List<Product> searchByName(String name);
}
