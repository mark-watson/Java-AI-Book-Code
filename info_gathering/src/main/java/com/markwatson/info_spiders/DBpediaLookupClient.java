package com.markwatson.info_spiders;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.*;

/**
 * Copyright Mark Watson 2008-2020. All Rights Reserved.
 * License: Apache-2.0
 */

// Use Georgi Kobilarov's DBpedia lookup web service
//    ref: http://lookup.dbpedia.org/api/search.asmx?op=KeywordSearch
//    example: http://lookup.dbpedia.org/api/search.asmx/KeywordSearch?QueryString=Flagstaff&QueryClass=XML&MaxHits=10

/**
 * Searches return results that contain any of the search terms. I am going to filter
 * the results to ignore results that do not contain all search terms.
 */


public class DBpediaLookupClient extends DefaultHandler {
  public DBpediaLookupClient(String query) throws Exception {
    this.query = query;
    System.out.println("\n query: " + query);
    CloseableHttpClient client = HttpClients.createDefault();

    String query2 = query.replaceAll(" ", "+"); // URLEncoder.encode(query, "utf-8");
    System.out.println("\n query2: " + query2);
/*
    HttpGet request = new HttpGet("http://lookup.dbpedia.org/api/search.asmx/KeywordSearch?QueryString=" +
        query2);

    // add request headers
    request.addHeader("custom-key", "mkyong");
    request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

    CloseableHttpResponse response = client.execute(request);
    HttpEntity entity = response.getEntity();
    if (entity != null) {
      // return it as a String
      String result = EntityUtils.toString(entity);
      System.out.println(result);
    }
*/
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser sax = factory.newSAXParser();
    sax.parse("http://lookup.dbpedia.org/api/search.asmx/KeywordSearch?QueryString=" +
        query2, this);

  }

  private List<Map<String, String>> variableBindings = new ArrayList<Map<String, String>>();
  private Map<String, String> tempBinding = null;
  private String lastElementName = null;

  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    //System.out.println("startElement " + qName);
    if (qName.equalsIgnoreCase("result")) {
      tempBinding = new HashMap<String, String>();
    }
    lastElementName = qName;
  }

  public void endElement(String uri, String localName, String qName) throws SAXException {
    //System.out.println("endElement " + qName);
    if (qName.equalsIgnoreCase("result")) {
      if (!variableBindings.contains(tempBinding) && containsSearchTerms(tempBinding))
        variableBindings.add(tempBinding);
    }
  }

  public void characters(char[] ch, int start, int length) throws SAXException {
    String s = new String(ch, start, length).trim();
    //System.out.println("characters (lastElementName='" + lastElementName + "'): " + s);
    if (s.length() > 0) {
      if ("Description".equals(lastElementName)) {
        if (tempBinding.get("Description") == null) {
          tempBinding.put("Description", s);
        }
        tempBinding.put("Description", "" + tempBinding.get("Description") + " " + s);
      }
      //if ("URI".equals(lastElementName)) tempBinding.put("URI", s);
      if ("URI".equals(lastElementName) && s.indexOf("Category")==-1 && tempBinding.get("URI") == null) {
        tempBinding.put("URI", s);
      }
      if ("Label".equals(lastElementName)) tempBinding.put("Label", s);
    }
  }

  public List<Map<String, String>> variableBindings() {
    return variableBindings;
  }
  private boolean containsSearchTerms(Map<String, String> bindings) {
    StringBuilder sb = new StringBuilder();
    for (String value : bindings.values()) sb.append(value);  // do not need white space
    String text = sb.toString().toLowerCase();
    StringTokenizer st = new StringTokenizer(this.query);
    while (st.hasMoreTokens()) {
      if (text.indexOf(st.nextToken().toLowerCase()) == -1) {
        return false;
      }
    }
    return true;
  }
  private String query = "";
}