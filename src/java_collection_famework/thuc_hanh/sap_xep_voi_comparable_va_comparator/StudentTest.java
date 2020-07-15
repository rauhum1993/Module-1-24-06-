package java_collection_famework.thuc_hanh.sap_xep_voi_comparable_va_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {


        Student student = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Hai", 38, "HT");
        Student student3 = new Student("Khanh", 38, "NA");
        Student student4 = new Student("Hai", 38, "DN");

        List<Student> lists = new ArrayList<>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        lists.add(student4);


        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists,ageComparator);
        System.out.println("So sanh theo tuoi,ten, dia chi:");
        for(Student st : lists){
            System.out.println(st.toString());
        }
    }
}
