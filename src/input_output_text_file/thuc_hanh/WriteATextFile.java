package input_output_text_file.thuc_hanh;

import java.io.File;
import java.io.IOException;

public class WriteATextFile {
    public static void main(String[] args) {
     File file= new File("quang love mai.txt");
     if(!file.isFile()){
         System.out.println("not file");
//         file.createNewFile("anh chuong love mai.txt");
     }

    }
}
