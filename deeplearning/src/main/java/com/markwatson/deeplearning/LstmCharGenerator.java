/* *****************************************************************************
 * Copyright (c) 2020 Konduit K.K.
 * Copyright (c) 2015-2019 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package com.markwatson.deeplearning;

/**
 * This file was cloned from the LSTM GenerateTxtModel by Alex Black.
 *
 * I modified this example to use the CSV Wisconsin cancer data instead of the
 * complete works of Shakespeare.
 *
 */

import org.apache.commons.lang3.StringUtils;
import org.deeplearning4j.nn.conf.BackpropType;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.LSTM;
import org.deeplearning4j.nn.conf.layers.RnnOutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.conditions.Conditions;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.indexing.BooleanIndexing;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.nd4j.linalg.dataset.DataSet;

// LSTM utility written by Alex Black:
import org.deeplearning4j.examples.advanced.modelling.charmodelling.utils.CharacterIterator;

import java.io.IOException;
import java.util.Random;
import java.nio.charset.StandardCharsets;

public class LstmCharGenerator {
  public static void main(String[] args ) throws Exception {
    int lstmLayerSize = 400;	//Number of units in each LSTM layer
    int miniBatchSize = 16;		//Size of mini batch to use when  training
    int exampleLength = 250;	//Length of each training example sequence to use. This could certainly be increased
    int tbpttLength = 40;     //Length for truncated backpropagation through time. i.e., do parameter updates ever 50 characters
    int numEpochs = 100;		  //Total number of training epochs
    int generateSamplesEveryNMinibatches = 5;  //How frequently to generate samples from the network
    int nSamplesToGenerate = 20;					//Number of samples to generate after each training epoch
    int nCharactersToSample = 300;				//Length of each sample to generate
    String generationInitialization = null;		//Optional character initialization; a random character is used if null
    // Above is Used to 'prime' the LSTM with a character sequence to continue/complete.
    // Initialization characters must all be in CharacterIterator.getMinimalCharacterSet() by default
    Random rng = new Random(12345);

    //Get a DataSetIterator that handles vectorization of text into something we can use to train
    // our LSTM network.
    CharacterIterator iter = getWisconsinDataIterator(miniBatchSize,exampleLength);
    int nOut = iter.totalOutcomes();

    //Set up network configuration:
    MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
        .seed(12345)
        .l2(0.0001)
        .weightInit(WeightInit.XAVIER)
        .updater(new Adam(0.005))
        .list()
        .layer(new LSTM.Builder().nIn(iter.inputColumns()).nOut(lstmLayerSize)
            .activation(Activation.TANH).build())
        .layer(new LSTM.Builder().nIn(lstmLayerSize).nOut(lstmLayerSize)
            .activation(Activation.TANH).build())
        .layer(new RnnOutputLayer.Builder(LossFunctions.LossFunction.MCXENT).activation(Activation.SOFTMAX)        //MCXENT + softmax for classification
            .nIn(lstmLayerSize).nOut(nOut).build())
        .backpropType(BackpropType.TruncatedBPTT).tBPTTForwardLength(tbpttLength).tBPTTBackwardLength(tbpttLength)
        .build();

    MultiLayerNetwork net = new MultiLayerNetwork(conf);
    net.init();
    net.setListeners(new ScoreIterationListener(1));

    //Print the  number of parameters in the network (and for each layer)
    System.out.println(net.summary());

    //Do training, and then generate and print samples from network
    int miniBatchNumber = 0;
    for( int i=0; i<numEpochs; i++ ){
      while(iter.hasNext()){
        DataSet ds = iter.next();
        net.fit(ds);
        if(++miniBatchNumber % generateSamplesEveryNMinibatches == 0){
          System.out.println("--------------------");
          System.out.println("Completed " + miniBatchNumber + " minibatches of size " + miniBatchSize + "x" + exampleLength + " characters" );
          System.out.println("Sampling characters from network given initialization \"" + (generationInitialization == null ? "" : generationInitialization) + "\"");
          String[] samples = sampleCharactersFromNetwork(generationInitialization,net,iter,rng,nCharactersToSample,nSamplesToGenerate);
          System.out.println("----- Samples -----");
          for( int j=0; j<samples.length; j++ ) {
            // discard samples that don't contain 10 numbers per line
            String [] lines = samples[j].split("\n");
            for (int k=0; k<lines.length; k++) {
              if (StringUtils.countMatches(lines[k], ",") == 9 &&
                  lines[k].split(",").length == 10) {
                System.out.println(lines[k]);
              }
            }
          }
        }
      }

      iter.reset();	//Reset iterator for another epoch
    }

    System.out.println("\n\nExample complete");
  }

