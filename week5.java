package week5;

import java.util.Arrays;
import java.util.Scanner;

public class Week5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("~~~~~~~BASIC~~~~~~~\n");

        String[] favorites = {
            "Motorcycle", "Coffee", "Coding", "Music", "Gaming"
        };

        for (int i = 0; i < favorites.length; i++) {
            System.out.println((i + 1) + ". " + favorites[i]);
        }

        System.out.println("Total length: " + favorites.length);

        System.out.println("\n~~~~~~~INTERMEDIATE~~~~~~\n");

        int[] scores = {76, 90, 98, 92, 88, 85, 95, 80};

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

        System.out.println("Total Number of Students: " + scores.length);
        System.out.println("Sum of Scores: " + sum);
        System.out.printf("Average Score: %.2f%n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        System.out.println("\n~~~~~~~ADVANCED~~~~~~\n");

        int[] advancedScores = {85, 90, 78, 92, 88, 76, 95, 80};

        int target = 95;
        int foundIndex = -1;

        for (int i = 0; i < advancedScores.length; i++) {
            if (advancedScores[i] == target) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Target " + target + " found at index: " + foundIndex);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }

        int[] scoresCopy = Arrays.copyOf(advancedScores, advancedScores.length);
        Arrays.sort(scoresCopy);

        System.out.println("Original scores: " + Arrays.toString(advancedScores));
        System.out.println("Sorted scores:   " + Arrays.toString(scoresCopy));

        System.out.println("\n~~~~~~~EXPERT~~~~~~\n");

        String[] names = {"GOCHI", "MAX", "ISHA", "CHAN"};

        int[][] rawQuizData = {
            {90, 90, 91, 92},
            {88, 76, 95, 82},
            {97, 92, 97, 94},
            {85, 90, 78, 92}
        };

        double[] studentAverages = new double[names.length];

        for (int i = 0; i < names.length; i++) {
            int quizSum = 0;

            for (int j = 0; j < rawQuizData[i].length; j++) {
                quizSum += rawQuizData[i][j];
            }

            studentAverages[i] =
                (double) quizSum / rawQuizData[i].length;
        }

        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - 1 - i; j++) {
                if (studentAverages[j] < studentAverages[j + 1]) {
                    double tempAverage = studentAverages[j];
                    studentAverages[j] = studentAverages[j + 1];
                    studentAverages[j + 1] = tempAverage;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;
                }
            }
        }

        System.out.println("--- Class Leaderboard ---");

        int currentRank = 1;

        for (int i = 0; i < names.length; i++) {
            if (i > 0 &&
                studentAverages[i] != studentAverages[i - 1]) {
                currentRank = i + 1;
            }

            System.out.printf(
                "Rank %d: %s | Average: %.2f%n",
                currentRank, names[i], studentAverages[i]
            );
        }

        System.out.print("\nEnter student name to search rank: ");
        String searchName = scanner.nextLine().trim();

        int searchIndex = -1;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(searchName)) {
                searchIndex = i;
                break;
            }
        }

        if (searchIndex != -1) {
            int rank = 1;

            for (int i = 0; i < names.length; i++) {
                if (studentAverages[i] > studentAverages[searchIndex]) {
                    rank++;
                }
            }

            System.out.printf(
                "%s is at Rank %d with an average of %.2f%n",
                names[searchIndex], rank, studentAverages[searchIndex]
            );
        } else {
            System.out.println("Student not found.");
        }

        scanner.close();
    }
}
