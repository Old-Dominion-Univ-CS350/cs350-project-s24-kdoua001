package edu.odu.cs.cs350;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.RBFKernel;
import weka.core.Instances;
import java.io.*;

public class SVMtrainer {

    public SMO trainSVM(Instances data) throws Exception {
        String[] options = { "-N", "0", "-V", "-1" };

        // Tuning hyperparameters gamma and C
        double bestGamma = 0.01;
        double bestC = 8.0;
        double bestResult = 0.0;

        for (double gamma = 0.01; gamma <= 0.1; gamma += 0.09 / 7) {
            for (double c = 8.0; c <= 15.0; c += 7 / 7) {
                SMO svm = new SMO();
                svm.setOptions(options);
                svm.setKernel(new RBFKernel(data, 25007, gamma));
                svm.setC(c);

                Evaluation eval = new Evaluation(data);
                eval.crossValidateModel(svm, data, 5, new java.util.Random(1));
                double score = eval.pctCorrect();

                if (score > bestResult) {
                    bestResult = score;
                    bestGamma = gamma;
                    bestC = c;
                }
            }
        }

        // Create SMO (Sequential Minimal Optimization) classifier with best parameters
        SMO svm = new SMO();
        svm.setOptions(options);
        svm.setKernel(new RBFKernel(data, 25007, bestGamma));
        svm.setC(bestC);

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
