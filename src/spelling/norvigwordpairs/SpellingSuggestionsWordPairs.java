package spelling.norvig;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * A spelling correct suggestion utility based on Peter Norvig's
 * Python spelling program: http://norvig.com/spell-correct.html
 *
 * Note: this version uses word pairs (greatly increasing memory and processing requirements)
 *
 */
public class SpellingSuggestionsWordPairs {

	public SpellingSuggestionsWordPairs() throws FileNotFoundException {
		Pattern p = Pattern.compile("[,.()'\";:\\s]+");
		Scanner scanner = new Scanner(new File("/tmp/small.txt"));
		scanner.useDelimiter(p);
		String last = "ahjhjhdsgh";
		while (scanner.hasNext()) {
			String word = scanner.next();
			if (wordCounts.containsKey(word)) {
				Integer count = wordCounts.get(word);
				wordCounts.put(word, count + 1);
			} else {
				wordCounts.put(word, 1);
			}
			String pair = last + " " + word;
			if (wordPairCounts.containsKey(pair)) {
				Integer count = wordPairCounts.get(pair);
				wordPairCounts.put(pair, count + 1);
			} else {
				wordPairCounts.put(pair, 1);
			}
			last = word;
		}
		scanner.close();
   	    for (String pair : wordPairCounts.keySet()) {
	      if (wordPairCounts.get(pair) > 1) {
	          System.out.println(pair + ": " + wordPairCounts.get(pair));
	      }
	    }
	}
	
	private List<String> edits(String word) {
		int wordL = word.length(), wordLm1 = wordL - 1;
		List<String> possible = new ArrayList<String>();
		// drop a character:
		for (int i=0; i < wordL; ++i) {
			possible.add(word.substring(0, i) + word.substring(i+1));
		}
		// reverse order of 2 characters:
		for (int i=0; i < wordLm1; ++i) {
			possible.add(word.substring(0, i) + word.substring(i+1, i+2) +
					     word.substring(i, i+1) + word.substring(i+2));
		}
		// replace a character in each location in the word:
		for (int i=0; i < wordL; ++i) {
			for (char ch='a'; ch <= 'z'; ++ch) {
				possible.add(word.substring(0, i) + ch +
						     word.substring(i+1));
			}
		}
		// add in a character in each location in the word:
		for (int i=0; i <= wordL; ++i) {
			for (char ch='a'; ch <= 'z'; ++ch) {
				possible.add(word.substring(0, i) + ch +
						     word.substring(i));
			}
		}
		return possible;
	}
	
	public  String correct(String word, String previous_word) {
		if(wordCounts.containsKey(word)) return word;
		List<String> list = edits(word);
		// candidate hash has as word counts as keys, word as value:
		HashMap<Integer, String> candidates = new HashMap<Integer, String>();
		for (String testWord : list) {
			String word_pair = previous_word + " " + testWord;
			int count_from_1_word = 0;
			int count_from_word_pairs = 0;
			if(wordCounts.containsKey(testWord)) {
				count_from_1_word += wordCounts.get(testWord);
				candidates.put(wordCounts.get(testWord), testWord);
			}
			if (wordPairCounts.containsKey(word_pair)) {
				count_from_word_pairs += wordPairCounts.get(word_pair);
			}
			word_pair = testWord + " " + previous_word;
			if (wordPairCounts.containsKey(word_pair)) {
				count_from_word_pairs += wordPairCounts.get(word_pair);
			}
			int sum = count_from_1_word + count_from_word_pairs;
			if (sum > 0)  {
				candidates.put(sum, testWord);
			}
			System.out.println(word_pair + " : " + count_from_1_word + ", " + count_from_word_pairs + "  " + testWord);
		}
		/**
		 *  If candidates is not empty, then return the word with
		 *  the largest key (word count) value:
		 */
		if(candidates.size() > 0) {
			return candidates.get(Collections.max(candidates.keySet()));
		}
		return word;
	}

	public int usePairStatistics(String test_word, String previous_word) {
		return wordPairCounts.get(previous_word + " " + test_word);
	}
	
	/**
	 * main test method
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		SpellingSuggestionsWordPairs test = new SpellingSuggestionsWordPairs();
		System.out.println(test.edits("Doyyle"));
		System.out.println(test.edits("Doyyle").size());
		System.out.println(test.correct("Doyyle","Conan"));
	}

	private static Map<String, Integer> wordCounts = new HashMap<String, Integer>();
	private static Map<String, Integer> wordPairCounts = new HashMap<String, Integer>();
}
