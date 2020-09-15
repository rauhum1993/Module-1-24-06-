package lesson17_binary_file_anh_serialization.thuc_hanh.copy_cac_file_co_dung_luong_lon;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private int id;

    public Student( int id ,String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
