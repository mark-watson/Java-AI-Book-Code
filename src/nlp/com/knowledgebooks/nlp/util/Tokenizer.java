// Copyright 2003-2008.  Mark Watson (markw@markwatson.com).  All rights reserved.
// This software is released under the LGPL (www.fsf.org)
// For an alternative non-GPL license: contact the author
// THIS SOFTWARE COMES WITH NO WARRANTY

package nlp.com.knowledgebooks.nlp.util;

import java.util.*;
import java.io.*;

/**
 *
 * <p/>
 * Copyright 2007 by Mark Watson. All rights reserved.
 * <p/>
 */
public class Tokenizer {
    /**
     * utility to tokenize an input string into an Array of Strings
     * @param s2 string containing words to tokenize
     * @return a List<String> of parsed tokens
     */
    static public List<String> wordsToList(String s2) {
        return wordsToList(s2, s2.length() + 1);
    }

    /**
     * utility to tokenize an input string into an Array of Strings - with a maximum # of returned words
     * @param s2 string containing words to tokenize
     * @param maxR maximum number of tokens to return
     * @return a List<String> of parsed tokens
     */
    static public List<String> wordsToList(String s2, int maxR) {
        s2 = stripControlCharacters(s2);
        List<String> words = new ArrayList<String>();
        String x;
        int count = 0;
        try {
            StreamTokenizer str_tok = new StreamTokenizer(new StringReader(s2));
            str_tok.whitespaceChars('"', '"');
            str_tok.whitespaceChars('\'', '\'');
            str_tok.whitespaceChars('/', '/');
            //str_tok.wordChars(':', ':');
            while (str_tok.nextToken() != StreamTokenizer.TT_EOF) {
                String s;
                switch (str_tok.ttype) {
                    case StreamTokenizer.TT_EOL:
                        s = ""; // we will ignore this
                        break;
                    case StreamTokenizer.TT_WORD:
                        s = str_tok.sval;
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        s = "" + (int) str_tok.nval; // .toString(); // we will ignore this

                        break;
                    default :
                        s = String.valueOf((char) str_tok.ttype);
                }
                if (s.length() < 1)
                    continue;
                //if (s.indexOf("-") > -1) continue;
                //s = s.toLowerCase();
                if (s.endsWith(".")) {
                    // first check for abreviations like "N.J.":
                    int index = s.indexOf(".");
                    if (index < (s.length() - 1)) {
                        words.add(s);
                    } else {
                        words.add(s.substring(0, s.length() - 1));
                        words.add(".");
                    }
                } else if (s.endsWith(",")) {
                    x = s.substring(0, s.length() - 1);
                    if (x.length() > 0) words.add(x);
                    words.add(",");
                } else if (s.endsWith(";")) {
                    x = s.substring(0, s.length() - 1);
                    if (x.length() > 0) words.add(x);
                    words.add(";");
                } else if (s.endsWith("?")) {
                    x = s.substring(0, s.length() - 1);
                    if (x.length() > 0) words.add(x);
                    words.add("?");
                } else if (s.endsWith(":")) {
                    x = s.substring(0, s.length() - 1);
                    if (x.length() > 0) words.add(x);
                    words.add(":");
                } else {
                    words.add(s);
                }
                if (++count >= maxR) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }

    static private String stripControlCharacters(String s) {
        StringBuffer sb = new StringBuffer(s.length() + 1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch > 256 || ch == '\n' || ch == '\t' || ch == '\r' || ch == 226) {
                sb.append(' ');
                continue;
            }
            //System.out.println(" ch: " + ch + " (int)ch: " + (int)ch + " Character.isISOControl(ch): " + Character.isISOControl(ch));
            if ((int) ch < 129)
                sb.append(ch);
            else
                sb.append(' ');
        }
        return sb.toString();
    }
    public static void main(String []args) {
    	String text = "The ball, rolling quickly, went down the hill.";
    	List<String> tokens = Tokenizer.wordsToList(text);
    	System.out.println(text);
    	for (String token : tokens) System.out.print("\""+token+"\" ");
    	System.out.println();
    }
}

