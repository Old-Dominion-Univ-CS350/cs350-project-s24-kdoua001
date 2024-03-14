package edu.odu.cs.cs350;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

    
public class testTextBlock{

    @Test
    public void testTextBlockConstructor()
    {
        String inputTest = "<NER> Ralph, Izzy, Peter </NER>";
        TextBlock  inputTxt = new TextBlock(inputTest);
        
        assertEquals("<NER> Ralph, Izzy, Peter </NER>", inputTxt.getTextBlock());

    }
    
    
    @Test
    public void testSetTextBlock()
    {
        TextBlock firstBlock = new TextBlock("default string");

        //create another block of words
        String blockOfWords = "This is a block of words";

        //use setter for textblock class
        firstBlock.setTextBlock(blockOfWords);
        
        assertEquals(blockOfWords, firstBlock.getTextBlock());
    }
    
    @Test
    public void testSetTokens()
    {
        
        
    }
    
    
}

