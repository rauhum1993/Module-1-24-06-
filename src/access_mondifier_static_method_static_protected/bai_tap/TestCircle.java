package access_mondifier_static_method_static_protected.bai_tap;

public class TestCircle {
    public static void main(String[] args) {

        System.out.println(TestCircle.language);

    }
    public static String language;

    static {

        if(System.getProperty("user.language").equals("en")){
            language="english";
        }else language="vietnam";
    }




}
