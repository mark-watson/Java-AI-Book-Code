/*
 * Copyright 2012 Marc Wick, geonames.org
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

/**
 * @author Marc Wick
 * @since 15.08.2012
 * 
 */
public class BoundingBox {

	public BoundingBox(double west, double east, double south, double north) {
		setWest(west);
		setEast(east);
		setSouth(south);
		setNorth(north);
	}

	/**
	 * @return the west
	 */
	public double getWest() {
		return west;
	}

	/**
	 * @param west
	 *            the west to set
	 */
	public void setWest(double west) {
		this.west = west;
	}

	/**
	 * @return the east
	 */
	public double getEast() {
		return east;
	}

	/**
	 * @param east
	 *            the east to set
	 */
	public void setEast(double east) {
		this.east = east;
	}

	/**
	 * @return the south
	 */
	public double getSouth() {
		return south;
	}

	/**
	 * @param south
	 *            the south to set
	 */
	public void setSouth(double south) {
		this.south = south;
	}

	/**
	 * @return the north
	 */
	public double getNorth() {
		return north;
	}

	/**
	 * @param north
	 *            the north to set
	 */
	public void setNorth(double north) {
		this.north = north;
	}

	private double west;
	private double east;
	private double south;
	private double north;

}
