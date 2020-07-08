package abstract_class_and_interface.bai_tap.interface_resizeble;

import abstract_class_and_interface.bai_tap.interface_resizeble.Circle;
import abstract_class_and_interface.bai_tap.interface_resizeble.Rectangle;
import abstract_class_and_interface.bai_tap.interface_resizeble.Shape;
import abstract_class_and_interface.bai_tap.interface_resizeble.Square;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1, "yellow", false);
        shapes[1] = new Rectangle(2, 3, "red", true);
        shapes[2] = new Square(4, "blue", true);
        shapes[2].setColor("red");
        for (Shape a : shapes){
            System.out.println(a);
        }
        for (Shape a : shapes) {
            a.resize(20);
        }
        for (Shape a : shapes){
            System.out.println(a);
        }
    }
}