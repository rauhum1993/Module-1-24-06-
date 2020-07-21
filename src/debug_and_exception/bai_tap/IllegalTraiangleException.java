package debug_and_exception.bai_tap;

import java.util.Scanner;

public class IllegalTraiangleException {
    public static void checkException(int a, int b, int c)throws IllegalArgumentException {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Nhap sai ,canh be hon 0");
        }
        if (a + b < c || b + c < a || a + c < b) {
            throw new IllegalArgumentException("Nhap tong hai canh be hon canh con lai");
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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }catch (Exception e){
            System.out.println("Nhap vao chua phai la so nguyen");
        }


    }
}

