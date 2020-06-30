package intruduction_to_java.bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        long rate= 23000;
        System.out.print("Nhập số tiền USD muốn quy đổi: ");
        long usd= scanner.nextLong();
        System.out.println("Số tiền vnđ sau khi quy đổi là:  "+ (usd*rate)+" vnđ");

    }
}
