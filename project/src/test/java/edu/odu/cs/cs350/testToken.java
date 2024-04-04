package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
        String otherInput = "h.e.l.l.o";

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
    public void testDetectLexicalFeatureNumber() {
        String testRepOfNumber = "10";
        String testLeadingZeroNumber = "007";
        String negativeInteger = "-456";
        String floatingPointNumber = "3.14";

        Token numbToken = new Token(testRepOfNumber, null);
        Token leadingZToken = new Token(testLeadingZeroNumber, null);
        Token negativeToken = new Token(negativeInteger, null);
        Token floatingToken = new Token(floatingPointNumber, null);

        numbToken.detectLexicalFeature();
        leadingZToken.detectLexicalFeature();
        negativeToken.detectLexicalFeature();
        floatingToken.detectLexicalFeature();

        assertEquals(LexicalFeature.NUMBER, numbToken.getLexicalFeature());
        assertEquals(LexicalFeature.NUMBER, leadingZToken.getLexicalFeature());
        assertEquals(LexicalFeature.NUMBER, negativeToken.getLexicalFeature());
        assertEquals(LexicalFeature.NUMBER, floatingToken.getLexicalFeature());
    }

    @Test
    public void testDetectLexicalFeatureCapWord() {
        String capitalizedWordInput = "Hello";
        String textSingleCapitalizedLetter = "World";

        Token capitalizedWordToken = new Token(capitalizedWordInput, null);
        Token singleCapToken = new Token(textSingleCapitalizedLetter, null);
        capitalizedWordToken.detectLexicalFeature();
        singleCapToken.detectLexicalFeature();

        assertEquals(LexicalFeature.CAPITALIZEDWORD, capitalizedWordToken.getLexicalFeature());
        assertEquals(LexicalFeature.CAPITALIZEDWORD, singleCapToken.getLexicalFeature());

    }

    @Test
    public void testDetectLexicalFeatureAllCaps() {
        String allCapsWord = "TEST";
        String allCapsWordStringInput = "BUILD";

        Token allCapsWordToken = new Token(allCapsWord, null);
        Token allCapitalizedWordToken = new Token(allCapsWordStringInput, null);
        allCapsWordToken.detectLexicalFeature();
        allCapitalizedWordToken.detectLexicalFeature();

        assertEquals(LexicalFeature.ALLCAPS, allCapsWordToken.getLexicalFeature());
        assertEquals(LexicalFeature.ALLCAPS, allCapitalizedWordToken.getLexicalFeature());
    }

    @Test
    public void testDetectLexicalFeatureSingleCap() {
        String singleLetterInput = "L";
        String secondSingleLetterInput = "M";

        Token tokenizeSingleLetterInput = new Token(singleLetterInput, null);
        Token tokenizeSecondSingleLetterInput = new Token(secondSingleLetterInput, null);

        tokenizeSingleLetterInput.detectLexicalFeature();
        tokenizeSecondSingleLetterInput.detectLexicalFeature();

        assertEquals(LexicalFeature.SINGLECAPLETTER, tokenizeSingleLetterInput.getLexicalFeature());
        assertEquals(LexicalFeature.SINGLECAPLETTER, tokenizeSecondSingleLetterInput.getLexicalFeature());
    }

    @Test
    public void testDetectLexicalFeaturePunctuation() {
        String testComma = ",";
        String testPeriod = ".";
        String testExclamationMark = "!";

        Token commaToken = new Token(testComma, null);
        Token periodToken = new Token(testPeriod, null);
        Token exclamationMarkToken = new Token(testExclamationMark, null);

        commaToken.detectLexicalFeature();
        periodToken.detectLexicalFeature();
        exclamationMarkToken.detectLexicalFeature();

        assertEquals(LexicalFeature.PUNCTUATION, commaToken.getLexicalFeature());
        assertEquals(LexicalFeature.PUNCTUATION, periodToken.getLexicalFeature());
        assertEquals(LexicalFeature.PUNCTUATION, exclamationMarkToken.getLexicalFeature());
    }

    @Test
    public void testDetectLexicalFeatureNewLine()
    {
        String testNewLine = "\n";

        Token tokenizeNewLine = new Token(testNewLine, null);

        tokenizeNewLine.detectLexicalFeature();

        assertEquals(LexicalFeature.NEWLINE, tokenizeNewLine.getLexicalFeature());
    }

    @Test
    public void testDetectLexicalFeatureNullFeature()
    {
        String testNullFeature = "NULL";

        Token tokenizeNullFeature = new Token(testNullFeature, null);

        tokenizeNullFeature.detectLexicalFeature();

        assertEquals(LexicalFeature.NULLFEATURE, tokenizeNullFeature.getLexicalFeature());
    }

    @Test
    public void testDetectLexicalFeatureOther()
    {
        String firstTestOther = "a";
        String secondTestOther = "words";
        String thirdTestOther = "TEST123";
        String fourthTestOther = "don't";
        String fifthTestOther = "odu.edu";

        Token tokenizeFirstOther = new Token(firstTestOther, null);
        Token tokenizeSecondOther = new Token(secondTestOther, null);
        Token tokenizeThirdOther = new Token(thirdTestOther, null);
        Token tokenizeFourthOther = new Token(fourthTestOther, null);
        Token tokenizeFifthOther = new Token(fifthTestOther, null);

        tokenizeFirstOther.detectLexicalFeature();
        tokenizeSecondOther.detectLexicalFeature();
        tokenizeThirdOther.detectLexicalFeature();
        tokenizeFourthOther.detectLexicalFeature();
        tokenizeFifthOther.detectLexicalFeature();

        assertEquals(LexicalFeature.OTHER, tokenizeFirstOther.getLexicalFeature());
        assertEquals(LexicalFeature.OTHER, tokenizeSecondOther.getLexicalFeature());
        assertEquals(LexicalFeature.OTHER, tokenizeThirdOther.getLexicalFeature());
        assertEquals(LexicalFeature.OTHER, tokenizeFourthOther.getLexicalFeature());
        assertEquals(LexicalFeature.OTHER, tokenizeFifthOther.getLexicalFeature());
    }

}
