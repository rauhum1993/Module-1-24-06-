package dsa_stack_queue.bai_tap.kiem_tra_chuoi_Palindrome_su_dung_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckPalindromeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to check: ");
        String str = scanner.nextLine();
        boolean checkPalindrome= checkPalindrome(str);
        if (checkPalindrome) {
            System.out.println( "the string is a Palindrome");
        } else System.out.println("the string is not a Palindrome");
    }


    private static boolean checkPalindrome(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.charAt(i));
            stack.push(str.charAt(i));
        }
        for (int j = 0; j < str.length(); j++) {

            if (queue.remove() != stack.pop()) {
                check = false;
                break;
            } else check = true;
        }
        return check;
    }


}

