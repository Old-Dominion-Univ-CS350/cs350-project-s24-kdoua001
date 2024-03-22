package edu.odu.cs.cs350;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputInfo {
    // private String input;

    private String dataFromTextBlocks;

    public void getDataFromTextBlocks() {
        this.dataFromTextBlocks = "";
    }

    public void getDataFromTextBlocks(String theString) {
        this.dataFromTextBlocks = theString;
    }

    public void outputText() {
        OutputInfo newOutput = new OutputInfo();
        // String output = newOutput.getDataFromTextBlocks();
        // System.out.println(output);
    }

}
