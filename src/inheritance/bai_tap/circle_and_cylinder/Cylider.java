package inheritance.bai_tap.circle_and_cylinder;

public class Cylider extends Circle {
    private double height;

    public Cylider() {
    }

    public Cylider(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return getArea()*height;
    }

    @Override
    public String toString() {
        return "A Cylider with height of "
                + getHeight()
                +"The volumn= "
                + getVolume()
                +super.toString();
    }
}
