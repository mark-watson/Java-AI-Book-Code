package nlp.com.knowledgebooks.nlp.util;

import java.util.HashSet;
import java.util.Set;
import nlp.public_domain.Stemmer;

public class NoiseWords {
	private static String[] words = {
		"the", "a", "an", "it", "or", "and", "he", "she",
		"with", "often", "to", "do", "that", "this", "is",
		"are", "one", "two", "since", "just", "start", 
		"beyond", "could", "not", "be", "from", "on", "could",
		"as", "say", "said", "will", "if", "by", "on", "often",
		"little", "big", "did", "do", "about", "any", "such",
		"up", "s", "already", "than", "now", "gave", "less",
		"more", "another", "for", "other", "goes", "would",
		"of", "her", "how", "told", "meet", "without",
		"few", "has", "ask", "run", "across", "rather", "me",
		"sometme", "want", "d", "look", "perhaps", "come",
		"o", "us", "m", "seem", "i", "u", "t", "what",
		"but", "last", "who", "toward", "when", "thing",
		"got", "can", "with", "at", "off", "in", "much",
		"under", "why", "also", "take", "am", "great",
		"in", "top"
	};
	private static Set<String> stems = new HashSet<String>();
	static {
		Stemmer stemmer = new Stemmer();
		for (String word : words) {
			stems.add(stemmer.stemOneWord(word));
		}
	}
	public static boolean checkFor(String stem) {
		return stems.contains(stem);
	}
}
