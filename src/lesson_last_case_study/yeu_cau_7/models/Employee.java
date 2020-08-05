package lesson_last_case_study.yeu_cau_7.models;

public class Employee {
    private String nameEmployee;
    private int ageEmployee;
    private String addressEmployee;

    public Employee(String nameEmployee, int ageEmployee, String addressEmployee) {
        this.nameEmployee = nameEmployee;
        this.ageEmployee = ageEmployee;
        this.addressEmployee = addressEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAgeEmployee() {
        return ageEmployee;
    }

    public void setAgeEmployee(int ageEmployee) {
        this.ageEmployee = ageEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    @Override
    public String toString() {
        return
                " nameEmployee='" + nameEmployee + '\'' +
                ", ageEmployee='" + ageEmployee + '\'' +
                ", addressEmployee='" + addressEmployee + '\'';
    }
}
