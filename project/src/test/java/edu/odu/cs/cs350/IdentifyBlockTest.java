package edu.odu.cs.cs350;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class IdentifyBlockTest {


    @Test
    public void testDefaultConstructor() {
        IdentifyBlock block = new IdentifyBlock();
        assertEquals("", block.getDataFromFile());
    }
 
    @Test
    public void testParameterizedConstructor() {
        String block = "<NER> this is for testing </NER>";
        IdentifyBlock testInput = new IdentifyBlock(block);
 
        assertEquals("<NER> this is for testing </NER>", testInput.getDataFromFile());
    }


    public void testReadInput() throws Exception {
        // Prepare input data
        String inputData = "Test input data";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream); // Redirect System.in to our input stream
 
        IdentifyBlock identifyBlock = new IdentifyBlock();
        identifyBlock.readInput(); // Call the method to read input
 
        // Assert that dataFromFile is equal to inputData
        assertEquals(inputData, identifyBlock.getDataFromFile());
 
        // Clean up: Restore System.in
        System.setIn(System.in);
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