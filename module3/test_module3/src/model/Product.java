package model;

public class Product {
   private String ID;
   private String name;
   private String price;
   private String numbers;
   private String color;
   private String status;
   private String category;

    public Product(String ID, String name, String price, String numbers, String color, String status, String category) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.numbers = numbers;
        this.color = color;
        this.status = status;
        this.category = category;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
