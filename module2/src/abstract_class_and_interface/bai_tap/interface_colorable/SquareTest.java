package abstract_class_and_interface.bai_tap.interface_colorable;


class SquareTest {
    public static void main(String[] args) {
        Shape[] shape= new Shape[3];
         shape[0]= new Circle(2,"black",true);
        shape[1]=new Square(1,"red",true);
        shape[2]= new Rectangle(2,3,"orange",false);
        for (Shape i: shape){
            if (i instanceof Square){
                System.out.println(i);
                ((Square) i).howToColor();
            }

        }






    }

}