  static CharacterIterator getWisconsinDataIterator(int miniBatchSize, int sequenceLength) throws IOException {
    String fileLocation = "data/training.csv";
    char[] validCharacters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ',', '\n'};
    System.out.println("++ valid characters in training data: ");
    for (char ch : validCharacters) System.out.print(" " + ch);
    System.out.println();
    return new CharacterIterator(fileLocation, StandardCharsets.UTF_8,
        miniBatchSize, sequenceLength, validCharacters, new Random(12345));
  }

  /** Generate a sample from the network, given an (optional, possibly null) initialization. Initialization
   * can be used to 'prime' the RNN with a sequence you want to extend/continue.<br>
   * Note that the initalization is used for all samples
   * @param initialization String, may be null. If null, select a random character as initialization for all samples
   * @param charactersToSample Number of characters to sample from network (excluding initialization)
   * @param net MultiLayerNetwork with one or more LSTM/RNN layers and a softmax output layer
   * @param iter CharacterIterator. Used for going from indexes back to characters
   */
  private static String[] sampleCharactersFromNetwork(String initialization, MultiLayerNetwork net,
                                                      CharacterIterator iter, Random rng, int charactersToSample, int numSamples ){
    //Set up initialization. If no initialization: use a random character
    if( initialization == null ){
      initialization = String.valueOf(iter.getRandomCharacter());
    }

    //Create input for initialization
    INDArray initializationInput = Nd4j.zeros(numSamples, iter.inputColumns(), initialization.length());
    char[] init = initialization.toCharArray();
    for( int i=0; i<init.length; i++ ){
      int idx = iter.convertCharacterToIndex(init[i]);
      for( int j=0; j<numSamples; j++ ){
        initializationInput.putScalar(new int[]{j,idx,i}, 1.0f);
      }
    }

    StringBuilder[] sb = new StringBuilder[numSamples];
    for( int i=0; i<numSamples; i++ ) sb[i] = new StringBuilder(initialization);

    //Sample from network (and feed samples back into input) one character at a time (for all samples)
    //Sampling is done in parallel here
    net.rnnClearPreviousState();
    INDArray output = net.rnnTimeStep(initializationInput);
    output = output.tensorAlongDimension((int)output.size(2)-1,1,0);	//Gets the last time step output

    for (int i = 0; i < charactersToSample; i++) {
      //Set up next input (single time step) by sampling from previous output
      INDArray nextInput = Nd4j.zeros(numSamples, iter.inputColumns());
      INDArray cumsum = Nd4j.cumsum(output, 1);

      for (int s = 0; s < numSamples; s++) {
        //Output is a probability distribution. Sample from this for each example we want to generate, and add it to the new input
        int sampledCharacterIdx = BooleanIndexing.firstIndex(cumsum.getRow(s), Conditions.greaterThan(rng.nextDouble())).getInt(0);
        nextInput.putScalar(new int[]{s, sampledCharacterIdx}, 1.0f);        //Prepare next time step input
        sb[s].append(iter.convertIndexToCharacter(sampledCharacterIdx));    //Add sampled character to StringBuilder (human readable output)
      }

      output = net.rnnTimeStep(nextInput);    //Do one time step of forward pass
    }

    String[] out = new String[numSamples];
    for( int i=0; i<numSamples; i++ ) out[i] = sb[i].toString();
    return out;
  }
}
