package lop_va_doi_tuong_java.bai_tap;

import java.util.Scanner;

public class XayDungLopFan {
    final int slow = 1;
    final int medium = 2;
    int fast = 3;
    int speed = slow;
    boolean on = false;
    double radius = 5;
    String color = "blue";

    public XayDungLopFan( int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;

    }

    public int getSlow() {
        return slow;
    }

    public int getMedium() {
        return medium;
    }

    public int getFast() {
        return fast;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setFast(int fast) {
        this.fast = fast;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = false;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public XayDungLopFan() {

    }

    public String toString() {
        if (this.on) {
            return ("fan is on" + "\n"
                    + "speed= " + getSpeed() + "\n"
                    + "color= " + getColor() + "\n"
                    + "radius= " + getRadius());

        } else
            return ("fan is off" + "\n"
                    + "speed= " + getSpeed() + "\n"
                    + "color= " + getColor() + "\n"
                    + "radius= " + getRadius());


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XayDungLopFan fan1 = new XayDungLopFan(3,true,10,"yellow");
        XayDungLopFan fan2 = new XayDungLopFan(2,false,5,"blue");
        int choice = -1;


            System.out.println("Menu");
            System.out.println("1. On ");
            System.out.println("2. Off");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println(fan1.toString());
                    break;
                }
                case 2: {
                    System.out.println(fan2.toString());

                    break;

                }
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");




        }
    }
}

