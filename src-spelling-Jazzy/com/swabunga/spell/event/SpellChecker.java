/*
Jazzy - a Java library for Spell Checking
Copyright (C) 2001 Mindaugas Idzelis
Full text of license can be found in LICENSE.txt

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
*/
package com.swabunga.spell.event;

import com.swabunga.spell.engine.Configuration;
import com.swabunga.spell.engine.SpellDictionary;
import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.engine.Word;
import com.swabunga.util.VectorUtility;

import java.io.IOException;
import java.util.*;


/**
 * This is the main class for spell checking (using the new event based spell
 * checking). 
 * <p/>
 * By default, the class makes a user dictionary to accumulate added words.
 * Since this user directory has no file assign to persist added words, they
 * will be retained for the duration of the spell checker instance.
 * If you set a user dictionary like 
 * {@link com.swabunga.spell.engine.SpellDictionaryHashMap SpellDictionaryHashMap}
 * to persist the added word, the user dictionary will have the possibility to
 * grow and be available across differents invocations of the spell checker.
 *
 * @author     Jason Height (jheight@chariot.net.au)
 * 19 June 2002
 */
public class SpellChecker {
  /** Flag indicating that the Spell Check completed without any errors present*/
  public static final int SPELLCHECK_OK = -1;
  /** Flag indicating that the Spell Check completed due to user cancellation*/
  public static final int SPELLCHECK_CANCEL = -2;

  private Vector eventListeners = new Vector();
  private Vector dictionaries = new Vector();
  private SpellDictionary userdictionary;

  private Configuration config = Configuration.getConfiguration();

  /**This variable holds all of the words that are to be always ignored */
  private Vector ignoredWords = new Vector();
  private Hashtable autoReplaceWords = new Hashtable();
  
  // added caching - bd
  // For cached operation a separate user dictionary is required
  private Map cache;
  private int threshold = 0;
  private int cacheSize = 0;
  

  /**
   * Constructs the SpellChecker.
   */
  public SpellChecker() {
    try {
      userdictionary = new SpellDictionaryHashMap();
    } catch (IOException e) {
      throw new RuntimeException("this exception should never happen because we are using null phonetic file");
    }
  }

  /**
   * Constructs the SpellChecker. The default threshold is used
   *
   * @param  dictionary  The dictionary used for looking up words.
   */
  public SpellChecker(SpellDictionary dictionary) {
    this();
    addDictionary(dictionary);
  }


  /**
   * Constructs the SpellChecker with a threshold
   *
   * @param  dictionary  the dictionary used for looking up words.
   * @param  threshold   the cost value above which any suggestions are 
   *                     thrown away
   */
  public SpellChecker(SpellDictionary dictionary, int threshold) {
    this(dictionary);
    config.setInteger(Configuration.SPELL_THRESHOLD, threshold);
  }

  /**
   * Accumulates a dictionary at the end of the dictionaries list used
   * for looking up words. Adding a dictionary give the flexibility to
   * assign the base language dictionary, then a more technical, then...
   *
   * @param dictionary the dictionary to add at the end of the dictionary list.
   */
  public void addDictionary(SpellDictionary dictionary) {
    if (dictionary == null) {
      throw new IllegalArgumentException("dictionary must be non-null");
    }
    this.dictionaries.addElement(dictionary);
  }

  /**
   * Registers the user dictionary to which words are added.
   *
   * @param dictionary the dictionary to use when the user specify a new word
   * to add.
   */
  public void setUserDictionary(SpellDictionary dictionary) {
    userdictionary = dictionary;
  }

  /**
   * Supply the instance of the configuration holding the spell checking engine
   * parameters.
   *
   * @return Current Configuration
   */
  public Configuration getConfiguration() {
    return config;
  }

  /**
   * Adds a SpellCheckListener to the listeners list.
   *
   * @param  listener  The feature to be added to the SpellCheckListener attribute
   */
  public void addSpellCheckListener(SpellCheckListener listener) {
    eventListeners.addElement(listener);
  }


  /**
   * Removes a SpellCheckListener from the listeners list.
   *
   * @param  listener  The listener to be removed from the listeners list.
   */
  public void removeSpellCheckListener(SpellCheckListener listener) {
    eventListeners.removeElement(listener);
  }


  /**
   * Fires off a spell check event to the listeners.
   *
   * @param  event  The event that need to be processed by the spell checking
   * system.
   */
  protected void fireSpellCheckEvent(SpellCheckEvent event) {
    for (int i = eventListeners.size() - 1; i >= 0; i--) {
      ((SpellCheckListener) eventListeners.elementAt(i)).spellingError(event);
    }
  }


