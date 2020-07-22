package lesson17_binary_file_anh_serialization.thuc_hanh.copy_cac_file_co_dung_luong_lon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static  String filePath="src/lesson17_binary_file_anh_serialization/thuc_hanh/copy_cac_file_co_dung_luong_lon/test.txt";
    public static void writerStudent(){
        try {
            Student student1= new Student( 1,"Khanh",27);



            FileOutputStream fileOutputStream=new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student1);
            objectOutputStream.flush();
            objectOutputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readerStudent()  {
        try {
            FileInputStream fileInputStream=new FileInputStream(filePath);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Student student2=(Student) objectInputStream.readObject();

            System.out.println(student2.getId()+" "+student2.getName()+" "+student2.getAge());
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        writerStudent();
        readerStudent();


    }
}
