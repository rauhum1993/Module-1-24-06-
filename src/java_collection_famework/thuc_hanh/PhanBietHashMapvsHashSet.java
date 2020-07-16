package java_collection_famework.thuc_hanh;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class PhanBietHashMapvsHashSet {
    public static void main(String[] args) {
       Student student1= new  Student("ha",17,"Da nang");
       Student student2= new  Student("mai",18,"Quang Nam");
       Student student3= new  Student("hien",22,"Quang Tri");
       Student student4= new  Student("thu",20,"Chau Doc");

       Map <Integer,Student> studentMap= new HashMap<>();
       studentMap.put(1,student1);
       studentMap.put(2,student2);
       studentMap.put(3,student3);
       studentMap.put(4,student4);
       studentMap.put(5,student1);


       for( Map.Entry<Integer,Student> student: studentMap.entrySet() ){
           System.out.println(student.toString());
       }
//        for(Student student : studentMap){
//            System.out.println(student.toString());
//        }

        System.out.println("-----------SET------------");
        Set<Student> students = new HashSet<Student>();
        students.add(student1);
        students.add(student4);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student2);

        System.out.println(students.toString());

//        for(Student student : students){
//            System.out.println(student.toString());
//        }



    }


    public static class Student{
        private String name;
        private int age;
        private String address;

        public Student() {
        }

        public Student(String name, int age, String address) {
            super();
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return " Student name = " + name + "," +
                    " age = " + age + " , " +
                    "address =" + address+"\n";
        }
    }
}
