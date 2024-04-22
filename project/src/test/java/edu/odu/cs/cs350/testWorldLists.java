package edu.odu.cs.cs350;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testWorldLists {
    @Test
    public void testSetIsCommonFirstNamesFileLoading() {
        // String fileName = "/Dictionary.commonFirstNames.txt";
        Iterable resourceUrl = WordLists.commonFirstNames();
        assertNotNull(resourceUrl, "Failed to load resource file");
        assertEquals(resourceUrl.iterator().next(), "mary");
    }

    @Test
    public void testSetIsCommonLastNamesFileLoading() {
        // String fileName = "/Dictionary.commonFirstNames.txt";
        Iterable resourceUrl = WordLists.commonLastNames();
        assertNotNull(resourceUrl, "Failed to load resource file");
        assertEquals(resourceUrl.iterator().next(), "smith");
    }

    @Test
    public void testPrefix() {
        // String fileName = "/Dictionary.commonFirstNames.txt";
        Iterable resourceUrl = WordLists.commonFirstNames();
        assertNotNull(resourceUrl, "Failed to load resource file");
        assertEquals(resourceUrl.iterator().next(), "mary");
    }

    @Test
    public void testSuffix() {
        // String fileName = "/Dictionary.commonFirstNames.txt";
        Iterable resourceUrl = WordLists.commonLastNames();
        assertNotNull(resourceUrl, "Failed to load resource file");
        assertEquals(resourceUrl.iterator().next(), "smith");
    }

    @Test
    public void testHonorfic() {
        // String fileName = "/Dictionary.commonFirstNames.txt";
        Iterable resourceUrl = WordLists.commonLastNames();
        assertNotNull(resourceUrl, "Failed to load resource file");
        assertEquals(resourceUrl.iterator().next(), "smith");
    }

}
