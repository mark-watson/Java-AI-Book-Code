/*
 * Copyright 2008 Marc Wick, geonames.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.geonames;

import java.util.HashSet;
import java.util.Set;

/**
 * search criteria for web services returning toponyms.
 * 
 * The string parameters do not have to be utf8 encoded. The encoding is done
 * transparently in the call to the web service.
 * 
 * The main parameter for the search over all fields is the 'q' parameter.
 * 
 * @see WebService#search
 * 
 * @see <a href="http://www.geonames.org/export/geonames-search.html">search
 *      webservice documentation< /a>
 * 
 * @author marc@geonames
 * 
 */
public class ToponymSearchCriteria {

	private String q;

	private String countryCode;

	private Set<String> countryCodes;

	private String countryBias;

	private String continentCode;

	private String name;

	private String nameEquals;

	private String nameStartsWith;

	private String tag;

	private String language;

	private Style style;

	private FeatureClass featureClass;

	private String[] featureCodes;

	private String adminCode1;

	private String adminCode2;

	private String adminCode3;

	private String adminCode4;

	private int maxRows;

	private int startRow;
	
	private double fuzzy = 1.0;

	private BoundingBox boundingBox;

	/**
	 * @return Returns the ISO 3166-1-alpha-2 countryCode.
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            The ISO 3166-1-alpha-2 countryCode to set.
	 */
	public void setCountryCode(String countryCode)
			throws InvalidParameterException {
		if (countryCode != null && countryCode.length() != 2) {
			throw new InvalidParameterException("invalid country code "
					+ countryCode);
		}
		this.countryCode = countryCode;
	}

	/**
	 * @param countryCode
	 *            The ISO 3166-1-alpha-2 countryCode to set.
	 */
	public void addCountryCode(String countryCode)
			throws InvalidParameterException {
		if (countryCode != null && countryCode.length() != 2) {
			throw new InvalidParameterException("invalid country code "
					+ countryCode);
		}
		if (this.countryCodes == null) {
			this.countryCodes = new HashSet<String>();
		}
		this.countryCodes.add(countryCode);
	}

	/**
	 * @return the countryCodes
	 */
	public Set<String> getCountryCodes() {
		return countryCodes;
	}

	/**
	 * @param countryCodes
	 *            the countryCodes to set
	 */
	public void setCountryCodes(Set<String> countryCodes) {
		this.countryCodes = countryCodes;
	}

	/**
	 * @return the countryBias
	 */
	public String getCountryBias() {
		return countryBias;
	}

	/**
	 * @param countryBias
	 *            the countryBias to set
	 */
	public void setCountryBias(String countryBias) {
		this.countryBias = countryBias;
	}

	/**
	 * @return the continentCode
	 */
	public String getContinentCode() {
		return continentCode;
	}

	/**
	 * @param continentCode
	 *            the continentCode to set
	 */
	public void setContinentCode(String continentCode) {
		this.continentCode = continentCode;
	}

	/**
	 * @return Returns the nameEquals.
	 */
	public String getNameEquals() {
		return nameEquals;
	}

	/**
	 * @param nameEquals
	 *            The nameEquals to set.
	 */
	public void setNameEquals(String exactName) {
		this.nameEquals = exactName;
	}

	/**
	 * @return Returns the featureCodes.
	 */
	public String[] getFeatureCodes() {
		return featureCodes;
	}

	/**
	 * @param featureCodes
	 *            The featureCodes to set.
	 */
	public void setFeatureCodes(String[] featureCodes) {
		this.featureCodes = featureCodes;
	}

	public void setFeatureCode(String featureCode) {
		this.featureCodes = new String[] { featureCode };
	}

	/**
	 * @return Returns the language.
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            The language to set.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return Returns the maxRows.
	 */
	public int getMaxRows() {
		return maxRows;
	}

	/**
	 * @param maxRows
	 *            The maxRows to set.
	 */
	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * search over the name field only.
	 * 
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the q.
	 */
	public String getQ() {
		return q;
	}

	/**
	 * The main search term. The search is executed over all fields (place name,
	 * country name, admin names, etc)
	 * 
	 * @param q
	 *            The q to set.
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * @return Returns the startRow.
	 */
	public int getStartRow() {
		return startRow;
	}

	/**
	 * @param startRow
	 *            The startRow to set.
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	/**
	 * @return Returns the style.
	 */
	public Style getStyle() {
		return style;
	}

	/**
	 * @param style
	 *            The style to set.
	 */
	public void setStyle(Style style) {
		this.style = style;
	}

	/**
	 * @return Returns the tag.
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            The tag to set.
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return Returns the nameStartsWith.
	 */
	public String getNameStartsWith() {
		return nameStartsWith;
	}

	/**
	 * @param nameStartsWith
	 *            The nameStartsWith to set.
	 */
	public void setNameStartsWith(String nameStartsWith) {
		this.nameStartsWith = nameStartsWith;
	}

	/**
	 * @return the featureClass
	 */
	public FeatureClass getFeatureClass() {
		return featureClass;
	}

	/**
	 * @param featureClass
	 *            the featureClass to set
	 */
	public void setFeatureClass(FeatureClass featureClass) {
		this.featureClass = featureClass;
	}

	/**
	 * @return the adminCode1
	 */
	public String getAdminCode1() {
		return adminCode1;
	}

	/**
	 * @param adminCode1
	 *            the adminCode1 to set
	 */
	public void setAdminCode1(String adminCode1) {
		this.adminCode1 = adminCode1;
	}

	/**
	 * @return the adminCode2
	 */
	public String getAdminCode2() {
		return adminCode2;
	}

	/**
	 * @param adminCode2
	 *            the adminCode2 to set
	 */
	public void setAdminCode2(String adminCode2) {
		this.adminCode2 = adminCode2;
	}

	/**
	 * @return the adminCode3
	 */
	public String getAdminCode3() {
		return adminCode3;
	}

	/**
	 * @param adminCode3
	 *            the adminCode3 to set
	 */
	public void setAdminCode3(String adminCode3) {
		this.adminCode3 = adminCode3;
	}

	public String getAdminCode4() {
		return adminCode4;
	}

	public void setAdminCode4(String adminCode4) {
		this.adminCode4 = adminCode4;
	}
	
	/**
	 * @return the fuzzy
	 */
	public double getFuzzy() {
		return fuzzy;
	}

	/**
	 * @param fuzzy the fuzzy to set
	 */
	public void setFuzzy(double fuzzy) {
		this.fuzzy = fuzzy;
	}

	/**
	 * @return the boundingBox
	 */
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	/**
	 * @param boundingBox
	 *            the boundingBox to set
	 */
	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}

}
