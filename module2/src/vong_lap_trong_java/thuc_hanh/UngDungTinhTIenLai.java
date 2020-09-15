package vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class UngDungTinhTIenLai {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập số tiền gửi(vnđ): ");
        double soTien= scanner.nextDouble();
        System.out.println("Nhập lãi suất năm(%): ");
        double laiSuat=scanner.nextDouble();
        System.out.println("Nhập thời hạn gửi(tháng): ");
        int thang=scanner.nextInt();


    }
}
