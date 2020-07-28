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

import java.util.Date;

/**
 * gmtOffset and dstOffset are computed on the server with the
 * {@link java.util.TimeZone} and included in the web service as not all
 * geonames users are using java.
 * 
 * @author marc
 * 
 */
public class Timezone {

	private String timezoneId;
	private String countryCode;
	private Date time;
	private Date sunrise;
	private Date sunset;

	@Deprecated
	private double gmtOffset;

	@Deprecated
	private double dstOffset;

	/**
	 * the dstOffset as of first of July of current year
	 * 
	 * @return the dstOffset
	 */
	@Deprecated
	public double getDstOffset() {
		return dstOffset;
	}

	/**
	 * @param dstOffset
	 *            the dstOffset to set
	 */
	public void setDstOffset(double dstOffset) {
		this.dstOffset = dstOffset;
	}

	/**
	 * the gmtOffset as of first of January of current year
	 * 
	 * @return the gmtOffset
	 */
	@Deprecated
	public double getGmtOffset() {
		return gmtOffset;
	}

	/**
	 * @param gmtOffset
	 *            the gmtOffset to set
	 */
	public void setGmtOffset(double gmtOffset) {
		this.gmtOffset = gmtOffset;
	}

	/**
	 * the timezoneId (example : "Pacific/Honolulu")
	 * 
	 * see also {@link java.util.TimeZone} and
	 * http://www.twinsun.com/tz/tz-link.htm
	 * 
	 * @return the timezoneId
	 */
	public String getTimezoneId() {
		return timezoneId;
	}

	/**
	 * @param timezoneId
	 *            the timezoneId to set
	 */
	public void setTimezoneId(String timezoneId) {
		this.timezoneId = timezoneId;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * @return the sunrise
	 */
	public Date getSunrise() {
		return sunrise;
	}

	/**
	 * @param sunrise
	 *            the sunrise to set
	 */
	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}

	/**
	 * @return the sunset
	 */
	public Date getSunset() {
		return sunset;
	}

	/**
	 * @param sunset
	 *            the sunset to set
	 */
	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}

}
