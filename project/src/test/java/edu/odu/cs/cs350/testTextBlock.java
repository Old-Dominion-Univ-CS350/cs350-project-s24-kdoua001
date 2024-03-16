package edu.odu.cs.cs350;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

    
public class testTextBlock{

    @Test
    public void testTextBlockConstructor()
    {
        String inputTest = "<NER> Ralph, Izzy, Peter </NER>";
        TextBlock  inputTxt = new TextBlock(inputTest);
        inputTxt.createTokens(inputTest);
        
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
    public void testCreateTokens()
    {
        String blockOfWords = "This is a block of words";
        TextBlock secondBlockOfText = new TextBlock(blockOfWords);

        secondBlockOfText.createTokens(blockOfWords);
        String subStringOfBlock = "This";

        assertEquals(subStringOfBlock, secondBlockOfText.getTokensList().get(0).getToken());
        
    }

    @Test
    public void testSetTokens(){
        String originalText = "This is to test set tokens function";
        TextBlock aBlockOfText = new TextBlock(originalText);

        List<Token> originalTokens = aBlockOfText.createTokens(originalText);
        aBlockOfText.setTokensList(originalTokens);

        List<Token> newTokens = aBlockOfText.createTokens("new tokens for test");
        aBlockOfText.setTokensList(newTokens);
        assertEquals("new", aBlockOfText.getTokensList().get(0).getToken());
   }


   @Test
   public void testToString()
   {
        Token My = new Token("My");
        Token name = new Token("name");
        Token is = new Token("is");
        Token John = new Token("John");
        Token Jim = new Token("Jim");
        Token Doe = new Token("Doe");

        John.setIsAName(true);
        Jim.setIsAName(true);
        Doe.setIsAName(true);

        TextBlock block = new TextBlock(" ");
        block.addToken(My);
        block.addToken(name);
        block.addToken(is);
        block.addToken(John);
        block.addToken(Jim);
        block.addToken(Doe);
    
        assertThat(block.toString(), is ("<NER> My name is <PER> John Jim Doe </PER> </NER>"));
   }

 
 
}

