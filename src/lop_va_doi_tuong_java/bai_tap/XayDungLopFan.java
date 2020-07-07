package lop_va_doi_tuong_java.bai_tap;

import java.util.Scanner;

class Fan {
    final int slow = 1;
    final int medium = 2;
    int fast = 3;
    int speed = slow;
    boolean on = false;
    double radius = 5;
    String color = "blue";

    public Fan() {


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


    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }


    public String toString() {
        if (isOn()) {
            return ("fan is on " + "\n"
                    + "speed= " + getSpeed() + "\n"
                    + "color= " + getColor() + "\n"
                    + "radius= " + getRadius());

        } else
            return ("fan is off " + "\n"
                    + "speed= " + getSpeed() + "\n"
                    + "color= " + getColor() + "\n"
                    + "radius= " + getRadius());


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        int choice;
        fan1.setSpeed(fan1.fast);
        fan1.setColor("yello");
        fan1.setRadius(10);
        fan1.setOn(true);


        fan2.setSpeed(fan2.slow);
        fan2.isOn();


        System.out.println("Menu");
        System.out.println("1. fan1 ");
        System.out.println("2. fan2");
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

