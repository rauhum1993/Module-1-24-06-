package vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class Nhap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Không đúng! Mời bạn nhập lại mật khẩu: ");
        String password = sc.nextLine();
        while (password != "12345") {
            System.out.println("Không đúng! Mời bạn nhập lại mật khẩu: ");
            password = sc.nextLine();
        }
    }
}
