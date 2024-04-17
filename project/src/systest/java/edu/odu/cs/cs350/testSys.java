package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class testSys {
    @Test
    public void testSystest(){
        String [] args = {"src/test/data/input.txt"};

        try{
            Extractor.main(args);
        } catch (Exception e){
            System.out.println("Exception thrown");
        }
        
    }
    
}
