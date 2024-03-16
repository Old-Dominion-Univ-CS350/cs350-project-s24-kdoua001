package edu.odu.cs.cs350;

import java.util.Scanner;
import java.io.InputStreamReader;


 
public class IdentifyBlock {
   
    private String dataFromFile;
   
    //constructor
    public IdentifyBlock() {
        this.dataFromFile = "";
    }
 
    public IdentifyBlock(String data) {
        this.dataFromFile = data;
    }
 
    //getter for dataFromFile
    public String getDataFromFile(){
        return this.dataFromFile;
    }

    public void setDataFromFile(String data){
        this.dataFromFile = data;
    }

    public void readInput() throws Exception {
        Scanner scanner = new Scanner(new InputStreamReader(System.in, "UTF-8"));
        scanner.useDelimiter("\\A");
        String content = scanner.next();
        this.dataFromFile = content;
        scanner.close();
    }
   

}






































/* 
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

     //Getter for datFromFile
     public String getDataFromFile() {
        return this.dataFromFile;
    }
    
    //Getter for nerBlocks
    public List<String> getNerBlocks() {
        return this.nerBlocks;
    }

    //Overide toString method to return dataFromFile
    @Override
    public String toString() {
        return this.dataFromFile;
    }

    //Reads content of file 
    public String readFile(String filePath) {
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

    public static final String NER_OPEN = "<NER>";
    public static final String NER_CLOSE = "</NER>";
    public static final int NER_LAST = 6;

    private bool ValidTags(String data, int index)
    {
        return (data.indexOf(NER_OPEN, index) >= 0 && data.indexOf(NER_CLOSE, index) >= 0) ? true : false;
    }

    private int CloseIndex(String data, int index)
    {
        return data.indexOf(NER_CLOSE, index) + NER_LAST;
    }

    //Extracts text blocks from data
    private List<String> extractNerBlocks(String data) {
        List<String> blocks = new ArrayList<>();
        int index = data.indexOf(NER_OPEN, 0);
        int tempIndex;

        while (ValidTags(data, index)) {
            tempIndex = index;
            index += CloseIndex(data, tempIndex);
            blocks.add(data.substring(tempIndex, index)); 
            index++;
        } 
        return blocks;
    }
 
} 
*/