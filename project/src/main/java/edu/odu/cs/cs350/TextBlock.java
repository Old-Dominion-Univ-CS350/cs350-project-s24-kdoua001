package edu.odu.cs.cs350;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TextBlock {
    private  List<Token> tokensList;
        
    TextBlock(String BlockText){
        this.tokensList = createTokens(BlockText);
    }

    public void setTokensList(List<Token> AssignedTokens) {
        this.tokensList = AssignedTokens;
    }

    public List<Token> getTokensList() {
        return this.tokensList;
    }

    public List<Token> createTokens(String BlockText) {
        //Returns True if Word or Puncuation is Found
        String noTags = BlockText.replaceAll("<[^>]*>", "");
        List<Token> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+|\\p{Punct}");
        Matcher matcher = pattern.matcher(noTags);

        //Set isPuncuation to True if Punc is Found in First Char, False if Not
        while (matcher.find()) {
            String tokenString = matcher.group();
            Token AddMe = new Token(tokenString);
            boolean isPunc = Character.isLetterOrDigit(tokenString.charAt(0));
            AddMe.setIsPunctuation(!isPunc);
            tokens.add(AddMe);
        }

        return tokens;
    }

    /**
     * @return string representation of TextBlock
     * Entire text block will be wrapped in <NER> </NER> and
     * persons will be wrapped in <PER> </PER>
     */
    public String toString(){
        StringBuilder theString = new StringBuilder();
        theString.append("<NER>"); 
    
        int lastIndex = tokensList.size() - 1;

        for (int index = 0; index <= lastIndex; index++){
            Token currentToken = tokensList.get(index);
            Token previousToken = (index > 0) ? tokensList.get(index - 1) : null;
            Token nextToken = (index < lastIndex) ? tokensList.get(index + 1) : null;

            if (currentToken.isName() && !previousToken.isName()){
                theString.append("<PER>");//beginning of name
            }

            theString.append(currentToken.getTokenString());

            if (currentToken.isName() && !nextToken.isName()){
                theString.append("</PER>");//end of name
            }

            if(!(nextToken == null) && !nextToken.isPunctuation()){
                theString.append(" ");
            }
        }
        
        theString.append("</NER>");
        return theString.toString().trim();
    }

    /**
     * 
     * @param token a Token object
     * Adds a token to tokensList
     */
    public void addToken(Token token){
        this.tokensList.add(token);
    }

}