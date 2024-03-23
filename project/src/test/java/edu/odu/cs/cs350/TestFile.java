package edu.odu.cs.cs350;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class TestFile {

    @Test
    public void testDefaultConstructor() {
        File file = new File();
        assertEquals("", file.getDataFromFile());
        assertEquals(new ArrayList<>(), file.getBlocks());
    }

    @Test
    public void testParameterizedConstructor() {
        String block = "<NER>this is for testing</NER>";
        File testInput = new File(block);

        assertEquals("<NER>this is for testing</NER>", testInput.getDataFromFile());

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        testInput.output();

        assertEquals(block, outputStreamCaptor.toString().trim());

    }

    public void testReadInput() throws Exception {
        // Prepare input data
        String inputData = "Test input data";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream); // Redirect System.in to our input stream

        File identifyBlock = new File();
        identifyBlock.readInput(); // Call the method to read input

        // Assert that dataFromFile is equal to inputData
        assertEquals(inputData, identifyBlock.getDataFromFile());

        // Clean up: Restore System.in
        System.setIn(System.in);
    }

    @Test
    public void testExtractNerBlocks() {
        File identifyBlock = new File();

        // Sample input data containing NER blocks
        String inputData = "This is a <NER>sample</NER> text <NER>with</NER> NER blocks.";

        // Expected extracted NER blocks
        List<String> expectedBlocks = new ArrayList<>();
        expectedBlocks.add("<NER>sample</NER>");
        expectedBlocks.add("<NER>with</NER>");

        // Call extractNerBlocks method
        List<String> actualBlocks = File.extractBlocks(inputData);

        // Compare the actual blocks with the expected blocks
        assertEquals(expectedBlocks.size(), actualBlocks.size());
        for (int i = 0; i < expectedBlocks.size(); i++) {
            assertEquals(expectedBlocks.get(i), actualBlocks.get(i));
        }
    }

}
