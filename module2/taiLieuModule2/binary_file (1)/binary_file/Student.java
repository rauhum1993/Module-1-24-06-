package binary_file;

import java.io.*;

public class Student implements Serializable {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {
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

    @Override
    public String toString() {
        return "name: " + this.name + " age: " + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        Student otherStudent = (Student) obj;
        if (this.name.equals(otherStudent.name)) {
            return true;
        } else {
            return false;
        }
    }
}
