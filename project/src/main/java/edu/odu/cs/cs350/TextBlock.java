package edu.odu.cs.cs350;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a TextBlock object.
 * It contains functions for creating tokens and converting TextBlocks to a
 * string.
 */
public class TextBlock {
    /**
     * List of tokens.
     */
    private List<Token> tokensList;

    /**
     * 
     * List containging a list of shingles for the textblock
     */
    private List<List<Token>> shinglesList;

    /**
     * Main Constructor.
     * 
     * @param BlockText
     */
    TextBlock(String BlockText) {
        this.tokensList = createTokens(BlockText);
        shinglesList = this.generateShingles(tokensList, 3,3);
    }

    /**
     * @param AssignedTokens assignedTokens
     */
    public void setTokensList(List<Token> AssignedTokens) {
        this.tokensList = AssignedTokens;
    }

    /**
     * @return tokenlist
     */
    public List<Token> getTokensList() {
        return this.tokensList;
    }

    /**
     * @param BlockText string of textblocks
     * @return List of Tokens
     */
    public List<Token> createTokens(String BlockText) {
        // Returns True if Word or Puncuation is Found
        String noTags = BlockText.replaceAll("<[^>]*>", "");
        List<Token> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+|\\p{Punct}|\\n");
        Matcher match = pattern.matcher(noTags);

        // Set isPunctuation to True if Punc is Found in First Char, False if Not
        while (match.find()) {
            String tokenString = match.group();
            Token AddMe = new Token(tokenString);
            boolean isPunctuation = Character.isLetterOrDigit(tokenString.charAt(0));
            AddMe.setIsPunctuation(!isPunctuation);

            // detect lexical feature of tokens
            // AddMe.detectLexicalFeature();
            tokens.add(AddMe);
        }

        return tokens;
    }

    /**
     * @return string representation of TextBlock
     *         Entire text block will be wrapped in NER /NER and
     *         persons will be wrapped in PER /PER
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
     * 
     * @param token a Token object
     *              Adds a token to tokensList
     */
    public void addToken(Token token) {
        this.tokensList.add(token);
    }

    /**
     * Used to search tokensList for a token containing a string.
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
     * For demonstration purposes only.
     * If the first three tokens in a textblock are "My" "name" "is" it will set the
     * next two tokens as personal Names.
     * This will allow us to demonstrate that personal names will appear wrapped in
     * PER /PER tags in output.
     */
    public void myNameIs() {
        if (this.containsString("My") && this.containsString("name") && this.containsString("is")) {
            tokensList.get(3).setIsName(true);
            tokensList.get(4).setIsName(true);
        }
    }

    /**
     * Used to generate shingling to be used as input for the learning machine.
     * Section 5.3 of design notes.
     * 
     * @param tokens a list of Tokens we want to apply shingling to
     * @param start  The number of tokens before the current token that are included
     *               in the shingle
     * @param end    The number of tokens after the current token that are included
     *               in the shingle
     * @return A list of a list of tokens with shingling applied.
     */
    public List<List<Token>> generateShingles(List<Token> tokens, int start, int end) {
        List<List<Token>> shingles = new ArrayList<>();

        // Add null tokens at the beginning and end of the list
        List<Token> paddedTokens = new ArrayList<>();
        for (int i = 0; i < start; i++) {
            paddedTokens.add(new Token("null"));
        }
        paddedTokens.addAll(tokens);
        for (int i = 0; i < end; i++) {
            paddedTokens.add(new Token("null"));
        }

        for (int i = start; i < paddedTokens.size() - end; i++) {
            List<Token> shingle = new ArrayList<>();

            // Add the k tokens before the current token
            for (int j = i - start; j < i; j++) {
                shingle.add(paddedTokens.get(j));
            }

            // Add the current token
            shingle.add(paddedTokens.get(i));

            // Add the k' tokens after the current token
            for (int j = i + 1; j < i + 1 + end; j++) {
                shingle.add(paddedTokens.get(j));
            }

            // Add the shingle to the result list
            shingles.add(shingle);
        }

        return shingles;
    }

}