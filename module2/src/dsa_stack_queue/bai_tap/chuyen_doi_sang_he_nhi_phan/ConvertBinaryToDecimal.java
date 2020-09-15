package dsa_stack_queue.bai_tap.chuyen_doi_sang_he_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class ConvertBinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the binary number to convert to decimal: ");
        long number = scanner.nextLong();
        Stack<Integer> stack = new Stack<>();
        while (number != 0) {
            if (number % 2 == 0) {
                stack.push(0);
                number = number / 10;
            } else {
                stack.push(1);
                number = (number - 1) / 10;
            }
        }
        System.out.println(stack);
//        Stack<Integer> newstack = new Stack<>();
//        for (int j = stack.size() - 1; j >= 0; j--) {
//            newstack.push(stack.pop());
//        }
//        System.out.println(newstack);
        int result = 0;
        int size = stack.size();
        for (int k=0;k<size;k++){
            if (stack.get(k)==1){
                result+=Math.pow(2,k);
            }


        }
        System.out.println(result);


    }
}
