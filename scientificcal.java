package calc.basic;

public class BasicCalc {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero");
            return 0;
        }

        return a / b;
    }
}
package calc.advanced;

public class AdvancedCalc {

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double sqrt(double a) {
        if (a < 0) {
            System.out.println("Invalid square root");
            return 0;
        }

        return Math.sqrt(a);
    }

    public double log(double a) {
        if (a <= 0) {
            System.out.println("Invalid logarithm");
            return 0;
        }

        return Math.log(a);
    }
}
package print.display;

public class Display {

    public void display(double result) {
        System.out.println("Result = " + result);
    }
}
import java.util.Scanner;

import calc.basic.BasicCalc;
import calc.advanced.AdvancedCalc;
import print.display.Display;

public class TestCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BasicCalc b = new BasicCalc();
        AdvancedCalc a = new AdvancedCalc();
        Display d = new Display();

        int choice;
        double x, y, result;

        do {
            System.out.println("\n--- SCIENTIFIC CALCULATOR ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power");
            System.out.println("6. Square Root");
            System.out.println("7. Log");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter two numbers: ");
                    x = sc.nextDouble();
                    y = sc.nextDouble();
                    result = b.add(x, y);
                    d.display(result);
                    break;

                case 2:
                    System.out.print("Enter two numbers: ");
                    x = sc.nextDouble();
                    y = sc.nextDouble();
                    result = b.subtract(x, y);
                    d.display(result);
                    break;

                case 3:
                    System.out.print("Enter two numbers: ");
                    x = sc.nextDouble();
                    y = sc.nextDouble();
                    result = b.multiply(x, y);
                    d.display(result);
                    break;

                case 4:
                    System.out.print("Enter two numbers: ");
                    x = sc.nextDouble();
                    y = sc.nextDouble();
                    result = b.divide(x, y);
                    d.display(result);
                    break;

                case 5:
                    System.out.print("Enter base and power: ");
                    x = sc.nextDouble();
                    y = sc.nextDouble();
                    result = a.power(x, y);
                    d.display(result);
                    break;

                case 6:
                    System.out.print("Enter number: ");
                    x = sc.nextDouble();
                    result = a.sqrt(x);
                    d.display(result);
                    break;

                case 7:
                    System.out.print("Enter number: ");
                    x = sc.nextDouble();
                    result = a.log(x);
                    d.display(result);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 8);

        sc.close();
    }
}
