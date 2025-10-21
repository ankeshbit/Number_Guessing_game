import java.util.*;

public class Main {
    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int tries = 0;
        int randomNum = min + (int)(Math.random() * (max - min + 1));
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your guess between 1 and 100 (or 0 to exit):");
            int user_input = sc.nextInt();

            if (user_input == 0) {
                System.out.println("Exiting...");
                System.out.println("The number was: " + randomNum);
                break;
            }

            if (user_input < 1 || user_input > 100)
            {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                continue;
            }

            tries++; 
            if (user_input < randomNum) 
            {
                System.out.println("You guessed too low.");
            }
            else if (user_input > randomNum) 
            {
                System.out.println("You guessed too high.");
            }
            else 
            {
                System.out.println(" You guessed it right!");
                break;
            }
        }

        System.out.println("You took a total of " + tries + " attempt(s).");
        sc.close();
    }
}