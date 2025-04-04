import java.io.File; //imports
import java.io.FileNotFoundException; //have to import in order to pull from a file
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class WordSearch {
    private char[][] board;
    private int[] colmoves = {0, 1, 1,  1,  0, -1, -1, -1}; //x
    private int[] rowmoves = {1, 1, 0, -1, -1, -1,  0,  1}; //y

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

    // public boolean contains(String word) {


    // }


    // public boolean start(int row, int col) {
	// 	if(isValid(row,col)) {
	// 		stepCount++;
	// 		board[row][col] = stepCount;
	// 		return solve(row,col);
	// 	}
	// 	else return false;
	// }

    // public boolean solve(int row, int col) {
	// 	if(stepCount==board.length*board.length) {
	// 		return true;
	// 	}
	// 	for(int i = 0; i < rowMove.length; i++) {
	// 		int nextR = row + rowMove[i];
	// 		int nextC = col + colMove[i];
	// 		if(isValid(nextR, nextC)) {
	// 			board[nextR][nextC] = ++stepCount;
	// 			if(solve(nextR,nextC)) {
	// 				return true;
	// 			}
	// 			board[nextR][nextC] = 0;
	// 			stepCount--;
	// 		}
	// 	}
	// 	return false;
	// }


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
