package spelling.jazzy;

// see: http://sourceforge.net/projects/jazzy/ for Jazzy source code

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellChecker;


public class SpellingJazzyTester {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File dict = new File("test_data/dictionary/english.0");
		SpellChecker checker = new SpellChecker(new SpellDictionaryHashMap(dict));
		int THRESHOLD = 10; // computational cost threshold
		System.out.println(checker.getSuggestions("runnng", THRESHOLD));
		System.out.println(checker.getSuggestions("season", THRESHOLD));
		System.out.println(checker.getSuggestions("advantagius", THRESHOLD));
	}

}
