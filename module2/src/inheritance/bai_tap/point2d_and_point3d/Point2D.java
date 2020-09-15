package inheritance.bai_tap.point2d_and_point3d;

public class Point2D {
   private float x=0.0f;
   private float y=0.0f;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x,float y){
        this.x=getX();
        this.y=getY();
    }
    public float[] getXY(){
        float[] array= new float[2];
        array[0]=getX();
        array[1]=getY();
        return array;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x= " + getX() +
                ", y= " + getY() +
                " Array= "+ getXY()[0] +","+ getXY()[1]+
                '}';
    }
}
