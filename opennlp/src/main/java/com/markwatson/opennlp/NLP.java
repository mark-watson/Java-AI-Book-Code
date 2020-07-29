package com.markwatson.opennlp;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.*;
import java.util.*;

public class NLP {

  private static String getModelPath() {
    String ret = "models/";
    try {
      new FileInputStream("models/en-ner-organization.bin");
    } catch (FileNotFoundException ex) {
      try {
        new FileInputStream("../opennlp/models/en-ner-organization.bin");
        ret = "../opennlp/models/";
      } catch (FileNotFoundException e) {
        System.err.println("Error: can not find OpenNLP model files, looking in ./models and ../opennlp/models");
      }
    }
    return ret;
  }
  public static String[] tokenize(String s) {
    return tokenizer.tokenize(s);
  }
  public static String[] sentenceSplitter(String s) {
    return sentenceSplitter.sentDetect(s);
  }

  public static String[] POS(String s) {
    return tagger.tag(tokenize(s));
  }

  public static String[] POS(String[] tokens) {
    return tagger.tag(tokens);
  }

  public static Set<String> companyNames(String text) {
    return companyNames(tokenizer.tokenize(text));
  }

  public static Set<String> companyNames(String tokens[]) {
    Set<String> ret = new HashSet<String>();
    Span[] nameSpans = organizationFinder.find(tokens);
    if (nameSpans.length == 0) return ret;
    for (int i = 0; i < nameSpans.length; i++) {
      Span span = nameSpans[i];
      StringBuilder sb = new StringBuilder();
      for (int j = span.getStart(); j < span.getEnd(); j++) sb.append(tokens[j] + " ");
      ret.add(sb.toString().trim().replaceAll(" ,", ","));
    }
    return ret;
  }

  public static Set<String> locationNames(String text) {
    return locationNames(tokenizer.tokenize(text));
  }

  public static Set<String> locationNames(String tokens[]) {
    Set<String> ret = new HashSet<String>();
    Span[] nameSpans = locationFinder.find(tokens);
    if (nameSpans.length == 0) return ret;
    for (int i = 0; i < nameSpans.length; i++) {
      Span span = nameSpans[i];
      StringBuilder sb = new StringBuilder();
      for (int j = span.getStart(); j < span.getEnd(); j++)
        sb.append(tokens[j] + " ");
      ret.add(sb.toString().trim().replaceAll(" ,", ","));
    }
    return ret;
  }

  public static Set<String> personNames(String text) {
    return personNames(tokenizer.tokenize(text));
  }

  public static Set<String> personNames(String tokens[]) {
    Set<String> ret = new HashSet<String>();
    Span[] nameSpans = personNameFinder.find(tokens);
    if (nameSpans.length == 0) return ret;
    for (int i = 0; i < nameSpans.length; i++) {
      Span span = nameSpans[i];
      StringBuilder sb = new StringBuilder();
      for (int j = span.getStart(); j < span.getEnd(); j++) sb.append(tokens[j] + " ");
      ret.add(sb.toString().trim().replaceAll(" ,", ","));
    }
    return ret;
  }

  static public Tokenizer tokenizer = null;
  static public SentenceDetectorME sentenceSplitter = null;
  static POSTaggerME tagger = null;
  static NameFinderME organizationFinder = null;
  static NameFinderME locationFinder = null;
  static NameFinderME personNameFinder = null;
  static String modelPath = null;

  static {

    try {
      modelPath = getModelPath();
      InputStream organizationInputStream = new FileInputStream(modelPath + "en-ner-organization.bin");
      TokenNameFinderModel model = new TokenNameFinderModel(organizationInputStream);
      organizationFinder = new NameFinderME(model);
      organizationInputStream.close();

      InputStream locationInputStream = new FileInputStream(modelPath + "en-ner-location.bin");
      model = new TokenNameFinderModel(locationInputStream);
      locationFinder = new NameFinderME(model);
      locationInputStream.close();

      InputStream personNameInputStream = new FileInputStream(modelPath + "en-ner-person.bin");
      model = new TokenNameFinderModel(personNameInputStream);
      personNameFinder = new NameFinderME(model);
      personNameInputStream.close();

      InputStream tokienizerInputStream = new FileInputStream(modelPath + "en-token.bin");
      TokenizerModel modelTokenizer = new TokenizerModel(tokienizerInputStream);
      tokenizer = new TokenizerME(modelTokenizer);
      tokienizerInputStream.close();

      InputStream sentenceInputStream = new FileInputStream(modelPath + "en-sent.bin");
      SentenceModel sentenceTokenizer = new SentenceModel(sentenceInputStream);
      sentenceSplitter = new SentenceDetectorME(sentenceTokenizer);
      tokienizerInputStream.close();

      organizationInputStream = new FileInputStream(modelPath + "en-pos-maxent.bin");
      POSModel posModel = new POSModel(organizationInputStream);
      tagger = new POSTaggerME(posModel);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
