package edu.odu.cs.cs350;

/**
 * This class represents a token object 
 * It contains boolean values for various token attributes
 * It also contains a string representation of the token
 */
public class Token {
    
    private String tokenString;
    private boolean isName;
    private boolean inDictionary;
    private boolean isLocation;
    private boolean commonFirst;
    private boolean commonLast;
    private boolean honorific;
    private boolean killWord;
    private boolean isPunctuation;
    
    /**
     * Constructor
     */
    public Token(String assignedString){
        this.tokenString = assignedString;
        this.inDictionary = false;
        this.isLocation = false;
        this.commonFirst = false;
        this.commonLast = false;
        this.honorific = false;
        this.killWord = false;
        this.isPunctuation = false;
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
        return this.isName;
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
        return this.isLocation;
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
        return this.honorific;
    }

    /**
     * @param
     * @return true if a kill word, false if not
     */
    public boolean isKillWord() {
        return this.killWord;
    }

    /**
     * @param
     * @return true if a puncuation, false if not
     */
    public boolean isPunctuation() {
        return this.isPunctuation;
    }

    /**
     * Sets the TokenString of a Token
     * @param tokenString
     * @return
     */
    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    /**
     * Sets the Bool isName of a Token
     * @param isName
     * @return 
     */
    public void setIsName(boolean isName) {
        this.isName = isName;
    }

    /**
     * Sets the Bool inDictionary of Token
     * @param inDictionary
     * @return 
     */
    public void setIsInDictionary(boolean inDictionary) {
        this.inDictionary = inDictionary;
    }

    /**
     * Sets the Bool isLocation of Token
     * @param isLocation
     * @return 
     */
    public void setIsLocation(boolean isLocation) {
        this.isLocation = isLocation;
    }

    /**
     * Sets the Bool commonFirst of a Token
     * @param commonFirst
     * @return 
     */
    public void setIsCommonFirst(boolean commonFirst) {
        this.commonFirst = commonFirst;
    }

    /**
     * Sets the Bool commonLast of a Token
     * @param commonLast
     * @return 
     */
    public void setIsCommonLast(boolean commonLast) {
        this.commonLast = commonLast;
    }

    /**
     * Sets the Bool honorific of a Token
     * @param honorific
     * @return 
     */
    public void setIsHonorific(boolean honorific) {
        this.honorific = honorific;
    }

    /**
     * Sets the Bool killWord of a Token
     * @param killword
     * @return 
     */
    public void setIsKillWord(boolean killWord) {
        this.killWord = killWord;
    }

    /**
     * Sets the Bool isPunctuation of a Token 
     * @param isPunctuation
     * @return 
     */
    public void setIsPunctuation(boolean isPunctuation) {
        this.isPunctuation = isPunctuation;
    }
}