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
package org.geonames;

/**
 * @author marc
 * @since 20.01.2011
 * 
 */
public class GeoNamesException extends Exception {

	private static final long serialVersionUID = 746586385626445380L;
	private String message;
	private int exceptionCode;

	public GeoNamesException(int exceptionCode, String msg) {
		super(msg);
		this.message = msg;
		this.exceptionCode = exceptionCode;
	}

	public GeoNamesException(String msg) {
		super(msg);
		this.message=msg;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the exceptionCode
	 */
	public int getExceptionCode() {
		return exceptionCode;
	}

}
