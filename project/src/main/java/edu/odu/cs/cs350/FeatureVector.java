package edu.odu.cs.cs350;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import java.util.List;
import java.util.ArrayList;

/**
 * This class creates feature vectors based on token attributes/other 
 * features using Weka's Instances class. 
 */
public class FeatureVector {

    /**
     * Method to create feature vectors based on Token attributes
     * @param tokenList tokenList
     * @return data
     */
    public Instances createVectors(List<Token> tokenList) {
        ArrayList<Attribute> attributes = new ArrayList<>();

        // add boolean attributes from Token class
        attributes.add(new Attribute("isName"));
        attributes.add(new Attribute("isInDictionary"));
        attributes.add(new Attribute("isLocation"));
        attributes.add(new Attribute("isCommonFirst"));
        attributes.add(new Attribute("isCommonLast"));
        attributes.add(new Attribute("isHonorific"));
        attributes.add(new Attribute("isKillWord"));
        attributes.add(new Attribute("isPunctuation"));

        // Add lexical feature attribute
        ArrayList<String> lexicalFeatureValues = new ArrayList<>();
        lexicalFeatureValues.add("NUMBER");
        lexicalFeatureValues.add("SINGLECAPLETTER");
        lexicalFeatureValues.add("CAPITALIZEDWORD");
        lexicalFeatureValues.add("ALLCAPS");
        lexicalFeatureValues.add("PUNCTUATION");
        lexicalFeatureValues.add("NEWLINE");
        lexicalFeatureValues.add("NULLFEATURE");
        lexicalFeatureValues.add("OTHER");
        attributes.add(new Attribute("lexicalFeature", lexicalFeatureValues));

        // create instances object with the defined attributes
        Instances data = new Instances("FeatureVectors", attributes, tokenList.size());

        for (Token token : tokenList) {
            double[] values = new double[data.numAttributes()];

            // Set attribute values based on Token attributes
            values[0] = token.isName() ? 1.0 : 0.0;
            values[1] = token.isInDictionary() ? 1.0 : 0.0;
            values[2] = token.isLocation() ? 1.0 : 0.0;
            values[3] = token.isCommonFirst() ? 1.0 : 0.0;
            values[4] = token.isCommonLast() ? 1.0 : 0.0;
            values[5] = token.isHonorific() ? 1.0 : 0.0;
            values[6] = token.isKillWord() ? 1.0 : 0.0;
            values[7] = token.isPunctuation() ? 1.0 : 0.0;

            // Set lexical feature value
            values[8] = token.getLexicalFeature().ordinal();

            // Create DenseInstance and add to Instances object
            data.add(new DenseInstance(1.0, values));
        }

        return data;
    }

}
