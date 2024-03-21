package edu.odu.cs.cs350;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a TextBlock object
 * It contains functions for creating tokens and converting TextBlocks to a string
 */
public class TextBlock {
    private  List<Token> tokensList;

    /**
     * Main Constructor 
     */
    TextBlock(String BlockText){
        this.tokensList = createTokens(BlockText);
    }

    /**
     * @param AssignedTokens
     * @return none
     */
    public void setTokensList(List<Token> AssignedTokens) {
        this.tokensList = AssignedTokens;
    }

    /**
     * @param none
     * @return tokenlist
     */
    public List<Token> getTokensList() {
        return this.tokensList;
    }

    /**
     * @param BlockText
     * @return List of Tokens
     */
    public List<Token> createTokens(String BlockText) {
        //Returns True if Word or Puncuation is Found
        String noTags = BlockText.replaceAll("<[^>]*>", "");
        List<Token> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+|\\p{Punct}");
        Matcher match = pattern.matcher(noTags);

        //Set isPuncuation to True if Punc is Found in First Char, False if Not
        while (match.find()) {
            String tokenString = match.group();
            Token AddMe = new Token(tokenString);
            boolean isPunctuation = Character.isLetterOrDigit(tokenString.charAt(0));
            AddMe.setIsPunctuation(!isPunctuation);
            tokens.add(AddMe);
        }

        return tokens;
    }

    /**
     * converts TextBlock object to string representation
     * Will be wrapped in <NER> </NER> and personal names will be wrapped in <PER> </PER>
     * @return string representation of a TextBlock object
     */
    public String toString() {
        StringBuilder theString = new StringBuilder();
        theString.append("<NER>");
        for (int index = 0; index < tokensList.size(); index++) {
            Token currentToken = tokensList.get(index);
            Token previousToken = (index > 0) ? tokensList.get(index - 1) : null;
            Token nextToken = (index < tokensList.size() - 1) ? tokensList.get(index + 1) : null;

            if (isNameStart(currentToken, previousToken)) {
                theString.append("<PER>"); // Beginning of name
            }

            theString.append(currentToken.getTokenString());

            if (isNameEnd(currentToken, nextToken)) {
                theString.append("</PER>"); // End of name
            }

            if (!isLastToken(index, tokensList.size()) && !nextToken.isPunctuation()) {
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

    
    /**
     * used by toString
     * @param currentToken current token in TextBlock being processed
     * @param previousToken previous token in TextBlock
     * @return true if current token is a name AND previous token is not 
     */
    private boolean isNameStart(Token currentToken, Token previousToken) {
        return currentToken.isName() && (previousToken == null || !previousToken.isName());
    }

    /**
     * used by toString
     * @param currentToken current token in TextBlock being processed
     * @param nextToken next token in TextBlock to be processed
     * @return true if current token is a name AND the next token is not 
     */
    private boolean isNameEnd(Token currentToken, Token nextToken) {
        return currentToken.isName() && (nextToken == null || !nextToken.isName());
    }

    /**
     * 
     * @param currentIndex current token in TextBlock being processed
     * @param totalTokens total number of tokens in TextBlock 
     * @return true if the current token is the last token in TextBlock
     */
    private boolean isLastToken(int currentIndex, int totalTokens) {
        return currentIndex == totalTokens - 1;
    }

}