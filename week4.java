package week4;

import java.util.Scanner;

public class Week4 {
    public static void main(String[] args) {
        
        // Initialize the Scanner once for the whole program
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("~~~~~~~BASIC~~~~~~~\n");
        
        for (int i = 1; i <= 20; i++) {
            System.out.println("Number: " + i + " | Square: " + (i * i));
        }
        
        System.out.println("\n~~~~~~~INTERMEDIATE~~~~~~\n");
  
        int total = 0;

        System.out.print("Enter an integer (-1 to stop): ");
        int number = scanner.nextInt();

        while (number != -1) {
            total += number;
            System.out.print("Enter an integer (-1 to stop): ");
            number = scanner.nextInt();
        }

        System.out.println("Final Total: " + total);
        
        System.out.println("\n~~~~~~~ADVANCED~~~~~~\n");
        
        for (int i = 1; i <= 5; i++) {
            
            // demonstrates continue: skips row 3
            if (i == 3) {
                continue; 
            }
            
            for (int j = 1; j <= 5; j++) {
                
                // demonstrates break: stops inner loop when j reaches 4
                if (j == 4) {
                    break; 
                }
                
                System.out.print("* ");
            }
            
            System.out.println();
        }
        
        System.out.println("\n~~~~~~~EXPERT~~~~~~\n");
        
        int[][] warehouse = {
            {10, -1, 25},
            {3, 15, 8},
            {20, 12, -1}
        };
        
        int choice;
        
        do {
            System.out.println("\n--- Gochi's Inventory ---");
            System.out.println("1. Calculate Total Inventory");
            System.out.println("2. Find First Critically Low Shelf");
            System.out.println("3. Restock Shelf");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            
            if (choice == 1) {
                int subTotal = 0;
                for (int i = 0; i < warehouse.length; i++) {
                    for (int j = 0; j < warehouse[i].length; j++) {
                        if (warehouse[i][j] == -1) {
                            continue;
                        }
                        subTotal += warehouse[i][j];
                    }
                }
                System.out.println("Total Inventory: " + subTotal);
                
            } else if (choice == 2) {
                boolean found = false;
                for (int i = 0; i < warehouse.length; i++) {
                    for (int j = 0; j < warehouse[i].length; j++) {
                        if (warehouse[i][j] != -1 && warehouse[i][j] < 5) {
                            System.out.println("Critically low shelf at [" + i + "][" + j + "] with count: " + warehouse[i][j]);
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        break;
                    }
                }
                if (!found) {
                    System.out.println("No critically low shelves found.");
                }
                
            } else if (choice == 3) {
                System.out.print("Enter row index (0-2): ");
                int r = scanner.nextInt();
                System.out.print("Enter column index (0-2): ");
                int c = scanner.nextInt();
                
                if (r >= 0 && r < warehouse.length && c >= 0 && c < warehouse[0].length) {
                    if (warehouse[r][c] == -1) {
                        System.out.println("Error: That shelf is damaged.");
                    } else {
                        int amount = -1;
                        while (amount < 0) {
                            System.out.print("Enter amount to restock: ");
                            amount = scanner.nextInt();
                            if (amount < 0) {
                                System.out.println("Invalid amount.");
                            }
                        }
                        warehouse[r][c] += amount;
                        System.out.println("Restocked! New count: " + warehouse[r][c]);
                    }
                } else {
                    System.out.println("Invalid position.");
                }
            }
            
        } while (choice != 4);
        
        scanner.close();
    } 
}
