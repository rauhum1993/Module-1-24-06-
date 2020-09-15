package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class TInhTongSoOMotCotXacDinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input row: ");
        int a = scanner.nextInt();
        System.out.println("Input column: ");
        int b = scanner.nextInt();
        int matrix[][] = new int[a][b];

        System.out.println("Enter " + matrix.length + " rows and " +
                matrix[0].length + " columns: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print("Enter row: " + row + "\t" + "column: " + column + " :");
                matrix[row][column] = scanner.nextInt();
            }

        }
        System.out.println("Array : ");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println("Enter the column you want to sum: ");
        int isColumn = scanner.nextInt();
        int sum=0 ;
        for (int i = 0; i < matrix.length; i++) {

                sum += matrix[i][isColumn-1];
        }
        System.out.println("Sum is Column "+isColumn+" = "+sum);
    }
}
