package edu.odu.cs.cs350;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 
public class IdentifyBlock {
   
    private String dataFromFile;
    private List<String> nerBlocks;
   
    //Constructor
    public IdentifyBlock() {
        this.dataFromFile = "";
        this.nerBlocks = new ArrayList<>();
    }

    //Constructor with data param
    public IdentifyBlock(String data) {
        this.dataFromFile = data;
        this.nerBlocks = extractNerBlocks(data);
    }
 
    //getter for dataFromFile
    public String getDataFromFile(){
        return this.dataFromFile;
    }

    //Getter for nerBlocks
    public List<String> getNerBlocks() {
        return this.nerBlocks;
    }

    //Setter for dataFromFile
    public void setDataFromFile(String data){
        this.dataFromFile = data;
    }

    //Reads input and stores it in string
    public void readInput() throws Exception {
        Scanner scanner = new Scanner(new InputStreamReader(System.in, "UTF-8"));
        scanner.useDelimiter("\\A");
        String content = scanner.next();
        this.dataFromFile = content;
        scanner.close();
    }
   
    //Method to identify tagged blocks of text 
    public List<String> extractNerBlocks(String text) {
        List<String> taggedBlocks = new ArrayList<>();

        //Define pattern to identify blocks of text
        Pattern pattern = Pattern.compile("<NER>.*?</NER>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);

        //Find patterns and adds them to the list
        while (matcher.find()) {
            String textBlocks = matcher.group();
            taggedBlocks.add(textBlocks);
        }

        return taggedBlocks;
    }

    public void Output()
    {
        List<String> output = new ArrayList<>();
        nerBlocks = getNerBlocks();
        for (String string : nerBlocks)
        {
            TextBlock textBlock = new TextBlock(string);
            output.add(textBlock.toString());
        }
        for (String string : output)
        {
            System.out.println(string);
        }
    }

}