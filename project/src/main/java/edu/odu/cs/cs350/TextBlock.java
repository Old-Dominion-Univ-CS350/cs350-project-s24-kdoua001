package edu.odu.cs.cs350;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TextBlock {
    private  String theText;
    private  List<Token> tokensList;
        
    TextBlock(String BlockText){
        this.theText =  BlockText;
        this.tokensList = createTokens(BlockText);
    }
    
    
    public void setTextBlock(String AssignedBlock) {
        this.theText =  AssignedBlock;
    }

    public String getTextBlock() {
        return this.theText;
    }

    public void setTokensList(List<Token> AssignedTokens) {
        this.tokensList = AssignedTokens;
    }

    public List<Token> getTokensList() {
        return this.tokensList;
    }

    public List<Token> createTokens(String BlockText) {
        //Returns True if Word or Puncuation is Found
        String noTags = BlockText.replaceAll("<[^>]*>", ""); //I took the tags out of tokensList. makeString() will add them back to the string -Peter
        List<Token> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+|\\p{Punct}");
        Matcher matcher = pattern.matcher(noTags); //Changed BlockText to noTags -Peter

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
    
    /**
     * Adds NER blocks
     * Adds each token in tokensList to a single string
     * @return a single string with all the tokens and NER blocks
     */
    public String makeString(){
        StringBuilder theString = new StringBuilder();

        theString.append("<NER> ");
    
        for(Token token : tokensList){
            theString.append(token.getToken());
            theString.append(" ");
        }

        theString.append("</NER>");

        return theString.toString();

    }


    /**
     * Adds PER tags
     * @param startNameIndex The beginning of the personal name
     * @param numberOfTokensInName The number of tokens that make up the name
     */
    public void addPersonTag(int startNameIndex, int numberOfTokensInName){
        Token nameBegin = new Token("<PER>");
        Token nameEnd = new Token("</PER>");
        tokensList.add(startNameIndex -1, nameBegin);
        tokensList.add(startNameIndex + numberOfTokensInName, nameEnd);
        theText = this.makeString();
    }
    
}