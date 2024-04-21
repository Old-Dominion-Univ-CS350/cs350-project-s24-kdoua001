package edu.odu.cs.cs350;
import weka.classifiers.Classifier;
import weka.core.SerializationHelper;
import java.io.InputStream;

public class ModelLoader {

    public static Classifier loadModelFromJar() throws Exception {
        try (InputStream modelStream = ModelLoader.class.getResourceAsStream("/model/smo.model")) {
            if (modelStream == null) {
                throw new Exception("Model file not found in JAR.");
            }
            return (Classifier) SerializationHelper.read(modelStream);
        }
    }
}
