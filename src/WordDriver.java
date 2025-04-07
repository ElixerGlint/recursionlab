import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WordDriver {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the wordsearch solver!"); //introduction
        Scanner input = new Scanner(System.in); //creating a scanner
        System.out.println("What is the name of your wordsearch file (make sure to NOT include .txt): "); //asking for the file names (used later to pull and push data)
        String file1 = input.nextLine();
        file1+= ".txt";
        Scanner fileinput = new Scanner(new File(file1)); //creating the reader
        WordSearch wordsearch = new WordSearch(fileinput);
        fileinput.close();
        String cont; 

        System.out.println("What word would you like to find: ");
        cont = input.nextLine();

        while(!cont.equals("!")) { //while they are not finished
            System.out.println(wordsearch);
            if(wordsearch.contains(cont)) { //if there is a soluton: show it
                System.out.println("The solution is as shown below:");
                System.out.println(wordsearch);
            }
            else { //otherwise say there is no solution
                System.out.println("There was no solution");
            }
            wordsearch.reset(); //reset after every run
            
            System.out.println("Type the next word you would like to search, otherwise type ! to quit."); //ask again
            cont = input.nextLine();
        }

        input.close();
    }
}
