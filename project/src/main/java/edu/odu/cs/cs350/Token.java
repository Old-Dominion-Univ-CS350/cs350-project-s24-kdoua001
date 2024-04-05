package edu.odu.cs.cs350;

import java.util.regex.Pattern;

import javax.lang.model.util.ElementScanner14;

/**
 * This class represents a token object
 * It contains boolean values for various token attributes
 * It also contains a string representation of the token
 */
public class Token {

    private String tokenString = null;
    private boolean nameFlag;
    private boolean inDictionary;
    private boolean locationFlag;
    private boolean commonFirst;
    private boolean commonLast;
    private boolean honorificFlag;
    private boolean killWordFlag;
    private boolean punctuationFlag;
    private LexicalFeature lexicalFeature;
    private FeatureOfSpeech speechFeature;

    /**
     * Constructor for Token
     * 
     * @param assignedString string to assign to token
     */
    public Token(String assignedString) {
        this.tokenString = assignedString;
        this.inDictionary = false;
        this.locationFlag = false;
        this.commonFirst = false;
        this.commonLast = false;
        this.honorificFlag = false;
        this.killWordFlag = false;
        this.punctuationFlag = false;
        DetectFeatureOfSpeech();

    }

    /**
     * Constructor
     * 
     * @param assignedString assigned string
     * @param lexicalFeature feature the lexical feature associated with the token.
     */
    public Token(String assignedString, LexicalFeature lexicalFeature) {
        this.tokenString = assignedString;
        this.lexicalFeature = lexicalFeature;
        this.inDictionary = false;
        this.locationFlag = false;
        this.commonFirst = false;
        this.commonLast = false;
        this.honorificFlag = false;
        this.killWordFlag = false;
        this.punctuationFlag = false;
        DetectFeatureOfSpeech();
    }

    /**
     * @return the string of the token
     */
    public String getTokenString() {
        return this.tokenString;
    }

    /**
     * @return true if is a name, false if else
     */
    public boolean isName() {
        return this.nameFlag;
    }

    /**
     * @return true of dictionary, false if not
     */
    public boolean isInDictionary() {
        return this.inDictionary;
    }

    /**
     * @return true if is a location, false if not
     */
    public boolean isLocation() {
        return this.locationFlag;
    }

    /**
     * @return true if a common first name, false if not
     */
    public boolean isCommonFirst() {
        return this.commonFirst;
    }

    /**
     * @return true if common last name, false if not
     */
    public boolean isCommonLast() {
        return this.commonLast;
    }

    /**
     * @return true if a honorific, false if not
     */
    public boolean isHonorific() {
        return this.honorificFlag;
    }

    /**
     * @return true if a kill word, false if not
     */
    public boolean isKillWord() {
        return this.killWordFlag;
    }

    /**
     * @return true if a puncuation, false if not
     */
    public boolean isPunctuation() {
        return this.punctuationFlag;
    }

    /**
     * Sets the TokenString of a Token
     * 
     * @param string string representation of Token
     */
    public void setTokenString(String string) {
        this.tokenString = string;
    }

    /**
     * Sets the Bool isName of a Token
     * 
     * @param name boolean isName
     */
    public void setIsName(boolean name) {
        this.nameFlag = name;
    }

    /**
     * Sets the Bool inDictionary of Token
     * 
     * @param dictionary is this token in the dictionary
     */
    public void setIsInDictionary(boolean dictionary) {
        this.inDictionary = dictionary;
    }

    /**
     * Sets the Bool isLocation of Token
     * 
     * @param location is this token a location
     */
    public void setIsLocation(boolean location) {
        this.locationFlag = location;
    }

    /**
     * Sets the Bool commonFirst of a Token
     * 
     * @param first is this a common first name
     */
    public void setIsCommonFirst(boolean first) {
        this.commonFirst = first;
    }

