package inheritance.bai_tap.point_and_moveable_point;




class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint=new MoveablePoint();
        System.out.println(moveablePoint);


        moveablePoint= new MoveablePoint(1.5f,1.6f,0.3f,0.4f);
        System.out.println(moveablePoint);
        moveablePoint.move();
        System.out.println(moveablePoint);


//        System.out.println(moveablePoint.move(
//                new float[] {moveablePoint.getX(),moveablePoint.getY()}));


    }

}