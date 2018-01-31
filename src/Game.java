import java.io.*;
import java.util.Scanner;

public class Game {

    private   int movieCount;
    private  String randomMovieName;
    private String filName;
    private char [] wrongGuessChar ; // this array holds the wrong guesses made by the user
    private char [] charToDisplay ; // this array holds the good guesses

    public String getRandomMovieName() throws IOException {
        selectRandomMovie(filName);
        return randomMovieName;
    }

    public int getMovieCount() throws IOException {
            countmovieslist(filName);
        return movieCount;
    }

    public void setWrongGuessChar(char[] wrongGuessChar) {
        this.wrongGuessChar = wrongGuessChar;
    }

    public void setCharToDisplay(char[] charToDisplay) {
        this.charToDisplay = charToDisplay;
        for (int i = 0; i < charToDisplay.length; i++) {
            this.charToDisplay[i]='_';
        }
    }

    public char[] getCharToDisplay() {
        return charToDisplay;
    }

    public char[] getWrongGuessChar() {
        return wrongGuessChar;
    }

    public int countmovieslist(String fileName) throws IOException {

       for (int i = 1; i <=1 ; i++) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("This file: " +fileName +" cannot be found");
            }
            while (reader.readLine() != null) movieCount++;
            reader.close();
        }
        return movieCount;
    }

    public String selectRandomMovie(String filName) throws FileNotFoundException {
        File myFile = new File(filName);
        Scanner fileScanner = new Scanner(myFile);
        int value = (int) (Math.random() * movieCount) + 1;

        for (int i = 0; i < value; i++) {
            randomMovieName = fileScanner.nextLine();
        }
        setCharToDisplay(new char[randomMovieName.length()]); //initialize good guesses array
        return randomMovieName;
    }

  public   Game(String FilName) throws IOException {
        movieCount =0;
        randomMovieName ="";
        filName = FilName;
        setWrongGuessChar(new char[10]);

  }

}
