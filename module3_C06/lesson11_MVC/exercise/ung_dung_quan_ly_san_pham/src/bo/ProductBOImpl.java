package bo;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBOImpl implements ProductBO {
   private static Map<String,Product> productMap =new HashMap<>();
   static {
       productMap.put("1",new Product("1","Giay nike","1000000","USA"));
       productMap.put("2",new Product("2","Ao nike","2000000","China"));
       productMap.put("3",new Product("3","Quan nike","3400000","DONG LAO"));
       productMap.put("4",new Product("4","Dep nike","5600000","NGA"));
       productMap.put("5",new Product("5","Mu nike","7800000","AN DO"));
   }




    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findByID(String id) {
        return productMap.get(id);
    }

    @Override
    public void update(String id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(String id) {
        productMap.remove(id);
    }

    @Override
    public Product searchByName(String name) {

        return null;
    }
}
