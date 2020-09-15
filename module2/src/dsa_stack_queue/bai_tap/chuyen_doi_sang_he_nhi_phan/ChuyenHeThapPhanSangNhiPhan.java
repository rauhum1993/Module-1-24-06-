package dsa_stack_queue.bai_tap.chuyen_doi_sang_he_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class ChuyenHeThapPhanSangNhiPhan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the integer to convert to binary: ");
        int number = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();

        while (number != 0) {
            if (number % 2 == 0) {
                stack.push(0);
                number = number / 2;
            } else {
                stack.push(1);
                number = number / 2;
            }
        }
        String result = "";
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            result += stack.pop();
        }
        System.out.println(result);


    }
}
