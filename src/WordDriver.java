import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WordDriver {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in); //creating a scanner
        System.out.println("What is the name of your wordsearch file (make sure to NOT include .txt): "); //asking for the file names (used later to pull and push data)
        String file1 = input.next();
        file1+=".txt";
        Scanner fileinput = new Scanner(new File(file1)); //creating the reader
        WordSearch wordsearch = new WordSearch(fileinput);
        fileinput.close();
        
        

        System.out.println(wordsearch);
        System.out.println(wordsearch.start("h"));
        

        input.close();
    }
}
