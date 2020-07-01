package MangVaPhuongThucTrongJava.bai_tap;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
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
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j] + "\t");
        }
        System.out.println("Nhap so can xoa: ");
        int input_name = scanner.nextInt();
        boolean isExist = false;
        int index_del;

        for (int k = 0; k < array.length; k++) {
            if (input_name == array[k]) {
                System.out.println("Position of the students in the list " + input_name + " is: " + (k + 1));
                index_del = k;
                for (i = index_del; i < array.length-1; i++) {
                    array[index_del] = array[index_del + 1];
                }

                isExist = true;
                break;
            }
        }
        if (!isExist)
            System.out.println("Not found " + input_name + " in the list.");
        System.out.print("Property list: ");
        for (int j = 0; j < array.length-1; j++) {
            System.out.println("\t"+array[j] + "\t");


            }
        }
    }


