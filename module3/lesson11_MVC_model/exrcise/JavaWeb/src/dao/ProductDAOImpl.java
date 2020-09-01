package dao;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductDAOImpl implements ProductDAO{
    private static Map<String, Product> productMap = new TreeMap<>();

    static {

        productMap.put("1", new Product("1", "Bút bi", 5000.0, "màu xanh","Thiên Long"));
        productMap.put("2", new Product("2", "Bút chì", 15000.0, "màu xám","CodeGym"));
        productMap.put("3", new Product("3", "Bút Nước", 25000.0, "màu đỏ","Hải Xồm"));
        productMap.put("4", new Product("4", "Bút Mực", 150000.0, "màu đen","Hà Nội"));
        productMap.put("5", new Product("5", "Bút Lông", 10000.0, "màu xang","Đà nẵng"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void update(String id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findByName(int id) {
        return productMap.get(id);
    }
}
