package edu.odu.cs.cs350;

import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import weka.classifiers.functions.SMO;
import weka.*;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.knowledgeflow.steps.Block;

/**
 * Main class for calling other classes and functions
 */
public class Extractor {
    /*
     * public static void main(String[] args) throws Exception {
     * Scanner scanner = new Scanner(System.in);
     * 
     * System.out.print("Enter the path to the input file: ");
     * String inputFile = scanner.nextLine();
     * 
     * // Check if the input file exists
     * File file = new File(inputFile);
     * if (!file.exists()) {
     * System.out.println("Error: Input file not found.");
     * return;
     * }
     * 
     * System.out.println("Input file: " + inputFile);
     * 
     * scanner.close();
     * 
     * }
     */

    /**
     * Main function
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new InputStreamReader(System.in, "UTF-8"));
        scanner.useDelimiter("\\A");
        String contentOfFile = scanner.next();
        scanner.close();

        Document Document = new Document(contentOfFile);
        List<TextBlock> blocks = Document.getBlocks();

        // Create a FeatureVector object
        FeatureVector featureVector = new FeatureVector();

        // Create a SVMtrainer object
        SVMtrainer svmTrainer = new SVMtrainer();

        // Create an empty Instances object to hold the training data

        Instances trainingData = null;

        for (TextBlock block : blocks) {
            // Create TextBlock object for each block
            String BlockString = block.toString();
            TextBlock TextBlock = new TextBlock(BlockString);
            List<Token> Tokens = TextBlock.createTokens(BlockString);

            // Create feature vectors for the current block's tokens
            Instances blockData = featureVector.createVectors(Tokens);

            // If trainingData is null, initialize it with the first blockData
            if (trainingData == null) {
                trainingData = new Instances(blockData, 0);
            } else {
                // Merge the current blockData with trainingData
                for (int i = 0; i < blockData.numInstances(); i++) {
                    trainingData.add(blockData.instance(i));
                }
            }
        }

        // Train the SVM model
        SMO trainedModel = svmTrainer.trainSVM(trainingData);

        // Save the trained model to a file
        String modelFile = "trained_model.model";
        svmTrainer.saveModel(trainedModel, modelFile);
        System.out.println("SVM model trained and saved successfully.");

    }
}
