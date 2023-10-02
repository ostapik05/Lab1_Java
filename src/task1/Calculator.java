package task1;

import java.util.Scanner;

public class Calculator {
    public static void main(final String[] args) {

        final double a = 5.3;
        final double b = 3.2;

        final Scanner scan = new Scanner(System.in);
        System.out.println("Enter operation: ");
        final char operation = scan.nextLine().charAt(0);

        double res = 0;

        //==================

        switch(operation){
            case '+':
                res = a + b;
                System.out.println(res);
                break;
            case '-':
                res = a - b;
                System.out.println(res);
                break;
            case '*':
                res = a * b;
                System.out.println(res);
                break;
            case '/':
                if(b != 0) {
                    res = a / b;
                    System.out.println(res);
                } else
                    System.out.println("Error");
                break;
            default:
                System.out.println("Entered operation is not defined");
        }
    }
}

