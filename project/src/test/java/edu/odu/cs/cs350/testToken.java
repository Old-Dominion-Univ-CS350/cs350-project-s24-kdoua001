package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class testToken {

    @Test
    public void testConstructor() {
        String string = "token";
        Token theToken = new Token(string);
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
        Token theToken = new Token(string);
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
        Token theToken = new Token(string);
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
        Token theToken = new Token(string);
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
        Token theToken = new Token(string);
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
        Token theToken = new Token(string);
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
        Token theToken = new Token(string);
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
        Token theToken = new Token(string);
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
        Token theToken = new Token(string);
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
        String testInput = "10";
        Token token = new Token(testInput, LexicalFeature.NUMBER);

        assertEquals(LexicalFeature.NUMBER, token.getLexicalFeature);

    }
}
