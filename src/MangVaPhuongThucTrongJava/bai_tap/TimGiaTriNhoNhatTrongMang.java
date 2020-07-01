package MangVaPhuongThucTrongJava.bai_tap;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {

    public static int minValue(int[] array) {
        int min = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;

    }


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
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;

        }
        System.out.print("Property list: ");
        System.out.println();
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j] + "\t");
        }

        System.out.println("Is min: " + array[minValue(array)] +
                " and index:" + minValue(array));


    }
}
