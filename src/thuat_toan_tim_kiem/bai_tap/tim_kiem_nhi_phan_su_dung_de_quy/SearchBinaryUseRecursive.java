package thuat_toan_tim_kiem.bai_tap.tim_kiem_nhi_phan_su_dung_de_quy;

import java.util.List;
import java.util.Scanner;

public class SearchBinaryUseRecursive {
    static int binarySearch(int[] list, int low, int high, int key) {


        if (high >= low) {
            int mid = ((high + low) / 2);

            if (key == list[mid]) {
                return mid;
            } else {
                if (key < list[mid]) {
                    return binarySearch(list, low, mid - 1, key);
                } else {
                    return binarySearch(list, mid + 1, high, key);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] list = {1, 2, 3, 4, 5, 7, 8};
        System.out.println("Enter Number To Search:");
        int number = scanner.nextInt();
        if (binarySearch(list, 0, list.length - 1, number) == -1) {
            System.out.println("Not Searching.");
        } else {
            System.out.println("Number " + number + " search in index: " +
                    binarySearch(list, 0, list.length - 1, number));
        }
    }
}