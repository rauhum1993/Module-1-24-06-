package java_collection_famework.thuc_hanh.sap_xep_voi_comparable_va_comparator;

public class Student {

    private String name;
    private Integer age;
    private String address;

    public Student(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return
                " name = " + name +
                " age = " + age+
                " address = " + address
                ;
    }


    }

