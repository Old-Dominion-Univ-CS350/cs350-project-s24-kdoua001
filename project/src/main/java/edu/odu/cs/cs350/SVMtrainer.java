package edu.odu.cs.cs350;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.RBFKernel;
import weka.core.Instance;
import weka.core.Instances;
import java.io.*;
import java.util.List;

/**
 * This class provides methods for training and saving Support Vector Machine
 * (SVM) models using WEKA.
 */
public class SVMtrainer {

    /**
     * Trains a Support Vector Machine (SVM) model.
     *
     * @param data The dataset to be used for training.
     * @return The trained SVM model.
     * @throws Exception If an error occurs during training.
     */
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

        // Train it
        svm.buildClassifier(data);

        return svm;
    }

    /**
     * Saves the trained SVM model to a file.
     *
     * @param svm       The trained SVM model to be saved.
     * @param modelFile The file path where the model will be saved.
     * @throws Exception If an error occurs during model saving.
     */
    public void saveModel(SMO svm, String modelFile) throws Exception {
        // Save the trained model to a file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(modelFile));
        oos.writeObject(svm);
        oos.close();
    }

}
