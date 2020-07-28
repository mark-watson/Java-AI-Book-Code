/*
 * Copyright 2011 Marc Wick, geonames.org
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
package org.geonames.utils;

import java.util.Comparator;

import org.geonames.WikipediaArticle;

/**
 * @author marc
 * @since 16.02.2011
 * 
 */
public class DistanceOrder implements Comparator<WikipediaArticle> {
	private double latitude;
	private double longitude;

	public DistanceOrder(double pLat, double pLng) {
		latitude = pLat;
		longitude = pLng;
	}

	public int compare(WikipediaArticle o1, WikipediaArticle o2) {
		double dist1 = dist(o1);
		double dist2 = dist(o2);
		return Double.compare(dist1, dist2);
	}

	private double dist(WikipediaArticle o) {
		return Distance.distanceKM(latitude, longitude, o.getLatitude(), o
				.getLongitude());
	}

}
