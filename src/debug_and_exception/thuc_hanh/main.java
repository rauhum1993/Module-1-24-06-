package debug_and_exception.thuc_hanh;

import java.io.UncheckedIOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);

        try {
          int a= 5/0;
        }

        catch (NullPointerException e){
            System.out.println("ahihi");
        }

       finally {
            System.out.println("khanh dep trai");
        }
    }
}
