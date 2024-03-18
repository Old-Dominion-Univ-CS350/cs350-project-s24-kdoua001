package edu.odu.cs.cs350;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;


public class TestOutput {

    @Test
    public void testdefaultConstructor()
    {
        OutputInfo data = new OutputInfo();
        assertEquals("", data.getDataFromTextBlocks());
    }

    @Test
    public void testParameterizedConstructor()
    {
        String data = "<NER> this is for testing </NER>";
        OutputInfo testData = new OutputInfo(data);
        assertEquals("<NER> this is for testing </NER>", testData.getDataFromTextBlocks());
    }
}
