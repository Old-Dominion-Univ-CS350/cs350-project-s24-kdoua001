package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
 * ouput appears in debug console
 */
public class ExampleSystemTest {
    @Test
    public void systemTest(){
        String [] args = {"src/systest/data/input.txt"};
        try{
            Extractor.main(args);
        } catch (Exception e){
            System.out.println("Exception thrown");
        }
        
    }
}
