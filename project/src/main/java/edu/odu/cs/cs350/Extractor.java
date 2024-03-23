package edu.odu.cs.cs350;


public class Extractor {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java Main <command> <inputFile>");
            return;
        }

        String command = args[0];
        if (command.equals("-jar")) {
            if (args.length < 3 || !args[1].equals("PNE.jar")) {
                System.out.println("Usage: java Main -jar PNE.jar <inputFile>");
                return;
            }
        }

    }

}