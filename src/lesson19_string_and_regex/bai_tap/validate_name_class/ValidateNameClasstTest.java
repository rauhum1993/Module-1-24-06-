package lesson19_string_and_regex.bai_tap.validate_name_class;

import lesson19_string_and_regex.bai_tap.validate_name_class.ValidateNameClass;

public class ValidateNameClasstTest {
   private static ValidateNameClass valiDateNameClass;
    private static final String[] valiNameClass= new String[]{"C0318G","C0520G","C0720K"};
    private static final String[] invaliNameClass= new String[]{ "M0318G", "P0323AG","HA9200K"};

    public static void main(String[] args) {
        valiDateNameClass =new ValidateNameClass();
        for (String name : valiNameClass) {
            boolean isvalid = valiDateNameClass.valiName(name);
            System.out.println("Email is " + name +" is valid: "+ isvalid);
        }
        for (String name : invaliNameClass) {
            boolean isvalid = valiDateNameClass.valiName(name);
            System.out.println("Email is " + name +" is valid: "+ isvalid);
        }

    }
}
