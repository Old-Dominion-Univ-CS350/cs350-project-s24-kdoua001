package edu.odu.cs.cs350;

import weka.classifiers.functions.SMO;
import weka.core.Instances;
import java.io.*;

public class SVMtrainer {

    public SMO trainSVM(Instances data) throws Exception {
        // Create SMO (Sequential Minimal Optimization) classifier
        SMO svm = new SMO();

        // Set options for SVM (if needed)
        String[] options = { "-N", "0", "-V", "-1" };
        svm.setOptions(options);

        // Build the classifier
        svm.buildClassifier(data);

        return svm;
    }

    public void saveModel(SMO svm, String modelFile) throws Exception {
        // Save the trained model to a file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(modelFile));
        oos.writeObject(svm);
        oos.close();
    }

}
