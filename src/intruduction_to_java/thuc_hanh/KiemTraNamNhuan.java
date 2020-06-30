package intruduction_to_java.thuc_hanh;

import java.util.Scanner;

public class KiemTraNamNhuan {
    public static void main(String[] args) {
        Scanner nam=new Scanner(System.in);
        System.out.print("Nhập vào năm cần xác định: ");
        int nhapNam= nam.nextInt();
        if(nhapNam % 4 == 0){
            if(nhapNam % 100 == 0){
                if(nhapNam % 400 == 0){
                    System.out.print(nhapNam+" là năm nhuận");
                } else {
                    System.out.print(nhapNam+" không phải là năm nhuận");
                }
            } else {
                System.out.print(nhapNam+" là năm nhuận");
            }
        } else {
            System.out.print(nhapNam+ " không phải là năm nhuận");
        }


    }
}
