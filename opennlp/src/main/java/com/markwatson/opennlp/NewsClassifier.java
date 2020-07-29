package com.markwatson.opennlp;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;

import java.io.*;
import java.util.*;

/**
 * This program uses the maximum entropy model we trained
 * using the instructions in the chapter on OpenNLP in the book.
 */

public class NewsClassifier {

  public static List<Pair<String,Double>> allRankedCategories(String text) {
    DocumentCategorizerME aCategorizer = new DocumentCategorizerME(docCatModel);
    double[] outcomes = aCategorizer.categorize(text);
    List<Pair<String,Double>> results = new ArrayList<Pair<String, Double>>();
    for (int i=0; i<outcomes.length; i++) {
      results.add(new Pair<String, Double>(aCategorizer.getCategory(i), outcomes[i]));
    }
    results.sort((Pair<String,Double> o1, Pair<String,Double> o2) ->
            o2.val < o1.val ? -1 : o2.val == o1.val ? 0 : 1); // sort in best-first order
    return results;
  }

  public static String bestCategory(String text) {
    DocumentCategorizerME aCategorizer = new DocumentCategorizerME(docCatModel);
    double[] outcomes = aCategorizer.categorize(text);
    return aCategorizer.getBestCategory(outcomes);
  }

  public static Pair<String,Float> classifyWithScore(String text) {
    DocumentCategorizerME classifier = new DocumentCategorizerME(docCatModel);
    double [] scores = classifier.categorize(text);
    int num_categories = classifier.getNumberOfCategories();
    if (num_categories > 0) {
      String bestString =  classifier.getBestCategory(scores);
      for (int i=0; i<num_categories; i++) {
        if (classifier.getCategory(i).equals(bestString)) {
          return new Pair<String,Float>(bestString, (float)scores[i]);
        }
      }
    }
    return new Pair<String,Float>("<no category>", 0f);
  }

  static DoccatModel docCatModel = null;

  static {

    try {
      InputStream modelIn = new FileInputStream("models/en-newscat.bin");
      docCatModel = new DoccatModel(modelIn);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
