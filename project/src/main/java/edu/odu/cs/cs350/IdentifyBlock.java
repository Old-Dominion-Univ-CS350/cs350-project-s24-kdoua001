package edu.odu.cs.cs350;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IdentifyBlock {
    //holds data from file
    private String dataFromFile;
    //holds list of strings
    private List<String> nerBlocks;
    
    //Default constructor 
    public IdentifyBlock() {
        this.dataFromFile = "";
        this.nerBlocks = new ArrayList<>();
    }

    //Data paramater contructor 
    public IdentifyBlock(String data) {
        this.dataFromFile = data;
        this.nerBlocks = extractNerBlocks(data);
    }

    //Reads content of file 
    private String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    //Extracts text blocks from data
    private List<String> extractNerBlocks(String data) {
        List<String> blocks = new ArrayList<>();
        int startIndex = 0;
        while (true) {
            int nerStartIndex = data.indexOf("<NER>", startIndex);
            if (nerStartIndex == -1) break;
            int nerEndIndex = data.indexOf("</NER>", nerStartIndex);
            if (nerEndIndex == -1) break;
            blocks.add(data.substring(nerStartIndex, nerEndIndex + 6)); 
            startIndex = nerEndIndex + 6;
        } 
        return blocks;
    }

    //Getter for datFromFile
    public String getDataFromFile() {
        return this.dataFromFile;
    }
    
    //Getter for nerBlocks
    public List<String> getNerBlocks() {
        return this.nerBlocks;
    }

    //Overide toString method to return dataFromFile
    @Overide
    public String toString() {
        return this.dataFromFile;
    }
 
} 