  /**
   * This method clears the words that are currently being remembered as
   *  <code>Ignore All</code> words and <code>Replace All</code> words.
   */
  public void reset() {
    ignoredWords = new Vector();
    autoReplaceWords = new Hashtable();
  }


  /**
   * Checks the text string.
   *  <p>
   *  Returns the corrected string.
   *
   * @param  text   The text that need to be spelled checked
   * @return        The text after spell checking
   * @deprecated    use checkSpelling(WordTokenizer)
   */
  public String checkString(String text) {
    StringWordTokenizer tokens = new StringWordTokenizer(text);
    checkSpelling(tokens);
    return tokens.getContext();
  }


  /**
   * Verifies if the word that is being spell checked contains at least a
   * digit.
   * Returns true if this word contains a digit.
   *
   * @param  word  The word to analyze for digit.
   * @return       true if the word contains at least a digit.
   */
  private final static boolean isDigitWord(String word) {
    for (int i = word.length() - 1; i >= 0; i--) {
      if (Character.isDigit(word.charAt(i))) {
        return true;
      }
    }
    return false;
  }


  /**
   * Verifies if the word that is being spell checked contains an Internet 
   * address. The method look for typical protocol or the habitual string 
   * in the word:
   * <ul>
   * <li>http://</li>
   * <li>ftp://</li>
   * <li>https://</li>
   * <li>ftps://</li>
   * <li>www.</li>
   * </ul>
   *
   * One limitation is that this method cannot currently recognize email
   * addresses. Since the 'word' that is passed in, may in fact contain
   * the rest of the document to be checked, it is not (yet!) a good
   * idea to scan for the @ character.
   *
   * @param  word  The word to analyze for an Internet address.
   * @return       true if this word looks like an Internet address.
   */
    public final static boolean isINETWord(String word) {
        String lowerCaseWord = word.toLowerCase();
        return lowerCaseWord.startsWith("http://") ||
              lowerCaseWord.startsWith("www.") ||
              lowerCaseWord.startsWith("ftp://") ||
              lowerCaseWord.startsWith("https://") ||
              lowerCaseWord.startsWith("ftps://");
  }


  /**
   * Verifies if the word that is being spell checked contains all
   * uppercases characters.
   *
   * @param  word  The word to analyze for uppercases characters
   * @return       true if this word contains all upper case characters
   */
  private final static boolean isUpperCaseWord(String word) {
    for (int i = word.length() - 1; i >= 0; i--) {
      if (Character.isLowerCase(word.charAt(i))) {
        return false;
      }
    }
    return true;
  }


  /**
   * Verifies if the word that is being spell checked contains lower and
   * upper cased characters. Note that a phrase beginning with an upper cased
   * character is not considered a mixed case word.
   *
   * @param  word  The word to analyze for mixed cases characters
   * @param startsSentence True if this word is at the start of a sentence
   * @return       true if this word contains mixed case characters
   */
  private final static boolean isMixedCaseWord(String word, boolean startsSentence) {
    int strLen = word.length();
    boolean isUpper = Character.isUpperCase(word.charAt(0));
    //Ignore the first character if this word starts the sentence and the first
    //character was upper cased, since this is normal behaviour
    if ((startsSentence) && isUpper && (strLen > 1))
      isUpper = Character.isUpperCase(word.charAt(1));
    if (isUpper) {
      for (int i = word.length() - 1; i > 0; i--) {
        if (Character.isLowerCase(word.charAt(i))) {
          return true;
        }
      }
    } else {
      for (int i = word.length() - 1; i > 0; i--) {
        if (Character.isUpperCase(word.charAt(i))) {
          return true;
        }
      }
    }
    return false;
  }


