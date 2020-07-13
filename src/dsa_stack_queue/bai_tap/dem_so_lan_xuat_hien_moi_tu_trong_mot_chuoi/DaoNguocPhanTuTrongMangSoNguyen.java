package dsa_stack_queue.bai_tap.dem_so_lan_xuat_hien_moi_tu_trong_mot_chuoi;

import java.util.Scanner;
import java.util.Stack;

public class DaoNguocPhanTuTrongMangSoNguyen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("nhap so luong so nguyen trong mang: ");
        int numberOf = scanner.nextInt();
        int i=0;
        do {
            System.out.println("Nhap so nguyen thu " + (i+1) + " can them: ");
            int number = scanner.nextInt();
            stack.push(number);
            i++;
        } while ( i<numberOf);
        System.out.println(stack);

        Stack<Integer> newstack= new Stack<>();

//        for(int j=stack.size()-1; j>=0;j--){
//            newstack.push(stack.pop());
//
//        }
        int size= stack.size();
        for(int j=0;j<size;j++){
            newstack.push(stack.pop());
        }
        System.out.println(newstack);




    }
}
