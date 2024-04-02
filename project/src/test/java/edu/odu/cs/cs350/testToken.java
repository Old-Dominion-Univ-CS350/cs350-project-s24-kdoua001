package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class testToken {

    @Test
    public void testConstructor() {
        String string = "token";
        Token theToken = new Token(string, null);
        assertEquals(string, theToken.getTokenString());
        assertFalse(theToken.isName());
        assertFalse(theToken.isInDictionary());
        assertFalse(theToken.isLocation());
        assertFalse(theToken.isCommonFirst());
        assertFalse(theToken.isCommonLast());
        assertFalse(theToken.isHonorific());
        assertFalse(theToken.isPunctuation());
    }

    @Test
    public void testSetTokenString() {
        String string = " ";
        Token theToken = new Token(string, null);
        theToken.setTokenString("token");
        assertEquals("token", theToken.getTokenString());
        assertFalse(theToken.isName());
        assertFalse(theToken.isInDictionary());
        assertFalse(theToken.isLocation());
        assertFalse(theToken.isCommonFirst());
        assertFalse(theToken.isCommonLast());
        assertFalse(theToken.isHonorific());
        assertFalse(theToken.isPunctuation());
    }

    @Test
    public void testSetIsName() {
        String string = "token";
        Token theToken = new Token(string, null);
        theToken.setIsName(true);
        assertEquals(string, theToken.getTokenString());
        assertTrue(theToken.isName());
        assertFalse(theToken.isInDictionary());
        assertFalse(theToken.isLocation());
        assertFalse(theToken.isCommonFirst());
        assertFalse(theToken.isCommonLast());
        assertFalse(theToken.isHonorific());
        assertFalse(theToken.isPunctuation());
    }

    @Test
    public void testSetIsInDictionary() {
        String string = "token";
        Token theToken = new Token(string, null);
        theToken.setIsInDictionary(true);
        assertEquals(string, theToken.getTokenString());
        assertFalse(theToken.isName());
        assertTrue(theToken.isInDictionary());
        assertFalse(theToken.isLocation());
        assertFalse(theToken.isCommonFirst());
        assertFalse(theToken.isCommonLast());
        assertFalse(theToken.isHonorific());
        assertFalse(theToken.isPunctuation());
    }

    @Test
    public void testSetIsLocation() {
        String string = "token";
        Token theToken = new Token(string, null);
        theToken.setIsLocation(true);
        assertEquals(string, theToken.getTokenString());
        assertFalse(theToken.isName());
        assertFalse(theToken.isInDictionary());
        assertTrue(theToken.isLocation());
        assertFalse(theToken.isCommonFirst());
        assertFalse(theToken.isCommonLast());
        assertFalse(theToken.isHonorific());
        assertFalse(theToken.isPunctuation());
    }

    @Test
    public void testSetIsCommonFirst() {
        String string = "token";
        Token theToken = new Token(string, null);
        theToken.setIsCommonFirst(true);
        assertEquals(string, theToken.getTokenString());
        assertFalse(theToken.isName());
        assertFalse(theToken.isInDictionary());
        assertFalse(theToken.isLocation());
        assertTrue(theToken.isCommonFirst());
        assertFalse(theToken.isCommonLast());
        assertFalse(theToken.isHonorific());
        assertFalse(theToken.isPunctuation());
    }

    @Test
    public void testSetIsCommonLast() {
        String string = "token";
        Token theToken = new Token(string, null);
        theToken.setIsCommonLast(true);
        assertEquals(string, theToken.getTokenString());
        assertFalse(theToken.isName());
        assertFalse(theToken.isInDictionary());
        assertFalse(theToken.isLocation());
        assertFalse(theToken.isCommonFirst());
        assertTrue(theToken.isCommonLast());
        assertFalse(theToken.isHonorific());
        assertFalse(theToken.isPunctuation());
    }

    @Test
    public void testSetIsHonorific() {
        String string = "token";
        Token theToken = new Token(string, null);
        theToken.setIsHonorific(true);
        assertEquals(string, theToken.getTokenString());
        assertFalse(theToken.isName());
        assertFalse(theToken.isInDictionary());
        assertFalse(theToken.isLocation());
        assertFalse(theToken.isCommonFirst());
        assertFalse(theToken.isCommonLast());
        assertTrue(theToken.isHonorific());
        assertFalse(theToken.isPunctuation());
    }

    @Test
    public void testSetIsPunctuation() {
        String string = "token";
        Token theToken = new Token(string, null);
        theToken.setIsPunctuation(true);
        assertEquals(string, theToken.getTokenString());
        assertFalse(theToken.isName());
        assertFalse(theToken.isInDictionary());
        assertFalse(theToken.isLocation());
        assertFalse(theToken.isCommonFirst());
        assertFalse(theToken.isCommonLast());
        assertFalse(theToken.isHonorific());
        assertTrue(theToken.isPunctuation());
    }

    @Test
    public void testLexicalFeatureNumber() {
        // Test input a string representing a number
        String testInput = "10";
        String punctuationMarkInput = "!";
        String singleCapLetterInput = "A";
        String aCapitalizedWordInput = "Word";
        String allCapsInput = "HELLO";
        String newLineInput = "\n";
        String nullInput = "";
        String otherInput = "other";

        // creating a new Token object with test input with various lexical Features
        Token token = new Token(testInput, LexicalFeature.NUMBER);
        Token puncToken = new Token(punctuationMarkInput, LexicalFeature.PUNCTUATION);
        Token singleCapToken = new Token(singleCapLetterInput, LexicalFeature.SINGLECAPLETTER);
        Token capWordToken = new Token(aCapitalizedWordInput, LexicalFeature.CAPITALIZEDWORD);
        Token allCapToken = new Token(allCapsInput, LexicalFeature.ALLCAPS);
        Token newLineToken = new Token(newLineInput, LexicalFeature.NEWLINE);
        Token nullToken = new Token(nullInput, LexicalFeature.NULLFEATURE);
        Token otherToken = new Token(otherInput, LexicalFeature.OTHER);

        // check if lexical feature associated with the token is equal to certain
        // lexical feature
        assertEquals(LexicalFeature.NUMBER, token.getLexicalFeature());
        assertEquals(LexicalFeature.PUNCTUATION, puncToken.getLexicalFeature());
        assertEquals(LexicalFeature.SINGLECAPLETTER, singleCapToken.getLexicalFeature());
        assertEquals(LexicalFeature.CAPITALIZEDWORD, capWordToken.getLexicalFeature());
        assertEquals(LexicalFeature.ALLCAPS, allCapToken.getLexicalFeature());
        assertEquals(LexicalFeature.NEWLINE, newLineToken.getLexicalFeature());
        assertEquals(LexicalFeature.NULLFEATURE, nullToken.getLexicalFeature());
        assertEquals(LexicalFeature.OTHER, otherToken.getLexicalFeature());

    }

    @Test
    public void testDetectLexicalFeature() {
        String testInput = "My";
        Token tokenInput = new Token(testInput, null);
        tokenInput.setLexicalFeature(LexicalFeature.CAPITALIZEDWORD);

        assertEquals(LexicalFeature.CAPITALIZEDWORD, tokenInput.getLexicalFeature());
    }
}
