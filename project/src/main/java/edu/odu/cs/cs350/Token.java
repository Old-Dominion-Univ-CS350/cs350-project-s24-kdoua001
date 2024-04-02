package edu.odu.cs.cs350;

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

    /**
     * Constructor
     * 
     * @param number
     * @param lexical feature the lexical feature associated with the token.
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
     * @param
     * @return the string of the token
     */
    public String getTokenString() {
        return this.tokenString;
    }

    /**
     * @param
     * @return true if is a name, false if else
     */
    public boolean isName() {
        return this.nameFlag;
    }

    /**
     * @param
     * @return true of dictionary, false if not
     */
    public boolean isInDictionary() {
        return this.inDictionary;
    }

    /**
     * @param
     * @return true if is a location, false if not
     */
    public boolean isLocation() {
        return this.locationFlag;
    }

    /**
     * @param
     * @return true if a common first name, false if not
     */
    public boolean isCommonFirst() {
        return this.commonFirst;
    }

    /**
     * @param
     * @return true if common last name, false if not
     */
    public boolean isCommonLast() {
        return this.commonLast;
    }

    /**
     * @param
     * @return true if a honorific, false if not
     */
    public boolean isHonorific() {
        return this.honorificFlag;
    }

    /**
     * @param
     * @return true if a kill word, false if not
     */
    public boolean isKillWord() {
        return this.killWordFlag;
    }

    /**
     * @param
     * @return true if a puncuation, false if not
     */
    public boolean isPunctuation() {
        return this.punctuationFlag;
    }

    /**
     * Sets the TokenString of a Token
     * 
     * @param tokenString
     * @return
     */
    public void setTokenString(String string) {
        this.tokenString = string;
    }

    /**
     * Sets the Bool isName of a Token
     * 
     * @param name
     * @return
     */
    public void setIsName(boolean name) {
        this.nameFlag = name;
    }

    /**
     * Sets the Bool inDictionary of Token
     * 
     * @param dictionary
     * @return
     */
    public void setIsInDictionary(boolean dictionary) {
        this.inDictionary = dictionary;
    }

    /**
     * Sets the Bool isLocation of Token
     * 
     * @param location
     * @return
     */
    public void setIsLocation(boolean location) {
        this.locationFlag = location;
    }

    /**
     * Sets the Bool commonFirst of a Token
     * 
     * @param first
     * @return
     */
    public void setIsCommonFirst(boolean first) {
        this.commonFirst = first;
    }

    /**
     * Sets the Bool commonLast of a Token
     * 
     * @param last
     * @return
     */
    public void setIsCommonLast(boolean last) {
        this.commonLast = last;
    }

    /**
     * Sets the Bool honorific of a Token
     * 
     * @param honorific
     * @return
     */
    public void setIsHonorific(boolean honorific) {
        this.honorificFlag = honorific;
    }

    /**
     * Sets the Bool killWord of a Token
     * 
     * @param killword
     * @return
     */
    public void setIsKillWord(boolean killWord) {
        this.killWordFlag = killWord;
    }

    /**
     * Sets the Bool isPunctuation of a Token
     * 
     * @param punctuation
     * @return
     */
    public void setIsPunctuation(boolean punctuation) {
        this.punctuationFlag = punctuation;
    }

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

    public void setLexicalFeature(LexicalFeature lexicalFeature) {
        this.lexicalFeature = lexicalFeature;
    }

    public void detectLexicalFeature() {
        if (tokenString.matches("\\d+")) {
            lexicalFeature = LexicalFeature.NUMBER;

        }

    }

}