package model;

public class Customer {
    private String name;
    private String birthday;
    private String address;
    private String imgCutomer;

    public Customer(String name, String birthday, String address, String imgCutomer) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.imgCutomer = imgCutomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgCutomer() {
        return imgCutomer;
    }

    public void setImgCutomer(String imgCutomer) {
        this.imgCutomer = imgCutomer;
    }
}
