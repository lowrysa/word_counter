import java.util.Scanner;
import java.io.*;
public class main {
    private static Scanner k;
    public static final void main (String args[]) {
        //Run Program
        k = new Scanner(System.in);
        run();
    }

    //Meat and Potatoes
    private static void run() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome to the word counter program!");
        boolean finished = false;
        while (!finished) {
            System.out.println("Either input text, or a .txt file to be counted:");
            String input = k.nextLine();
            try { //If file exists, it will be read thru
                Scanner fileReader = new Scanner(new File(input));
                System.out.println("\nOpening file...");
                String inputFile = "";
                while(fileReader.hasNextLine()) 
                    inputFile += fileReader.nextLine();    
                String[] splittingLine = inputFile.split(" ");
                System.out.println("Word Count: " + splittingLine.length);
                fileReader.close();
                finished = true;
            } catch (FileNotFoundException ex) { //Input must not be file then
                String[] splittingLine = input.split(" ");
                System.out.println("\nWord Count: " + splittingLine.length);
                finished = true;
            }    
        }
    }
}
