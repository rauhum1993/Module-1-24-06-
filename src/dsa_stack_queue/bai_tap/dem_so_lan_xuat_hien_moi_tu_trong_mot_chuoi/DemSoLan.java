package dsa_stack_queue.bai_tap.dem_so_lan_xuat_hien_moi_tu_trong_mot_chuoi;

import java.util.Scanner;
import java.util.TreeMap;

public class DemSoLan {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap chuoi ky tu");
        String chuoiKyTu = scanner.nextLine();


            TreeMap<Character, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < chuoiKyTu.length(); i++) {

                if (treeMap.get(chuoiKyTu.charAt(i)) == null) {
                    int index = 0;
                    index++;
                    treeMap.put(chuoiKyTu.charAt(i), index);
                } else {


                    treeMap.put(chuoiKyTu.charAt(i),treeMap.get(chuoiKyTu.charAt(i))+1);
                }

            }
        for (Character i : treeMap.keySet()) {
            System.out.println("ky tu: " + i + " .co so lan xuat hien la : " + treeMap.get(i));
        }



    }
}

