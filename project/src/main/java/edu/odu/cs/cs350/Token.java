package edu.odu.cs.cs350;

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

    // Constructor
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

    // Getter methods
    public String getTokenString() {
        return this.tokenString;
    }

    /**
     * @param
     * @return 
     */
    public boolean isName() {
        return this.isName;
    }

    /**
     * @param
     * @return 
     */
    public boolean isInDictionary() {
        return this.inDictionary;
    }

    /**
     * @param
     * @return 
     */
    public boolean isLocation() {
        return this.isLocation;
    }

    /**
     * @param
     * @return 
     */
    public boolean isCommonFirst() {
        return this.commonFirst;
    }

    /**
     * @param
     * @return 
     */
    public boolean isCommonLast() {
        return this.commonLast;
    }

    /**
     * @param
     * @return 
     */
    public boolean isHonorific() {
        return this.honorific;
    }

    /**
     * @param
     * @return 
     */
    public boolean isKillWord() {
        return this.killWord;
    }

    /**
     * @param
     * @return 
     */
    public boolean isPunctuation() {
        return this.isPunctuation;
    }

    // Setter methods
    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    /**
     * @param
     * @return 
     */
    public void setIsName(boolean isName) {
        this.isName = isName;
    }

    /**
     * @param
     * @return 
     */
    public void setIsInDictionary(boolean inDictionary) {
        this.inDictionary = inDictionary;
    }

    /**
     * @param
     * @return 
     */
    public void setIsLocation(boolean isLocation) {
        this.isLocation = isLocation;
    }

    /**
     * @param
     * @return 
     */
    public void setIsCommonFirst(boolean commonFirst) {
        this.commonFirst = commonFirst;
    }

    /**
     * @param
     * @return 
     */
    public void setIsCommonLast(boolean commonLast) {
        this.commonLast = commonLast;
    }

    /**
     * @param
     * @return 
     */
    public void setIsHonorific(boolean honorific) {
        this.honorific = honorific;
    }

    /**
     * @param
     * @return 
     */
    public void setIsKillWord(boolean killWord) {
        this.killWord = killWord;
    }

    /**
     * @param
     * @return 
     */
    public void setIsPunctuation(boolean isPunctuation) {
        this.isPunctuation = isPunctuation;
    }
}