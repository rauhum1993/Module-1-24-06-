package intruduction_to_java.bai_tap;

import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Cho biết tên bạn đi: ");
        String name= scanner.nextLine();
        System.out.println("Hello "+ name);

    }
}
