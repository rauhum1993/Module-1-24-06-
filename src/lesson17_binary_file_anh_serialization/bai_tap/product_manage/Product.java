package lesson17_binary_file_anh_serialization.bai_tap.product_manage;

import java.awt.*;
import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private int iD;
    private int price;
    private String manufacturer;
    private String otherDescription;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public Product( int iD, String productName, int price, String manufacturer, String otherDescription) {
        this.productName = productName;
        this.iD = iD;
        this.price = price;
        this.manufacturer = manufacturer;
        this.otherDescription = otherDescription;
    }
    @Override
    public String toString() {
        return " nameProduct= " + productName +
                "  id= " + iD +
                "  price= " + price+
                " manufacturer "+ manufacturer +
                " Other Description " + otherDescription +"\n";
    }


}
