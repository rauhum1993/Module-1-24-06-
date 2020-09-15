package lesson_student;

public class FatherTest {
    private String name;
    private String age;

    public FatherTest(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public FatherTest() {
    }

    public FatherTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
