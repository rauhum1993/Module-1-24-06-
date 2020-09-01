package bo;

import model.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAll();

    void update(String id, Product product);

    void remove(int id);

    Product findByName(int id);

    void create(Product product);


}
