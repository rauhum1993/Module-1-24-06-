package dao;

import model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();

    void update(String id, Product product);

    void remove(int id);

    Product findByName(int id);

    void create(Product product);
}
