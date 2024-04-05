package edu.odu.cs.cs350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.netlib.util.booleanW; 

public class Tagger {

    Tagger() {}

    public boolean IsArticle(String word) {
        String[] articles = {"a", "an", "the"};
        return Arrays.asList(articles).contains(word.toLowerCase());
    }

    public boolean IsConjunction(String word) {
        String[] articles = {"and"};
        return Arrays.asList(articles).contains(word.toLowerCase());
    }

    public boolean IsPeriod(String word) {
        return "." == word;
    }

    public boolean IsComma(String word) {
        return "," == word;
    }

    public boolean IsHyphen(String word) {
        return "-" == word;
    }
}