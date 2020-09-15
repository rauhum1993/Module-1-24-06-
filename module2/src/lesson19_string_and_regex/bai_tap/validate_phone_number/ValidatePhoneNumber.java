package lesson19_string_and_regex.bai_tap.validate_phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
//    private static final String PHONE_NUMBER = "[(0-9)]{4}[-(0]{3}[0-9)]{10}";
    private static final String PHONE_NUMBER = "[(0-9)[-](00-9)]{17}";
    public boolean validatePhoneNumber( String regex){
        Pattern pattern= Pattern.compile(PHONE_NUMBER);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
