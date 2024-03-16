package edu.odu.cs.cs350;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;

public class IdentifyBlockTest {

    @Test
    public void testReadFile() {
        IdentifyBlock identifyBlock = new IdentifyBlock();
        String filePath = "src/test/data/testinput.txt"; // Replace with the actual file path
        // Read the content of the file using the method to be tested
        identifyBlock.readFile(filePath);
        // Expected content of the file
        String expectedContent = "<NER>This is a test file. It contains some text.</NER>";
        // Compare the actual content with the expected content
        assertEquals(expectedContent, identifyBlock.getDataFromFile());
    }

    @Test
    public void testFileExists() {
        IdentifyBlock identifyBlock = new IdentifyBlock();

        // Test with an existing file
        String existingFilePath = "src/test/data/testinput.txt"; // Replace with the actual file path
        assertTrue(identifyBlock.fileExists(existingFilePath));

        // Test with a non-existing file
        String nonExistingFilePath = "src/test/data/nonexistentfile.txt"; // Replace with a non-existing file path
        assertFalse(identifyBlock.fileExists(nonExistingFilePath));
    }

    @Test
    public void testExtractNerBlocks() {
        IdentifyBlock identifyBlock = new IdentifyBlock();

        // Sample input data containing NER blocks
        String inputData = "This is a <NER>sample</NER> text <NER>with</NER> NER blocks.";

        // Expected extracted NER blocks
        List<String> expectedBlocks = new ArrayList<>();
        expectedBlocks.add("<NER>sample</NER>");
        expectedBlocks.add("<NER>with</NER>");

        // Call extractNerBlocks method
        List<String> actualBlocks = identifyBlock.extractNerBlocks(inputData);

        // Compare the actual blocks with the expected blocks
        assertEquals(expectedBlocks.size(), actualBlocks.size());
        for (int i = 0; i < expectedBlocks.size(); i++) {
            assertEquals(expectedBlocks.get(i), actualBlocks.get(i));
        }
    }
}