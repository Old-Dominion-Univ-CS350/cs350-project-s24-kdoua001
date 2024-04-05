package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import weka.core.Instances;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class TestTagger {


    @Test
    public void testIsArticle() {
        //Create TokenList - This Will Be Taken From a TextBlock
        Token testToken0 = new Token("a");
        Token testToken1 = new Token("an");
        Token testToken2 = new Token("the");


        Tagger tagger = new Tagger();
        assertTrue(tagger.IsArticle(testToken0));
    }
    
}
