package edu.odu.cs.cs350;

import java.util.Scanner;
import java.io.InputStreamReader;


 
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
        this.nerBlocks = extractNerBlocks(data)
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

    public void readInput() throws Exception {
        Scanner scanner = new Scanner(new InputStreamReader(System.in, "UTF-8"));
        scanner.useDelimiter("\\A");
        String content = scanner.next();
        this.dataFromFile = content;
        scanner.close();
    }
   

}