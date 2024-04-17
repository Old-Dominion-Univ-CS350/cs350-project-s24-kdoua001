
package edu.odu.cs.cs350;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class provides utility methods to access various word lists.
 */
public final class WordLists {
    private static String packagePath = "project/src/resources/extract/edu/odu/cs/extract/wordlists";

    private WordLists() {
    }

    /**
     * Retrieves an iterable for the English dictionary word list.
     * 
     * @return An iterable for the English dictionary word list.
     */
    public static Iterable<String> englishDictionary() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.english.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the stoplist word list.
     * 
     * @return An iterable for the stoplist word list.
     */
    public static Iterable<String> stoplist() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Stoplist.english.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of cities and states in the US.
     * 
     * @return An iterable for the list of cities and states in the US.
     */
    public static Iterable<String> citiesAndStatesUS() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.citiesStates.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of countries and territories.
     * 
     * @return An iterable for the list of countries and territories.
     */
    public static Iterable<String> countriesAndTerritories() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.territories.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of places.
     * 
     * @return An iterable for the list of places.
     */
    public static Iterable<String> places() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.placenames.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of first names.
     * 
     * @return An iterable for the list of first names.
     */
    public static Iterable<String> firstNames() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.firstNames.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of last names.
     * 
     * @return An iterable for the list of last names.
     */
    public static Iterable<String> lastNames() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.lastNames.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of common first names.
     * 
     * @return An iterable for the list of common first names.
     */
    public static Iterable<String> commonFirstNames() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.commonFirstNames.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of common last names.
     * 
     * @return An iterable for the list of common last names.
     */
    public static Iterable<String> commonLastNames() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.commonLastNames.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of honorifics.
     * 
     * @return An iterable for the list of honorifics.
     */
    public static Iterable<String> honorifics() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.honorifics.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of last name prefixes.
     * 
     * @return An iterable for the list of last name prefixes.
     */
    public static Iterable<String> lastNamePrefixes() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.prefixes.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of last name suffixes.
     * 
     * @return An iterable for the list of last name suffixes.
     */
    public static Iterable<String> lastNameSuffixes() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.suffixes.txt");
        return new StreamIterable(list);
    }

    /**
     * Retrieves an iterable for the list of non-personal identifier cues.
     * 
     * @return An iterable for the list of non-personal identifier cues.
     */
    public static Iterable<String> nonPersonalIdentifierCues() {
        InputStream list = WordLists.class.getResourceAsStream(packagePath + "Dictionary.nonPersonalProperNames.txt");
        return new StreamIterable(list);
    }

}

/**
 * This class provides an iterable for an input stream of strings.
 */
class StreamIterable implements Iterable<String> {
    private InputStream inputStream;

    /**
     * Constructs a StreamIterable object with the specified input stream.
     * 
     * @param inputStream The input stream containing strings.
     */
    public StreamIterable(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Returns an iterator over the elements in the input stream.
     * 
     * @return An iterator.
     */
    public Iterator<String> iterator() {
        Scanner scanner = new Scanner(inputStream);
        try {
            return scanner.useDelimiter("\\A").tokens().iterator();
        } finally {
            scanner.close();
        }
    }
}