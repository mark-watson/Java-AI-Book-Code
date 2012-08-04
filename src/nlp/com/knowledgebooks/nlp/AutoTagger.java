package nlp.com.knowledgebooks.nlp;

import nlp.public_domain.Stemmer;
import java.io.FileInputStream;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import nlp.com.knowledgebooks.nlp.util.NameValue;

/**
 * Associate pre-trained classification categories (tags) with input text: assigns
 * categories for news story types, technology category types, social information
 * types, etc. to input text.
 *
 * <p/>
 * Copyright 1998-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */
public class AutoTagger {
    private static Hashtable<String, Hashtable<String, Float>> tagClasses;
    private static String[] tagClassNames;
    private static List<Hashtable<String, Float>> hashes = new ArrayList<Hashtable<String, Float>>();
    /**
     * 
     * Static initialization of data from an XML file that contains
     * word count statistics for several common topics
     * 
     */
    static {
        DefaultHandler handler = new TagsSAXHandler();        
        SAXParserFactory factory = SAXParserFactory.newInstance();  // Use the default non-validating parser
        try {
            FileInputStream  xml_input_stream = new FileInputStream(System.getProperty("user.dir") + "/" + "test_data/classification_tags.xml");
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(xml_input_stream, handler );
        } catch (Throwable t) {
            t.printStackTrace();
        }
        tagClassNames = new String[tagClasses.size()];
        int count = 0;
        for (Enumeration<String> e = tagClasses.keys() ; e.hasMoreElements() ;) {
            String cname = e.nextElement();
            System.out.println("cname="+cname);
            hashes.add(tagClasses.get(cname));
            tagClassNames[count++] = cname;
        }
        tagClasses = null;
    }

    public AutoTagger() {
    }
    
    public List<NameValue<String, Float>> getTags(String text) {
    	List<NameValue<String, Float>> results = new ArrayList<NameValue<String, Float>>();
        List<SFtriple> tag_data = getTagsHelper(text);
        for (SFtriple triple : tag_data) {
        	results.add(new NameValue<String,Float>(triple.getS(), triple.getF()));
        }
    	return results;
    }
    
    /**
     * 
     * @param text input text processed to identify categories
     * @return
     */
    private List<SFtriple> getTagsHelper(String text) {
        Stemmer stemmer = new Stemmer();
        List<String> stems = stemmer.stemString(text);
        return getTagsHelper(stems);
    }

    /**
     * 
     * @param stems
     * @return
     */
    private List<SFtriple> getTagsHelper(List<String> stems) {
        List<SFtriple> ret = new ArrayList<SFtriple>();
        int size = tagClassNames.length;
        float[] scores = new float[size];
        for (String stem : stems) {
            for (int i = 0; i < size; i++) {
                Float f = hashes.get(i).get(stem);
                if (f != null) scores[i] += f;
            }
        }
        float max_score=0.001f;
        for (int i=0; i<size; i++) if (max_score < scores[i]) max_score = scores[i];
        float cutoff = 0.2f * max_score;
        for (int i=0; i<size; i++) {
            if (scores[i] > cutoff) ret.add(new SFtriple(tagClassNames[i], scores[i]/max_score, i));
        }
        //for (int i=0; i<size; i++) System.out.println(tagClassNames[i]+"\t"+scores[i]);
        Collections.sort(ret, new SFtripleComparator());
        return ret;
    }

    class SFtripleComparator implements Comparator<SFtriple> {
        public int compare(SFtriple o1, SFtriple o2) {
            return  (int) (1000 * (o2.getF() - o1.getF()));
        }
    }
    
    /**
     * 
     * @param text
     * @return
     */
    float[] getWordImportanceWeights(String text) {
        List<String> stems = new Stemmer().stemString(text);
        List<SFtriple> best_tags = getTagsHelper(stems);
        return getWordImportanceWeights(stems, best_tags);
    }
    /**
     * 
     * @param stems
     * @return
     */
    float[] getWordImportanceWeights(List<String> stems) {
        List<SFtriple> best_tags = getTagsHelper(stems);
        return getWordImportanceWeights(stems, best_tags);
    }
    /**
     * Find the words that are most important for determining tags and use
     * this information to find which words in input text are most important for
     * summarization, semantic understanding, etc.
     * @param stems  stems for words in text
     * @param best_tags  the best tags for this text
     * @return
     */
    private float[] getWordImportanceWeights(List<String> stems, List<SFtriple> best_tags) {
        int num = stems.size();
        float[] ret = new float[num];
        float scale = 1.0f / best_tags.size();
        for (SFtriple tag : best_tags) {
            Hashtable<String, Float> h = hashes.get(tag.getTopic_index());
            for (int i=0; i<num; i++) {
                Float f = h.get(stems.get(i));
                if (f!=null) ret[i] += h.get(stems.get(i)) * scale;
            }
        }
        return ret;
    }
    
    /**
     * Test program
     * 
     * @param args not used
     */
    public static void main(String[] args) {
    	AutoTagger test = new AutoTagger();
    	List<NameValue<String, Float>> results = test.getTags("The President went to Congress to argue for his tax bill before leaving on a vacation to Las Vegas to see some shows and gamble.");
    	for (NameValue<String, Float> result : results) {
    		System.out.println(result);
    	}
    }

    static class TagsSAXHandler extends org.xml.sax.helpers.DefaultHandler {
        int depth = 0;
        String last_topic="";
        Hashtable <String, Float>hash;
        // override default methods for a few SAX events:
        @Override
        public void startElement (String uri, String localName,
                                  String qName, Attributes attributes)
            throws SAXException
        {
            if (depth==0) {
                tagClasses = new Hashtable<String, Hashtable<String, Float>>();
            }
            if (depth==1)  {
                last_topic=attributes.getValue(0);
                hash = new Hashtable<String, Float>();
                tagClasses.put(last_topic, hash);
            }
            if (depth==2) {
                hash.put(attributes.getValue(0), Float.parseFloat(attributes.getValue(1)));
            }

            // debug:
            /*for (int i=0; i<depth; i++) System.out.print("   ");
            System.out.println("" + depth + " element: " + qName);
            if (attributes != null) {
                int num = attributes.getLength();
                for (int i=0; i<num; i++) {
                    String name = attributes.getQName(i);
                    String value = attributes.getValue(i);
                    for (int k=0; k<depth; k++) System.out.print("   ");
                    System.out.println("    attribute: " + name + " value: " + value);
                }
            }*/


            depth++;
        }
        @Override
        public void endElement (String uri, String localName, String qName)
            throws SAXException
        {
            depth--;
        }
        @Override
        public void characters (char ch[], int start, int length)
            throws SAXException
        {
        }
    }
    
    class SFtriple implements Comparable {

        public SFtriple(String s, float f, int topic_index) { this.s = s; this.f = f; this.topic_index = topic_index; }

        public String toString() { return "[SFtriple: "+s + " : " + f + " : " + topic_index + "]"; }

        public int compareTo(Object o) {
            return (int)(1000f*(((SFtriple)o).getF() - f));
        }

        private String s;
        private float f;
        private int topic_index;

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        public float getF() {
            return f;
        }

        public void setF(float f) {
            this.f = f;
        }

        public int getTopic_index() {
            return topic_index;
        }

        public void setTopic_index(int topic_index) {
            this.topic_index = topic_index;
        }
    }

}