    /**
     * Sets the Bool commonLast of a Token
     * 
     * @param last is this a common last name
     */
    public void setIsCommonLast(boolean last) {
        this.commonLast = last;
    }

    /**
     * Sets the Bool honorific of a Token
     * 
     * @param honorific is this a honorific
     */
    public void setIsHonorific(boolean honorific) {
        this.honorificFlag = honorific;
    }

    /**
     * Sets the Bool killWord of a Token
     * 
     * @param killWord is this a kill word
     */
    public void setIsKillWord(boolean killWord) {
        this.killWordFlag = killWord;
    }

    /**
     * Sets the Bool isPunctuation of a Token
     * 
     * @param punctuation is this punctuation
     */
    public void setIsPunctuation(boolean punctuation) {
        this.punctuationFlag = punctuation;
    }

    /**
     * @return string representation of a Token
     */
    @Override
    public String toString() {
        return this.tokenString;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------

    /**
     * gets the lexical feature associated with this token.
     * 
     * @return the lexical feature of this token
     */
    public LexicalFeature getLexicalFeature() {
        return lexicalFeature;
    }

    /**
     * 
     * @param lexicalFeature lexical feature
     */
    public void setLexicalFeature(LexicalFeature lexicalFeature) {
        this.lexicalFeature = lexicalFeature;
    }

    /**
     * detected lexical features
     */
    public void detectLexicalFeature() {
        if (tokenString.matches("-?\\d+(\\.\\d+)?")) {
            lexicalFeature = LexicalFeature.NUMBER;
        } else if (tokenString.length() == 1 && Character.isUpperCase(tokenString.charAt(0))) {
            lexicalFeature = LexicalFeature.SINGLECAPLETTER;
        } else if (tokenString.matches("[A-Z][a-z]*")) {
            lexicalFeature = LexicalFeature.CAPITALIZEDWORD;
        } else if (tokenString.matches("[A-Z]+")) {
            lexicalFeature = LexicalFeature.ALLCAPS;
        } else if (Pattern.matches(".*[.,?!]$", tokenString)) {
            lexicalFeature = LexicalFeature.PUNCTUATION;
        } else if (tokenString.equals("\n")) {
            lexicalFeature = LexicalFeature.NEWLINE;
        } else if (tokenString.isEmpty()) {
            lexicalFeature = LexicalFeature.NULLFEATURE;
        } else {
            lexicalFeature = LexicalFeature.OTHER;
        }

    }

    public void setFeatureOfSpeech(FeatureOfSpeech feature) {
        speechFeature = feature;
    }

    public FeatureOfSpeech getFeatureOfSpeech() {
        return speechFeature;
    }

    public void DetectFeatureOfSpeech() {

        Tagger tagger = new Tagger();

        if (tagger.IsArticle(tokenString)){
            setFeatureOfSpeech(FeatureOfSpeech.ARTICLES);
        }
        if (tagger.IsConjunction(tokenString)){
            setFeatureOfSpeech(FeatureOfSpeech.CONJUNCTION);
        }
        if (tagger.IsPeriod(tokenString)){
            setFeatureOfSpeech(FeatureOfSpeech.PERIOD);
        }
        if (tagger.IsComma(tokenString)){
            setFeatureOfSpeech(FeatureOfSpeech.COMMA);
        }
        if (tagger.IsHyphen(tokenString)){
            setFeatureOfSpeech(FeatureOfSpeech.HYPHEN);
        }
        
    public static String detectPersonalName(Token token) {
        // Check lexical feature of the token
        LexicalFeature lexicalFeature = token.getLexicalFeature();

        if (isLikelyPersonalName(lexicalFeature)) {
            return "<PER>" + token.getTokenString() + "</PER>";
        } else {
            return token.getTokenString();
        }

    }

    public static boolean isLikelyPersonalName(LexicalFeature lexicalFeature) {
        return lexicalFeature == LexicalFeature.CAPITALIZEDWORD;

    }

}