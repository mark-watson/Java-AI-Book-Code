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

/**
 * a street line segment. Includes house number information for the beginning
 * and end of the line as well as right and left hand side of the line.
 * 
 * @author marc@geonames
 * 
 */
public class StreetSegment extends PostalCode {

	private double[] latArray;

	private double[] lngArray;

	/**
	 * census feature class codes see
	 * http://www.geonames.org/maps/Census-Feature-Class-Codes.txt
	 */
	private String cfcc;

	private String name;

	/**
	 * from address left
	 */
	private String fraddl;

	/**
	 * from address right
	 */
	private String fraddr;

	/**
	 * to address left
	 */
	private String toaddl;

	/**
	 * to address right
	 */
	private String toaddr;

	/**
	 * @return the latArray
	 */
	public double[] getLatArray() {
		return latArray;
	}

	/**
	 * @param latArray
	 *            the latArray to set
	 */
	public void setLatArray(double[] latArray) {
		this.latArray = latArray;
	}

	/**
	 * @return the lngArray
	 */
	public double[] getLngArray() {
		return lngArray;
	}

	/**
	 * @param lngArray
	 *            the lngArray to set
	 */
	public void setLngArray(double[] lngArray) {
		this.lngArray = lngArray;
	}

	/**
	 * @return the cfcc
	 */
	public String getCfcc() {
		return cfcc;
	}

	/**
	 * @param cfcc
	 *            the cfcc to set
	 */
	public void setCfcc(String cfcc) {
		this.cfcc = cfcc;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the fraddl
	 */
	public String getFraddl() {
		return fraddl;
	}

	/**
	 * @param fraddl
	 *            the fraddl to set
	 */
	public void setFraddl(String fraddl) {
		this.fraddl = fraddl;
	}

	/**
	 * @return the fraddr
	 */
	public String getFraddr() {
		return fraddr;
	}

	/**
	 * @param fraddr
	 *            the fraddr to set
	 */
	public void setFraddr(String fraddr) {
		this.fraddr = fraddr;
	}

	/**
	 * @return the toaddl
	 */
	public String getToaddl() {
		return toaddl;
	}

	/**
	 * @param toaddl
	 *            the toaddl to set
	 */
	public void setToaddl(String toaddl) {
		this.toaddl = toaddl;
	}

	/**
	 * @return the toaddr
	 */
	public String getToaddr() {
		return toaddr;
	}

	/**
	 * @param toaddr
	 *            the toaddr to set
	 */
	public void setToaddr(String toaddr) {
		this.toaddr = toaddr;
	}

}
