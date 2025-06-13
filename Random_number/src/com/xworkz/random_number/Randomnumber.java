package com.xworkz.random_number;

import java.util.Random;
import java.util.Scanner;

public class Randomnumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the starting number:");
            int start = scanner.nextInt();

            System.out.println("Enter the ending number:");
            int end = scanner.nextInt();




            Random random = new Random();
            int randomNumber = random.nextInt(end - start + 1) + start;

            System.out.println("Guess the number:");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Correct guess The number was: " + randomNumber);
            } else {
                System.out.println("Wrong guess The number was: " + randomNumber);
            }

        } catch (Exception exception) {
            System.out.println("Invalid input. Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }
}
