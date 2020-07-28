package com.markwatson.nlp;

import com.markwatson.nlp.util.NoiseWords;
import public_domain.Stemmer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class stores stem count data for words in a document and provides
 * an API to compare the similarity between this document and another.
 * 
 * @author Mark Watson
 *
 * <p/>
 * Copyright 1998-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 *
 */
public class ComparableDocument {
	private ComparableDocument() { } // disable default constructor calls
	public ComparableDocument(File document) throws FileNotFoundException {
		this(new Scanner(document).useDelimiter("\\Z").next());
	}
	public ComparableDocument(String text) {
		// System.out.println("text:\n\n" + text + "\n\n");
		List<String> stems = new Stemmer().stemString(text);
		for (String stem : stems) {
			if (!NoiseWords.checkFor(stem)) {
				stem_count++;
				if (stemCountMap.containsKey(stem)) {
					Integer count = stemCountMap.get(stem);
					stemCountMap.put(stem, 1 + count);
				} else {
					stemCountMap.put(stem, 1);
				}
			}
			// System.out.println(stem + " : " + stemCountMap.get(stem));
		}
	}
	public Map<String, Integer> getStemMap() { return stemCountMap; }
	public int getStemCount() { return stem_count; }
	public float compareTo(ComparableDocument otherDocument) {
		long count = 0;
		Map<String, Integer> map2 = otherDocument.getStemMap();
		Iterator<String> iter = stemCountMap.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Integer count1 = stemCountMap.get(key);
			Integer count2 = map2.get(key);
			
			if (count1!=null && count2!=null) {
				count += count1 + count2;
				//System.out.println(key);
			}
		} 
		//System.out.println("stem_count="+stem_count);
		return (float) Math.sqrt(((float)(count*count) / (double)(stem_count * otherDocument.getStemCount()))) / 2f;
	}
	private Map<String, Integer> stemCountMap = new HashMap<String, Integer>();
    private int stem_count = 0;
    // throw away test program:
    public static void main(String[] args) throws FileNotFoundException {
    	ComparableDocument news1 = new ComparableDocument(new File("test_data/news_1.txt"));
    	ComparableDocument news2 = new ComparableDocument(new File("test_data/news_2.txt"));
    	ComparableDocument econ1 = new ComparableDocument(new File("test_data/economy_1.txt"));
    	ComparableDocument econ2 = new ComparableDocument(new File("test_data/economy_2.txt"));
    	System.out.println("news 1 - news1: " + news1.compareTo(news1));
    	System.out.println("news 1 - news2: " + news1.compareTo(news2));
    	System.out.println("news 2 - news2: " + news2.compareTo(news2));
    	System.out.println("news 1 - econ1: " + news1.compareTo(econ1));
    	System.out.println("econ 1 - econ1: " + econ1.compareTo(econ1));
    	System.out.println("news 1 - econ2: " + news1.compareTo(econ2));
    	System.out.println("news 2 - econ2: " + news2.compareTo(econ2));
    	System.out.println("econ 1 - econ2: " + econ1.compareTo(econ2));
    	System.out.println("econ 2 - econ2: " + econ2.compareTo(econ2));
    }
}


