package edu.odu.cs.cs350;

import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import weka.classifiers.functions.SMO;
import weka.*;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.knowledgeflow.steps.Block;

/**
 * Main class for calling other classes and functions.
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
     * Main function.
     * 
     * @param args args
     * @throws Exception exception
     */
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new InputStreamReader(System.in, "UTF-8"));
        scanner.useDelimiter("\\A");
        String contentOfFile = scanner.next();
        scanner.close();

        Document Document = new Document(contentOfFile);

        // Output the extracted blocks
        // System.out.println("Extracted Blocks:");
        Document.printDocumentWithPersonalNamesTag();
    }
    /*
     * try {
     * // Load your data from wherever it is stored
     * String dataFilePath = "project/src/main/data/trainingData.txt";
     * Scanner dataScanner = new Scanner(new File(dataFilePath));
     * StringBuilder dataBuilder = new StringBuilder();
     * while (dataScanner.hasNextLine()) {
     * dataBuilder.append(dataScanner.nextLine()).append("\n");
     * }
     * String data = dataBuilder.toString();
     * dataScanner.close();
     * 
     * // Create a Document object
     * Document document = new Document(data);
     * 
     * // Get the list of text blocks from the document
     * List<TextBlock> blocks = document.getBlocks();
     * 
     * // Create a FeatureVector object
     * FeatureVector featureVector = new FeatureVector();
     * 
     * // Create an empty list to store all tokens
     * List<Token> allTokens = new ArrayList<>();
     * 
     * // Iterate over each text block
     * for (TextBlock block : blocks) {
     * // Get the list of tokens from the current text block
     * List<Token> tokens = block.getTokensList();
     * // Add these tokens to the list of all tokens
     * allTokens.addAll(tokens);
     * }
     * 
     * // Create feature vectors from all tokens
     * Instances instances = featureVector.createVectors(allTokens);
     * 
     * // Train the SVM classifier
     * SVMtrainer svmtrainer = new SVMtrainer();
     * SMO svm = svmtrainer.trainSVM(instances);
     * 
     * // Save the trained model
     * String modelFilePath = "project/src/resources/smo.model";
     * svmtrainer.saveModel(svm, modelFilePath);
     * 
     * System.out.println("Training and saving the model completed successfully.");
     * } catch (Exception e) {
     * System.err.println("Error: " + e.getMessage());
     * e.printStackTrace();
     * }
     * }
     */ 
}
