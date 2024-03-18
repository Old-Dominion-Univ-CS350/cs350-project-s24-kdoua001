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

    public boolean isName() {
        return this.isName;
    }

    public boolean isInDictionary() {
        return this.inDictionary;
    }

    public boolean isLocation() {
        return this.isLocation;
    }

    public boolean isCommonFirst() {
        return this.commonFirst;
    }

    public boolean isCommonLast() {
        return this.commonLast;
    }

    public boolean isHonorific() {
        return this.honorific;
    }

    public boolean isKillWord() {
        return this.killWord;
    }

    public boolean isPunctuation() {
        return this.isPunctuation;
    }

    // Setter methods
    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    public void setIsName(boolean isName) {
        this.isName = isName;
    }

    public void setIsInDictionary(boolean inDictionary) {
        this.inDictionary = inDictionary;
    }

    public void setIsLocation(boolean isLocation) {
        this.isLocation = isLocation;
    }

    public void setIsCommonFirst(boolean commonFirst) {
        this.commonFirst = commonFirst;
    }

    public void setIsCommonLast(boolean commonLast) {
        this.commonLast = commonLast;
    }

    public void setIsHonorific(boolean honorific) {
        this.honorific = honorific;
    }

    public void setIsKillWord(boolean killWord) {
        this.killWord = killWord;
    }

    public void setIsPunctuation(boolean isPunctuation) {
        this.isPunctuation = isPunctuation;
    }
}