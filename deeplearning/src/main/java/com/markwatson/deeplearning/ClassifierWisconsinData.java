package com.markwatson.deeplearning;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.learning.config.Sgd;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Train a feed forward classifier network on the University of Wisconsin Cancer Data Set.
 */
public class ClassifierWisconsinData {

  private static final Logger log = LoggerFactory.getLogger(ClassifierWisconsinData.class);

  public static void main(String[] args) throws Exception {
    int numHidden = 3;
    int numOutputs = 1;
    int batchSize = 64;

    int seed = 33117;

    int numInputs = 9;
    int labelIndex = 9;
    int numClasses = 2;

    RecordReader recordReader = new CSVRecordReader();
    recordReader.initialize(new FileSplit(new File("data/","training.csv")));
    DataSetIterator trainIter =
        new RecordReaderDataSetIterator(recordReader,batchSize,labelIndex,numClasses);

    RecordReader recordReaderTest = new CSVRecordReader();
    recordReaderTest.initialize(
        new FileSplit(new File("data/","testing.csv")));
    DataSetIterator testIter =
        new RecordReaderDataSetIterator(recordReaderTest,batchSize,labelIndex,numClasses);

    MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
        .seed(seed) //use the same random seed
        .activation(Activation.TANH)
        .weightInit(WeightInit.XAVIER)
        .updater(new Sgd(0.1))
        .l2(1e-4)
        .list()
        .layer(0,
            new DenseLayer.Builder()
                .nIn(numInputs)
                .nOut(numHidden)
                .build()
        )
        .layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.MCXENT)
            .nIn(numHidden)
            .nOut(numClasses)
            .activation(Activation.SOFTMAX)
            .build()
        )
        .build();
    MultiLayerNetwork model = new MultiLayerNetwork(conf);
    model.init();
    model.setListeners(new ScoreIterationListener(100));
    model.fit( trainIter, 10 );

    Evaluation eval = new Evaluation(numOutputs);
    while (testIter.hasNext()) {
      DataSet ds = testIter.next();
      INDArray features = ds.getFeatures();
      System.out.println("Input features: " + features);
      INDArray labels = ds.getLabels();
      INDArray predicted = model.output(features,false);
      System.out.println("Predicted output: "+ predicted);
      System.out.println("Desired output: "+ labels);
      eval.eval(labels, predicted);
      System.out.println();
    }
    System.out.println("Evaluate model....");
    System.out.println(eval.stats());
  }
}
