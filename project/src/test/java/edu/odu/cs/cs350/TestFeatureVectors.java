package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import weka.core.Instances;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.List;

public class TestFeatureVectors {

    // Method to create a test Token object
    private Token createToken(boolean name, boolean inDictionary, boolean location, boolean commonFirst,
            boolean commonLast, boolean honorific, boolean prefix, boolean suffix,
            boolean englishWord, boolean killWord, boolean punctuation,
            LexicalFeature lexicalFeature, FeatureOfSpeech speechFeature) {

        Token token = new Token("");
        token.setIsName(name);
        token.setIsInDictionary(inDictionary);
        token.setIsLocation(location);
        token.setIsCommonFirst(commonFirst);
        token.setIsCommonLast(commonLast);
        token.setIsHonorific(honorific);
        token.setIsPrefix(prefix);
        token.setIsSuffix(suffix);
        token.setIsEnglishWord(englishWord);
        token.setIsKillWord(killWord);
        token.setIsPunctuation(punctuation);
        token.setLexicalFeature(lexicalFeature);
        token.setFeatureOfSpeech(speechFeature);
        return token;
    }

    // Test creating feature vectors with multiple tokens including all features
    @Test
    public void testCreateVectors() {
        List<Token> tokenList = new ArrayList<>();
        tokenList.add(createToken(true, true, true, true, true, true, true, true, true, true, true,
                LexicalFeature.NUMBER, FeatureOfSpeech.ARTICLES));
        tokenList.add(createToken(false, true, false, false, false, false, false, false, false, false, false,
                LexicalFeature.ALLCAPS, FeatureOfSpeech.PERIOD));

        FeatureVector featureVector = new FeatureVector();
        Instances data = featureVector.createVectors(tokenList);

        assertNotNull(data);
        assertEquals(tokenList.size(), data.numInstances());

        double[] instanceValues = data.get(0).toDoubleArray();
        assertEquals(1.0, instanceValues[0]); // isName
        assertEquals(1.0, instanceValues[1]); // isInDictionary
        assertEquals(1.0, instanceValues[2]); // isLocation
        assertEquals(1.0, instanceValues[3]); // isCommonFirst
        assertEquals(1.0, instanceValues[4]); // isCommonLast
        assertEquals(1.0, instanceValues[5]); // isHonorific
        assertEquals(1.0, instanceValues[6]); // isPrefix
        assertEquals(1.0, instanceValues[7]); // isSuffix
        assertEquals(1.0, instanceValues[8]); // isEnglishWord
        assertEquals(1.0, instanceValues[9]); // isKillWord
        assertEquals(1.0, instanceValues[10]); // isPunctuation
        assertEquals(LexicalFeature.NUMBER.ordinal(), (int) instanceValues[11]); // lexicalFeature
        assertEquals(FeatureOfSpeech.ARTICLES.ordinal(), (int) instanceValues[12]); // speechFeature
    }

    // Test creating feature vectors with a single token
    @Test
    public void testCreateVectorsWithSingleToken() {
        List<Token> singleTokenList = new ArrayList<>();
        singleTokenList.add(createToken(true, false, false, false, false, false, false, false, false, false, false,
                LexicalFeature.CAPITALIZEDWORD, FeatureOfSpeech.OTHER));

        FeatureVector featureVector = new FeatureVector();
        Instances data = featureVector.createVectors(singleTokenList);

        assertNotNull(data);
        assertEquals(1, data.numInstances());

        double[] instanceValues = data.get(0).toDoubleArray();
        assertEquals(1.0, instanceValues[0]); // isName
        assertEquals(0.0, instanceValues[1]); // isInDictionary
        assertEquals(0.0, instanceValues[2]); // isLocation
        assertEquals(0.0, instanceValues[3]); // isCommonFirst
        assertEquals(0.0, instanceValues[4]); // isCommonLast
        assertEquals(0.0, instanceValues[5]); // isHonorific
        assertEquals(0.0, instanceValues[6]); // isPrefix
        assertEquals(0.0, instanceValues[7]); // isSuffix
        assertEquals(0.0, instanceValues[8]); // isEnglishWord
        assertEquals(0.0, instanceValues[9]); // isKillWord
        assertEquals(0.0, instanceValues[10]); // isPunctuation
        assertEquals(LexicalFeature.CAPITALIZEDWORD.ordinal(), (int) instanceValues[11]); // lexicalFeature
        assertEquals(FeatureOfSpeech.OTHER.ordinal(), (int) instanceValues[12]); // speechFeature
    }

    // Test creating feature vectors with an empty token list
    @Test
    public void testCreateEmptyVectors() {
        List<Token> emptyTokenList = new ArrayList<>();
        FeatureVector featureVector = new FeatureVector();
        Instances data = featureVector.createVectors(emptyTokenList);

        assertNotNull(data);
        assertEquals(0, data.numInstances());
    }

    // Create a new FeatureVector instance
    @Test
    public void testConstructor() {

        FeatureVector featureVector = new FeatureVector();

        assertNotNull(featureVector);
        
    }

}
