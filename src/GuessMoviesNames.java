import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class GuessMoviesNames {
    public static void main(String args[]) throws Exception{
        // Create a Game object, Game is the class that contains the logic of the game
        String filName = new String("listOfMovies.txt");
        Game GuessNameGame = new Game(filName);
        // count movies in the movie list
        int moviesCount =GuessNameGame.getMovieCount();
        // create a file object with the movies list file

        if (moviesCount != 0) {// if list of movies is not empty enter here
            String movieName=GuessNameGame.getRandomMovieName() ;
            int wrongGuessCount=0; // this variable holds the number of wrong guesses made by the user

            String userInputString;  // this variable holds whatever the user types in at each round
             int sizeOfMovieName = movieName.length();
            // create a scanner to read user guesses
            Scanner userGuess = new Scanner(System.in);
            // initialize the good guesses to '_', meaning no guess


            for (int i = 0; i < 10; i++) { //The user only have 10 wrong guesses
                // Show the user the size of the name to guess
                System.out.print("You are guessing: ");
                for (int ii = 0; ii < sizeOfMovieName; ii++) {
                    System.out.print(GuessNameGame.getCharToDisplay()[ii]+" ");
                }
                System.out.println("");
                // Show the user the number of wrong guesses he made so far
                System.out.print("You have guessed ("+wrongGuessCount+") wrong letters: ");
                for (int iii = 0; iii < wrongGuessCount; iii++) {
                    System.out.print(GuessNameGame.getWrongGuessChar()[iii] +" ");
                }
                System.out.println("");
                // Ask the user to guess a letter
                System.out.print("Guess a letter:");

                char guessedChar = userGuess.nextLine().charAt(0);


                boolean isGoodGuess = false;
                userInputString = new String(GuessNameGame.getCharToDisplay());
                if (userInputString.indexOf(guessedChar) < 0) { // check if the same guess was previously made, if so go to next step
                    for (int index = movieName.indexOf(guessedChar);
                         index >= 0;
                         index = movieName.indexOf(guessedChar, index + 1)) {// check if the guess is correct and update good guesses array accordingly
                         GuessNameGame.getCharToDisplay()[index] = guessedChar;
                        isGoodGuess = true;
                    }
                }
                if (isGoodGuess){// if the guess is good
                    userInputString = new String(GuessNameGame.getCharToDisplay());
                    i=0;
                }
                else { // if the guess is wrong
                    GuessNameGame.getWrongGuessChar()[wrongGuessCount]=guessedChar;
                    wrongGuessCount++;
                }
                if ((userInputString.indexOf('_') < 0)||(wrongGuessCount==10)){ //if there is no more letter to guess or 10 wrong guesses were made
                    if(wrongGuessCount!=10) {
                        System.out.println("You win!");
                        System.out.print("You have guessed '" + userInputString + "' correctly.");
                    }
                    else{
                        System.out.println("Sorry, Game over!");
                        System.out.print("You have guessed ("+wrongGuessCount+") wrong letters: ");
                        System.out.print("The correct guess is '" + movieName + "'.");
                    }
                    break;
                }
            }
        }
    }
}

