package inheritance.bai_tap.circle_and_cylinder;

public class CyliderTest {
    public static void main(String[] args) {
        Cylider cylider= new Cylider();
        System.out.println(cylider);

        cylider= new Cylider("red",5,10);
        System.out.println(cylider);
    }
}
