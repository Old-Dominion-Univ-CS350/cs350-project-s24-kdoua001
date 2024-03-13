package edu.odu.cs.cs350;
import java.util.List;
public class TextBlock {
    private  String TextBlock;
    private  List<Token> Tokens;
        
    TextBlock(String BlockText){
        this.TextBlock =  BlockText;
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
        return null;
       }

    
}