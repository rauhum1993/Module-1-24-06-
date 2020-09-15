package lesson_student;

public class Stundent implements Comparable<Stundent> {
    private int id;
    private String name;
    private int age;
    private String nameClass;

    public Stundent(int id, String name, int age, String nameClass) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nameClass = nameClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", nameClass='" + nameClass + '\''
                ;
    }

    @Override
    public int compareTo(Stundent s1) {
        int value = name.compareTo(s1.name);
        if(value==0){
            return age-s1.age;
        }else{
            return value;
        }

    }
}
