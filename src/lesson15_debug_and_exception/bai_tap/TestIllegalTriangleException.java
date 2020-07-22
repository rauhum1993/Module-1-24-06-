package lesson15_debug_and_exception.bai_tap;

import java.util.Scanner;

public class TestIllegalTriangleException {
    public static void checkException(int a, int b, int c) throws IllegalTriangleException {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("Nhap sai ,canh be hon 0");
        }
        if (a + b < c || b + c < a || a + c < b) {
            throw new IllegalTriangleException("Nhap tong hai canh be hon canh con lai");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap canh thu nhat: ");
            int firstEdge = scanner.nextInt();
            System.out.println("Nhap canh thu hai: ");
            int secondEdge = scanner.nextInt();
            System.out.println("Nhap canh thu ba: ");
            int thirdEdge = scanner.nextInt();

            checkException(firstEdge, secondEdge, thirdEdge);
            System.out.println("chu vi tam giac la " + (firstEdge + secondEdge + thirdEdge));
        } catch (IllegalTriangleException e) {

            System.out.println(e);

        } catch (Exception e) {
            System.out.println("Nhap vao chua phai la so nguyen");
        }

    }

}
