package edu.odu.cs.cs350;

import java.util.regex.Pattern;

/**
 * This class represents a token object.
 * It contains boolean values for various token attributes.
 * It also contains a string representation of the token.
 */
public class Token {
    /**
     * The token string representation.
     * This is the raw string value of the token.
     */
    private String tokenString = null;

    /**
     * Flag indicating whether the token represents a name.
     */
    private boolean nameFlag;

    /**
     * Flag indicating whether the token is found in the dictionary.
     */
    private boolean inDictionary;

    /**
     * Flag indicating whether the token represents a location.
     */
    private boolean locationFlag;

    /**
     * Flag indicating whether the token is a common first name.
     */
    private boolean commonFirst;

    /**
     * Flag indicating whether the token is a common last name.
     */
    private boolean commonLast;

    /**
     * Flag indicating whether the token has an honorific (e.g., "Mr.", "Dr.").
     */
    private boolean honorificFlag;

    /**
     * Flag indicating whether the token is a "kill word" that should be ignored.
     */
    private boolean killWordFlag;

    /**
     * Flag indicating whether the token contains punctuation.
     */
    private boolean punctuationFlag;

    /**
     * The lexical feature of the token.
     */
    private LexicalFeature lexicalFeature;

    /**
     * The part of speech feature of the token.
     */
    private FeatureOfSpeech speechFeature;

    /**
     * Flag indicating whether the assinged string is possibly part of the english
     * language
     * 
     */
    private boolean isEnglishWord;

    /**
     * Constructor for Token.
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
        this.isEnglishWord = false;
        detectFeatureOfSpeech();
        detectLexicalFeature();
        detectCommonFirstName();
        detectEnglishWord();
        detectCommonLastName();
        detectCitiesAndStates();
        detectCountriesAndTerritories();
        detectPlaces();

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
     * Sets the TokenString of a Token.
     * 
     * @param string string representation of Token.
     */
    public void setTokenString(String string) {
        this.tokenString = string;
    }

    /**
     * Sets the Bool isName of a Token.
     * 
     * @param name boolean isName.
     */
    public void setIsName(boolean name) {
        this.nameFlag = name;
    }

    /**
     * Sets the Bool inDictionary of Token.
     * 
     * @param dictionary is this token in the dictionary.
     */
    public void setIsInDictionary(boolean dictionary) {
        this.inDictionary = dictionary;
    }

    /**
     * Sets the Bool isLocation of Token.
     * 
     * @param location is this token a location.
     */
    public void setIsLocation(boolean location) {
        this.locationFlag = location;
    }

    /**
     * Sets the Bool commonFirst of a Token.
     * 
     * @param first is this a common first name.
     */
    public void setIsCommonFirst(boolean first) {
        this.commonFirst = first;
    }

    /**
     * Sets the Bool commonLast of a Token.
     * 
     * @param last is this a common last name.
     */
    public void setIsCommonLast(boolean last) {
        this.commonLast = last;
    }

    /**
     * Sets the Bool honorific of a Token.
     * 
     * @param honorific is this a honorific.
     */
    public void setIsHonorific(boolean honorific) {
        this.honorificFlag = honorific;
    }

    /**
     * Sets the Bool killWord of a Token.
     * 
     * @param killWord is this a kill word.
     */
    public void setIsKillWord(boolean killWord) {
        this.killWordFlag = killWord;
    }

    /**
     * Sets the Bool isPunctuation of a Token.
     * 
     * @param punctuation is this punctuation.
     */
    public void setIsPunctuation(boolean punctuation) {
        this.punctuationFlag = punctuation;
    }

    /**
     * @return string representation of a Token.
     */
    @Override
    public String toString() {
        return this.tokenString;
    }

    // -------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Gets the lexical feature associated with this token.
     * 
     * @return the lexical feature of this token.
     */
    public LexicalFeature getLexicalFeature() {
        return lexicalFeature;
    }

    /**
     * Setter for lexical features.
     * 
     * @param lexicalFeature lexical feature.
     */
    public void setLexicalFeature(LexicalFeature lexicalFeature) {
        this.lexicalFeature = lexicalFeature;
    }

    /**
     * Assigns a Lexical Feature Type to the Token.
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

    /**
     * Sets the Feature Of Speech Attribute.
     * 
     * @param feature feature
     */
    public void setFeatureOfSpeech(FeatureOfSpeech feature) {
        speechFeature = feature;
    }

    /**
     * Gets the Feature of Speech Attribute.
     * 
     * @return FeatureOfSpeech speechFeature
     */
    public FeatureOfSpeech getFeatureOfSpeech() {
        return speechFeature;
    }

