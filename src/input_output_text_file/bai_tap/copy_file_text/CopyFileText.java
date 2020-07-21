package input_output_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap duong dan file source:");
        String linkSource = scanner.nextLine();
        System.out.println("Nhap duong dan chua file target:");
        String lickTarget = scanner.nextLine();
        CopyFileText copy = new CopyFileText();
        copy.copyFileText(linkSource, lickTarget);
    }



    public void copyFileText(String sourceFile, String targetFile) {
        try {

            File fileSource = new File(sourceFile);
            File fileTarget = new File(targetFile);

            BufferedReader brSource = new BufferedReader(new FileReader(fileSource));
            BufferedWriter brTarget = new BufferedWriter(new FileWriter(fileTarget));

            int sum=0;
            String lineSource = "";
            while ((lineSource = brSource.readLine()) != null) {
                System.out.println(lineSource);
                brTarget.write(lineSource);
                brTarget.write("\n");
                sum++;
            }
            System.out.println("so ky tu vua copy sang la :"+sum);
            brSource.close();
            brTarget.close();


        } catch (IOException e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");

        }

    }



}
