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
 * Is thrown when trying to access a field that has not been set as the style
 * for the request was not sufficiently verbose to return this information.
 * 
 * @author marc
 * 
 */
public class InsufficientStyleException extends GeoNamesException {
	public InsufficientStyleException(String msg) {
		super(msg);
	}
}
