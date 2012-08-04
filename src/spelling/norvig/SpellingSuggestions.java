package spelling.norvig;

import nlp.com.knowledgebooks.nlp.util.Tokenizer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * A spelling correct suggestion utility based on Peter Norvig's
 * Python spelling program: http://norvig.com/spell-correct.html
 *
 */
public class SpellingSuggestions {

	private SpellingSuggestions() { } // disable default constructor
	
	private static List<String> edits(String word) {
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
	
	public static String correct(String word) {
		if(wordCounts.containsKey(word)) return word;
		List<String> list = edits(word);
		// candidate hash has as word counts as keys, word as value:
		HashMap<Integer, String> candidates = new HashMap<Integer, String>();
		for (String testWord : list) {
			if(wordCounts.containsKey(testWord)) {
				candidates.put(wordCounts.get(testWord), testWord);
			}
		}
		/**
		 *  If candidates is not empty, then return the word with
		 *  the largest key (word count) value:
		 */
		if(candidates.size() > 0) {
			return candidates.get(Collections.max(candidates.keySet()));
		}
		/**
		 * If the edits method does not provide a candidate word that matches
		 * then we will call edits again with each previous permutation words.
		 * Note: this case occurs only about 20% of the time and obviously
		 *       increases the runtime of method correct.
		 */
		candidates.clear();
		for (String editWords : list) {
			for (String wrd : edits(editWords)) {
				if(wordCounts.containsKey(wrd)) {
					candidates.put(wordCounts.get(wrd),wrd);
				}
			}
		}
		//System.out.println(candidates);

		if (candidates.size() > 0) {
			return candidates.get(Collections.max(candidates.keySet()));
		}
		return word;
	}

	/**
	 * main test method
	 */
	public static void main(String[] args) {
		System.out.println(SpellingSuggestions.correct("baank"));
		System.out.println(SpellingSuggestions.correct("hown"));
		System.out.println(SpellingSuggestions.correct("watr"));
		System.out.println(SpellingSuggestions.correct("thee"));
		System.out.println(SpellingSuggestions.correct("thhe"));
		System.out.println(SpellingSuggestions.correct("smth"));
		System.out.println(SpellingSuggestions.correct("joonees"));
		System.out.println(SpellingSuggestions.correct("waateer"));
	}

	private static Map<String, Integer> wordCounts = new HashMap<String, Integer>();
	static {
		// Use Peter Norvig's training file:
		// http://www.norvig.com/spell-correct.html
		try {
			FileInputStream fstream = new FileInputStream("/tmp/big.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null) {
				List<String> words = Tokenizer.wordsToList(line);
				for (String word : words) {
					if (wordCounts.containsKey(word)) {
						Integer count = wordCounts.get(word);
						wordCounts.put(word, count + 1);
					} else {
						wordCounts.put(word, 1);
					}
				}
			}
			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
