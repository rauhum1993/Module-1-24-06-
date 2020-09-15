package lesson_student;

import java.util.Comparator;

public class Sort implements Comparator<Stundent> {


    @Override
    public int compare(Stundent o1, Stundent o2) {
        int value =o1.getName().compareTo(o2.getName());
        if(value==0){
            return o1.getAge()-o2.getAge();
        }else{
            return value;
        }
    }
}
