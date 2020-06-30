package vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in ra: ");
        int number = scanner.nextInt();
        int count = 0;
        int n = 2;
        String allNumber = "";
        while (count < number) {
            boolean check = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }

            }
            if (check){
                count++;
                allNumber+=n+" ";
            } n++;
        }
        System.out.println(allNumber);
    }
}
