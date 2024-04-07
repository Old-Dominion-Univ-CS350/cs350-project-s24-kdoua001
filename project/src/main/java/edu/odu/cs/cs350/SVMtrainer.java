package edu.odu.cs.cs350;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.RBFKernel;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.WekaPackageClassLoaderManager;

import java.io.*;
import java.lang.reflect.Method;
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
    public SMO trainSupportVectorMachine(Instances data) throws Exception {

        data.setClassIndex(data.numAttributes() - 1);
        String[] options = { "-N", "0", "-V", "-1" };

        // Tuning hyperparameters gamma and C
        /*
         * double bestGamma = 0.01;
         * double bestC = 8.0;
         * double bestResult = 0.0;
         * 
         * for (double gamma = 0.01; gamma <= 0.1; gamma += 0.09 / 7) {
         * for (double c = 8.0; c <= 15.0; c += 7 / 7) {
         * SMO svm = new SMO();
         * svm.setOptions(options);
         * svm.setKernel(new RBFKernel(data, 25007, gamma));
         * svm.setC(c);
         * 
         * Evaluation eval = new Evaluation(data);
         * eval.crossValidateModel(svm, data, 5, new java.util.Random(1));
         * double score = eval.pctCorrect();
         * 
         * if (score > bestResult) {
         * bestResult = score;
         * bestGamma = gamma;
         * bestC = c;
         * }
         * }
         * }
         */
        // Create SMO (Sequential Minimal Optimization) classifier with best parameters
        SMO SupportVectorMachine = new SMO();
        SupportVectorMachine.setOptions(options);
        // svm.setKernel(new RBFKernel(data, 25007, bestGamma));
        // svm.setC(bestC);

        // Train it
        SupportVectorMachine.buildClassifier(data);

        return SupportVectorMachine;
    }

    /**
     * Saves the trained SVM model to a file.
     *
     * @param SupportVectorMachine The trained SVM model to be saved.
     * @param modelFile            The file path where the model will be saved.
     * @throws Exception If an error occurs during model saving.
     */
    public void saveModel(SMO SupportVectorMachine, String modelFile) throws Exception {
        // Save the trained model to a file
        ObjectOutputStream Output = new ObjectOutputStream(new FileOutputStream(modelFile));
        Output.writeObject(SupportVectorMachine);
        Output.close();
    }

}
