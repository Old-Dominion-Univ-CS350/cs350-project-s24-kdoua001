package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import weka.core.Instances;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.List;

public class testFeatureVectors {

    @Test
    public void testCreateVectors() {
        // Create a list of sample tokens
        List<Token> tokenList = new ArrayList<>();
        tokenList.add(createToken(true, true, true, true, true, true, true, true, LexicalFeature.NUMBER,
                FeatureOfSpeech.ARTICLES));
        tokenList.add(createToken(false, true, false, false, false, false, false, false, LexicalFeature.ALLCAPS,
                FeatureOfSpeech.PERIOD));

        // Create the FeatureVector instance
        FeatureVector featureVector = new FeatureVector();
        Instances data = featureVector.createVectors(tokenList);

        // Assertions
        assertNotNull(data);
        assertEquals(tokenList.size(), data.numInstances());

        // Check attribute values for the first instance
        double[] instanceValues = data.get(0).toDoubleArray();
        assertEquals(1.0, instanceValues[0]); // isName
        assertEquals(1.0, instanceValues[1]); // isInDictionary
        assertEquals(1.0, instanceValues[2]); // isLocation
        assertEquals(1.0, instanceValues[3]); // isCommonFirst
        assertEquals(1.0, instanceValues[4]); // isCommonLast
        assertEquals(1.0, instanceValues[5]); // isHonorific
        assertEquals(1.0, instanceValues[6]); // isKillWord
        assertEquals(1.0, instanceValues[7]); // isPunctuation
        assertEquals(LexicalFeature.NUMBER.ordinal(), (int) instanceValues[8]); // lexicalFeature
        assertEquals(FeatureOfSpeech.ARTICLES.ordinal(), (int) instanceValues[9]); // speechFeature

        // Check attribute values for the second instance
        instanceValues = data.get(1).toDoubleArray();
        assertEquals(0.0, instanceValues[0]); // isName
        assertEquals(1.0, instanceValues[1]); // isInDictionary
        assertEquals(0.0, instanceValues[2]); // isLocation
        assertEquals(0.0, instanceValues[3]); // isCommonFirst
        assertEquals(0.0, instanceValues[4]); // isCommonLast
        assertEquals(0.0, instanceValues[5]); // isHonorific
        assertEquals(0.0, instanceValues[6]); // isKillWord
        assertEquals(0.0, instanceValues[7]); // isPunctuation
        assertEquals(LexicalFeature.ALLCAPS.ordinal(), (int) instanceValues[8]); // lexicalFeature
        assertEquals(FeatureOfSpeech.PERIOD.ordinal(), (int) instanceValues[9]); // speechFeature
    }

    // Method to create a test Token object
    private Token createToken(boolean name, boolean inDictionary, boolean location, boolean commonFirst,
            boolean commonLast, boolean honorific, boolean killWord, boolean punctuation,
            LexicalFeature lexicalFeature, FeatureOfSpeech speechFeature) {
        Token token = new Token("");
        token.setIsName(name);
        token.setIsInDictionary(inDictionary);
        token.setIsLocation(location);
        token.setIsCommonFirst(commonFirst);
        token.setIsCommonLast(commonLast);
        token.setIsHonorific(honorific);
        token.setIsKillWord(killWord);
        token.setIsPunctuation(punctuation);
        token.setLexicalFeature(lexicalFeature);
        token.setFeatureOfSpeech(speechFeature);
        return token;
    }

}
