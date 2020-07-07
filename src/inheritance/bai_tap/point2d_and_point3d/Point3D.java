package inheritance.bai_tap.point2d_and_point3d;

public class Point3D  extends Point2D{

    private float z=0.0f;

    public Point3D(float x, float y,float z) {
        super(x, y);
        this.z=z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y,float z){

        this.z=getZ();
    }
    public float[] getXYZ() {
        float[] array = new float[3];
        array[0]=getX();
        array[1]=getY();
        array[2]=getZ();
        return array;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", z=" + getZ() +
                ", Array[3]= " + getXYZ()[0] +
                ","+getXYZ()[1]+","+getXYZ()[2]+
                '}';
    }
}
