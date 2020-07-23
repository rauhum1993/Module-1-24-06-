package lesson19_string_and_regex.bai_tap.validate_phone_number;

import lesson19_string_and_regex.bai_tap.validate_name_class.ValidateNameClass;

public class ValidatePhoneNumberTest {
    private  static ValidatePhoneNumber validatePhoneNumber;
    private static String[] valiPhoneNumber= new String[] {"(84)-(0396692526)","(23)-(0123456897)","(04)-(0392351235)"};
    private static String[] invaliPhoneNumber= new String[] {"(a8)-(22222222)","(64)-(01234f6897)","(04)-(4392351235)"};

    public static void main(String[] args) {
        validatePhoneNumber =new ValidatePhoneNumber();

        for (String phone : valiPhoneNumber) {
            boolean isvalid = validatePhoneNumber.validatePhoneNumber(phone);
            System.out.println("Email is " + phone +" is valid: "+ isvalid);
        }
        for (String phone: invaliPhoneNumber) {
            boolean isvalid = validatePhoneNumber.validatePhoneNumber(phone);
            System.out.println("Email is " + phone +" is valid: "+ isvalid);
        }

    }
}


