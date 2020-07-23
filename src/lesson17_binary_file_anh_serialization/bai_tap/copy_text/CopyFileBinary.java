package lesson17_binary_file_anh_serialization.bai_tap.copy_text;

import java.io.*;
import java.util.Scanner;

public class CopyFileBinary {
    public static void main(String[] args) throws IOException {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter the path of the copy file ");
        String sourceFile=scanner.nextLine();
        System.out.println("Enter the path and name the file to be copied");
        String targetFile=scanner.nextLine();
        CopyFileBinary Object1=new CopyFileBinary();
        Object1.copyFileBinary(sourceFile,targetFile);
    }


    public void copyFileBinary(String sourceFile, String targetFile) throws IOException {

        FileInputStream fileSource = null;
        FileInputStream fileTarget1 = null;
        ObjectInputStream oOPSoure = null;
        ObjectInputStream oOPsTarget = null;


        FileOutputStream fileTarget= null;
        ObjectOutputStream oIPSTarget=null;

        try {
           fileSource =new FileInputStream(sourceFile);

           oOPSoure = new ObjectInputStream(fileSource);

           fileTarget=new FileOutputStream(targetFile);
           oIPSTarget=new ObjectOutputStream(fileTarget);
//            System.out.println("Data of file source is: ");
//            System.out.println(oOPSoure.readObject());

              oIPSTarget.writeObject(oOPSoure.readObject());
              fileTarget1 =new FileInputStream(targetFile);
              oOPsTarget=new ObjectInputStream(fileTarget1);
            System.out.println("Successful copying, data copied is:  ");
            System.out.println(oOPsTarget.readObject());



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            fileSource.close();
            fileTarget.close();
            oIPSTarget.close();
            oOPSoure.close();
            oOPsTarget.close();

        }

    }

}
