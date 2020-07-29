package com.markwatson.info_spiders;

import net.htmlparser.jericho.*;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * This simple web spider returns a list of lists, each containing two
 * strings representing "URL" and "text". Specifically, I do not return links on each page.
 */

/**
 * Copyright Mark Watson 2008-2020. All Rights Reserved.
 * License: Apache 2
 */

public class WebSpider {
  public WebSpider(String root_url, int max_returned_pages) throws Exception {
    String host = new URL(root_url).getHost();
    System.out.println("+ host: " + host);
    List<String> urls = new ArrayList<String>();
    Set<String> already_visited = new HashSet<String>();
    urls.add(root_url);
    int num_fetched = 0;
    while (num_fetched <= max_returned_pages && !urls.isEmpty()) {
      try {
        System.out.println("+ urls: " + urls);
        String url_str = urls.remove(0);
        System.out.println("+ url_str: " + url_str);
        //if (url_str.toLowerCase().indexOf(host) > -1 && url_str.indexOf("https:") == -1 && !already_visited.contains(url_str)) {
        if (url_str.toLowerCase().indexOf(host) > -1 && !already_visited.contains(url_str)) {
          already_visited.add(url_str);
          URL url = new URL(url_str);
          URLConnection connection = url.openConnection();
          connection.setAllowUserInteraction(false);
          InputStream ins = url.openStream();
          Source source = new Source(ins);
          num_fetched++;
          TextExtractor te = new TextExtractor(source);
          String text = te.toString();
          // Skip any pages where text on page is identical to existing
          // page (e.g., http://example.com and http://exaple.com/index.html
          boolean process = true;
          for (List<String> ls : url_content_lists) {
            if (text.equals(ls.get(1))) {
              process = false;
              break;
            }
          }
          if (process) {
            try {
              Thread.sleep(500);
            } catch (Exception ignore) {
            }
            List<StartTag> anchorTags = source.getAllStartTags("a ");
            ListIterator iter = anchorTags.listIterator();
            while (iter.hasNext()) {
              StartTag anchor = (StartTag) iter.next();
              Attributes attr = anchor.parseAttributes();
              Attribute link = attr.get("href");
              String link_str = link.getValue();
              if (link_str.indexOf("http:") == -1) {
                String path = url.getPath();
                if (path.endsWith("/")) path = path.substring(0, path.length() - 1);
                int index = path.lastIndexOf("/");
                if (index > -1) path = path.substring(0, index);
                link_str = url.getHost() + "/" + path + "/" + link_str;
                link_str = "http://" + link_str.replaceAll("///", "/").replaceAll("//", "/");
              }
              urls.add(link_str);
            }
            List<String> ls = new ArrayList<String>(2);
            ls.add(url_str);
            ls.add(text);
            url_content_lists.add(ls);
          }
        }
      } catch (Exception ex) {
        System.out.println("Error: " + ex);
        ex.printStackTrace();
      }
    }
  }

  public List<List<String>> url_content_lists = new ArrayList<List<String>>();
}
