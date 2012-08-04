package textsearch;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.store.LockObtainFailedException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper class for an embedded Lucene index to support.
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

public class LuceneManager {

  private String data_store_file_root;

  /**
   * 
   * @param data_store_file_root
   */
  public LuceneManager(String data_store_file_root) {
      this.data_store_file_root = data_store_file_root;
  }
  
  /**
   * If you want to start with a fresh index, call this method immediately
   * after creating a new instance of a LuceneManager.
   * @throws IOException 
   * @throws LockObtainFailedException 
   * @throws CorruptIndexException 
   * 
   */
  public void createAndClearLuceneIndex() throws CorruptIndexException, LockObtainFailedException, IOException {
    deleteFilePath(new File(data_store_file_root + "/lucene_index"));
    File index_dir = new File(data_store_file_root + "/lucene_index");
    new IndexWriter(index_dir, new StandardAnalyzer(), true).close();
  }
  
  /**
   * 
   * @throws java.io.IOException
   */
  public void close() throws IOException {
      reader.close();
      writer.close();
  }
  /**
   * 
   * @param document_original_uri
   * @param document_plain_text
   * @throws org.apache.lucene.index.CorruptIndexException
   * @throws java.io.IOException
   */
  public void addDocumentToIndex(String document_original_uri, String document_plain_text) throws CorruptIndexException, IOException {
      File index_dir = new File(data_store_file_root + "/lucene_index");
      writer = new IndexWriter(index_dir, new StandardAnalyzer(), false);
      Document doc = new Document();
      doc.add(new Field("uri", document_original_uri, Field.Store.YES, Field.Index.NO));
      doc.add(new Field("text", document_plain_text, Field.Store.YES, Field.Index.TOKENIZED));
      writer.addDocument(doc);
      writer.optimize();
      writer.close();
  }
  /**
   * 
   * @param search_query
   * @return
   * @throws org.apache.lucene.queryParser.ParseException
   * @throws java.io.IOException
   */
  public List<String> searchIndexForURIs(String search_query) throws ParseException, IOException {
      reader = IndexReader.open(data_store_file_root + "/lucene_index");
      List<String> ret = new ArrayList<String>();
      Searcher searcher = new IndexSearcher(reader);
      Analyzer analyzer = new StandardAnalyzer();
      QueryParser parser = new QueryParser("text", analyzer);
      Query query = parser.parse(search_query);
      Hits hits = searcher.search(query);
      for (int i = 0; i < hits.length(); i++) {
          System.out.println(" * * searchIndexForURIs: hit: " + hits.doc(i));
          Document doc = hits.doc(i);
          String uri = doc.get("uri");
          ret.add(uri);
      }
      reader.close();
      return ret;
  }
  /**
   * 
   * @param search_query
   * @return
   * @throws java.lang.Exception
   */
  public List<String[]> searchIndexForURIsAndDocText(String search_query) throws Exception {
      reader = IndexReader.open(data_store_file_root + "/lucene_index");
      List<String[]> ret = new ArrayList<String[]>();
      Searcher searcher = new IndexSearcher(reader);
      Analyzer analyzer = new StandardAnalyzer();
      QueryParser parser = new QueryParser("text", analyzer);
      Query query = parser.parse(search_query);
      System.out.println(" * * test query: " + search_query);
      Hits hits = searcher.search(query);
      for (int i = 0; i < hits.length(); i += 1) {
        Document doc = hits.doc(i);
        System.out.println("     * *  hit: " + hits.doc(i));
        String [] pair = new String[]{doc.get("uri"), doc.get("text")};
        ret.add(pair);
      }
      reader.close();
      return ret;
  }
  
  private static final String fileSeparator = System.getProperty("file.separator");
  
  private boolean deleteFilePath(File filePath) {
    System.out.println("deleteFile(" + filePath + ")");
    if (filePath == null) {
        return false;
    }

    if (filePath.isDirectory()) {
        String[] dirListing = filePath.list();

        // For each file/directory in listing, make recursive call.
        int len = dirListing.length;
        for (int i = 0; i < len; i++) {
            if (deleteFilePath(new File(filePath.toString() + fileSeparator + dirListing[i])) == false) {
                // Break and return an error.
                return false;
            }
        }
    }

    // Delete file or directory.
    if (filePath.delete() == false) {
        // Display message and return an error.
        System.out.println("Could not delete: " + filePath.getAbsolutePath());
        return false;
    }

    return true;
}

  private IndexWriter writer;
  private IndexReader reader;

  /**
   * @param args
   * @throws Throwable 
   */
  public static void main(String[] args) throws Throwable {
    LuceneManager lm = new LuceneManager("/tmp");
    // start fresh: create a new index:
    lm.createAndClearLuceneIndex();
    lm.addDocumentToIndex("file://tmp/test1.txt", "This is a test for index and a test for search.");
    lm.addDocumentToIndex("file://tmp/test2.txt", "Please test the index code.");
    lm.addDocumentToIndex("file://tmp/test3.txt", "Please test the index code before tomorrow.");
    // get URIs of matching documents:
    List<String> doc_uris = lm.searchIndexForURIs("test, index");
    System.out.println("Matched document URIs: " + doc_uris);
    // get URIs and document text for matching documents:
    List<String[]> doc_uris_with_text = lm.searchIndexForURIsAndDocText("test, index");
    for (String[] uri_and_text : doc_uris_with_text) {
      System.out.println("Matched document URI:  " + uri_and_text[0]);
      System.out.println("        document text: " + uri_and_text[1]);
    }
    
  }

}
