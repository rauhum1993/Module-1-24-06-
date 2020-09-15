package inheritance.bai_tap.triangle;

public class Triangle extends ShapeExercises {
    private double z=1.0;

    public Triangle() {
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Triangle(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    public double getArea(){
        return Math.sqrt((getX()+getY()+z)*(getX()+getY()-z)*
                (getX()+z-getY())*(getY()+z-getX()))/4;
    }
    public double getPerimeter(){
        return getX()+getY()+z;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x =" + getX() +
                ",y = " + getY() +
                ",z = " + getZ() +
                " ,Area = " + getArea() +
                " ,Perimeter = " + getPerimeter() +
                '}';
    }
}
