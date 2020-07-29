package com.markwatson.web_scraping;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Examples of using jsoup
 */
public class MySitesExamples {

  public static void main(String[] args) throws Exception {
    Document doc = Jsoup.connect("https://markwatson.com")
        .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.0; rv:77.0) Gecko/20100101 Firefox/77.0")
        .timeout(2000).get();
    Elements newsHeadlines = doc.select("div p");
    for (Element element : newsHeadlines) {
      System.out.println(" next element text: " + element.text());
    }
    String all_page_text = doc.text();
    System.out.println("All text on web page:\n" + all_page_text);
    Elements anchors = doc.select("a[href]");
    for (Element anchor : anchors) {
      String uri = anchor.attr("href");
      System.out.println(" next anchor uri: " + uri);
      System.out.println(" next anchor text: " + anchor.text());
    }
    Elements absolute_uri_anchors = doc.select("a[href]");
    for (Element anchor : absolute_uri_anchors) {
      String uri = anchor.attr("abs:href");
      System.out.println(" next anchor absolute uri: " + uri);
      System.out.println(" next anchor absolute text: " + anchor.text());
    }

  }
}
