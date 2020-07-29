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

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toDegrees;
import static java.lang.Math.toRadians;

/**
 * compass bearing from the first point to the second point in degrees.
 * 
 * @author Marc Wick
 */
public class Bearing {

	/**
	 * Returns the direction from the first point to the second point in
	 * degrees. The direction is the clockwise angle between the magnetic north
	 * and the direction from point1 to point2
	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	// http://www.movable-type.co.uk/scripts/latlong.html
	public static double calculateBearing(double lat1, double lng1,
			double lat2, double lng2) {
		double dLon = toRadians(lng2 - lng1);
		lat1 = toRadians(lat1);
		lat2 = toRadians(lat2);
		double y = sin(dLon) * cos(lat2);
		double x = cos(lat1) * sin(lat2) - sin(lat1) * cos(lat2) * cos(dLon);
		double brng = toDegrees(atan2(y, x));
		return (brng + 360) % 360;
	}
}
