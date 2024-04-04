package edu.odu.cs.cs350;

import java.io.File;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for calling other classes and functions
 */
public class Extractor {
    /* 
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path to the input file: ");
        String inputFile = scanner.nextLine();

        // Check if the input file exists
        File file = new File(inputFile);
        if (!file.exists()) {
            System.out.println("Error: Input file not found.");
            return;
        }

        System.out.println("Input file: " + inputFile);

        scanner.close();

    }
    */
    
    /**
     * Main function
     * 
     * @param args args
     * @throws Exception exception
     */
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new InputStreamReader(System.in, "UTF-8"));
        scanner.useDelimiter("\\A");
        String contentOfFile = scanner.next();
        scanner.close();

        Document Document = new Document(contentOfFile);

        // Output the extracted blocks
        System.out.println("Extracted Blocks:");
        Document.printDocument();
    }

}
