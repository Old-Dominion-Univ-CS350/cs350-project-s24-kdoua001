package edu.odu.cs.cs350;

import java.io.File;

public class Extractor {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java Extractor <inputFile>");
            return;
        }

        String inputFile = args[0];

        // Check if the input file exists
        File file = new File(inputFile);
        if (!file.exists()) {
            System.out.println("Error: Input file not found.");
            return;
        }

        System.out.println("Input file: " + inputFile);

        // Perform actions with the input file
    }
}
