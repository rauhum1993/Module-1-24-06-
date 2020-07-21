package debug_and_exception.bai_tap;

import java.util.Scanner;

public class TestIllegalTriangleException {


    public static void main(String[] args) {


        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap canh thu nhat: ");
            int firstEdge = scanner.nextInt();
            System.out.println("Nhap canh thu hai: ");
            int secondEdge = scanner.nextInt();
            System.out.println("Nhap canh thu ba: ");
            int thirdEdge = scanner.nextInt();
            IllegalTriangleException.checkException(firstEdge, secondEdge, thirdEdge);
            System.out.println("chu vi tam giac la " + (firstEdge + secondEdge + thirdEdge));
        } catch (IllegalTriangleException e) {
            System.out.println(e);

        }catch (Exception e){
            System.out.println("Nhap vao chua phai la so nguyen");
        }


    }
}
