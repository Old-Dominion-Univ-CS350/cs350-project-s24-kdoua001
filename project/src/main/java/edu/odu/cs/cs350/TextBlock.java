package edu.odu.cs.cs350;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class TextBlock {
    private  String TextBlock;
    private  List<Token> Tokens;
        
    TextBlock(String BlockText){
        this.TextBlock =  BlockText;
        this.Tokens = createTokens(BlockText);
    }
    
    
     public void setTextBlock(String AssignedBlock) {
            this.TextBlock =  AssignedBlock;
        }

       public String getTextBlock() {
            return this.TextBlock;
        }

      public void setTokens(List<Token> AssignedTokens) {
            this.Tokens = AssignedTokens;
        }

       public List<Token> getTokens() {
            return this.Tokens;
        }

       public List<Token> createTokens(String BlockText) {
        //Returns True if Word or Puncuation is Found
        List<Token> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+|\\p{Punct}");
        Matcher matcher = pattern.matcher(BlockText); 

        //Set isPuncuation to True if Punc is Found in First Char, False if Not
        while (matcher.find()) {
            String tokenString = matcher.group();
            Token AddMe = new Token(tokenString);
            boolean isPunc = Character.isLetterOrDigit(tokenString.charAt(0));
            AddMe.setPunctuation(isPunc);
            tokens.add(AddMe);
        }

        return tokens;
       }

    
}