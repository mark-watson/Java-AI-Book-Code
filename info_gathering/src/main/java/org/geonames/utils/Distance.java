/*
 * Copyright 2006 Marc Wick, geonames.org
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

/**
 * Distance calculations.
 * 
 * @author marc@geonames
 * 
 */
public class Distance {

	/**
	 * mean radius = 6372.0
	 * 
	 * The Earth's equatorial radius = 6335.437 km.
	 * 
	 * The Earth's polar radius = 6399.592 km.
	 * 
	 * 
	 */
	public static final double EARTH_RADIUS_KM = 6372.0;

	/**
	 * statute miles
	 */
	public static final double EARTH_RADIUS_MILES = 3963.0;

	/**
	 * http://mathworld.wolfram.com/GreatCircle.html
	 * 
	 * and
	 * 
	 * http://www.mathforum.com/library/drmath/view/51711.html
	 * 
	 * @return
	 */
	public static double distance(double lat1, double lng1, double lat2,
			double lng2, char unit, int numberOfDigits) {
		double a1 = Math.toRadians(lat1);
		double b1 = Math.toRadians(lng1);
		double a2 = Math.toRadians(lat2);
		double b2 = Math.toRadians(lng2);
		double d = Math.acos(Math.cos(a1) * Math.cos(b1) * Math.cos(a2)
				* Math.cos(b2) + Math.cos(a1) * Math.sin(b1) * Math.cos(a2)
				* Math.sin(b2) + Math.sin(a1) * Math.sin(a2));

		double dist = 0;
		if (unit == 'M') {
			dist = d * EARTH_RADIUS_MILES;
		} else {
			dist = d * EARTH_RADIUS_KM;
		}

		if (Double.isNaN(dist)) {
			// use pytagoras for very small distances,
			dist = Math.sqrt(Math.pow(Math.abs(lat1 - lat2), 2)
					+ Math.pow(Math.abs(lng1 - lng2), 2));
			// as rule of thumb multiply with 110km =1 degree
			if (unit == 'M') {
				dist *= 69;
			} else {
				dist *= 110;
			}
		}

		if (numberOfDigits == 0) {
			dist = (int) dist;
		} else if (numberOfDigits > 0) {
			double factor = Math.pow(10, numberOfDigits);
			dist = Math.floor(dist * factor) / factor;
		}
		return dist;
	}

	public static double distanceKM(double lat1, double lng1, double lat2,
			double lng2) {
		return distance(lat1, lng1, lat2, lng2, 'K', 3);
	}

	public static double distanceMiles(double lat1, double lng1, double lat2,
			double lng2) {
		return distance(lat1, lng1, lat2, lng2, 'M', 3);
	}
}
