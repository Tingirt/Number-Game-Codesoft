package CodeSoftIntern.NumberGame;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chances = 10;
        int totalWins = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int randomNumber = getRandomNumber(1, 100);
            boolean guessCorrect = false;

            for (int i = 0; i < chances; i++) {
                System.out.println("Chance " + (i + 1) + ": Enter your guess (between 1 and 100):");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    guessCorrect = true;
                    totalWins++;
                    System.out.println("You won! Congratulations!");
                    break;
                } else if (userGuess > randomNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
            }

            if (!guessCorrect) {
                System.out.println("You ran out of chances. The number was " + randomNumber + ".");
            }

            System.out.println("Do you want to play again? (y/n)");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing! Your final score is " + totalWins + " wins.");

    }

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}