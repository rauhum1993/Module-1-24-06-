package bo;

import model.Product;

import java.util.List;

public interface ProductBO {
    List<Product> findAll();

    void save(Product product);

    Product findByID(String id);

    void  update(String id,Product product);

    void  remove(String id);

    Product searchByName(String name);
}

