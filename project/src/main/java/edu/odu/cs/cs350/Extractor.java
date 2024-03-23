package edu.odu.cs.cs350;

import java.io.File;

public class Extractor {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java Main <command> <inputFile>");
            // return;
        }

        String inputFile = args[0];

        File file = new File(inputFile);
        if (!file.exists()) {
            System.out.println("Error: Input file not found.");
            return;
        }

        System.out.println("Input file: " + inputFile);
    }

}