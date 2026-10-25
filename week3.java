package week3;

import java.util.Scanner;

public class Week3 {

    public static void main(String[] args) {
        
        System.out.println("\n~~~~~BASIC~~~~~\n");
        
        int score = 77; 

        if (score >= 60) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        
        System.out.println("\n~~~~~INTERMEDIATE~~~~~\n");
        
        double purchaseAmount = 3500.0; 
        double discountRate = 0.0;

        if (purchaseAmount >= 5000) {
            discountRate = 0.15;
        } else if (purchaseAmount >= 3000) {
            discountRate = 0.10;
        } else if (purchaseAmount >= 1000) {
            discountRate = 0.05;
        } else {
            discountRate = 0.0;
        }

        double finalPrice = purchaseAmount - (purchaseAmount * discountRate);

        System.out.println("Purchase Amount: " + purchaseAmount);
        System.out.println("Discount Tier: " + (int)(discountRate * 100) + "%");
        System.out.println("Final Price: " + finalPrice);
        
        System.out.println("\n~~~~~ADVANCED~~~~~\n");
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean isLocked = false;

        if (username.equals("Gochi")) {
            if (password.equals("midorima_17")) {
                if (!isLocked) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Error: Account is locked.");
                }
            } else {
                System.out.println("Error: Incorrect password.");
            }
        } else {
            System.out.println("Error: Username not found.");
        }
        
        System.out.println("\n~~~~~EXPERT~~~~~\n");

        System.out.print("Enter username: ");
        username = scanner.nextLine();

        if (username.equals("gochi")) {
            System.out.print("Enter 4-digit PIN: ");
            int pin = scanner.nextInt();

            if (pin == 1717) {
                System.out.println("Login successful!");

                double balance = 1777888.0;

                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();

                String tier = "";
                if (balance >= 50000) {
                    tier = "Platinum";
                } else if (balance >= 20000) {
                    tier = "Gold";
                } else if (balance >= 10000) {
                    tier = "Silver";
                } else {
                    tier = "Bronze";
                }

                double limit = 0;
                if (tier.equals("Platinum")) limit = 20000;
                else if (tier.equals("Gold")) limit = 10000;
                else if (tier.equals("Silver")) limit = 5000;
                else limit = 2000;

                double feeRate = 0.0;
                switch (tier) {
                    case "Platinum": feeRate = 0.01; break;
                    case "Gold": feeRate = 0.02; break;
                    case "Silver": feeRate = 0.03; break;
                    case "Bronze": feeRate = 0.05; break;
                }

                double fee = amount * feeRate;
                double total = amount + fee;

                if (amount <= balance) {
                    if (amount <= limit) {
                        if (total <= balance) {
                            System.out.println("APPROVE: Tier is " + tier + ". Fee: " + fee);
                        } else {
                            System.out.println("DENY: Not enough balance to cover transaction fee.");
                        }
                    } else {
                        System.out.println("DENY: Amount exceeds daily limit for " + tier + " tier.");
                    }
                } else {
                    System.out.println("DENY: Insufficient balance.");
                }

            } else {
                System.out.println("DENY: Incorrect PIN.");
            }
        } else {
            System.out.println("DENY: Invalid username.");
        }
        
        scanner.close();
 
    }
    
}
