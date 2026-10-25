package week5;

import java.util.Arrays;
import java.util.Scanner;

class Student {
    String name;
    int[] quizzes;
    double average;

    public Student(String name, int[] quizzes) {
        this.name = name;
        this.quizzes = quizzes;
        this.average = calculateAverage();
    }

    private double calculateAverage() {
        int sum = 0;
        for (int i = 0; i < quizzes.length; i++) {
            sum += quizzes[i];
        }
        return (double) sum / quizzes.length;
    }
}

public class Week5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("~~~~~~~BASIC~~~~~~~\n");
        String[] favorites = {"Motorcycle", "Coffee", "Coding", "Music", "Gaming"};
        for (int i = 0; i < favorites.length; i++) {
            System.out.println((i + 1) + ". " + favorites[i]);
        }
        System.out.println("Total length: " + favorites.length);
        
        System.out.println("\n~~~~~~~INTERMEDIATE~~~~~~\n");
        int[] scores = new int[8];
        System.out.println("Enter 8 student scores:");
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Score " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
        }
        
        int sum = 0;
        int highest = scores[0];
        int lowest = scores[0];
        
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            if (scores[i] > highest) {
                highest = scores[i];
            }
            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }
        
        double average = (double) sum / scores.length;
        
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        
        System.out.println("\n~~~~~~~ADVANCED~~~~~~\n");
        int target = 95;
        int foundIndex = -1;
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                foundIndex = i;
                break;
            }
        }
        
        if (foundIndex != -1) {
            System.out.println("Target " + target + " found at index: " + foundIndex);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
        
        int[] scoresCopy = Arrays.copyOf(scores, scores.length);
        Arrays.sort(scoresCopy);
        
        System.out.println("Original scores: " + Arrays.toString(scores));
        System.out.println("Sorted scores:   " + Arrays.toString(scoresCopy));
        
        System.out.println("\n~~~~~~~EXPERT~~~~~~\n");
        String[] names = {"GOCHI", "MAX", "ISHA", "CHAN"};
        int[][] rawQuizData = {
            {90, 90, 91, 92},
            {88, 76, 95, 82},
            {97, 92, 97, 94},
            {85, 90, 78, 92}
        };

        Student[] students = new Student[names.length];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(names[i], rawQuizData[i]);
        }

        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].average < students[j + 1].average) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("--- Class Leaderboard ---");
        int currentRank = 1;
        for (int i = 0; i < students.length; i++) {
            if (i > 0 && students[i].average != students[i - 1].average) {
                currentRank = i + 1;
            }
            System.out.println("Rank " + currentRank + ": " + students[i].name + " | Average: " + students[i].average);
        }

        scanner.nextLine();
        System.out.print("\nEnter student name to search rank: ");
        String searchName = scanner.nextLine();

        int searchIndex = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].name.equalsIgnoreCase(searchName)) {
                searchIndex = i;
                break;
            }
        }

        if (searchIndex != -1) {
            int rank = 1;
            for (int i = 0; i < students.length; i++) {
                if (students[i].average > students[searchIndex].average) {
                    rank++;
                }
            }
            System.out.println(students[searchIndex].name + " is at Rank " + rank + " with an average of " + students[searchIndex].average);
        } else {
            System.out.println("Student not found.");
        }

        scanner.close();
    }
}
