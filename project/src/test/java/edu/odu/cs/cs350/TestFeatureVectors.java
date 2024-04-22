package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import weka.core.Instances;
import weka.core.DenseInstance;

import java.util.List;
import java.util.ArrayList;

public class TestFeatureVectors {

    // Helper method to create a token with specified attributes
    private Token createToken(boolean name, boolean inDictionary, boolean location, boolean commonFirst,
                              boolean commonLast, boolean honorific, boolean prefix, boolean suffix,
                              boolean englishWord, boolean killWord, boolean punctuation,
                              LexicalFeature lexicalFeature, FeatureOfSpeech speechFeature) {
        Token token = new Token("TestToken");
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

    // Test the creation of feature vectors
    @Test
    public void testCreateVectors() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(createToken(true, true, true, false, false, false, true, false, true, false, false,
                               LexicalFeature.CAPITALIZEDWORD, FeatureOfSpeech.ARTICLES));
        tokens.add(createToken(false, false, false, true, true, true, false, true, false, true, true,
                               LexicalFeature.ALLCAPS, FeatureOfSpeech.PERIOD));

        FeatureVector featureVector = new FeatureVector();
        Instances data = featureVector.createVectors(tokens);

        assertNotNull(data, "Data should not be null");
        assertEquals(2, data.numInstances(), "Should have two instances");

        // Check the attribute values of the first token
        double[] values = data.get(0).toDoubleArray();
        assertAll("Checking all attributes of the first token",
            () -> assertEquals(1.0, values[0], "isName should be 1.0"),
            () -> assertEquals(1.0, values[1], "isInDictionary should be 1.0"),
            () -> assertEquals(1.0, values[2], "isLocation should be 1.0"),
            () -> assertEquals(0.0, values[3], "isCommonFirst should be 0.0"),
            () -> assertEquals(0.0, values[4], "isCommonLast should be 0.0"),
            () -> assertEquals(0.0, values[5], "isHonorific should be 0.0"),
            () -> assertEquals(1.0, values[6], "isPrefix should be 1.0"),
            () -> assertEquals(0.0, values[7], "isSuffix should be 0.0"),
            () -> assertEquals(1.0, values[8], "isEnglishWord should be 1.0"),
            () -> assertEquals(0.0, values[9], "isKillWord should be 0.0"),
            () -> assertEquals(0.0, values[10], "isPunctuation should be 0.0"),
            () -> assertEquals(LexicalFeature.CAPITALIZEDWORD.ordinal(), (int) values[11], "LexicalFeature should match"),
            () -> assertEquals(FeatureOfSpeech.ARTICLES.ordinal(), (int) values[12], "FeatureOfSpeech should match")
        );

    }

        // Create a new FeatureVector instance
        @Test
        public void testConstructor() {
    
            FeatureVector featureVector = new FeatureVector();
    
            assertNotNull(featureVector);
            
        }
}
