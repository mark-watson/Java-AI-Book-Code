package markov;

import java.util.*;
import java.io.*;

/**
 * Markov learning and recall
 *
 * <p/>
 * Copyright 2002-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */

public class Markov {
    static public void main(String[] args) {
        new Markov();
    }

    /**
     *  The public constructor does everything:
     *
     *   1. reads a tagged input file tagged_text.txt and builds
     *      a list of all possible tags and words
     *   2. trains a visible Markov model
     *   3. tests the Markov model by tagging new test sentences
     *      containing only words originally in tagged text file.
     */
    public Markov() {
        build_words_and_tags();
        print_statistics();
        train_model();
        test_model();
    }

    /**
     *  Read an input file of manually tagged text. Get a sequence of words and
     *  associated tags and also build sequences of unique words and unique tags.
     */
    public void build_words_and_tags() {
        try {
            FileReader fr = new FileReader("test_data/markov/tagged_text.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                p(line);
                line = line.trim();
                while (true) {
                    int index = line.indexOf(" ");
                    String key;
                    String tag;
                    if (index == -1) {
                        int index2 = line.indexOf("/");
                        key = line.substring(0, index2).toLowerCase();
                        tag = line.substring(index2 + 1);
                    } else {
                        String line2 = line.substring(0, index);
                        line = line.substring(index + 1);
                        int index2 = line2.indexOf("/");
                        key = line2.substring(0, index2).toLowerCase();
                        tag = line2.substring(index2 + 1);
                    }
                    List<String> v = lexicon.get(key);
                    if (v == null) {
                        v = new ArrayList<String>(5);
                    }
                    v.add(tag);
                    lexicon.put(key, v);
                    if (tags.get(tag) == null) {
                        tags.put(tag, new Integer(1));
                        tagCount++;
                    } else {
                        int old_count = ((Integer)tags.get(tag)).intValue();
                        tags.put(tag, new Integer(old_count + 1));
                    }
                    if (words.get(key) == null) {
                        words.put(key, new Integer(wordCount++));
                    }
                    wordList.add(key);
                    tagList.add(tag);
                    if (index == -1) break;
                }
            }
            uniqueTags.addAll(tags.keySet());
            uniqueWords.addAll(words.keySet());
            uniqueTagCount = uniqueTags.size();
            uniqueWordCount = uniqueWords.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *   For debug only: print out statistics of number of unique words and unique tags.
     */
    public void print_statistics() {
        int word_count = 0;
        for (String key : lexicon.keySet()) {
            word_count++;
            List<String> v = lexicon.get(key);
            p0(key + ":");
            for (String s : v) p0(" " + s);
            p("");
        }
        p("\ntotal number of unique words is " + word_count + "\n");
        p("wordCount=" + wordCount + ", tagCount=" + tagCount);
    }

    /**
     *  This is for debug only: print out training matrices in a CSV type format
     *  so that the matrices can be examined in a spreadsheet program for debugging purposes.
     */
    private void WriteCSVfile(List<String> rowNames, List<String> colNames, float[][] buf, String fileName) {
        p("tagList.size()="+tagList.size());
        try {
            FileWriter fw = new FileWriter(fileName + ".txt");
            PrintWriter bw = new PrintWriter(new BufferedWriter(fw));
            // write the first title row:
            StringBuffer sb = new StringBuffer(500);
            for (int i = 0, size = colNames.size(); i < size; i++) {
                sb.append("," + colNames.get(i));
            }
            bw.println(sb.toString());
            // loop on remaining rows:
            for (int i = 0, size = buf.length; i < size; i++) {
                sb.delete(0, sb.length());
                sb.append(rowNames.get(i));
                for (int j = 0, size2 = buf[i].length; j < size2; j++) {
                    sb.append("," + buf[i][j]);
                }
                bw.println(sb.toString());
            }
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     *  This is for book production only: print out training matrices in a Latex type format
     *  so that the matrices can be inserted into my manuscript:

   \begin{table}[htdp]
\caption{Runtimes by Method}
\centering

\begin{tabular}{|l|l|l|}
\hline
\textbf{Class.method name}&\textbf{Percent of total runtime}&\textbf{Percent in this method}\\
\hline
Chess.main&97.7&0.0\\
GameSearch.playGame&96.5&0.0\\

Chess.calcPieceMoves&1.7&0.8\\
\hline
\end{tabular}
   
\label{tab:runtimes_by_method}
\end{table}
   
     */
    private void WriteLatexFile(List<String> rowNames, List<String> colNames, float[][] buf, String fileName) {
        p("tagList.size()="+tagList.size());
        int SKIP = 6;
        try {
            FileWriter fw = new FileWriter(fileName + ".latex");
            PrintWriter bw = new PrintWriter(new BufferedWriter(fw));
            int size = colNames.size() - SKIP;
            bw.print("\\begin{table*}[htdp]\n\\caption{ADD CAPTION}\\centering\\begin{tabular}{|");
            for (int i = 0; i < size+1; i++) bw.print("l|");
            bw.println("}\n\\hline");
            bw.print(" &");
            for (int i = 0; i < size; i++) {
              bw.print("\\emph{" + colNames.get(i)+"}");
              if (i < (size-1)) bw.print("&");
            }
            bw.println("\\\\\n\\hline");
            
//bw.printf(format, args)
            // loop on remaining rows:
            for (int i = 0, size3 = buf.length - SKIP; i < size3; i++) {
                bw.print(rowNames.get(i)+"&");
                for (int j = 0, size2 = buf[i].length - SKIP; j < size2; j++) {
                    bw.printf("%.2f",buf[i][j]);
                    if (j < (size2-1)) bw.print("&");
                }
                bw.println("\\\\");
            }
            bw.println("\\hline\n\\end{tabular}\n\\label{tab:CHANGE_THIS_LABEL}\n\\end{table*}");
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     *  Train a Markov model using manually tagged input text
     */
    public void train_model() {
        // start by filling in the tag to tag transition count matrix:
        tagToTagTransitionCount = new float[uniqueTagCount][uniqueTagCount];
        p("tagCount="+tagCount);
        p("uniqueTagCount="+uniqueTagCount);
        for (int i = 0; i < uniqueTagCount; i++) {
            for (int j = 0; j < uniqueTagCount; j++) {
                tagToTagTransitionCount[i][j] = 0;
            }
        }
        String tag1 = (String) tagList.get(0);
        int index1 = uniqueTags.indexOf(tag1);           // inefficient!
        int index0;
        for (int i = 0, size1 = wordList.size() - 1; i < size1; i++) {
            index0 = index1;
            tag1 = (String) tagList.get(i + 1);
            index1 = uniqueTags.indexOf(tag1);           // inefficient
            tagToTagTransitionCount[index0][index1]++;
        }
        WriteCSVfile(uniqueTags, uniqueTags, tagToTagTransitionCount, "tag_to_tag");
        WriteLatexFile(uniqueTags, uniqueTags, tagToTagTransitionCount, "tag_to_tag");
        // now calculate the probabilities of transitioning from tagN to tagM:
        probabilityTag1ToTag2 = new float[uniqueTagCount][uniqueTagCount];
        for (int i = 0; i < uniqueTagCount; i++) {
            int count = ((Integer)tags.get((String)uniqueTags.get(i))).intValue();
            p("tag: " + uniqueTags.get(i) + ", count="+count);
            for (int j = 0; j < uniqueTagCount; j++) {
                probabilityTag1ToTag2[i][j] = 0.0001f + tagToTagTransitionCount[i][j] / (float)count;
            }
        }
        WriteCSVfile(uniqueTags, uniqueTags, probabilityTag1ToTag2, "test_data/markov/prob_tag_to_tag");
        WriteLatexFile(uniqueTags, uniqueTags, probabilityTag1ToTag2, "test_data/markov/prob_tag_to_tag");
        // now calculate the probability of a word, given a proceeding tag:
        probabilityWordGivenTag = new float[uniqueWordCount][uniqueTagCount];
        for (int i = 0; i < uniqueWordCount; i++) {
            String word = uniqueWords.get(i);
            for (int j = 0; j < uniqueTagCount; j++) {
                String tag = uniqueTags.get(j);
                // note: index of tag is one less than index of emitted word we are testing:
                int countTagOccurence = tags.get(tag);
                float wordWithTagOccurence = 0;
                for (int n=0, sizem1=wordList.size()-1; n<sizem1; n++) {
                    String testWord = wordList.get(n);
                    String testTag  = tagList.get(n);
                    if (testWord.equals(word) && testTag.equals(tag)) {
                        wordWithTagOccurence++;
                    }
                }
                probabilityWordGivenTag[i][j] = wordWithTagOccurence / (float)countTagOccurence;
            }
        }
        WriteLatexFile(uniqueWords, uniqueTags, probabilityWordGivenTag, "test_data/markov/prob_word_given_tag");
        WriteCSVfile(uniqueWords, uniqueTags, probabilityWordGivenTag, "test_data/markov/prob_word_given_tag");
    }

    // data for exponential method of evaluating most probable tags for a sequence of words:
    int [] indices;
    int [] counts;
    ArrayList<ArrayList<String>> possibleTags;

    /**
     *  Increment the class variable indices[] to point to the next possible set of tags
     *  to check.
     */
    private boolean incrementIndices(int num) { // uses the global arrays indices and counts
        for (int i=0; i<num; i++) {
            if (indices[i] < (counts[i] - 1)) {
                indices[i] += 1;
                for (int j=0; j<i; j++) {
                    indices[j] = 0;
                }
                return true;
            }
        }
        return false;
    }

    /**
     *  For a sequence of words, values of class variable indices[], and class variable
     *  possibleTags, evaluate how well tags rate using equation 10.7 in [Manning/Schutze, 1999]
     */
    float score(List<String> words) { // uses global variables
        float s = 1.0f;
        int num = words.size();
        float prob_tag_i_given_tag_i_minus_1 = 1.0f;
        for (int i=0; i<num; i++) {
            System.out.println("words["+i+"]="+words.get(i));
            //int tag_index = indices[i];
            if (i > 0) {
                List<String> v0 = possibleTags.get(i - 1);
                List<String> v1 = possibleTags.get(i);
                int index1 = uniqueTags.indexOf(v0.get(indices[i - 1]));
                int index2 = uniqueTags.indexOf(v1.get(indices[i]));
                System.out.println("index1="+index1+"[tag: "+uniqueTags.get(index1)+"], index2="+index2
                            +"[tag: "+uniqueTags.get(index2)+"]");
                prob_tag_i_given_tag_i_minus_1 = probabilityTag1ToTag2[index1][index2];
                int index3 = uniqueWords.indexOf("" + words.get(i));
                float p = probabilityWordGivenTag[index3][index2];
                System.out.println("word: " + words.get(i) + ", p="+p);
                prob_tag_i_given_tag_i_minus_1 *= p;
            }
            s *= prob_tag_i_given_tag_i_minus_1;
        }
        return s;
    }

    /**
     *  Use exponential runtime tagging algorithm (evaluates trained Markov model).
     *  NOTE: do not use this algorithm for long input word sequences - instead,
     *  break up long sequences of text into smaller pieces (i.e., process just
     *  a few sentences at a time).
     */
    public List<String> exponential_tagging_algorithm(List<String> words) {
        possibleTags = new ArrayList<ArrayList<String>>();
        int num = words.size();
        indices = new int[num];
        counts = new int[num];
        int [] best_indices = new int[num];
        for (int i=0; i<num; i++) { indices[i] = 0; counts[i] = 0;}
        for (int i=0; i<num; i++) {
            String word = "" + words.get(i);
            List<String> v = lexicon.get(word);
            ArrayList<String> v2 = new ArrayList<String>();  // possible tags at index i
            for (int j=0; j<v.size(); j++) {
                String tag = "" + v.get(j);
                if (v2.contains(tag) == false)   { v2.add(tag);  counts[i]++; }
            }

            possibleTags.add(v2);      // possible tags at index i
            System.out.print("^^ word: " + word + ", tag count: " + counts[i] + ", tags: ");
            for (int j=0; j<v2.size(); j++) System.out.print(" " + v2.get(j));
            System.out.println();
        }
        float best_score = -9999;
        do {
            System.out.print("Current indices:");
            for (int k=0; k<num; k++) System.out.print(" " + indices[k]);
            System.out.println();
            float score = score(words);
            if (score > best_score) {
                best_score = score;
                System.out.println(" **  ** new best score: " + best_score);
                for (int m=0; m<num; m++) best_indices[m] = indices[m];
            }
        } while (incrementIndices(num));

        List<String> tags = new ArrayList<String>(num);
        for (int i=0; i<num; i++) {
            List<String> v = possibleTags.get(i);
            tags.add(v.get(best_indices[i]));
        }
        return tags;
    }

    /**
     *   Throw away test method.
     */
    public void test_model() {
        List<String> words = new ArrayList<String>();     words.add(".");
        words.add("the"); words.add("dog"); words.add("chased"); words.add("the"); words.add("cat"); words.add(".");
        words.add("mary"); words.add("went"); words.add("to"); words.add("the"); words.add("river"); words.add(".");
        words.add("john"); words.add("saw"); words.add("mary"); words.add("bank"); words.add("the");
        words.add("airplane"); words.add(".");
        List<String> tags = exponential_tagging_algorithm(words);
        p("");
        for (int i=0; i<words.size()-1; i++) {
            p(""+words.get(i)+"\t: "+tags.get(i));
        }
    }

    /**
     *  Utility print method - with line feed
     */
    public void p(String s) {
        System.out.println(s);
    }

    /**
     *  Utility print method - no line feed
     */
    public void p0(String s) {
        System.out.print(s);
    }

    Map<String,List<String>> lexicon = new Hashtable<String,List<String>>();
    Map<String, Integer> tags = new Hashtable<String, Integer>();
    Map<String, Integer> words = new Hashtable<String, Integer>();
    List<String> uniqueTags = new ArrayList<String>();
    List<String> uniqueWords = new ArrayList<String>();
    int uniqueTagCount;
    int uniqueWordCount;
    //String [] tagNames;
    int tagCount = 0;                  // from training text
    int wordCount = 0;                 // from training text
    List<String> wordList = new ArrayList<String>();    // from training text
    List<String> tagList = new ArrayList<String>();     // from training text
    float[][] tagToTagTransitionCount;      // [num_tag][num_tag]
    int[][] wordCountByTag;
    float [][]probabilityTag1ToTag2;
    float [][]probabilityWordGivenTag;


}
