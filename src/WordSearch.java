import java.io.File; //imports
import java.io.FileNotFoundException; //have to import in order to pull from a file
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class WordSearch {
    private char[][] board;
    private static int[] colmoves = {0, 1, 1,  1,  0, -1, -1, -1}; //x
    private static int[] rowmoves = {1, 1, 0, -1, -1, -1,  0,  1}; //y

    /**
     * The constructor
     * @param asd the scanner for the file used
     * @throws FileNotFoundException the throw exception if no file is found
     */
    public WordSearch(Scanner asd) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>(); //create the arraylist
        try {
            while(asd.hasNextLine()) { //fills the arraylist
                lines.add(asd.nextLine());
            }
        } catch (Exception e) {}

        board = new char[lines.size()][lines.get(0).length()]; //creates the board
        for(int i = 0; i < lines.size(); i++) { //fills out the board with the contents of the arraylist
            for(int j = 0; j < lines.get(i).length(); j++) {
                board[i][j] = lines.get(i).charAt(j);
            }
        }
    }

    /**
     * This checks if the word is within a wordsearch
     * @param word the word its looking for
     * @return true or false, showing if it was found or not
     */
    public boolean contains(String word) { //works perfectly
        for(int i = 0; i < board.length ; i++) {
            for(int j = 0; j < board[0].length ; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(solve(word,i,j,0)) {
                        return true;
                    }
                }
            }
        }
        return false;
	}

    /**
     * This is the recursive function that solves if it has the word inside of it or not
     * @param word the word its looking for
     * @param row the current row
     * @param col the current collum
     * @param index what letter of the word they are on (its an integer for ease)
     * @return true/false if it has been solved
     */
    public boolean solve(String word, int row, int col, int index) { //WORKS!!!!!!
        if (index == word.length()) { //all of the possible ways it can fail
            return true;
        }
        if (!isValid(row, col) || board[row][col] != word.charAt(index)) {
            return false;
        }
    
        board[row][col] = Character.toUpperCase(board[row][col]); //sets the current space to an uppercase if we know its temporarly correct
    
        for (int i = 0; i < rowmoves.length; i++) { //goes through all the moves looking for the correct one
            int nextR = row + rowmoves[i];
            int nextC = col + colmoves[i];
            if (solve(word, nextR, nextC, index + 1)) { //if it makes it here, it moves on.
                return true; 
            }
        }

        board[row][col] = Character.toLowerCase(board[row][col]);;
    
        return false;
    }

    /**
     * Checks if the current space is valid to move onto (already used/out of bounds)
     * @param currentr row
     * @param currentc collum
     * @return true or false if its a valid space to make the move onto
     */
    public boolean isValid(int currentr, int currentc) { //works
        if(currentr < 0 || currentc < 0 || currentr > board.length - 1 || currentc > board[0].length -1) { //edges
            return false;
        }
        if(Character.isUpperCase(board[currentr][currentc])){ //uppercase
            return false;
        }
        return true;
    }

    /**
     * resets the board back to all lowercase
     */
    public void reset() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length;j++) {
                board[i][j] = Character.toLowerCase(board[i][j]);
            }
        }
    }

    /**
     * The tostring, just prints out the board in a pretty way
     */
    @Override
    public String toString() {
        String output = "";
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                output+= board[i][j] + " ";
            }
            output+= '\n';
        }
        return output;
    }


    //getters and setters
    public char[][] getBoard() {
        return board;
    }
    public void setBoard(char[][] board) {
        this.board = board;
    }
    public int[] getColmoves() {
        return colmoves;
    }
    public void setColmoves(int[] colmoves) {
        this.colmoves = colmoves;
    }
    public int[] getRowmoves() {
        return rowmoves;
    }
    public void setRowmoves(int[] rowmoves) {
        this.rowmoves = rowmoves;
    }

}