  /**
   * This method will fire the spell check event and then handle the event
   *  action that has been selected by the user.
   *
   * @param  tokenizer        Description of the Parameter
   * @param  event            The event to handle
   * @return                  Returns true if the event action is to cancel the current spell checking, false if the spell checking should continue
   */
  protected boolean fireAndHandleEvent(WordTokenizer tokenizer, SpellCheckEvent event) {
    fireSpellCheckEvent(event);
    String word = event.getInvalidWord();
    //Work out what to do in response to the event.
    switch (event.getAction()) {
      case SpellCheckEvent.INITIAL:
        break;
      case SpellCheckEvent.IGNORE:
        break;
      case SpellCheckEvent.IGNOREALL:
        ignoreAll(word);
        break;
      case SpellCheckEvent.REPLACE:
        tokenizer.replaceWord(event.getReplaceWord());
        break;
      case SpellCheckEvent.REPLACEALL:
        String replaceAllWord = event.getReplaceWord();
        if (!autoReplaceWords.containsKey(word)) {
          autoReplaceWords.put(word, replaceAllWord);
        }
        tokenizer.replaceWord(replaceAllWord);
        break;
      case SpellCheckEvent.ADDTODICT:
        String addWord = event.getReplaceWord();
        if (!addWord.equals(word))
          tokenizer.replaceWord(addWord);
        userdictionary.addWord(addWord);
        break;
      case SpellCheckEvent.CANCEL:
        return true;
      default:
        throw new IllegalArgumentException("Unhandled case.");
    }
    return false;
  }

  /**
   * Adds a word to the list of ignored words
   * @param word The text of the word to ignore
   */
  public void ignoreAll(String word) {
    if (!ignoredWords.contains(word)) {
      ignoredWords.addElement(word);
    }
  }
  
  /**
   * Adds a word to the user dictionary
   * @param word The text of the word to add
   */
  public void addToDictionary(String word) {
    if (!userdictionary.isCorrect(word))
      userdictionary.addWord(word);
  }
  
  /**
   * Indicates if a word is in the list of ignored words
   * @param word The text of the word check
   */
  public boolean isIgnored(String word){
  	return ignoredWords.contains(word);
  }
  
  /**
   * Verifies if the word to analyze is contained in dictionaries. The order 
   * of dictionary lookup is:
   * <ul>
   * <li>The default user dictionary or the one set through 
   * {@link SpellChecker#setUserDictionary}</li>
   * <li>The dictionary specified at construction time, if any.</li>
   * <li>Any dictionary in the order they were added through 
   * {@link SpellChecker#addDictionary}</li>
   * </ul>
   *
   * @param word The word to verify that it's spelling is known.
   * @return true if the word is in a dictionary.
   */
  public boolean isCorrect(String word) {
    if (userdictionary.isCorrect(word)) return true;
    for (Enumeration e = dictionaries.elements(); e.hasMoreElements();) {
      SpellDictionary dictionary = (SpellDictionary) e.nextElement();
      if (dictionary.isCorrect(word)) return true;
    }
    return false;
  }

  /**
   * Produces a list of suggested word after looking for suggestions in various
   * dictionaries. The order of dictionary lookup is:
   * <ul>
   * <li>The default user dictionary or the one set through 
   * {@link SpellChecker#setUserDictionary}</li>
   * <li>The dictionary specified at construction time, if any.</li>
   * <li>Any dictionary in the order they were added through 
   * {@link SpellChecker#addDictionary}</li>
   * </ul>
   *
   * @param word The word for which we want to gather suggestions
   * @param threshold the cost value above which any suggestions are 
   *                  thrown away
   * @return the list of words suggested
   */
  public List getSuggestions(String word, int threshold) {
    if (this.threshold != threshold && cache != null) {
       this.threshold = threshold;
       cache.clear();
    }
    
    ArrayList suggestions = null;
    
    if (cache != null)
       suggestions = (ArrayList) cache.get(word);

    if (suggestions == null) {
       suggestions = new ArrayList(50);
    
       for (Enumeration e = dictionaries.elements(); e.hasMoreElements();) {
           SpellDictionary dictionary = (SpellDictionary) e.nextElement();
           
           if (dictionary != userdictionary)
              VectorUtility.addAll(suggestions, dictionary.getSuggestions(word, threshold), false);
       }

       if (cache != null && cache.size() < cacheSize)
         cache.put(word, suggestions);
    }
    
    VectorUtility.addAll(suggestions, userdictionary.getSuggestions(word, threshold), false);
    suggestions.trimToSize();
    
    return suggestions;
  }

  /**
  * Activates a cache with the maximum number of entries set to 300
  */
  public void setCache() {
    setCache(300);
  }

  /**
  * Activates a cache with specified size
  * @param size - max. number of cache entries (0 to disable chache)
  */
  public void setCache(int size) {
    cacheSize = size;
    if (size == 0)
      cache = null;
   else
     cache = new HashMap((size + 2) / 3 * 4);
  }

