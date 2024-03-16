package edu.odu.cs.cs350;
public class Token {
    
    private String TokenString;
    private boolean isAName;
    private boolean inDictionary;
    private boolean isLocation;
    private boolean commonFirst;
    private boolean commonLast;
    private boolean honorific;
    private boolean killWord;
    private boolean isPunctuation;

    Token(String AssignedString){
        this.TokenString =  AssignedString;
        this.inDictionary = false;
        this.isLocation = false;
        this.commonFirst = false;
        this.commonLast = false;
        this.honorific = false;
        this.killWord = false;
        this.isPunctuation = false;
    }

    public boolean isPunctuation() {
        return isPunctuation;
    }


    String getToken()
    {
        return this.TokenString;
    }

    boolean getIsAName()
    {
        return this.isAName;
    }

    boolean getInDictionary()
    {
        return this.inDictionary;
    }

    boolean getIsLocation()
    {
        return this.isLocation;
    }

    boolean getCommonFirst()
    {
        return this.commonFirst;
    }

    boolean getCommonLast()
    {
        return this.commonLast;
    }

    boolean getHonorific()
    {
        return this.honorific;
    }

    boolean getKillWord()
    {
        return this.killWord;
    }

    void setToken(String str)
    {
        this.TokenString = str;
    }

    void setIsAName(boolean isName)
    {
        this.isAName = isName;
    }

    void setInDictonary(boolean bool)
    {
        this.inDictionary = bool;
    }

    void setIsLocation(boolean bool)
    {
        this.isLocation = bool;
    }

    void setCommonFirst(boolean bool)
    {
        this.commonFirst = bool;
    }

    void setCommonLast(boolean bool)
    {
        this.commonLast = bool;
    }

    void setHonorific(boolean bool)
    {
        this.honorific = bool;
    }

    void setKillWord(boolean bool)
    {
        this.killWord = bool;
    }

    void setPunctuation(boolean isPunctuation) {
        this.isPunctuation = isPunctuation;
    }

}
