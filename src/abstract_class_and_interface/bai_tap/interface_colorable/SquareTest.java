package abstract_class_and_interface.bai_tap.interface_colorable;


class SquareTest {
    public static void main(String[] args) {
        Square square=new Square();
        Square square1=new Square();
        square= new Square(4,"Colorable",true);
        square1= new Square(5,"red",true);

        System.out.println(square);
        System.out.println(square1);



        square.howToColor();
        square1.howToColor();
        System.out.println(square);
        System.out.println(square1);
    }

}