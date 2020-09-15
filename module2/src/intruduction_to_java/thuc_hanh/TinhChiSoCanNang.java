package intruduction_to_java.thuc_hanh;

import java.util.Scanner;

public class TinhChiSoCanNang {
    public static void main(String[] args) {
        Scanner kiemTra = new Scanner(System.in);
        double chieuCao, canNang, chiSo;
        System.out.println(" Nhập chiều cao của You vào đê (nhập theo mét): ");
        chieuCao = kiemTra.nextDouble();
        System.out.println(" Nặng bao nhiêu đấy (nhập theo kg): ");
        canNang=kiemTra.nextDouble();
        chiSo=canNang/Math.pow(chieuCao,2);
        if(chiSo<18.5){
            System.out.println(chiSo+ " Thiếu cân ăn thêm vào");
        } else if (chiSo<25.0){
            System.out.println(chiSo +" ngon ,ăn thế thôi");
        } else if(chiSo<30.0){
            System.out.println(chiSo+ "thừa cân rồi ăn ít thôi");
        } else {
            System.out.println(chiSo+ "giờ thì thở cũng lên cân");
        }
    }
}
