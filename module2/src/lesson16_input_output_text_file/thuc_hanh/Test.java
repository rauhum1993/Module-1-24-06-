package lesson16_input_output_text_file.thuc_hanh;

import java.io.*;

public class Test {
        public static void main(String[] args){

try{
    File file= new File("src/lesson16_input_output_text_file/bai_tap/text.txt");
    File file1= new File("src/lesson16_input_output_text_file/bai_tap/copy_text.txt");
    file.createNewFile();
    file1.createNewFile();
    PrintWriter writer= new PrintWriter(file);
    writer.println("a1a");
    writer.println("b3b");
    writer.println("c3c");
    writer.close();

}catch (Exception e){
    System.out.println("Chua co file");
}


        }
}
