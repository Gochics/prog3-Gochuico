package week.pkg2;

import java.util.Scanner;

public class Week2 {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("\n~~~~~BASIC~~~~~\n");
      
      System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        System.out.println("\n--- Results ---");
        System.out.println("Addition (+): " + (num1 + num2));
        System.out.println("Subtraction (-): " + (num1 - num2));
        System.out.println("Multiplication (*): " + (num1 * num2));
        System.out.println("Division (/): " + (num1 / num2));
        System.out.println("Modulo (%): " + (num1 % num2));

        // Division (/) and Modulo (%) behave differently with negative operands.

        System.out.print("\n~~~~~INTERMEDIATE~~~~~\n");
        
        System.out.print("\nEnter student's average grade: ");
        double average = scanner.nextDouble();

        System.out.print("Enter number of absences: ");
        int absences = scanner.nextInt();

        boolean isPassed = (average >= 75 && absences <= 3) || (average >= 90);

        if (isPassed) {
            System.out.println("Result: PASS");
            System.out.println("Reasoning: Met requirements.");
        } else {
            System.out.println("Result: FAIL");
            System.out.println("Reasoning: Did not meet requirements.");
        }
        
        
         System.out.print("\n~~~~~ADVANCED~~~~~\n");
        
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        balance += 500;
        System.out.println("After adding deposit: " + balance);

        balance *= 1.05;
        System.out.println("After 5% interest: " + balance);

        balance += 200;
        System.out.println("After final deposit: " + balance);

        int count = 1;
        System.out.println("\nPostfix (count++): " + count++);
        System.out.println("After postfix line, count is: " + count);

        count = 1;
        System.out.println("Prefix (++count): " + ++count);
        System.out.println("After prefix line, count is: " + count);
        
        System.out.println("\n~~~~~EXPERT~~~~~\n");
        
        int a = 12;
        int b = 5;

        // PREDICTION: true
        boolean check1 = (a > 10) && (b < 8);
        System.out.println("Check 1: " + check1);

        // PREDICTION: false
        boolean check2 = (a < 5) || (b == 20);
        System.out.println("Check 2: " + check2);

        // PREDICTION: true
        boolean check3 = !(a == b);
        System.out.println("Check 3: " + check3);
        
        scanner.close();
    }
    
}
