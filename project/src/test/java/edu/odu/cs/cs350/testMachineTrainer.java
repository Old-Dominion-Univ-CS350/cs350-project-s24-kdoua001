package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import weka.classifiers.functions.SMO;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class testMachineTrainer {

    // Checks functionality of the trainSVM method
    public void testTrainSVM() {
        MachineTrainer svmTrainer = new MachineTrainer();

        try {
            ArrayList<Attribute> attributes = new ArrayList<>();
            attributes.add(new Attribute("attribute1"));
            attributes.add(new Attribute("class", List.of("A", "B")));

            Instances data = new Instances("TestDataset", attributes, 0);
            data.setClassIndex(data.numAttributes() - 1);

            DenseInstance instance1 = new DenseInstance(2);
            instance1.setValue(attributes.get(0), 1.0);
            instance1.setValue(attributes.get(1), "A");
            data.add(instance1);

            DenseInstance instance2 = new DenseInstance(2);
            instance2.setValue(attributes.get(0), 2.0);
            instance2.setValue(attributes.get(1), "B");
            data.add(instance2);

            if (data.numInstances() >= 5) {
                SMO svmModel = svmTrainer.trainSupportVectorMachine(data);

                assertNotNull(svmModel);

            } else {
                fail("Not enough instances in the dataset for cross-validation");
            }
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    // Checks if model is saved
    @Test
    public void testSaveModel() {
        MachineTrainer svmTrainer = new MachineTrainer();

        try {
            // Create a mock SVM model
            SMO svmModel = new SMO();

            // Define a temporary file for testing
            String tempModelFilePath = "testModel.model";

            // Save the model
            svmTrainer.saveModel(svmModel, tempModelFilePath);

            // Assert that the model file exists
            File modelFile = new File(tempModelFilePath);
            assertTrue(modelFile.exists());

            // Clean up: delete the temporary model file
            modelFile.delete();
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
