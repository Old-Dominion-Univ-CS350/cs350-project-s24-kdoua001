
package edu.odu.cs.cs350;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public final class WordLists {
    private static String packagePath = "project/src/resources/extract/edu/odu/cs/extract/wordlists";

    private WordLists() {
    }

    public static Iterable<String> englishDictionary() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.english.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> stoplist() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Stoplist.english.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> citiesAndStatesUS() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.citiesStates.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> countriesAndTerritories() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.territories.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> places() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.placenames.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> firstNames() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.firstNames.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> lastNames() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.lastNames.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> commonFirstNames() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.commonFirstNames.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> commonLastNames() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.commonLastNames.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> honorifics() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.honorifics.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> lastNamePrefixes() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.prefixes.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> lastNameSuffixes() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.suffixes.txt");
        return new StreamIterable(list);
    }

    public static Iterable<String> nonPersonalIdentifierCues() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.nonPersonalProperNames.txt");
        return new StreamIterable(list);
    }
}

// Nested class definition for StreamIterable
class StreamIterable implements Iterable<String> {
    private InputStream inputStream;

    public StreamIterable(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Iterator<String> iterator() {
        Scanner scanner = new Scanner(inputStream);
        try {
            return scanner.useDelimiter("\\A").tokens().iterator();
        } finally {
            scanner.close();
        }
    }
}