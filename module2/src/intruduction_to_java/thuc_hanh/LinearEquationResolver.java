package intruduction_to_java.thuc_hanh;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        Scanner giaTri=new Scanner(System.in);
        System.out.print("a=");
        double a=giaTri.nextDouble();
        System.out.print("b=");
        double b=giaTri.nextDouble();
        System.out.print("c=");
        double c=giaTri.nextDouble();
        if (a!=0){
            double solution =-b/a;
            System.out.printf("The solution is: %f!", solution);
        }else {
            if (b==0){
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }

        }

    }
}
