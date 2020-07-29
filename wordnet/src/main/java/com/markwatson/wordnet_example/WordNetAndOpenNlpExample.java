package com.markwatson.wordnet_example;

/**
 * This is an example use of WordNet using the extjwnl library.
 *
 * Copyright 2020 Mark Watson. All Rights Reserved. Apache 2 license.
 *
 * For documentation see my book "Practical Artificial Intelligence Programming
 * With Java", chapter "Combining the WordNet Linguistic Database With OpenNLP"
 * at https://leanpub.com/javaai that can be read for free online.
 *
 */

import com.markwatson.opennlp.NLP;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.*;
import net.sf.extjwnl.data.list.PointerTargetNode;
import net.sf.extjwnl.dictionary.Dictionary;

import java.util.*;

public class WordNetAndOpenNlpExample {

  private WordNetAndOpenNlpExample() {
  }

  static Dictionary dictionary = null;
  static {
    try {
      dictionary = Dictionary.getDefaultResourceInstance();
    } catch (JWNLException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  static public Map<String, List<List<String>>> getHypernyms(String s)
      throws JWNLException {
    Map hypernymMap = new HashMap<String, List<List<String>>>();
    String[] tokens = NLP.tokenize(s);
    String[] pos = NLP.POS(s);
    for (int i = 0; i < tokens.length; i++) {
      if (pos[i].startsWith("N")) {
        IndexWord iw = dictionary.getIndexWord(POS.NOUN, tokens[i]);
        List hypernymList = new ArrayList<List<List<String>>>();
        for (Synset aSense : iw.getSenses()) {
          List lemmaList = new ArrayList<List<String>>();
          lemmaList.add(aSense.getGloss());
          for (PointerTargetNode ptn : PointerUtils.getDirectHypernyms(aSense)) {
            List<PointerTarget> pthTargets = ptn.getPointerTarget().getTargets();
            for (Object pt : pthTargets) {
              try {
                Synset spt = (Synset) pt;
                List<Word> words = spt.getWords();
                for (Word word : words) {
                  lemmaList.add(word.getLemma());
                }
              } catch (Exception ignore) {
              }
            }
          }
          hypernymList.add(lemmaList);
        }
        if (hypernymList.size() > 0) hypernymMap.put(tokens[i], hypernymList);
      }
    }
    return hypernymMap;
  }

  static public Map<String, List<List<String>>> getSynonyms(String s)
      throws JWNLException {
    Map synonymMap = new HashMap<String, List<List<String>>>();
    String[] tokens = NLP.tokenize(s);
    String[] pos = NLP.POS(s);
    for (int i = 0; i < tokens.length; i++) {
      if (pos[i].startsWith("N")) {
        List<List<String>> lemmaList = new ArrayList<List<String>>();
        IndexWord iw = dictionary.getIndexWord(POS.NOUN, tokens[i]);
        for (Synset aSense : iw.getSenses()) {
          List<String> lemmas = new ArrayList<String>();
          lemmas.add(aSense.getGloss());
          for (Word word : aSense.getWords()) {
            lemmas.add(word.getLemma());
          }
          lemmaList.add(lemmas);
        }
        if (lemmaList.size() > 0) synonymMap.put(tokens[i], lemmaList);
      }
    }
    return synonymMap;
  }

  public static void main(String[] args)
      throws JWNLException {
    String s = "The cat, and dog, ran after President Bill Clinton in Mexico";
    System.out.println("\n**** Hypernyms:\n");
    System.out.println(getHypernyms(s));
    System.out.println("\n**** Synonyms:\n");
    System.out.println(getSynonyms(s));
  }
}