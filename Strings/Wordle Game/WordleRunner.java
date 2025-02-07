import java.util.Scanner;

public class WordleRunner {
    public static void main(String[] args) {
        HiddenWord hiddenWord = new HiddenWord();
        System.out.println("Welcome to Wordle! You have 6 attempts to guess the hidden word.");
        Scanner scanner = new Scanner(System.in);
        int attempts = 1;
        boolean guessedCorrectly = false;
        String word = hiddenWord.getHiddenWord(); 
        System.out.println("Your word is: " + word);
        while (attempts < 7 && !guessedCorrectly) {
            System.out.print("Guess #" + attempts + ": Enter your guess: ");
            String guess = scanner.nextLine();
            guess = guess.toLowerCase();

            if (guess.length() != 5) {
                System.out.println("Please enter a 5-letter word.");
                continue;
            }

            if (guess.equals(word)) { 
                System.out.println("Congratulations! You've guessed the word correctly.");
                hiddenWord.getWord(guess);
                guessedCorrectly = true;
            } else {
                hiddenWord.getWord(guess); 
                guessedCorrectly = false;
            }

            attempts++;
        }

        if (guessedCorrectly == false) {
            System.out.println("You failed to guess the correct word. The hidden word was: " + word);
        } 
        if (guessedCorrectly)
            System.out.println("You guessed the correct word in " + (attempts-1) + " attempts."); 

        scanner.close();
    }
}