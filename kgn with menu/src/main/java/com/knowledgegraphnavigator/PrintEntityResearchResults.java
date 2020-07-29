package com.knowledgegraphnavigator;

import static com.knowledgegraphnavigator.Log.out;
import static com.knowledgegraphnavigator.Utils.removeBrackets;

import java.sql.SQLException;
import java.util.List;

public class PrintEntityResearchResults {

  /**
   * Note for Windows users: the Windows console may not render the following
   * ANSI terminal escape sequences correctly. If yo have problems, just
   * change the following to the empty string "":
   */
  public static final String RESET = "\u001B[0m"; // ANSI characters for styling
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";

  private PrintEntityResearchResults() { }

  public PrintEntityResearchResults(Sparql endpoint,
                                    List<EntityAndDescription> people,
                                    List<EntityAndDescription> companies,
                                    List<EntityAndDescription> cities,
                                    List<EntityAndDescription> countries)
      throws SQLException, ClassNotFoundException {
    out("\n" + GREEN + "Individual People:\n" + RESET);
    for (EntityAndDescription person : people) {
      out("  " + GREEN + String.format("%-25s", person.entityName) +
          PURPLE + " : " + removeBrackets(person.entityUri) + RESET);
      out(EntityDetail.personAsString(endpoint, person.entityUri));
    }
    out("\n" + CYAN + "Individual Companies:\n" + RESET);
    for (EntityAndDescription company : companies) {
      out("  " + CYAN + String.format("%-25s", company.entityName) +
          YELLOW + " : " + removeBrackets(company.entityUri) + RESET);
      out(EntityDetail.companyAsString(endpoint, company.entityUri));
    }
    out("\n" + GREEN + "Individual Cities:\n" + RESET);
    for (EntityAndDescription city : cities) {
      out("  " + GREEN + String.format("%-25s", city.entityName) +
          PURPLE + " : " + removeBrackets(city.entityUri) + RESET);
      out(EntityDetail.cityAsString(endpoint, city.entityUri));
    }
    out("\n" + GREEN + "Individual Countries:\n" + RESET);
    for (EntityAndDescription country : countries) {
      out("  " + GREEN + String.format("%-25s", country.entityName) +
          PURPLE + " : " + removeBrackets(country.entityUri) + RESET);
      out(EntityDetail.countryAsString(endpoint, country.entityUri));
    }
    out("");
  }
}
