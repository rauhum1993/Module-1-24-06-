import javafx.scene.image.Image;

import java.util.Date;

public class Customer {
    private String nameCustomer;
    private String birthdayCutomer;
    private String address;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthdayCutomer() {
        return birthdayCutomer;
    }

    public void setBirthdayCutomer(String birthdayCutomer) {
        this.birthdayCutomer = birthdayCutomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(String nameCustomer, String birthdayCutomer, String address, String image) {
        this.nameCustomer = nameCustomer;
        this.birthdayCutomer = birthdayCutomer;
        this.address = address;
        this.image = image;
    }
}
