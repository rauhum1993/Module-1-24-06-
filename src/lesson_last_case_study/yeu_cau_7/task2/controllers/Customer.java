package lesson_last_case_study.yeu_cau_7.task2.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String name;
    private String birthday;
    private String sex;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String guestType;
    private String address;
    private Object Services;

    public Customer(String name, String birthday, String sex, String idCard, String phoneNumber,
                    String email, String guestType, String address, Object services) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.guestType = guestType;
        this.address = address;
        Services = services;
    }

    public Object getServices() {
        return Services;
    }

    public void setServices(Object services) {
        Services = services;
    }

    public void addNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------Enter customer information------");
        System.out.println("Enter Customer Name : ");
        String nameCustomer= scanner.nextLine();
        System.out.println("Enter Customer Birthday: ");
        String birthdayCustomer= scanner.nextLine();
        System.out.println("Enter Customer sex: ");
        String sexCustomer= scanner.nextLine();
        System.out.println("Enter Id Card Of Customer: ");
        String idCard= scanner.nextLine();
        System.out.println("Enter Phone Number Of Customer :");
        String phoneNumber= scanner.nextLine();
        System.out.println("Enter Email Of Customer: ");
        String email= scanner.nextLine();
        System.out.println("Enter Guest Type Of Customer :");
        String guestType = scanner.nextLine();
        System.out.println("Enter Address Of Customer: ");
        String address =scanner.nextLine();

        Customer customer=new Customer(nameCustomer,birthdayCustomer,sexCustomer,idCard,phoneNumber,email,guestType,address,null);
        List<Customer> customers=new ArrayList<>();
        final String FILE_CUSTOMER="Name Customer, Birthday Customer, Sex Customer, Id Card, Phone Number, Emmail, Guest type, Address, Services.";
        customers.add(customer);


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

}
