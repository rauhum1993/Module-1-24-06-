package dsa_stack_queue.bai_tap.dem_so_lan_xuat_hien_moi_tu_trong_mot_chuoi;

import java.util.Scanner;
import java.util.Stack;

public class DaoNguocChuoiSuDungStack {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap chuoi can dao nguoc vao: ");
        String str = scanner.nextLine();
        Stack<Character> stack= new Stack<>();
        for (int i=0; i<str.length();i++){
            stack.push(str.charAt(i));
        }
        System.out.println(stack);
        Stack<Character> newstack= new Stack<>();
        for(int j=stack.size()-1;j>=0;j--){
            newstack.push(stack.pop());
        }
        System.out.println(newstack);


    }
}
