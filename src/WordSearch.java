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
        for(int i = 0; i < board.length -1; i++) {
            for(int j = 0; j < board[0].length -1; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(solve(word,i,j,0)) {
                        return true;
                    }
                }
            }
        }
        return false;
	}

    public boolean solve(String word, int row, int col, int index) { //main problems here
        if(index > word.length()) {
            return false;
        }
        //----------------
		for(int i = 0; i < rowmoves.length; i++) {
			int nextR = row + rowmoves[i];
			int nextC = col + colmoves[i];
            
            System.out.println(board[row][col]);
            board[row][col] = Character.toUpperCase(board[row][col]);
            System.out.println((isValid(nextR, nextC, index, word)));
			if(isValid(nextR, nextC, index, word)) {
				if(solve(word, nextR,nextC, index+1)) {
					return true;
				}
				board[nextR][nextC] = 0;
                //------------
                
			}
            // board[row][col] = Character.toLowerCase(board[row][col]);
		}
		return false;
	}


    public boolean isValid(int nextR, int nextC, int index, String word) {
        if(nextR < 0 || nextC < 0 || nextR > board.length-1 || nextC > board[0].length-1) {
            return false;
        }
        if(Character.isUpperCase(board[nextR][nextC])){
            return false;
        }
        return true;
    }



    private void reset() {
        //runs through everything and sets it all to lowercase


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
