package com.markwatson.ner_dbpedia;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * Copyright Mark Watson 2020. Apache 2 license,
 */
public class NerMaps {

  private static Collection<String> getResourcesFromJarFile(
      final File file,
      final Pattern pattern){
    final ArrayList<String> retval = new ArrayList<String>();
    ZipFile zf;
    try{
      zf = new ZipFile(file);
    } catch(final ZipException e){
      throw new Error(e);
    } catch(final IOException e){
      throw new Error(e);
    }
    final Enumeration e = zf.entries();
    while(e.hasMoreElements()){
      final ZipEntry ze = (ZipEntry) e.nextElement();
      final String fileName = ze.getName();
      final boolean accept = pattern.matcher(fileName).matches();
      if(accept){
        retval.add(fileName);
      }
    }
    try{
      zf.close();
    } catch(final IOException e1){
      throw new Error(e1);
    }
    return retval;
  }

  private static Collection<String> getResourcesFromDirectory(
      final File directory,
      final Pattern pattern){
    final ArrayList<String> retval = new ArrayList<String>();
    final File[] fileList = directory.listFiles();
    for(final File file : fileList){
      if(file.isDirectory()){
        retval.addAll(getResourcesFromDirectory(file, pattern));
      } else{
        try{
          final String fileName = file.getCanonicalPath();
          final boolean accept = pattern.matcher(fileName).matches();
          if(accept){
            retval.add(fileName);
          }
        } catch(final IOException e){
          throw new Error(e);
        }
      }
    }
    return retval;
  }



  private static String enforceAngleBrackets(String s) {
    if (s.startsWith("<")) return s;
    return "<" + s + ">";
  }
  private static Map<String, String> textFileToMap(String nerFileName) {
    Map<String, String> ret = new HashMap<String, String>();
    try {
      InputStream in = ClassLoader.getSystemResourceAsStream(nerFileName);
      BufferedReader reader = new BufferedReader(new InputStreamReader(in));
      List<String> lines = new ArrayList<String>();
      String line2;
      while((line2 = reader.readLine()) != null) {
        lines.add(line2);
      }
      reader.close();
      lines.forEach(line -> {
        String[] tokens = line.split("\t");
        if (tokens.length > 1) {
          ret.put(tokens[0], enforceAngleBrackets(tokens[1]));
        }
      });
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return ret;
  }

  static public final Map<String, String> broadcastNetworks = textFileToMap("BroadcastNetworkNamesDbPedia.txt");
  static public final Map<String, String> cityNames = textFileToMap("CityNamesDbpedia.txt");
  static public final Map<String, String> companyames = textFileToMap("CompanyNamesDbPedia.txt");
  static public final Map<String, String> countryNames = textFileToMap("CountryNamesDbpedia.txt");
  static public final Map<String, String> musicGroupNames = textFileToMap("MusicGroupNamesDbPedia.txt");
  static public final Map<String, String> personNames = textFileToMap("PeopleDbPedia.txt");
  static public final Map<String, String> politicalPartyNames = textFileToMap("PoliticalPartyNamesDbPedia.txt");
  static public final Map<String, String> tradeUnionNames = textFileToMap("TradeUnionNamesDbPedia.txt");
  static public final Map<String, String> universityNames = textFileToMap("UniversityNamesDbPedia.txt");

  public static void main(String[] args) throws IOException {
    System.out.println(
        new NerMaps().textFileToMap("CityNamesDbpedia.txt"));
  }
}
