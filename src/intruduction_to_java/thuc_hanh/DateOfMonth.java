package intruduction_to_java.thuc_hanh;

import java.util.Scanner;

public class DateOfMonth {
    public static void main(String[] args) {
        Scanner thangNam =new Scanner(System.in);
        System.out.print("Hãy nhập vào tháng mà bạn muốn tính ngày: ");
        String thang= thangNam.nextLine();
        switch (thang){
            case "2":
                System.out.print("Tháng "+thang+" có 28 hoặc 29 ngày");
                break;
            case "1":
            case "3":
            case "5":
            case "7":
            case "8":
            case "10":
            case "12":
                System.out.print("Tháng '" + thang + "' có 31 ngày");
                break;
            case "4":
            case "6":
            case "9":
            case "11":
                System.out.print("Tháng " + thang + "có 30 ngày");
                break;
            default:
            System.out.print("Bạn nhập không phải là tháng");
            break;
        }

    }
}
