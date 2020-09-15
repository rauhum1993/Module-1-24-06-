package access_mondifier_static_method_static_protected.bai_tap;

public class Circle {
    public static void main(String[] args) {
        System.out.println(Circle.radius);
    }
    public static double radius = 1.0;
    private String color = "red";
    public Circle() {

    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}

