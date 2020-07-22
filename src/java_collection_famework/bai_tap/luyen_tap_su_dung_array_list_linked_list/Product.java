package java_collection_famework.bai_tap.luyen_tap_su_dung_array_list_linked_list;

import java.io.Serializable;

public class Product  {
   private String nameProduct;
   private int id;
   private double price;

    public Product(String nameProduct, int id, double price) {
        this.nameProduct = nameProduct;
        this.id = id;
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " nameProduct= " + nameProduct +
                "  id= " + id +
                "  price= " + price+"\n";
    }
}
