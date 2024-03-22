package edu.odu.cs.cs350;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IdentifyBlock class
 */
public class IdentifyBlock {

    private String dataFromFile;
    private List<String> blocks;

    /**
     * Constructor
     */
    public IdentifyBlock() {
        this.dataFromFile = "";
        this.blocks = new ArrayList<>();
    }

    /**
     * Constructor with data param
     * 
     * @param data
     */
    public IdentifyBlock(String data) {
        this.dataFromFile = data;
        this.blocks = extractBlocks(data);
    }

    /**
     * getter for dataFromFile
     * 
     * @return
     */
    public String getDataFromFile() {
        return this.dataFromFile;
    }

    /**
     * Getter for nerBlocks
     * 
     * @return
     */
    public List<String> getBlocks() {
        return this.blocks;
    }

    /**
     * Setter for dataFromFile
     * 
     * @param data
     */
        public void setDataFromFile(String data) {
        this.dataFromFile = data;
    }

    /**
     * Reads input and stores it in string
     * 
     * @throws Exception
     */
    public void readInput() throws Exception {
        Scanner scanner = new Scanner(new InputStreamReader(System.in, "UTF-8"));
        scanner.useDelimiter("\\A");
        String content = scanner.next();
        this.dataFromFile = content;
        scanner.close();
    }

    /**
     * Method to identify tagged blocks of text
     * 
     * @param text
     * @return
     */
    public List<String> extractBlocks(String data) {
        List<String> taggedBlocks = new ArrayList<>();

        // Define pattern to identify blocks of text
        Pattern pattern = Pattern.compile("<NER>.*?</NER>", Pattern.DOTALL);
        Matcher match = pattern.matcher(data);

        // Find patterns and adds them to the list
        while (match.find()) {
            String Strings = match.group();
             taggedBlocks.add(Strings);
        }

         return taggedBlocks;
    }

    /**
     * Output text blocks
     */
    public void output() {
        // Create output list
        List<String> output = new ArrayList<>();
    
        // Get text blocks for list
        blocks = getBlocks();
    
        // Loop for adding blocks to output
        for (String string : blocks) {
            // Get text block to add to output
            String String = new String(string);
            // Add text block to output list
            output.add(String.toString());
        }
    
        // Loop for outputting Strings
        for (String string : output) {
            // Output each text block from output list
            System.out.println(string);
        }
    }

}