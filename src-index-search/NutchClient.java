import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * Nutch client
 *
 * <p/>
 * Copyright 1996-2012 by Mark Watson. All rights reserved.
 * <p/>
 * This software is can be used under either of the following licenses:
 * <p/>
 * 1. LGPL v3<br/>
 * 2. Apache 2
 * <p/>
 */
public class NutchClient {

  static public List<Hashtable<String,String>> searchGetCache(String opensearch_url, String query) throws IOException, ParserConfigurationException, SAXException {
    return search_helper(opensearch_url, query, true);
  }
  
  static public List<Hashtable<String,String>> search(String opensearch_url, String query) throws IOException, ParserConfigurationException, SAXException {
    return search_helper(opensearch_url, query, false);
  }
  
  static private List<Hashtable<String,String>> search_helper(String opensearch_url, String query, boolean return_cache) throws IOException, ParserConfigurationException, SAXException {
    List<Hashtable<String,String>> ret = new ArrayList<Hashtable<String,String>>();
    String url_str = opensearch_url + "?query=" + URLEncoder.encode(query, "UTF-8");
    System.out.println(url_str);
    URL url = new URL(url_str);
    URLConnection uc = url.openConnection();
    BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
    DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc  = docBuilder.parse(bis);
    doc.getDocumentElement().normalize();
    System.out.println( doc.getDocumentElement().getTagName());
    NodeList listItems = doc.getElementsByTagName("item");
    int numItems = listItems.getLength();
    for (int i=0; i<numItems; i++) {
      Node item = listItems.item(i);
      //System.out.println("\nStart of new item in RSS 2.0 XML stream:");
      Hashtable<String,String> new_item = new Hashtable<String,String>();
      ret.add(new_item);
      NodeList item_data = item.getChildNodes();
      int num = item_data.getLength();
      for (int n=0; n<num; n++) {
        Node data = item_data.item(n);
        String name = data.getNodeName();
        if (name.equals("title") || name.equals("description") ||
            name.equals("link")) {
          new_item.put(name, data.getTextContent());
        }
        if (name.equals("nutch:cache")) {
          new_item.put("cache_uri", data.getTextContent());
        }
        // debug printout:
        //if (!name.equals("#text")) {
        //  String text = data.getTextContent();
        //  System.out.println(name + ": " + text);
        //}
      }
      if (return_cache && new_item.get("cache_uri")!=null) {
        new_item.put("cache_content", getCacheContent(new_item.get("cache_uri")));
      }
    }
    return ret;
  }
  
  static public String getCacheContent(String cache_uri) throws IOException {
    URL url = new URL(cache_uri);
    URLConnection uc = url.openConnection();
    return new Scanner(uc.getInputStream()). useDelimiter("\\Z").next();
  }
  
  /**
   * @param args
   * @throws IOException 
   * @throws ParserConfigurationException 
   * @throws SAXException 
   */
  public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
    long t1 = System.currentTimeMillis();
    List<Hashtable<String,String>> results =
      NutchClient.search("http://localhost:8080/opensearch", "Java AI");
      //NutchClient.searchGetCache("http://localhost:8080/opensearch", "Java RDF");
    long t2 = System.currentTimeMillis();
    System.out.println("results: " + results);
    System.out.println(" Time in milliseconds for web service call: " + (t2 - t1));
    System.out.println(results.get(0));
    System.out.println(results.get(1));
  }

}
