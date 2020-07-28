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
 * an intersection between two streets
 * 
 * @author Mark Thomas
 * 
 */
public class Intersection {
	private String street2;

	private Address address = new Address();

	public double getDistance() {
		return address.getDistance();
	}

	public void setDistance(double d) {
		address.setDistance(d);
	}

	public String getAdminCode1() {
		return address.getAdminCode1();
	}

	public void setAdminCode1(String s) {
		address.setAdminCode1(s);
	}

	public String getAdminName1() {
		return address.getAdminName1();
	}

	public void setAdminName1(String s) {
		address.setAdminName1(s);
	}

	public String getAdminName2() {
		return address.getAdminName2();
	}

	public void setAdminName2(String s) {
		address.setAdminName2(s);
	}

	public String getCountryCode() {
		return address.getCountryCode();
	}

	public void setCountryCode(String s) {
		address.setCountryCode(s);
	}

	public double getLatitude() {
		return address.getLatitude();
	}

	public void setLatitude(double d) {
		address.setLatitude(d);
	}

	public double getLongitude() {
		return address.getLongitude();
	}

	public void setLongitude(double d) {
		address.setLongitude(d);
	}

	public String getPlaceName() {
		return address.getPlaceName();
	}

	public void setPlaceName(String s) {
		address.setPlaceName(s);
	}

	public String getPostalCode() {
		return address.getPostalCode();
	}

	public void setPostalCode(String s) {
		address.setPostalCode(s);
	}

	public String getStreet1() {
		return address.getStreet();
	}

	public void setStreet1(String s) {
		address.setStreet(s);
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

}
