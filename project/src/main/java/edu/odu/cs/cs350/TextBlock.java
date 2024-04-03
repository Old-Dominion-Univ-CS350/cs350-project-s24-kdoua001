package edu.odu.cs.cs350;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a TextBlock object
 * It contains functions for creating tokens and converting TextBlocks to a
 * string
 */
public class TextBlock {
    private List<Token> tokensList;

    static final int shingleSize = 3;

    /**
     * Main Constructor
     */
    TextBlock(String BlockText) {
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
        // Returns True if Word or Puncuation is Found
        String noTags = BlockText.replaceAll("<[^>]*>", "");
        List<Token> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+|\\p{Punct}");
        Matcher match = pattern.matcher(noTags);

        // Set isPunctuation to True if Punc is Found in First Char, False if Not
        while (match.find()) {
            String tokenString = match.group();
            Token AddMe = new Token(tokenString, null);
            boolean isPunctuation = Character.isLetterOrDigit(tokenString.charAt(0));
            AddMe.setIsPunctuation(!isPunctuation);

            // detect lexical feature of tokens
            AddMe.detectLexicalFeature();
            tokens.add(AddMe);
        }

        return tokens;
    }

    /**
     * @return string representation of TextBlock
     *         Entire text block will be wrapped in <NER> </NER> and
     *         persons will be wrapped in <PER> </PER>
     */
    @Override
    public String toString() {
        myNameIs();// Demonstration purposes only.
        StringBuilder theString = new StringBuilder();
        theString.append("<NER>");
        int lastIndex = tokensList.size() - 1;

        for (int index = 0; index <= lastIndex; index++) {
            Token currentToken = tokensList.get(index);
            Token previousToken = (index > 0) ? tokensList.get(index - 1) : null;
            Token nextToken = (index < lastIndex) ? tokensList.get(index + 1) : null;
            if (currentToken.isName() && !previousToken.isName()) {
                theString.append("<PER>");// beginning of name
            }
            theString.append(currentToken.getTokenString());
            if ((nextToken == null || !nextToken.isName()) && currentToken.isName()) {
                theString.append("</PER>");// end of name
            }
            if (!(nextToken == null) && !nextToken.isPunctuation()) {
                theString.append(" ");
            }
        }

        theString.append("</NER>");
        return theString.toString().trim();
    }

    /**
     * This function will generate shingles to be used to generate input for the
     * learning machine
     * as described in section 5.3 in the Design Notes
     * 
     * @param tokens a list of tokens to be turned into shingles
     * @return a list containing lists of tokens.
     */
    public static List<List<Token>> generateShingles(List<Token> tokens) {
        List<List<Token>> shingles = new ArrayList<>();

        int windowSize = 2 * shingleSize + 1;

        // Add initial null tokens for lists with null tokens at the beginning
        for (int i = 0; i < shingleSize; i++) {
            List<Token> nullWindow = new ArrayList<>();
            for (int j = 0; j < shingleSize - i; j++) {
                nullWindow.add(null);
            }
            nullWindow.addAll(tokens.subList(0, i + shingleSize + 1));
            shingles.add(nullWindow);
        }

        // Add tokens to list
        for (int i = 0; i <= tokens.size() - windowSize; i++) {
            List<Token> window = new ArrayList<>(tokens.subList(i, i + windowSize));
            shingles.add(window);
        }

        // Add trailing null tokens for lists with null tokens at the end
        for (int i = 0; i < shingleSize; i++) {
            List<Token> nullWindow = new ArrayList<>(tokens.subList(tokens.size() - windowSize + i, tokens.size()));
            for (int j = 0; j < shingleSize - i; j++) {
                nullWindow.add(null);
            }
            shingles.add(nullWindow);
        }

        return shingles;
    }

    /**
     * 
     * @param token a Token object
     *              Adds a token to tokensList
     */
    public void addToken(Token token) {
        this.tokensList.add(token);
    }

    /**
     * used to search tokensList for a token containing a string
     * 
     * @param search the string representation of a token to be found
     * @return true if a token in tokensList contains the string
     */
    public boolean containsString(String search) {
        for (Token token : tokensList) {
            if (token.getTokenString().equals(search)) {
                return true;
            }
        }
        return false;
    }

    /**
     * For demonstration purposes only
     * If the first three tokens in a textblock are "My" "name" "is" it will set the
     * next two tokens as personal Names
     * This will allow us to demonstrate that personal names will appear wrapped in
     * <PER> </PER> tags in output
     */
    public void myNameIs() {
        if (this.containsString("My") && this.containsString("name") && this.containsString("is")) {
            tokensList.get(3).setIsName(true);
            tokensList.get(4).setIsName(true);
        }
    }

}