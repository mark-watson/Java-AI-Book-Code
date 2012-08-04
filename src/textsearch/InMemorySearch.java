package textsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class InMemorySearch {
  private final int MAX_WORDS_PER_DOCUMENT = 1000;
  public static void main(String[] args) {
    InMemorySearch ims = new InMemorySearch();
    TestDocument doc1 = new TestDocument("This is a test for index and a test for search.");
    ims.add(doc1);
    TestDocument doc2 = new TestDocument("Please test the index code.");
    ims.add(doc2);
    TestDocument doc3 = new TestDocument("Please test the index code before tomorrow.");
    ims.add(doc3);
    ims.debug();
    List<Integer> search_results = ims.search("test index", 2);
    System.out.println("\nSearch results (doc IDs): " + search_results);
  }
  public void add(TestDocument document) {
    Map<String,Integer> wcount = new Hashtable<String,Integer>();
    StringTokenizer st = new StringTokenizer(document.text.toLowerCase(), " .,;:!");
    int num_words = st.countTokens();
    if (num_words == 0)  return;
    while (st.hasMoreTokens()) {
      String word = st.nextToken();
      System.out.println(word);
      if (wcount.containsKey(word)) {
        wcount.put(word, wcount.get(word) +  (MAX_WORDS_PER_DOCUMENT / num_words));
      } else {
        wcount.put(word, MAX_WORDS_PER_DOCUMENT / num_words);
      }
    }
    for (String word : wcount.keySet()) {
      TreeSet<IdCount> ts;
      if (index.containsKey(word)) {
        ts = index.get(word);
      } else {
        ts = new TreeSet<IdCount>();
        index.put(word, ts);
      }
      ts.add(new IdCount(document.id, wcount.get(word) * MAX_WORDS_PER_DOCUMENT / num_words));
    }
  }

  public List<Integer> search(String search_terms) {
    return search(search_terms, 10);
  }
  
  public List<Integer> search(String search_terms, int max_terms) {
    List<Integer> ret = new ArrayList<Integer>(10);
    // temporary tree set to keep ordered search results:
    final Map<Integer,Integer> ordered_results = new Hashtable<Integer,Integer>(0);
    StringTokenizer st = new StringTokenizer(search_terms.toLowerCase(), " .,;:!");
    while (st.hasMoreTokens()) {
      String word = st.nextToken();
      Iterator<IdCount> word_counts = index.get(word).iterator();
      while (word_counts.hasNext()) {
        IdCount ts = word_counts.next();
        Integer id = ts.id;
        if (ordered_results.containsKey(id)) {
          ordered_results.put(id, ordered_results.get(id) + ts.count);
        } else {
          ordered_results.put(id, ts.count);
        }
      }
    }
    List<Integer> keys = new ArrayList<Integer>(ordered_results.keySet()); 
    Collections.sort(keys, new Comparator<Integer>() { 
        public int compare(Integer a, Integer b) { 
            return -ordered_results.get(a).compareTo(ordered_results.get(b)) ;
        } 
    }); 
    int count = 0;
  result_loop:
    for (Integer id : keys) {
      if (count++ >= max_terms) break result_loop;
      ret.add(id);
    }
    return ret;
  }

  public void debug() {
    System.out.println("*** Debug: dump of search index:\n");
    for (String word : index.keySet()) {
      System.out.println("\n* " + word);
      TreeSet<IdCount> ts = index.get(word);
      Iterator<IdCount> iter = ts.iterator();
      while (iter.hasNext()) {
        System.out.println("   " + iter.next());
      }
    }
  }
  private Map<String,TreeSet<IdCount>> index =
    new Hashtable<String, TreeSet<IdCount>>();
}

class TestDocument {
  int id;
  String text;
  static int count = 0;
  TestDocument(String text) {
    this.text = text;
    id = count++;
  }
  public String toString() {
    int len = text.length();
    if (len > 25) len = 25;
    return "[Document id: " + id + ": " + text.substring(0,len) + "...]";
  }
}


class IdCount implements Comparable<IdCount> {
  int id = 0;
  int count = 0;
  public IdCount(int k, int v) {
    this.id = k;
    this.count = v;
  }
  public String toString() {
    return "[IdCount: " + id + " : " + count + "]";
  }
  public int compareTo(IdCount o) {
    // don't use i1-i2: avoid overflows
    if (o.count == count) return 0;
    if (o.count > count) return 1;
    return -1;
  }
}