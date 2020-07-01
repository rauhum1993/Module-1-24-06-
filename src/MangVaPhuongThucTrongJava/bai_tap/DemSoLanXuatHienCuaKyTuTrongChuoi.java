package MangVaPhuongThucTrongJava.bai_tap;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        System.out.println("Enter a string: ");
        String string = scanner.nextLine();
        System.out.println("Enter the characters : ");
        String character = scanner.nextLine();
        System.out.println("The total number of " +
                "characters in the " + string + " is: " + string.length());
        System.out.println(""+string.charAt(2)+string.charAt(10));
        for (int i = 0; i < string.length(); i++) {
            if (character.equals(string.charAt(i))) {
                count++;


            }
            System.out.println(count);
        }
        System.out.println("The number of occurrences of the letter  " +
               character +"  in the "+string+ " is:"+ count);
    }
}

