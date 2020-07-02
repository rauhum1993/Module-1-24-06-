package mang_va_phuong_thuc_trong_java.bai_tap;


import java.util.Scanner;

public class TimPhanTuLonNhatTrongMangHaiChieu {
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
                System.out.print("Enter row: " + row +"\t"+ "column: " + column+" :");
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
        int max=0;
        for (int row = 0; row < matrix.length; row++) {

            for (int column = 0; column < matrix[row].length; column++) {
               max=  matrix[0][0];
              if (matrix[row][column]>max){
                  max=matrix[row][column];
              }
            }

        }
        System.out.print("Max ="+ max);
    }
}
