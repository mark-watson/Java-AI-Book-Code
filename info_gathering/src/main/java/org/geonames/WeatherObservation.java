/*
 * Copyright 2010 Marc Wick, geonames.org
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
 * @author marc
 * @since 25.11.2010
 * 
 */
public class WeatherObservation {
	private String observation;
	private Date observationTime;
	private String stationName;
	private String icaoCode;
	private String countryCode;
	private Integer elevation;
	private double latitude;
	private double longitude;
	private double temperature;
	private double dewPoint;
	private double humidity;
	private String clouds;
	private String weatherCondition;
	private String windSpeed;

	/**
	 * @return the observation
	 */
	public String getObservation() {
		return observation;
	}

	/**
	 * @param observation
	 *            the observation to set
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}

	/**
	 * @return the observationTime
	 */
	public Date getObservationTime() {
		return observationTime;
	}

	/**
	 * @param observationTime
	 *            the observationTime to set
	 */
	public void setObservationTime(Date observationTime) {
		this.observationTime = observationTime;
	}

	/**
	 * @return the stationName
	 */
	public String getStationName() {
		return stationName;
	}

	/**
	 * @param stationName
	 *            the stationName to set
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	/**
	 * @return the icaoCode
	 */
	public String getIcaoCode() {
		return icaoCode;
	}

	/**
	 * @param icaoCode
	 *            the icaoCode to set
	 */
	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
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
	 * @return the elevation
	 */
	public Integer getElevation() {
		return elevation;
	}

	/**
	 * @param elevation
	 *            the elevation to set
	 */
	public void setElevation(Integer elevation) {
		this.elevation = elevation;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature
	 *            the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the dewPoint
	 */
	public double getDewPoint() {
		return dewPoint;
	}

	/**
	 * @param dewPoint
	 *            the dewPoint to set
	 */
	public void setDewPoint(double dewPoint) {
		this.dewPoint = dewPoint;
	}

	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity
	 *            the humidity to set
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the clouds
	 */
	public String getClouds() {
		return clouds;
	}

	/**
	 * @param clouds
	 *            the clouds to set
	 */
	public void setClouds(String clouds) {
		this.clouds = clouds;
	}

	/**
	 * @return the weatherCondition
	 */
	public String getWeatherCondition() {
		return weatherCondition;
	}

	/**
	 * @param weatherCondition
	 *            the weatherCondition to set
	 */
	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}

	/**
	 * @return the windSpeed
	 */
	public String getWindSpeed() {
		return windSpeed;
	}

	/**
	 * @param windSpeed
	 *            the windSpeed to set
	 */
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

}
