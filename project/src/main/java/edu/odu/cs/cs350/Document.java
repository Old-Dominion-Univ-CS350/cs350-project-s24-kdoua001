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
public class Document {

    private String dataFromFile;
    private List<TextBlock> blocks;

    /**
     * Constructor
     */
    public Document() {
        this.dataFromFile = "";
        this.blocks = new ArrayList<>();
    }

    /**
     * Constructor with data param
     * 
     * @param data data 
     */
    public Document(String data) {
        this.dataFromFile = data;
        this.blocks = createBlocks(data);
    }

    /**
     * getter for dataFromFile
     * 
     * @return data from file
     */
    public String getDataFromFile() {
        return this.dataFromFile;
    }

    /**
     * Getter for nerBlocks
     * 
     * @return ner blocks
     */
    public List<TextBlock> getBlocks() {
        return this.blocks;
    }

    /**
     * Setter for dataFromFile
     * 
     * @param data data to set 
     */
    public void setDataFromFile(String data) {
        this.dataFromFile = data;
    }

    // /**
    // * Reads input and stores it in string
    // *
    // * @throws Exception
    // */
    // public void readInput() throws Exception {
    // Scanner scanner = new Scanner(new InputStreamReader(System.in, "UTF-8"));
    // scanner.useDelimiter("\\A");
    // String content = scanner.next();
    // this.dataFromFile = content;
    // scanner.close();
    // }

    /**
     * Method to identify tagged blocks of text
     * 
     * @param data text
     * @return taggedBlocks
     */
    public List<TextBlock> createBlocks(String data) {
        List<TextBlock> taggedBlocks = new ArrayList<>();

        // Define pattern to identify blocks of text
        Pattern pattern = Pattern.compile("<NER>.*?</NER>", Pattern.DOTALL);
        Matcher match = pattern.matcher(data);

        // Find patterns and adds them to the list
        while (match.find()) {
            String blocktext = match.group();
            TextBlock AddMe = new TextBlock(blocktext);
            taggedBlocks.add(AddMe);
        }

        return taggedBlocks;
    }

    /**
     * Output text blocks
     */
    public void printDocument() {
        // Create output list
        List<String> output = new ArrayList<>();

        // Get text blocks for list
        blocks = getBlocks();

        // Loop for adding blocks to output
        for (TextBlock Block : blocks) {
            // Get text block to add to output
            String BlockString = Block.toString();
            // Add text block to output list
            output.add(BlockString);
        }

        // Loop for outputting Strings
        for (String string : output) {
            // Output each text block from output list
            System.out.println(string);
        }
    }

}