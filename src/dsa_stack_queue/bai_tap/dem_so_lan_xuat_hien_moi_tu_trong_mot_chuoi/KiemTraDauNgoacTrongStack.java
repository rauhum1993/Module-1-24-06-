package dsa_stack_queue.bai_tap.dem_so_lan_xuat_hien_moi_tu_trong_mot_chuoi;

import java.util.Scanner;
import java.util.Stack;


public class KiemTraDauNgoacTrongStack {
    public static boolean checkSym(String str) {
        Stack<Character> stack = new Stack<>();
        boolean check = false;
        char left = '(';
        char right = ')';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {

            if (left == str.charAt(i)) {
                stack.push(left);
                count++;
            }

            if (right == str.charAt(i)) {
                count--;
                if (!stack.isEmpty()) {
                    check = true;
                    stack.pop();
                } else {
                    check = false;
                }
            }
        }
        if (count != 0) {
            check = false;
        }
        return check;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to check: ");
        String str = scanner.nextLine();
        boolean check = checkSym(str);
        if (check) {
            System.out.println("Well");
        } else {
            System.out.println("???????????");
        }
    }
}

