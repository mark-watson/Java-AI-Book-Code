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
 * Enumeration for the GeoNames feature classes A,H,L,P,R,S,T,U,V
 * 
 * @author marc
 * 
 */
public enum FeatureClass {
	/**
	 * Administrative Boundary Features
	 */
	A,
	/**
	 * Hydrographic Features
	 */
	H,
	/**
	 * Area Features
	 */
	L,
	/**
	 * Populated Place Features
	 */
	P,
	/**
	 * Road / Railroad Features
	 */
	R,
	/**
	 * Spot Features
	 */
	S,
	/**
	 * Hypsographic Features
	 */
	T,
	/**
	 * Undersea Features
	 */
	U,
	/**
	 * Vegetation Features
	 */
	V;

	public static FeatureClass fromValue(String value) {
		if (value == null || "".equals(value)) {
			return null;
		}
		return valueOf(value);
	}
}
