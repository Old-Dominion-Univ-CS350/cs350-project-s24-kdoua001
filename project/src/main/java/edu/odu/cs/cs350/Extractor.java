package edu.odu.cs.cs350;

import java.io.File;
import java.util.Scanner;

public class Extractor {

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
}
