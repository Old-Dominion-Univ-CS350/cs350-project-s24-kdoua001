package edu.odu.cs.cs350;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class testTextBlock {

    @Test
    public void testTextBlockConstructor() {
        String inputTest = "<NER>Ralph, Izzy, Peter</NER>";
        TextBlock inputTxt = new TextBlock(inputTest);
        inputTxt.createTokens(inputTest);

        assertEquals("<NER>Ralph, Izzy, Peter</NER>", inputTxt.toString());

    }

    @Test
    public void testCreateTokens() {
        // create a block of words
        String blockOfWords = "This is a block of words";
        TextBlock secondBlockOfText = new TextBlock(blockOfWords);

        // create tokens for the block of words
        secondBlockOfText.createTokens(blockOfWords);
        String subStringOfBlock = "This";

        // check if the first token is equal to the first word in the block of words
        assertEquals(subStringOfBlock, secondBlockOfText.getTokensList().get(0).getTokenString());

    }

    @Test
    public void testSetTokens() {
        String originalText = "This is to test set tokens function";
        TextBlock aBlockOfText = new TextBlock(originalText);

        List<Token> originalTokens = aBlockOfText.createTokens(originalText);
        aBlockOfText.setTokensList(originalTokens);

        List<Token> newTokens = aBlockOfText.createTokens("new tokens for test");
        aBlockOfText.setTokensList(newTokens);
        assertEquals("new", aBlockOfText.getTokensList().get(0).getTokenString());
    }

    @Test
    public void testToString() {
        String text = "<NER>My name is John Doe!</NER>";
        TextBlock block = new TextBlock(text);
        assertThat(block.toString(), is("<NER>My name is <PER>John Doe</PER>!</NER>"));

        Token John = new Token("John");
        John.setIsName(true);
        John.setIsPunctuation(false);
        Token Jim = new Token("Jim");
        Jim.setIsName(true);
        Jim.setIsPunctuation(false);
        Token Doe = new Token("Doe");
        Doe.setIsName(true);
        Doe.setIsPunctuation(false);
        Token period = new Token(".");
        period.setIsPunctuation(true);

        String text2 = "<NER>His name is</NER>";
        TextBlock block2 = new TextBlock(text2);
        assertThat(block2.toString(), is("<NER>His name is</NER>"));
        block2.addToken(John);
        block2.addToken(Jim);
        block2.addToken(Doe);
        block2.addToken(period);
        assertThat(block2.toString(), is("<NER>His name is <PER>John Jim Doe</PER>.</NER>"));
    }

    @Test
    public void testMyNameIs() {
        TextBlock textBlock = new TextBlock("<NER>My name is John Doe!</NER>");
        assertTrue(textBlock.containsString("My"));
        textBlock.myNameIs();
        assertTrue(textBlock.toString().equals("<NER>My name is <PER>John Doe</PER>!</NER>"));
    }

    @Test
    public void testGenerateShingles() {
        List<List<Token>> shingles = new ArrayList<>();
        String text = "<NER>by John Doe, Lawrence Livermore Laboratory n</NER>";
        TextBlock block = new TextBlock(text);
        shingles = block.generateShingles(block.getTokensList());
        for (List<Token> shingle : shingles) {
            System.out.println("Shingle: " + shingle);
        }
    }

    @Test
    public void testIsLexicalFeature() {
        String lexicalFeaturesStringExample = "This is test input 10";
        TextBlock aBlockOfText = new TextBlock(lexicalFeaturesStringExample);
        boolean isANum = false;
        List<Token> inputTokens = aBlockOfText.createTokens(lexicalFeaturesStringExample);

        for (int i = 0; i < inputTokens.size(); i++) {
            Token token = inputTokens.get(i);
            String tokenValue = token.getTokenString();
            if (tokenValue.matches("\\d+")) {
                isANum = true;

                break;
            }
        }
        // for (Token token : inputTokens) {
        // String tokenValue = token.getTokenString();
        // if (tokenValue.matches("\\d+")) {
        // isANum = true;

        // break;
        // }

        // }

        assertTrue(isANum);

    }

}
