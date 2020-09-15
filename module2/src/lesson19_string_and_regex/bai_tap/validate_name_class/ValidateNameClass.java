package lesson19_string_and_regex.bai_tap.validate_name_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateNameClass {
    private static final String NAME_CLASS_REGEX= "(C|A|P)[0-9]{4}(G|H|I|K|L|M)";
    public boolean valiName(String regex) {
        Pattern pattern= Pattern.compile(NAME_CLASS_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
