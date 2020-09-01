package bo;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.Product;

import java.util.List;

public class ProductBOImpl implements ProductBO {


    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public void update(String id, Product product) {
        productDAO.update(id,product);
    }

    @Override
    public void remove(int id) {
        productDAO.remove(id);
    }

    @Override
    public Product findByName(int id) {
        return productDAO.findByName(id);
    }

    @Override
    public void create(Product product) {

    }

//    static {
//        products = new HashMap<>();
//        products.put(1, new Product(1, "Bút bi", 5000.0, "màu xanh","Thiên Long"));
//        products.put(2, new Product(2, "Bút chì", 15000.0, "màu xám","CodeGym"));
//        products.put(3, new Product(3, "Bút Nước", 25000.0, "màu đỏ","Hải Xồm"));
//        products.put(4, new Product(4, "Bút Mực", 150000.0, "màu đen","Hà Nội"));
//        products.put(5, new Product(5, "Bút Lông", 10000.0, "màu xang","Đà nẵng"));
//
//    }



}
