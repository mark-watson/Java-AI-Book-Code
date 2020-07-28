package com.knowledgegraphnavigator;

import com.markwatson.ner_dbpedia.TextToDbpediaUris;
import com.markwatson.semanticweb.QueryResult;

import static com.knowledgegraphnavigator.Log.out;
import static com.knowledgegraphnavigator.Log.sparql;
import static com.knowledgegraphnavigator.Log.clearSparql;

import java.util.ArrayList;
import java.util.List;

public class KGN {

  public KGN() throws Exception {
    Sparql endpoint = new Sparql();

    ConsoleUserInterface console = new ConsoleUserInterface();

    while (true) {
      String query = "Canada"; // console.getUserQueryFromConsole();
      out("\nProcessing query:\n" + query + "\n");
      if (query.equalsIgnoreCase("sparql")) {
        out("Generated SPARQL used to get current results:\n");
        out(sparql.toString());
        out("\n");
        clearSparql();
      } else {
        TextToDbpediaUris kt = new TextToDbpediaUris(query);
        List<EntityAndDescription> userSelectedPeople = new ArrayList();
        List<EntityAndDescription> userSelectedCompanies = new ArrayList();
        List<EntityAndDescription> userSelectedCities = new ArrayList();
        List<EntityAndDescription> userSelectedCountries = new ArrayList();
        if (kt.personNames.size() > 0) {
          List<EntityAndDescription> entityAndDescriptionList = new ArrayList();
          for (int i = 0; i < kt.personNames.size(); i++) {
            entityAndDescriptionList.add(
                new EntityAndDescription(kt.personNames.get(i), kt.personUris.get(i)));
          }
          userSelectedPeople = console.selectUsingCheckBox(entityAndDescriptionList);
        }
        if (kt.companyNames.size() > 0) {
          List<EntityAndDescription> entityAndDescriptionList = new ArrayList();
          for (int i = 0; i < kt.companyNames.size(); i++) {
            entityAndDescriptionList.add(
                new EntityAndDescription(kt.companyNames.get(i), kt.companyUris.get(i)));
          }
          userSelectedCompanies = console.selectUsingCheckBox(entityAndDescriptionList);
        }
        if (kt.cityNames.size() > 0) {
          out("+++++ kt.cityNames:" + kt.cityNames.toString());
          List<EntityAndDescription> entityAndDescriptionList = new ArrayList();
          for (int i = 0; i < kt.cityNames.size(); i++) {
            entityAndDescriptionList.add(
                new EntityAndDescription(kt.cityNames.get(i), kt.cityUris.get(i)));
          }
          userSelectedCities = console.selectUsingCheckBox(entityAndDescriptionList);
        }
        if (kt.countryNames.size() > 0) {
          out("+++++ kt.countryNames:" + kt.countryNames.toString());
          List<EntityAndDescription> entityAndDescriptionList = new ArrayList();
          for (int i = 0; i < kt.countryNames.size(); i++) {
            entityAndDescriptionList.add(
                new EntityAndDescription(kt.countryNames.get(i), kt.countryUris.get(i)));
          }
          userSelectedCountries = console.selectUsingCheckBox(entityAndDescriptionList);
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

  public static void main(String[] args) throws Exception {
    new KGN();
  }
}
