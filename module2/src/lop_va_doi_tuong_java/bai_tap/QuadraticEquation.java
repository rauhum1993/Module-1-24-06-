package lop_va_doi_tuong_java.bai_tap;

import java.util.Scanner;

class QuadraticEquationtTest {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter a:");
        double a=scanner.nextDouble();
        System.out.print("Enter b:");
        double b=scanner.nextDouble();
        System.out.print("Enter c:");
        double c=scanner.nextDouble();
        QuadraticEquation input= new QuadraticEquation(a,b,c);
        System.out.print("a= "+"\t"+input.getA()+"\t");
        System.out.print("b= "+"\t"+input.getB()+"\t");
        System.out.print("c= "+"\t"+input.getC()+"\t");

        double delta= input.getDiscriminant();
        System.out.println("");
        if (delta<0){
            System.out.println("the equation has no solution");
        } else {
            System.out.println("The first solution of the equation is: "+input.getRoot1());
            System.out.println("The second root of the equation is: "+input.getRoot2());
        }

    }
}
 class QuadraticEquation{
   private double a,b,c;
    public QuadraticEquation(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;

    }
    public double getA(){
        return this.a;
    }
    public double getB(){
        return this.b;
    }
    public double getC(){
        return this.c;
    }

    public double getDiscriminant(){
        return this.b*this.b-4*this.a*this.c;
    }
    public double getRoot1(){
        return (-1*this.b+Math.sqrt(Math.pow(b,2)-4*this.a*this.c))/(2*this.a);
    }
    public double getRoot2(){
        return (-1*this.b-Math.sqrt(Math.pow(b,2)-4*this.a*this.c))/(2*this.a);
    }

}
