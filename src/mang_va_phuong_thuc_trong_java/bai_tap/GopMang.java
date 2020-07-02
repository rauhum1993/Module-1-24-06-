package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int size1;
        int size2;
        int[] array1;
        int[] array2;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter a size mang 1: ");
            size1 = scanner.nextInt();
            if (size1 > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size1 > 20);

        array1 = new int[size1];
        int i = 0;
        while (i < array1.length) {
            System.out.print("Enter element" + (i + 1)+" mang 1 la: " + " : ");
            array1[i] = scanner.nextInt();
            i++;

        }

        do {
            System.out.println("Enter a size mang 2 : ");
            size2 = scanner.nextInt();
            if (size2 > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size2 > 20);

        array2 = new int[size2];
        int i1 = 0;

        while (i1 < array2.length) {
            System.out.print("Enter element" + (i1 + 1)+" mang 2 la " + " : ");
            array2[i1] = scanner.nextInt();
            i1++;
        }

        System.out.print("mang 1: ");
        System.out.println("");

        for (int j = 0; j < array1.length; j++) {
            System.out.print(array1[j] + "\t");

        }
        System.out.println("");
        System.out.print("mang 2: ");
        System.out.println("");
        for (int j = 0; j < array2.length; j++) {
            System.out.print(array2[j] + "\t");
        }
        int[] array3= new int[size1+size2];
        for(int p=0;p<size1;p++){
            array3[p]=array1[p];
        }

        int count=0;

        for (int k=size1; k<size1+size2;k++){

            array3[k]=array2[count++];
        }

        System.out.println("");
        for(int val :array3){
            System.out.println(val);
        }

    }
}