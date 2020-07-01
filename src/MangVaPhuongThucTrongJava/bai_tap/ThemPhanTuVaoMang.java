package MangVaPhuongThucTrongJava.bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {

        int size;
        int[] array;


        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("Enter a size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);

        array = new int[size + 1];
        int i = 0;
        while (i < array.length - 1) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;

        }
        System.out.print("Property list: ");
        System.out.println("");
        for (int j = 0; j < array.length - 1; j++) {
            System.out.println(array[j] + "\t");
        }
        System.out.println("Nhap so can them: ");
        int input_name = scanner.nextInt();
        System.out.println("nhap vi tri can chen " + input_name + " vao trong mang");
        int index = scanner.nextInt();

        for (i = array.length - 1; i > index - 1; i--) {

            array[i] = array[i - 1];
        }
        array[index - 1] = input_name;


        for (int j = 0; j < array.length; j++) {
            System.out.println("\t" + array[j] + "\t");

        }
    }
}

