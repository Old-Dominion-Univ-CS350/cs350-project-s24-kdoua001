package edu.odu.cs.cs350;
public class Token {
    
    private:
        String TokenString;
        boolean inDictionary;
        boolean isLocation;
        boolean commonFirst;
        boolean commonLast;
        boolean honorific;
        boolean killWord;
    
    Token(String AssignedString){
        this.TokenString = String AssignedString;
        this.inDictionary = false;
        this.isLocation = false;
        this.commonFirst = false;
        this.commonLast = false;
        this.honorific = false;
        this.killWord = false;
    }
}
