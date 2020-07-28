package com.knowledgegraphnavigator;

import com.markwatson.ner_dbpedia.TextToDbpediaUris;
import com.markwatson.semanticweb.QueryResult;

import static com.knowledgegraphnavigator.Log.out;
import static com.knowledgegraphnavigator.Log.sparql;
import static com.knowledgegraphnavigator.Log.clearSparql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KGN {

  private static List<String> demosList =
      Arrays.asList(
          "Bill Gates and Melinda Gates worked at Microsoft",
          "IBM opened an office in Canada",
          "Steve Jobs worked at Apple Computer and visited IBM and Microsoft in Seattle");

  public KGN() throws Exception {
    Sparql endpoint = new Sparql();

    while (true) {
      String query = getUserQueryFromConsole();
      out("\nProcessing query:\n" + query + "\n");
      if (query.equalsIgnoreCase("sparql")) {
        out("Generated SPARQL used to get current results:\n");
        out(sparql.toString());
        out("\n");
        clearSparql();
      } else {
        if (query.equalsIgnoreCase("demo")) {
          query = demosList.get((int) (Math.random() * (demosList.size() + 1)));
        }
        TextToDbpediaUris kt = new TextToDbpediaUris(query);
        List<EntityAndDescription> userSelectedPeople = new ArrayList();
        if (kt.personNames.size() > 0) {
          for (int i = 0; i < kt.personNames.size(); i++) {
            userSelectedPeople.add(
                new EntityAndDescription(kt.personNames.get(i), kt.personUris.get(i)));
          }
        }
        List<EntityAndDescription> userSelectedCompanies = new ArrayList();
        if (kt.companyNames.size() > 0) {
          for (int i = 0; i < kt.companyNames.size(); i++) {
            userSelectedCompanies.add(
                new EntityAndDescription(kt.companyNames.get(i), kt.companyUris.get(i)));
          }
        }
        List<EntityAndDescription> userSelectedCities = new ArrayList();
        if (kt.cityNames.size() > 0) {
          out("+++++ kt.cityNames:" + kt.cityNames.toString());
          for (int i = 0; i < kt.cityNames.size(); i++) {
            userSelectedCities.add(
                new EntityAndDescription(kt.cityNames.get(i), kt.cityUris.get(i)));
          }
        }
        List<EntityAndDescription> userSelectedCountries = new ArrayList();
        if (kt.countryNames.size() > 0) {
          out("+++++ kt.countryNames:" + kt.countryNames.toString());
          for (int i = 0; i < kt.countryNames.size(); i++) {
            userSelectedCountries.add(
                new EntityAndDescription(kt.countryNames.get(i), kt.countryUris.get(i)));
          }
        }
        new PrintEntityResearchResults(endpoint,
            userSelectedPeople,
            userSelectedCompanies,
            userSelectedCities,
            userSelectedCountries);

        for (EntityAndDescription person1 : userSelectedPeople) {
          for (EntityAndDescription person2 : userSelectedPeople) {
            if (person1 != person2) {
              QueryResult qr = EntityRelationships.results(endpoint, person1.entityUri, person2.entityUri);
              if (qr.rows.size() > 0) {
                out("Relationships between person " + person1.entityName +
                    " person " + person2.entityName + ":");
                out(qr.toString());
              }
            }
          }
        }
        //  Bill Gates, Melinda Gates and Steve Jobs at Apple Computer, IBM and Microsoft in Seattle
        for (EntityAndDescription person : userSelectedPeople) {
          for (EntityAndDescription company : userSelectedCompanies) {
            QueryResult qr = EntityRelationships.results(endpoint, person.entityUri, company.entityUri);
            if (qr.rows.size() > 0) {
              out("Relationships between person " + person.entityName +
                  " company " + company.entityName + ":");
              out(qr.toString());
            }
          }
        }
        for (EntityAndDescription company1 : userSelectedCompanies) {
          for (EntityAndDescription company2 : userSelectedCompanies) {
            if (company1 != company2) {
              QueryResult qr = EntityRelationships.results(endpoint, company1.entityUri, company2.entityUri);
              if (qr.rows.size() > 0) {
                out("Relationships between company " + company1.entityName +
                    " company " + company2.entityName + ":");
                out(qr.toString());
              }
            }
          }
        }
      }
    }
  }

  private String getUserQueryFromConsole() {
    out("Enter entities query:");
    Scanner input = new Scanner(System.in);
    String ret = "";
    while (input.hasNext()) {
      ret = input.nextLine();
      break;
    }
    return ret;
  }

  public static void main(String[] args) throws Exception {
    new KGN();
  }
}
