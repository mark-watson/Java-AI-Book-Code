package com.markwatson.ner_dbpedia;

import java.util.ArrayList;
import java.util.List;

public class TextToDbpediaUris {
  private TextToDbpediaUris() {
  }

  public List<String> personUris = new ArrayList<String>();
  public List<String> personNames = new ArrayList<String>();
  public List<String> companyUris = new ArrayList<String>();
  public List<String> companyNames = new ArrayList<>();
  public List<String> cityUris = new ArrayList<>();
  public List<String> cityNames = new ArrayList<String>();
  public List<String> countryUris = new ArrayList<String>();
  public List<String> countryNames = new ArrayList<String>();

  public List<String> broadcastNetworkUris = new ArrayList<String>();
  public List<String> broadcastNetworkNames = new ArrayList<String>();

  public List<String> musicGroupUris = new ArrayList<String>();
  public List<String> musicGroupNames = new ArrayList<String>();

  public List<String> politicalPartyUris = new ArrayList<String>();
  public List<String> politicalPartyNames = new ArrayList<String>();

  public List<String> tradeUnionUris = new ArrayList<String>();
  public List<String> tradeUnionNames = new ArrayList<String>();

  public List<String> universityUris = new ArrayList<String>();
  public List<String> universityNames = new ArrayList<String>();

  public TextToDbpediaUris(String text) {
    String[] tokens = tokenize(text + " . . .");
    String uri = "";
    for (int i = 0, size = tokens.length - 2; i < size; i++) {
      String n2gram = tokens[i] + " " + tokens[i + 1];
      String n3gram = n2gram + " " + tokens[i + 2];
      // check for 3grams:
      if ((uri = NerMaps.personNames.get(n3gram)) != null) {
        log("person", i, i + 2, n3gram, uri);
        i += 2;
        continue;
      }
      if ((uri = NerMaps.cityNames.get(n3gram)) != null) {
        log("city", i, i + 2, n3gram, uri);
        i += 2;
        continue;
      }
      if ((uri = NerMaps.companyames.get(n3gram)) != null) {
        log("company", i, i + 2, n3gram, uri);
        i += 2;
        continue;
      }
      if ((uri = NerMaps.countryNames.get(n3gram)) != null) {
        log("country", i, i + 2, n3gram, uri);
        i += 2;
        continue;
      }
      if ((uri = NerMaps.broadcastNetworks.get(n3gram)) != null) {
        log("broadcastNetwork", i, i + 2, n3gram, uri);
        i += 2;
        continue;
      }
      if ((uri = NerMaps.politicalPartyNames.get(n3gram)) != null) {
        log("politicalParty", i, i + 2, n3gram, uri);
        i += 2;
        continue;
      }
      if ((uri = NerMaps.tradeUnionNames.get(n3gram)) != null) {
        log("tradeUnion", i, i + 2, n3gram, uri);
        i += 2;
        continue;
      }
      if ((uri = NerMaps.universityNames.get(n3gram)) != null) {
        log("unitersity", i, i + 2, n3gram, uri);
        i += 2;
        continue;
      }
      if ((uri = NerMaps.musicGroupNames.get(n3gram)) != null) {
        log("musicGroup", i, i + 2, n3gram, uri);
        i += 2;
        continue;
      }

      // check for 2grams:
      if ((uri = NerMaps.personNames.get(n2gram)) != null) {
        log("person", i, i + 1, n2gram, uri);
        i += 1;
        continue;
      }
      if ((uri = NerMaps.cityNames.get(n2gram)) != null) {
        log("city", i, i + 1, n2gram, uri);
        i += 1;
        continue;
      }
      if ((uri = NerMaps.companyames.get(n2gram)) != null) {
        log("company", i, i + 1, n2gram, uri);
        i += 1;
        continue;
      }
      if ((uri = NerMaps.countryNames.get(n2gram)) != null) {
        log("country", i, i + 1, n2gram, uri);
        i += 1;
        continue;
      }
      if ((uri = NerMaps.musicGroupNames.get(n2gram)) != null) {
        log("musicGroup", i, i + 1, n2gram, uri);
        i += 1;
        continue;
      }
      if ((uri = NerMaps.broadcastNetworks.get(n2gram)) != null) {
        log("broadCastNetwork", i, i + 1, n2gram, uri);
        i += 1;
        continue;
      }
      if ((uri = NerMaps.politicalPartyNames.get(n2gram)) != null) {
        log("politicalParty", i, i + 1, n2gram, uri);
        i += 1;
        continue;
      }
      if ((uri = NerMaps.tradeUnionNames.get(n2gram)) != null) {
        log("tradeUnion", i, i + 1, n2gram, uri);
        i += 1;
        continue;
      }
      if ((uri = NerMaps.universityNames.get(n2gram)) != null) {
        log("unitersity", i, i + 1, n2gram, uri);
        i += 1;
        continue;
      }

      // check for 1grams:
      if ((uri = NerMaps.personNames.get(tokens[i])) != null) {
        log("person", i, i + 1, tokens[i], uri);
        continue;
      }
      if ((uri = NerMaps.cityNames.get(tokens[i])) != null) {
        log("city", i, i + 1, tokens[i], uri);
        continue;
      }
      if ((uri = NerMaps.companyames.get(tokens[i])) != null) {
        log("company", i, i + 1, tokens[i], uri);
        continue;
      }
      if ((uri = NerMaps.countryNames.get(tokens[i])) != null) {
        log("country", i, i + 1, tokens[i], uri);
        continue;
      }
      if ((uri = NerMaps.broadcastNetworks.get(tokens[i])) != null) {
        log("broadCastNetwork", i, i + 1, tokens[i], uri);
        continue;
      }
      if ((uri = NerMaps.musicGroupNames.get(tokens[i])) != null) {
        log("musicGroup", i, i + 1, tokens[i], uri);
        continue;
      }
      if ((uri = NerMaps.politicalPartyNames.get(tokens[i])) != null) {
        log("politicalParty", i, i + 1, tokens[i], uri);
        continue;
      }
      if ((uri = NerMaps.tradeUnionNames.get(tokens[i])) != null) {
        log("tradeUnion", i, i + 1, tokens[i], uri);
        continue;
      }
      if ((uri = NerMaps.universityNames.get(tokens[i])) != null) {
        log("unitersity", i, i + 1, tokens[i], uri);
      }
    }
  }

