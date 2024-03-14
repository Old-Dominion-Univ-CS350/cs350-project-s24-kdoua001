package edu.odu.cs.cs350;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class IdentifyBlockTest {

    @Test
    public void testReadFile() {
        IdentifyBlock identifyBlock = new IdentifyBlock();
        String filePath = "project/src/test/data/testinput.txt"; // Replace with the actual file path
        // Read the content of the file using the method to be tested
        identifyBlock.readFile(filePath);
        // Expected content of the file
        String expectedContent = "<NER>This is a test file. It contains some text.</NER>";
        // Compare the actual content with the expected content
        assertEquals(expectedContent, identifyBlock.getDataFromFile());
    }
}