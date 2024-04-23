package edu.odu.cs.cs350;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HonorificPrefixSuffixSysTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void systemTest() throws Exception {
        String expected = "<NER> <PER> Dr.Doe</PER> and <PER> Mr.Livermore </PER>  Laborator </NER> <NER> <PER> Michael Jackson Jr </PER> is cool </NER>";

        // Read the content of the input file
        String inputFileContent = new String(
                Files.readAllBytes(Paths.get("src/systest/data/HonorificSuffixPrefix.txt")),
                StandardCharsets.UTF_8);

        // Redirect System.in to read from the input file content
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(inputFileContent.getBytes(StandardCharsets.UTF_8)));

        try {
            // Call the main method
            Extractor.main(new String[0]);
        } catch (Exception e) {
            System.out.println("Exception thrown: " + e.getMessage());
        } finally {
            // Restore the original System.in
            System.setIn(originalIn);
        }
        String output = outContent.toString();
        assertEquals(expected.trim(), output.trim());

    }

}