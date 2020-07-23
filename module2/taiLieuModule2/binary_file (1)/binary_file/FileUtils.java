package binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static final String FILE_PATH = "D:\\Work\\CodeGym\\C05\\Module2\\sourcedemo\\src\\binary_file\\student.txt";

    public static List<Student> readFile() {
        FileInputStream fis = null;
        ObjectInputStream objectInputStream = null;
        List<Student> studentList = null;
        try {
            fis = new FileInputStream(FILE_PATH);
            objectInputStream = new ObjectInputStream(fis);

            studentList = (List<Student>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            studentList = new ArrayList<>();
        } finally {
            try {
                if (objectInputStream != null)
                    objectInputStream.close();
            } catch (IOException e) {
                studentList = new ArrayList<>();
            }
        }
        return studentList;
    }

    public static void writeFile(List<Student> studentList) {
        FileOutputStream fos = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fos = new FileOutputStream(FILE_PATH);
            objectOutputStream = new ObjectOutputStream(fos);

            objectOutputStream.writeObject(studentList);
            objectOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
