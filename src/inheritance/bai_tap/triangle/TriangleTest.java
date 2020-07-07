package inheritance.bai_tap.triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle=new Triangle();
        System.out.println(triangle);

        triangle= new Triangle(3,3,3);
        System.out.println(triangle);
    }
}
