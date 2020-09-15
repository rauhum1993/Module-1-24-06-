package inheritance.bai_tap.circle_and_cylinder;

public class Circle {
    private String color = "green";
    private double radius = 10;

    public Circle() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with color of "
                + getColor()
                + " and "
                + "radius= "+ getRadius()
                + " The Area = "+ getArea() ;
    }
}
