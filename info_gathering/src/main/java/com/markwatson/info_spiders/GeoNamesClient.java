package com.markwatson.info_spiders;

import org.geonames.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright Mark Watson 2008-2020. All Rights Reserved.
 * License: Apache 2
 */

// You will need a free GeoNames account. Sign up:  https://www.geonames.org/login
// Then, set an environment variable: export GEONAMES=your-geonames-account-name

public class GeoNamesClient {
  public GeoNamesClient() {
  }

  private List<GeoNameData> helper(String name, String type) throws Exception {
    List<GeoNameData> ret = new ArrayList<GeoNameData>();

    String geonames_account_name = System.getenv("GEONAMES");
    if (geonames_account_name == null) {
      System.err.println("You will need a free GeoNames account.");
      System.err.println("Sign up:  https://www.geonames.org/login");
      System.err.println("Then, set an environment variable:");
      System.err.println("     export GEONAMES=your-geonames-account-name");
      throw new Exception("Need API key");
    }
    WebService.setUserName(System.getenv("GEONAMES"));

    ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
    searchCriteria.setStyle(Style.LONG);
    searchCriteria.setQ(name);
    ToponymSearchResult searchResult = WebService.search(searchCriteria);
    for (Toponym toponym : searchResult.getToponyms()) {
      //System.out.println("* " + toponym.getName() + " : " +toponym.getFeatureClassName());
      if (toponym.getFeatureClassName() != null &&
        toponym.getFeatureClassName().toString().indexOf(type) > -1 &&
        toponym.getName().indexOf(name) > -1 &&
        valid(toponym.getName())) {
        ret.add(new GeoNameData(toponym));
      }
    }
    return ret;
  }

  private boolean valid(String str) {
    if (str.contains("0")) return false;
    if (str.contains("1")) return false;
    if (str.contains("2")) return false;
    if (str.contains("3")) return false;
    if (str.contains("4")) return false;
    if (str.contains("5")) return false;
    if (str.contains("6")) return false;
    if (str.contains("7")) return false;
    if (str.contains("8")) return false;
    return !str.contains("9");
  }

  public List<GeoNameData> getCityData(String city_name) throws Exception {
    return helper(city_name, "city");
  }

  public List<GeoNameData> getCountryData(String country_name) throws Exception {
    return helper(country_name, "country");
  }

  public List<GeoNameData> getStateData(String state_name) throws Exception {
    List<GeoNameData> states = helper(state_name, "state");
    for (GeoNameData state : states) {
      state.geoType = GeoNameData.GeoType.STATE;
    }
    return states;
  }

  public List<GeoNameData> getRiverData(String river_name) throws Exception {
    return helper(river_name, "stream");
  }

  public List<GeoNameData> getMountainData(String mountain_name) throws Exception {
    return helper(mountain_name, "mountain");
  }
}