  public void log(String nerType, int index1, int index2, String ngram, String uri) {
    System.out.println(nerType + "\t" + index1 + "\t" + index2 + "\t" + ngram + "\t" + uri);
    if (!uri.startsWith("<")) uri = "<" + uri + ">";
    if (nerType.equals("person")) {
      if (!personUris.contains(uri)) {
        personUris.add(uri);
        personNames.add(ngram);
      }
    }
    if (nerType.equals("company")) {
      if (!this.companyUris.contains(uri)) {
        companyUris.add(uri);
        companyNames.add(ngram);
      }
    }
    if (nerType.equals("city")) {
      if (!cityUris.contains(uri)) {
        cityUris.add(uri);
        cityNames.add(ngram);
      }
    }
    if (nerType.equals("country")) {
      if (!countryUris.contains(uri)) {
        countryUris.add(uri);
        countryNames.add(ngram);
      }
    }
    if (nerType.equals("broadCastNetwork")) {
      if (!broadcastNetworkUris.contains(uri)) {
        broadcastNetworkUris.add(uri);
        broadcastNetworkNames.add(ngram);
      }
    }
    if (nerType.equals("musicGroup")) {
      if (!musicGroupUris.contains(uri)) {
        musicGroupUris.add(uri);
        musicGroupNames.add(ngram);
      }
    }
    if (nerType.equals("politicalParty")) {
      if (!politicalPartyUris.contains(uri)) {
        politicalPartyUris.add(uri);
        politicalPartyNames.add(ngram);
      }
    }
    if (nerType.equals("tradeUnion")) {
      if (!tradeUnionUris.contains(uri)) {
        tradeUnionUris.add(uri);
        tradeUnionNames.add(ngram);
      }
    }
    if (nerType.equals("university")) {
      if (!universityUris.contains(uri)) {
        universityUris.add(uri);
        universityNames.add(ngram);
      }
    }
  }

  private String[] tokenize(String s) {
    return s.replaceAll("\\.", " \\. ").replaceAll(",", " , ")
        .replaceAll("\\?", " ? ").replaceAll("\n", " ").replaceAll(";", " ; ").split(" ");
  }
}