package com.markwatson.opennlp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Unit test for NLP.
 */
public class NLPTest extends TestCase {

  public NLPTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    return new TestSuite(NLPTest.class);
  }

  public void testDemoAllNlpAPis() {
    String sentence = "Apple Computer, Microsoft, and Google are in the tech sector. Each is very profitable.";
    System.out.println("\nNew test sentence:\n\n" + sentence + "\n");
    String [] sentences = NLP.sentenceSplitter(sentence);
    System.out.println("Sentences found: " + Arrays.toString(sentences));

    sentence = "Apple Computer, Microsoft, and Google are in the tech sector.";
    System.out.println("\nNew test sentence:\n\n" + sentence + "\n");
    Set<String> names = NLP.companyNames(sentence);
    System.out.println("Company names found: " + names);

    sentence = "Apple Computer is located in Cupertino, California and Microsoft is located in Seattle, Washington. He went to Oregon";
    System.out.println("\nNew test sentence:\n\n" + sentence + "\n");
    Set<String> names1 = NLP.locationNames(sentence);
    System.out.println("Location names found: " + names1);

    sentence = "President Bill Clinton left office.";
    System.out.println("\nNew test sentence:\n\n" + sentence + "\n");
    Set<String> names2 = NLP.personNames(sentence);
    System.out.println("Person names found: " + names2);

    sentence = "The White House is often mentioned in the news about  U.S. foreign policy. Members of Congress and the President are worried about the next election and may pander to voters by promising tax breaks. Diplomacy with Iran, Iraq, and North Korea is non existent in spite of a worry about nuclear weapons. A uni-polar world refers to the hegemony of one country, often a militaristic empire. War started with a single military strike. The voting public wants peace not war. Democrats and Republicans argue about policy.";
    System.out.println("\nNew test sentence:\n\n" + sentence + "\n");
    List<Pair<String, Double>> results = NewsClassifier.allRankedCategories(sentence);
    System.out.println("All ranked categories found: " + results);

    sentence = "The food affects colon cancer and ulcerative colitis. There is some evidence that sex helps keep us healthy. Eating antioxidant rich foods may prevent desease. Smoking may raise estrogen levels in men and lead to heart failure.";
    System.out.println("\nNew test sentence:\n\n" + sentence + "\n");
    String results2 = NewsClassifier.bestCategory(sentence);
    System.out.println("Best category found found (HEALTH): " + results2);
    List<Pair<String, Double>> results3 = NewsClassifier.allRankedCategories(sentence);
    System.out.println("All ranked categories found (HEALTH): " + results3);
    System.out.println("Best category with score: " + NewsClassifier.classifyWithScore(sentence));
  }

}