    /**
     * Assigns the Token a Feature of Speech Type.
     */
    public void detectFeatureOfSpeech() {

        Tagger tagger = new Tagger();

        if (tagger.IsArticle(tokenString)) {
            setFeatureOfSpeech(FeatureOfSpeech.ARTICLES);
        } else if (tagger.IsConjunction(tokenString)) {
            setFeatureOfSpeech(FeatureOfSpeech.CONJUNCTION);
        } else if (tagger.IsPeriod(tokenString)) {
            setFeatureOfSpeech(FeatureOfSpeech.PERIOD);
        } else if (tagger.IsComma(tokenString)) {
            setFeatureOfSpeech(FeatureOfSpeech.COMMA);
        } else if (tagger.IsHyphen(tokenString)) {
            setFeatureOfSpeech(FeatureOfSpeech.HYPHEN);
        } else {
            setFeatureOfSpeech(FeatureOfSpeech.OTHER);
        }
    }

    /**
     * Detects if the token's lexical features suggest it represents a personal
     * name.
     * and wraps the token string in PER tags if it is likely a personal name.
     * 
     * @return the token string wrapped in PER tags if it's likely a personal name.
     */
    public String detectPersonalName() {
        // Check lexical feature of the token
        LexicalFeature lexicalFeature = this.getLexicalFeature();
        FeatureOfSpeech featureOfSpeech = this.getFeatureOfSpeech();
        // Check if the lexical feature suggests it is likely a personal name
        if (isLikelyPersonalName(lexicalFeature, featureOfSpeech)) {
            return "<PER>" + this.getTokenString() + "</PER>" + "";
        } else {
            return this.getTokenString(); // else return the token without per tags
        }

    }

    /**
     * Determine if the provided lexical feature, feature of speech is likely to.
     * represent a personal.
     * name.
     * 
     * @param lexicalFeature  lexical feature to be evaluated.
     * @param featureOfSpeech speech feature to be evaluated.
     * @return True if the lexical feature is either Capitalized word, All caps, or
     *         Single capitalized letter and the feature of speech is not an
     *         article, conjunction, period, comma or hyphen.
     */
    public boolean isLikelyPersonalName(LexicalFeature lexicalFeature, FeatureOfSpeech featureOfSpeech) {
        return lexicalFeature == LexicalFeature.CAPITALIZEDWORD
                || lexicalFeature == LexicalFeature.ALLCAPS
                || lexicalFeature == LexicalFeature.SINGLECAPLETTER &&
                        (featureOfSpeech != FeatureOfSpeech.ARTICLES &&
                                featureOfSpeech != FeatureOfSpeech.CONJUNCTION &&
                                featureOfSpeech != FeatureOfSpeech.PERIOD &&
                                featureOfSpeech != FeatureOfSpeech.COMMA &&
                                featureOfSpeech != FeatureOfSpeech.HYPHEN);

    }

    public void detectCommonFirstName() {
        Iterable<String> commonFirstNames = WordLists.commonFirstNames();
        for (String name : commonFirstNames) {
            if (tokenString.equalsIgnoreCase(name)) {
                commonFirst = true;
                return;
            }
        }
        commonFirst = false;
    }

    public void detectCommonLastName() {
        Iterable<String> commonLastNames = WordLists.commonLastNames();
        for (String lastnames : commonLastNames) {
            if (tokenString.equalsIgnoreCase(lastnames)) {
                commonLast = true;
                return;
            }
        }
        commonLast = false;
    }

    public boolean getIsEnglishWord() {
        return isEnglishWord;
    }

    public void setIsEnglishWord(boolean isEqualTo) {
        isEnglishWord = isEqualTo;
    }

    public void detectEnglishWord() {
        Iterable<String> englishDictionary = WordLists.englishDictionary();
        for (String dictionaryWord : englishDictionary) {
            if (dictionaryWord.equalsIgnoreCase(tokenString)) {
                setIsEnglishWord(true);
                return;
            }
        }
        setIsEnglishWord(false);
        return;
    }

    public boolean getIsLocation()) {
        return locationFlag;
    }

    public void detectCitiesAndStates() {
        Iterable<String> citiesAndStates = WordLists.citiesAndStatesUS();
        for (String cityOrState : citiesAndStates) {
            if (cityOrState.equalsIgnoreCase(tokenString)) {
                setIsLocation(true);
                return;
            }
        }
        setIsLocation(false);
        return;
    }

    public void detectCountriesAndTerritories() {
        Iterable<String> countriesAndTerritories = WordLists.countriesAndTerritories();
        for (String countryOrTerritory : countriesAndTerritories) {
            if (countryOrTerritory.equalsIgnoreCase(tokenString)) {
                setIsLocation(true);
                return;
            }
        }
        setIsLocation(false);
        return;
    }

    public void detectPlaces() {
        Iterable<String> places = WordLists.places();
        for (String place : places) {
            if (place.equalsIgnoreCase(tokenString)) {
                setIsLocation(true);
                return;
            }
        }
        setIsLocation(false);
        return;
    }

}