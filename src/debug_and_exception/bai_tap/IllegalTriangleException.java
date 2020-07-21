package debug_and_exception.bai_tap;


public class IllegalTriangleException  extends  Exception{

    public IllegalTriangleException(String message) {
        super(message);
    }

    public static void checkException(int a, int b, int c)throws IllegalTriangleException {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("Nhap sai ,canh be hon 0");
        }
        if (a + b < c || b + c < a || a + c < b) {
            throw new IllegalTriangleException("Nhap tong hai canh be hon canh con lai");
        }

    }

}

