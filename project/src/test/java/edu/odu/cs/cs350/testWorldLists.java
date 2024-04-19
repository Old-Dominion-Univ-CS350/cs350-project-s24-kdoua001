package edu.odu.cs.cs350;

import java.net.URL;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testWorldLists {
    @Test
    public void testSetIsCommonFirstNamesFileLoading() {
        String fileName = "project/src/resources/extract/edu/odu/cs/extract/wordlists/Dictionary.commonFirstNames.txt";
        URL resourceUrl = WordLists.class.getResource(fileName);
        // assertNotNull(resourceUrl, "Failed to load resource file: " + fileName);

    }
}
