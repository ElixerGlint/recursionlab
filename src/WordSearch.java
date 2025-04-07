import java.io.File; //imports
import java.io.FileNotFoundException; //have to import in order to pull from a file
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class WordSearch {
    private char[][] board;
    private static int[] colmoves = {0, 1, 1,  1,  0, -1, -1, -1}; //x
    private static int[] rowmoves = {1, 1, 0, -1, -1, -1,  0,  1}; //y

    public WordSearch(Scanner asd) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>();
        try {
            while(asd.hasNextLine()) {
                lines.add(asd.nextLine());
            }
        } catch (Exception e) {}

        board = new char[lines.size()][lines.get(0).length()];
        for(int i = 0; i < lines.size(); i++) {
            for(int j = 0; j < lines.get(i).length(); j++) {
                board[i][j] = lines.get(i).charAt(j);
            }
        }
    }

    public boolean start(String word) { //works perfectly
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

    public boolean solve(String word, int row, int col, int index) { //WORKS!!!!!!
        if (index == word.length()) {
            return true;
        }
    
        if (!isValid(row, col) || board[row][col] != word.charAt(index)) {
            return false;
        }
    
        board[row][col] = Character.toUpperCase(board[row][col]);
    
        for (int i = 0; i < rowmoves.length; i++) {
            int nextR = row + rowmoves[i];
            int nextC = col + colmoves[i];
            if (solve(word, nextR, nextC, index + 1)) {
                return true; 
            }
        }

        board[row][col] = Character.toLowerCase(board[row][col]);;
    
        return false;
    }


    public boolean isValid(int currentr, int currentc) { //works
        if(currentr < 0 || currentc < 0 || currentr > board.length - 1 || currentc > board[0].length -1) {
            return false;
        }
        if(Character.isUpperCase(board[currentr][currentc])){
            return false;
        }
        return true;
    }

    public void reset() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length;j++) {
                board[i][j] = Character.toLowerCase(board[i][j]);
            }
        }
    }









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
