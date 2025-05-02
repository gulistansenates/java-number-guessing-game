import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain;

        do {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Select difficulty level:");
            System.out.println("1. Easy (1-10)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-1000)");

            int maxNumber = 100;
            int maxAttempts = 7;

            System.out.print("Your choice (1-3): ");
            int choice = getValidInteger(scanner);

            switch (choice) {
                case 1:
                    maxNumber = 10;
                    maxAttempts = 5;
                    break;
                case 2:
                    maxNumber = 100;
                    maxAttempts = 7;
                    break;
                case 3:
                    maxNumber = 1000;
                    maxAttempts = 10;
                    break;
                default:
                    System.out.println("Invalid choice, defaulting to Medium (1-100).");
            }

            int randomNumber = random.nextInt(maxNumber) + 1;
            int guessCount = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI've picked a number between 1 and " + maxNumber + ". Try to guess it!");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (guessCount < maxAttempts) {
                System.out.print("Your guess: ");
                int guess = getValidInteger(scanner);
                guessCount++;

                if (guess < randomNumber) {
                    System.out.println("Try a higher number.");
                } else if (guess > randomNumber) {
                    System.out.println("Try a lower number.");
                } else {
                    guessedCorrectly = true;
                    break;
                }
            }

            if (guessedCorrectly) {
                System.out.println("Congratulations! You guessed the correct number in " + guessCount + " attempts.");
                int score = Math.max(100 - (guessCount - 1) * 10, 0);
                System.out.println("Your score: " + score);
            } else {
                System.out.println("You've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("Thanks for playing. Goodbye!");
        scanner.close();
    }

    private static int getValidInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
