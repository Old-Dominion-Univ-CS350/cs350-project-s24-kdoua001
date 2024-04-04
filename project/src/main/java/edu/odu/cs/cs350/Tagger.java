package edu.odu.cs.cs350;

import java.util.List;

/**
 * The Tagger class is responsible for tagging tokens in a TextBlock with their
 * respective part-of-speech (POS) tags and adjusting the probability of being a
 * personal name (PER) based on the POS tag.
 */
public class Tagger {
    //private POSTagger posTagger; // Use your custom POSTagger implementation
    //private Tokenizer tokenizer; // Use your custom Tokenizer implementation

    /**
     * Constructor that initializes the POS tagger and tokenizer.
     *
     * @param posTagger The custom POS tagger implementation
     * @param tokenizer The custom tokenizer implementation
     */
    /* 
    public Tagger(POSTagger posTagger, Tokenizer tokenizer) {
        this.posTagger = posTagger;
        this.tokenizer = tokenizer;
    }
    */

    /**
     * Tags the tokens in the given TextBlock with their POS tags and adjusts the
     * probability of being a personal name (<PER>) based on the POS tag.
     *
     * @param textBlock The TextBlock to be tagged
     */
    /* 
    public void tagTextBlock(TextBlock textBlock) {
        List<Token> tokens = textBlock.getTokensList();
        String tokenizedText = tokenizer.tokenize(textBlock.toString());
        String[] tokenizedSentence = tokenizedText.split(" ");
        String[] tags = posTagger.tagSentence(tokenizedSentence);

        // Associate POS tags with tokens and adjust PER probability
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            String tag = tags[i];
            token.setPosTag(tag);

            // Adjust the probability of being a PER based on POS tag
            if (tag.startsWith("NNP")) {
                // Increase the probability if it's a proper noun
                token.increasePERProbability(0.5);
            } else if (tag.startsWith("NN")) {
                // Decrease the probability if it's a common noun
                token.decreasePERProbability(0.2);
            }
            // You can add more conditions for other POS tags as needed
        }
    }
    */
}