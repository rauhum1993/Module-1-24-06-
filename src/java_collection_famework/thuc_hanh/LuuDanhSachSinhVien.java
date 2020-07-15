package java_collection_famework.thuc_hanh;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LuuDanhSachSinhVien {
    public static void main(String[] args) {
        Map<String,Integer> hashMap= new HashMap<>();
        hashMap.put("Mai",16);
        hashMap.put("Ha",16);
        hashMap.put("Hien",18);
        hashMap.put("Thu",19);


        System.out.println("Display entries in HashMap");
        System.out.println(hashMap +"\n");

        Map<String,Integer> treeMap= new TreeMap<>(hashMap);
        System.out.println("Display entries in TreeMap");
        System.out.println(treeMap);

        Map<String,Integer> linkedHashMap= new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("Mai",16);
        linkedHashMap.put("Ha",17);
        linkedHashMap.put("Hien",20);
        linkedHashMap.put("Thu",16);
        System.out.println("Display entries in LinkedHashMap");
        System.out.println(linkedHashMap);
        System.out.println("\nThe age for " + "Ha is " + linkedHashMap.get("Ha"));
    }
}
