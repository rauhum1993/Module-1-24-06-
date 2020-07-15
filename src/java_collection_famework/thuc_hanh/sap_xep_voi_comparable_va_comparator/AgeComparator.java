package java_collection_famework.thuc_hanh.sap_xep_voi_comparable_va_comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
      int result= s1.getAge().compareTo(s2.getAge());
      if (result==0){
        int  result1= s1.getName().compareTo(s2.getName());
        if (result1==0){
            return s1.getAddress().compareTo(s2.getAddress());
        }
        return result1;
      }
      return result;

    }
}