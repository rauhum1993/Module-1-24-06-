package lesson_last_case_study.yeu_cau_7.task1.models;

public class TestServices {
    public static void main(String[] args) {
        Services  villa= new Villa("Villa",14.6,100,
                3,"vip","1","adas",
                "ds",5,6);


      Services  villa1 = (Services) villa;
        System.out.println(villa1.showInfor());
    }
}
