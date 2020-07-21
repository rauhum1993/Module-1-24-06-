package input_output_text_file.bai_tap.doc_file_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class WriteFileCSV {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap duong dan cua danh ba can doc:");
        String fileCSV= scanner.nextLine();
        WriteFileCSV country=new WriteFileCSV();
        country.writeFileCSV(fileCSV);
    }



    public void writeFileCSV(String fileCSV){
        try{
            File file=new File(fileCSV);
            FileReader fileReader=new FileReader(file);
            BufferedReader br=new BufferedReader(fileReader);
            String line = "";
            String cvsSplitBy = ",";
            int i = 0;
            while ((line=br.readLine())!=null){
                String[] country=line.split(cvsSplitBy);
                System.out.println("Country "+(i+1)+" is: \t"+country[5]);
                i++;
            }

        } catch (Exception e){
            System.out.println("Error");
        }

    }
}
