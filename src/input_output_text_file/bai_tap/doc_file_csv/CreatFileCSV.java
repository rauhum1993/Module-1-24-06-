package input_output_text_file.bai_tap.doc_file_csv;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreatFileCSV {
    public static void main(String[] args) throws IOException {
        File file= new File("src/input_output_text_file/bai_tap/doc_file_csv/danh_ba.txt");
        file.createNewFile();




    }
}
