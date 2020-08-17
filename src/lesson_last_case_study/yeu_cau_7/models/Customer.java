package lesson_last_case_study.yeu_cau_7.models;

public class Customer implements Comparable<Customer> {
    private String name;
    private String birthday;
    private String sex;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String guestType;
    private String address;
    private Services userService;

    public Services getUserService() {
        return userService;
    }

    public void setUserService(Services userService) {
        this.userService = userService;
    }


    public Customer(String name, String birthday, String sex, String idCard, String phoneNumber, String email, String guestType, String address) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.guestType = guestType;
        this.address = address;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }

    public String getAddRess() {
        return address;
    }

    public void setAddRess(String addRess) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + sex + '\'' +
                ", id='" + idCard + '\'' +
                ", numberPhone='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", typeCustomer='" + guestType + '\'' +
                ", address='" + address + '\'' +
                ", userService=" + userService.showInfor() +
                '}';
    }

    public void showInfor() {
        System.out.println("Customer{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + sex + '\'' +
                ", id='" + idCard + '\'' +
                ", numberPhone='" +  phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", typeCustomer='" + guestType + '\'' +
                ", address='" + address + '\'' +
                '}');
    }


    @Override

    public int compareTo(Customer o1) {
        int value = name.compareTo(o1.name);
        if (value == 0) {
            int yearFirst = Integer.parseInt(this.birthday.split("/")[2]);
            int yearSecond = Integer.parseInt(this.birthday.split("/")[2]);
            value = yearFirst - yearSecond;
        }
        return value;
    }
}
