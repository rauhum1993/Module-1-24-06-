package lesson_student;

import lesson_last_case_study.yeu_cau_7.commons.ReadWriteFile;
import lesson_last_case_study.yeu_cau_7.controllers.MainController;
import lesson_last_case_study.yeu_cau_7.models.*;

import java.io.*;
import java.util.List;

public class ReadWriteFileStudent {
    public static String[] arrayTemp;

    public static List<String> readerFile(String filePath)  {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrayTemp = line.split(",");
                if (filePath.equals(MainStudent.FILE_STUDENT)) {
                    String id=ReadWriteFileStudent.arrayTemp[0];
                    String name = ReadWriteFileStudent.arrayTemp[1];
                    String age = ReadWriteFileStudent.arrayTemp[2];
                    String nameClass = ReadWriteFileStudent.arrayTemp[3];

                    MainStudent.stundentList.add(new Stundent(Integer.parseInt(id),name, Integer.parseInt(age), nameClass));



                }

            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
          e.printStackTrace();
        }

        List<String> o = null;
        return o;

    }

    public static void writerFile(String str, String filePath) {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveFile(String str, String filePath) {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}