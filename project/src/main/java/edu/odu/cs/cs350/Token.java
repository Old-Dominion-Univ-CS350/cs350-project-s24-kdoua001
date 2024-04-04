package edu.odu.cs.cs350;

import java.util.regex.Pattern;

/**
 * This class represents a token object
 * It contains boolean values for various token attributes
 * It also contains a string representation of the token
 */
public class Token {

    private String tokenString = null;
    private boolean nameFlag;
    private boolean inDictionary;
    private boolean locationFlag;
    private boolean commonFirst;
    private boolean commonLast;
    private boolean honorificFlag;
    private boolean killWordFlag;
    private boolean punctuationFlag;
    private LexicalFeature lexicalFeature;

    // New field for POS tag
    private String posTag;
    private double perProbability = 0.5; // Initial probability of being a PER

    /**
     * Constructor
     * 
     * @param assignedString assigned string 
     * @param lexicalFeature feature the lexical feature associated with the token.
     */
    public Token(String assignedString, LexicalFeature lexicalFeature) {
        this.tokenString = assignedString;
        this.lexicalFeature = lexicalFeature;
        this.inDictionary = false;
        this.locationFlag = false;
        this.commonFirst = false;
        this.commonLast = false;
        this.honorificFlag = false;
        this.killWordFlag = false;
        this.punctuationFlag = false;
    }

    /**
     * @return the string of the token
     */
    public String getTokenString() {
        return this.tokenString;
    }

    /**
     * @return true if is a name, false if else
     */
    public boolean isName() {
        return this.nameFlag;
    }

    /**
     * @return true of dictionary, false if not
     */
    public boolean isInDictionary() {
        return this.inDictionary;
    }

    /**
     * @return true if is a location, false if not
     */
    public boolean isLocation() {
        return this.locationFlag;
    }

    /**
     * @return true if a common first name, false if not
     */
    public boolean isCommonFirst() {
        return this.commonFirst;
    }

    /**
     * @return true if common last name, false if not
     */
    public boolean isCommonLast() {
        return this.commonLast;
    }

    /**
     * @return true if a honorific, false if not
     */
    public boolean isHonorific() {
        return this.honorificFlag;
    }

    /**
     * @return true if a kill word, false if not
     */
    public boolean isKillWord() {
        return this.killWordFlag;
    }

    /**
     * @return true if a puncuation, false if not
     */
    public boolean isPunctuation() {
        return this.punctuationFlag;
    }

    /**
     * Sets the TokenString of a Token
     * 
     * @param string string representation of Token
     */
    public void setTokenString(String string) {
        this.tokenString = string;
    }

    /**
     * Sets the Bool isName of a Token
     * 
     * @param name boolean isName
     */
    public void setIsName(boolean name) {
        this.nameFlag = name;
    }

    /**
     * Sets the Bool inDictionary of Token
     * @param dictionary is this token in the dictionary
     */
    public void setIsInDictionary(boolean dictionary) {
        this.inDictionary = dictionary;
    }

    /**
     * Sets the Bool isLocation of Token
     * @param location is this token a location
     */
    public void setIsLocation(boolean location) {
        this.locationFlag = location;
    }

    /**
     * Sets the Bool commonFirst of a Token
     * @param first is this a common first name
     */
    public void setIsCommonFirst(boolean first) {
        this.commonFirst = first;
    }

    /**
     * Sets the Bool commonLast of a Token
     * @param last is this a common last name
     */
    public void setIsCommonLast(boolean last) {
        this.commonLast = last;
    }

    /**
     * Sets the Bool honorific of a Token 
     * @param honorific is this a honorific
     */
    public void setIsHonorific(boolean honorific) {
        this.honorificFlag = honorific;
    }

    /**
     * Sets the Bool killWord of a Token
     * 
     * @param killWord is this a kill word
     */
    public void setIsKillWord(boolean killWord) {
        this.killWordFlag = killWord;
    }

    /**
     * Sets the Bool isPunctuation of a Token
     * 
     * @param punctuation is this punctuation
     */
    public void setIsPunctuation(boolean punctuation) {
        this.punctuationFlag = punctuation;
    }

    /**
     * @return string representation of a Token
     */
    @Override
    public String toString() {
        return this.tokenString;
    }

    /**
     * gets the lexical feature associated with this token.
     * 
     * @return the lexical feature of this token
     */
    public LexicalFeature getLexicalFeature() {
        return lexicalFeature;
    }

    /**
     * 
     * @param lexicalFeature lexical feature
     */
    public void setLexicalFeature(LexicalFeature lexicalFeature) {
        this.lexicalFeature = lexicalFeature;
    }

    /**
     * detected lexical features
     */
    public void detectLexicalFeature() {
        if (tokenString.matches("-?\\d+(\\.\\d+)?")) {
            lexicalFeature = LexicalFeature.NUMBER;
        } else if (tokenString.length() == 1 && Character.isUpperCase(tokenString.charAt(0))) {
            lexicalFeature = LexicalFeature.SINGLECAPLETTER;
        } else if (tokenString.matches("[A-Z][a-z]*")) {
            lexicalFeature = LexicalFeature.CAPITALIZEDWORD;
        } else if (tokenString.matches("[A-Z]+")) {
            lexicalFeature = LexicalFeature.ALLCAPS;
        } else if (Pattern.matches(".*[.,?!]$", tokenString)) {
            lexicalFeature = LexicalFeature.PUNCTUATION;
        } else if (tokenString.equals("\n")) {
            lexicalFeature = LexicalFeature.NEWLINE;
        } else if (tokenString.isEmpty()) {
            lexicalFeature = LexicalFeature.NULLFEATURE;
        } else {
            lexicalFeature = LexicalFeature.OTHER;
        }

    }

    // _____________________________SPRINT 2
    // STUFF__________________________________________________

    /**
     * Sets the part-of-speech (POS) tag for this token.
     *
     * @param tag The POS tag
     */
    public void setPosTag(String tag) {
        this.posTag = tag;
    }

    /**
     * Returns the part-of-speech (POS) tag for this token.
     *
     * @return The POS tag
     */
    public String getPosTag() {
        return this.posTag;
    }

    /**
     * Increases the probability of this token being a personal name (PER) by the
     * specified amount.
     *
     * @param increase The amount to increase the probability by
     */
    public void increasePERProbability(double increase) {
        this.perProbability = Math.min(this.perProbability + increase, 1.0);
    }

    /**
     * Decreases the probability of this token being a personal name (PER) by the
     * specified amount.
     *
     * @param decrease The amount to decrease the probability by
     */
    public void decreasePERProbability(double decrease) {
        this.perProbability = Math.max(this.perProbability - decrease, 0.0);
    }

    /**
     * Returns the current probability of this token being a personal name (PER).
     *
     * @return The probability of being a PER
     */
    public double getPERProbability() {
        return this.perProbability;
    }

}