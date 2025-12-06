import java.util.Scanner;

class GuessingGame {

    private int min = 1;
    private int max = 100;
    private int randomNum;
    private int attempts;

    public void startGame() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            resetGame();
            System.out.println("🎯 Welcome to the Number Guessing Game!");

            while (true) {
                System.out.print("Enter your guess between 1 and 100 (or 0 to exit): ");
                int guess = sc.nextInt();

                if (guess == 0) {
                    System.out.println("Exiting...");
                    System.out.println("The number was: " + randomNum);
                    sc.close();
                    return;
                }

                if (!isValidGuess(guess)) {
                    System.out.println("Invalid input. Enter between 1 and 100.");
                    continue;
                }

                attempts++;
                if (checkGuess(guess)) break;
            }

            System.out.println("You took " + attempts + " attempt(s).");

            System.out.print("Do you want to play again? (y/n): ");
            char choice = sc.next().toLowerCase().charAt(0);

            if (choice != 'y') {
                System.out.println("Thanks for playing!");
                sc.close();
                return;
            }
        }
    }

    private void resetGame() {
        randomNum = min + (int)(Math.random() * (max - min + 1));
        attempts = 0;
    }

    private boolean isValidGuess(int guess) {
        return guess >= min && guess <= max;
    }

    private boolean checkGuess(int guess) {
        if (guess < randomNum) {
            System.out.println("Too low!");
            return false;
        } else if (guess > randomNum) {
            System.out.println("Too high!");
            return false;
        } else {
            System.out.println("🎉 You guessed it right!");
            return true;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.startGame();
    }
}
