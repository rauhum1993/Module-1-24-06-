package dsa_danh_sach.bai_tap.trien_khai_lop_listed_list_don_gian;

import java.util.ArrayList;

public class MyListTest {
    public static class Student{
        private int id;
        private String name;

        public Student(){

        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a= new Student(1,"khanh");
        Student b= new Student(2,"hai");
        Student c= new Student(3,"tung");
        Student d= new Student(4,"dat");
        Student e= new Student(5,"hien");
        Student f=new Student(7,"hoang");

        MyList<Student> studentMyList= new MyList<>();
        MyList<Student> newMyList= new MyList<>();
        studentMyList.add(a);
        studentMyList.add(b);
        studentMyList.add(c);
        studentMyList.add(d);
        studentMyList.add(e);


        System.out.println( studentMyList.size());

        for (int i=0; i< studentMyList.size();i++){
            Student student= (Student) studentMyList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }

//        System.out.println(studentMyList.get(2).getName());
//
//        System.out.println(studentMyList.contains(b));
//
//         newMyList= studentMyList.clone();
//        for (int i=0; i< newMyList.size();i++){
//            System.out.println(newMyList.get(i).getName());
//        }

       studentMyList.remove(1);

        for (int i=0; i< studentMyList.size();i++){
            Student student= (Student) studentMyList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }
    }
}
