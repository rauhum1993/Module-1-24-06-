package vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Print the rectangle");
        System.out.println("2.Print the square triangle (The corner is square at" +
                " 4 different angles: top-left, top-right, botton-left, botton-right)");
        System.out.println("3.Print isosceles triangle");
        System.out.println("4.Exit");
        System.out.println("Enter number: ");
        int choise = scanner.nextInt();
        switch (choise) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    System.out.println();
                    for (int j = 0; j < 7; j++) {
                        System.out.print("*");
                    }
                }
                break;
            case 2: {
                for (int i = 0; i < 6; i++) {
                    System.out.println();
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                }
                System.out.println();

                for (int i = 5; i > 0; i--) {
                    System.out.println();
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                }
                break;
            }
            case 3:
                System.out.println("Nhập chiều dài cạnh đáy:");
                int number=scanner.nextInt();
                for (int i = 0; i < number; i++) {
                    System.out.println();
                    for (int k = 0; k < (number+1) - i; k++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j <= (2*i+1); j++) {
                        System.out.print("*");
                    }


                }
                break;


        }
    }
}


