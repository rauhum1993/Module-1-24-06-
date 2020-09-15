package lesson17_binary_file_anh_serialization.bai_tap.copy_text;

import java.io.*;
import java.util.Scanner;

public class CopyFileBinary {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the copy file ");
        String sourceFile = scanner.nextLine();
        System.out.println("Enter the path and name the file to be copied");
        String targetFile = scanner.nextLine();
        CopyFileBinary Object1 = new CopyFileBinary();
        Object1.copyFileBinary(sourceFile, targetFile);
    }


    public void copyFileBinary(String sourceFile, String targetFile) throws IOException {

        File file = new File(sourceFile);
        FileInputStream fileSource = null;
        ObjectInputStream objectInputStreamSource = null;

        FileInputStream fileInputTarget = null;
        FileOutputStream fileOutputTarget = null;
        ObjectOutputStream objectOutputStreamTarget = null;
        ObjectInputStream objectInputStreamTarget = null;

        try {
            fileSource = new FileInputStream(sourceFile);
            objectInputStreamSource = new ObjectInputStream(fileSource);

            fileOutputTarget = new FileOutputStream(targetFile);
            objectOutputStreamTarget = new ObjectOutputStream(fileOutputTarget);

            System.out.println("Data of file source is: ");

            Object objectReadSoure = objectInputStreamSource.readObject();
            System.out.println(objectReadSoure);
//copy file
            objectOutputStreamTarget.writeObject(objectReadSoure);
            fileInputTarget = new FileInputStream(targetFile);
            objectInputStreamTarget = new ObjectInputStream(fileInputTarget);

            // Notice has successfully copied
            System.out.println("Successful copying, data copied is:  ");
            System.out.println(objectInputStreamTarget.readObject());
            System.out.println("Number of bytes in file is: " + file.length());



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileSource.close();
            fileOutputTarget.close();
            objectOutputStreamTarget.flush();
            objectOutputStreamTarget.close();
            objectInputStreamSource.close();
            objectInputStreamTarget.close();

        }

    }

}
