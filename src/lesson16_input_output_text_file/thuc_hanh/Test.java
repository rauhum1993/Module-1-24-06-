package lesson16_input_output_text_file.thuc_hanh;

import java.io.*;

public class Test {
        public static void main(String[] args){
//           File fileWriter =new File("src/input_output_text_file/bai_tap/ahuhu.txt");
//            fileWriter.createNewFile();
try{
    File file= new File("src/input_output_text_file/bai_tap/test.txt");
    File file1= new File("src/input_output_text_file/bai_tap/copy_test.txt");
    file1.createNewFile();
    file.createNewFile();
    PrintWriter writer= new PrintWriter(file);
    writer.println("aaa");
    writer.println("bbb");
    writer.println("ccc");
    writer.close();

}catch (Exception e){
    System.out.println("Chua co file");
}


        }
}
