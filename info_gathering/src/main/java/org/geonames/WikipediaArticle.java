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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Comparator;

/**
 * a wikipedia article
 * 
 * @author marc@geonames
 * 
 */
public class WikipediaArticle {

	private String language;

	private String title;

	private String summary;

	private String wikipediaUrl;

	private String feature;

	private int population;

	private Integer elevation;

	private double latitude;

	private double longitude;

	private String thumbnailImg;

	private int rank;

	/**
	 * @return Returns the elevation.
	 */
	public Integer getElevation() {
		return elevation;
	}

	/**
	 * @param elevation
	 *            The elevation to set.
	 */
	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	/**
	 * @return Returns the feature.
	 */
	public String getFeature() {
		return feature;
	}

	/**
	 * @param feature
	 *            The feature to set.
	 */
	public void setFeature(String feature) {
		this.feature = feature;
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
	 * @return Returns the latitude.
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            The latitude to set.
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return Returns the longitude.
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            The longitude to set.
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return Returns the population.
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * @param population
	 *            The population to set.
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/**
	 * @return Returns the summary.
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary
	 *            The summary to set.
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return Returns the wikipediaUrl.
	 */
	public String getWikipediaUrl() {
		if (wikipediaUrl == null || WebService.isAndroid()) {
			String urlTitle = title.replace(' ', '_');
			try {
				urlTitle = URLEncoder.encode(urlTitle, "UTF8");
			} catch (UnsupportedEncodingException ex) {
			}
			String lang = language;
			if (WebService.isAndroid()) {
				lang += ".m";
			}
			return "http://" + lang + ".wikipedia.org/wiki/" + urlTitle;
		}
		return wikipediaUrl;
	}

	/**
	 * @param wikipediaUrl
	 *            The wikipediaUrl to set.
	 */
	public void setWikipediaUrl(String wikipediaURL) {
		this.wikipediaUrl = wikipediaURL;
	}

	/**
	 * @return the thumbnailImg
	 */
	public String getThumbnailImg() {
		return thumbnailImg;
	}

	/**
	 * @param thumbnailImg
	 *            the thumbnailImg to set
	 */
	public void setThumbnailImg(String thumbnailImg) {
		this.thumbnailImg = thumbnailImg;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank
	 *            the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	public final static Comparator ELEVATION_ORDER = new Comparator<WikipediaArticle>() {
		public int compare(WikipediaArticle o1, WikipediaArticle o2) {
			return Double.compare(o2.elevation, o1.elevation);
		}
	};

	public final static Comparator RANK_ORDER = new Comparator<WikipediaArticle>() {
		public int compare(WikipediaArticle o1, WikipediaArticle o2) {
			return Double.compare(o2.rank, o1.rank);
		}
	};
}