  /**
   * This method is called to check the spelling of the words that are returned
   * by the WordTokenizer.
   * <p/>
   * For each invalid word the action listeners will be informed with a new 
   * SpellCheckEvent.<p>
   *
   * @param  tokenizer  The media containing the text to analyze.
   * @return Either SPELLCHECK_OK, SPELLCHECK_CANCEL or the number of errors found. The number of errors are those that
   * are found BEFORE any corrections are made.
   */
  public final int checkSpelling(WordTokenizer tokenizer) {
    int errors = 0;
    boolean terminated = false;
    //Keep track of the previous word
//    String previousWord = null;
    while (tokenizer.hasMoreWords() && !terminated) {
      String word = tokenizer.nextWord();
      //Check the spelling of the word
      if (!isCorrect(word)) {
          if ((config.getBoolean(Configuration.SPELL_IGNOREMIXEDCASE) && isMixedCaseWord(word, tokenizer.isNewSentence())) ||
            (config.getBoolean(Configuration.SPELL_IGNOREUPPERCASE) && isUpperCaseWord(word)) ||
            (config.getBoolean(Configuration.SPELL_IGNOREDIGITWORDS) && isDigitWord(word)) ||
            (config.getBoolean(Configuration.SPELL_IGNOREINTERNETADDRESSES) && isINETWord(word))) {
          //Null event. Since we are ignoring this word due
          //to one of the above cases.
        } else {
          //We cant ignore this misspelt word
          //For this invalid word are we ignoring the misspelling?
          if (!isIgnored(word)) {
            errors++;
            //Is this word being automagically replaced
            if (autoReplaceWords.containsKey(word)) {
              tokenizer.replaceWord((String) autoReplaceWords.get(word));
            } else {
              //JMH Need to somehow capitalise the suggestions if
              //ignoreSentenceCapitalisation is not set to true
              //Fire the event.
              List suggestions = getSuggestions(word, config.getInteger(Configuration.SPELL_THRESHOLD));
              if (capitalizeSuggestions(word, tokenizer))
                suggestions = makeSuggestionsCapitalized(suggestions);
              SpellCheckEvent event = new BasicSpellCheckEvent(word, suggestions, tokenizer);
              terminated = fireAndHandleEvent(tokenizer, event);
            }
          }
        }
      } else {
        //This is a correctly spelt word. However perform some extra checks
        /*
         *  JMH TBD          //Check for multiple words
         *  if (!ignoreMultipleWords &&) {
         *  }
         */
        //Check for capitalisation
        if (isSupposedToBeCapitalized(word, tokenizer)) {
          errors++;
          StringBuffer buf = new StringBuffer(word);
          buf.setCharAt(0, Character.toUpperCase(word.charAt(0)));
          Vector suggestion = new Vector();
          suggestion.addElement(new Word(buf.toString(), 0));
          SpellCheckEvent event = new BasicSpellCheckEvent(word, suggestion, tokenizer);
          terminated = fireAndHandleEvent(tokenizer, event);
        }
      }
    }
    if (terminated)
      return SPELLCHECK_CANCEL;
    else if (errors == 0)
      return SPELLCHECK_OK;
    else
      return errors;
  }
  
  
  private List makeSuggestionsCapitalized(List suggestions) {
    Iterator iterator = suggestions.iterator();
    while(iterator.hasNext()) {
      Word word = (Word)iterator.next();
      String suggestion = word.getWord();
      StringBuffer stringBuffer = new StringBuffer(suggestion);
      stringBuffer.setCharAt(0, Character.toUpperCase(suggestion.charAt(0)));
      word.setWord(stringBuffer.toString());
    }
    return suggestions;
  }

    
   private boolean isSupposedToBeCapitalized(String word, WordTokenizer wordTokenizer) {
     boolean configCapitalize = !config.getBoolean(Configuration.SPELL_IGNORESENTENCECAPITALIZATION);
     return configCapitalize && wordTokenizer.isNewSentence() && Character.isLowerCase(word.charAt(0));
  } 

   private boolean capitalizeSuggestions(String word, WordTokenizer wordTokenizer) {
   // if SPELL_IGNORESENTENCECAPITALIZATION and the initial word is capitalized, suggestions should also be capitalized
   // if !SPELL_IGNORESENTENCECAPITALIZATION, capitalize suggestions only for the first word in a sentence
     boolean configCapitalize = !config.getBoolean(Configuration.SPELL_IGNORESENTENCECAPITALIZATION);
     boolean uppercase = Character.isUpperCase(word.charAt(0));
     return (configCapitalize && wordTokenizer.isNewSentence()) || (!configCapitalize && uppercase);
   }
}
