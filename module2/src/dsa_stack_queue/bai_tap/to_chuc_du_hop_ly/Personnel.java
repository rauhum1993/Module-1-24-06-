package dsa_stack_queue.bai_tap.to_chuc_du_hop_ly;

public class Personnel {
    String name;
    String sex;
    String birthday;


    public Personnel() {
    }

    public Personnel(String name, String sex, String birthday) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return  "name: " + name + '\t' +
                "sex: " + sex + '\t' +
                "birthday: " + birthday + '\t'
                ;
    }
}
