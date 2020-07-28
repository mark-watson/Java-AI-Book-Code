/*
 * Copyright 2008-2012 Marc Wick, geonames.org
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * provides static methods to access the <a
 * href="http://www.geonames.org/export/ws-overview.html">GeoNames web
 * services</a>.
 * <p>
 * Note : values for some fields are only returned with sufficient {@link Style}
 * . Accessing these fields (admin codes and admin names, elevation,population)
 * will throw an {@link InsufficientStyleException} if the {@link Style} was not
 * sufficient.
 * 
 * @author marc@geonames
 * 
 */
public class WebService {

	private static Logger logger = Logger.getLogger("org.geonames");

	private static String USER_AGENT = "gnwsc/1.1.14";

	private static boolean isAndroid = false;

	private static String geoNamesServer = "http://api.geonames.org";

	private static String geoNamesServerFailover = "http://api.geonames.org";

	private static long timeOfLastFailureMainServer;

	private static long averageConnectTime;

	private static long averageSampleSize = 20;

	private static Style defaultStyle = Style.MEDIUM;

	private static int readTimeOut = 120000;

	private static int connectTimeOut = 10000;

	private static String DATEFMT = "yyyy-MM-dd HH:mm:ss";

	private static Proxy proxy;

	static {
		USER_AGENT += " (";
		String os = System.getProperty("os.name");
		if (os != null) {
			USER_AGENT += os + ",";
		}
		String osVersion = System.getProperty("os.version");
		if (osVersion != null) {
			USER_AGENT += osVersion;
		}
		USER_AGENT += ")";

		// android version
		try {
			Class aClass = Class.forName("android.os.Build");
			if (aClass != null) {
				isAndroid = true;
				Field[] fields = aClass.getFields();
				if (fields != null) {
					for (Field field : fields) {
						if ("MODEL".equalsIgnoreCase(field.getName())) {
							USER_AGENT += "(" + field.get(aClass) + ", ";
						}
					}
				}
				aClass = Class.forName("android.os.Build$VERSION");
				if (aClass != null) {
					fields = aClass.getFields();
					if (fields != null) {
						for (Field field : fields) {
							if ("RELEASE".equalsIgnoreCase(field.getName())) {
								USER_AGENT += field.get(aClass);
							}
						}
					}
				}
				USER_AGENT += ")";
			}
		} catch (Throwable t) {
		}
	}

	/**
	 * user name to pass to commercial web services for authentication and
	 * authorization
	 */
	private static String userName;

	/**
	 * token to pass to as optional authentication parameter to the commercial
	 * web services.
	 */
	private static String token;

	/**
	 * adds the username stored in a static variable to the url. It also adds a
	 * token if one has been set with the static setter previously.
	 * 
	 * @param url
	 * @return url with the username appended
	 */
	private static String addUserName(String url) {
		if (userName != null) {
			url = url + "&username=" + userName;
		}
		if (token != null) {
			url = url + "&token=" + token;
		}
		return url;
	}

	/**
	 * adds the default style to the url. The default style can be set with the
	 * static setter. It is 'MEDIUM' if not set.
	 * 
	 * @param url
	 * @return url with the style parameter appended
	 */
	private static String addDefaultStyle(String url) {
		if (defaultStyle != Style.MEDIUM) {
			url = url + "&style=" + defaultStyle.name();
		}
		return url;
	}

	/**
	 * returns the currently active server. Normally this is the main server, if
	 * the main server recently failed then the failover server is returned. If
	 * the main server is not available we don't want to try with every request
	 * whether it is available again. We switch to the failover server and try
	 * from time to time whether the main server is again accessible.
	 * 
	 * @return
	 */
	private static String getCurrentlyActiveServer() {
		if (timeOfLastFailureMainServer == 0) {
			// no problems with main server
			return geoNamesServer;
		}
		// we had problems with main server
		if (System.currentTimeMillis() - timeOfLastFailureMainServer > 1000l * 60l * 10l) {
			// but is was some time ago and we switch back to the main server to
			// retry. The problem may have been solved in the mean time.
			timeOfLastFailureMainServer = 0;
			return geoNamesServer;
		}
		if (System.currentTimeMillis() < timeOfLastFailureMainServer) {
			throw new Error("time of last failure cannot be in future.");
		}
		// the problems have been very recent and we continue with failover
		// server
		if (geoNamesServerFailover != null) {
			return geoNamesServerFailover;
		}
		return geoNamesServer;
	}

	/**
	 * @return the isAndroid
	 */
	public static boolean isAndroid() {
		return isAndroid;
	}

	/**
	 * opens the connection to the url and sets the user agent. In case of an
	 * IOException it checks whether a failover server is set and connects to
	 * the failover server if it has been defined and if it is different from
	 * the normal server.
	 * 
	 * @param url
	 *            the url to connect to
	 * @return returns the inputstream for the connection
	 * @throws IOException
	 */
	private static InputStream connect(String url) throws IOException {
		int status = 0;
		String currentlyActiveServer = getCurrentlyActiveServer();
		try {
			long begin = System.currentTimeMillis();
			HttpURLConnection httpConnection = null;
			if (proxy == null) {
				httpConnection = (HttpURLConnection) new URL(
						currentlyActiveServer + url).openConnection();
			} else {
				httpConnection = (HttpURLConnection) new URL(
						currentlyActiveServer + url).openConnection(proxy);
			}
			httpConnection.setConnectTimeout(connectTimeOut);
			httpConnection.setReadTimeout(readTimeOut);
			httpConnection.setRequestProperty("User-Agent", USER_AGENT);
			InputStream in = httpConnection.getInputStream();
			status = httpConnection.getResponseCode();

			if (status == 200) {
				long elapsedTime = System.currentTimeMillis() - begin;
				averageConnectTime = (averageConnectTime
						* (averageSampleSize - 1) + elapsedTime)
						/ averageSampleSize;
				// if the average elapsed time is too long we switch server
				if (geoNamesServerFailover != null
						&& averageConnectTime > 5000
						&& !currentlyActiveServer
								.equals(geoNamesServerFailover)) {
					timeOfLastFailureMainServer = System.currentTimeMillis();
				}
				return in;
			}
		} catch (IOException e) {
			return tryFailoverServer(url, currentlyActiveServer, 0, e);
		}
		// we only get here if we had a statuscode <> 200
		IOException ioException = new IOException("status code " + status
				+ " for " + url);
		return tryFailoverServer(url, currentlyActiveServer, status,
				ioException);
	}

	private static synchronized InputStream tryFailoverServer(String url,
			String currentlyActiveServer, int status, IOException e)
			throws MalformedURLException, IOException {
		// we cannot reach the server
		logger.log(Level.WARNING, "problems connecting to geonames server "
				+ currentlyActiveServer, e);
		// is a failover server defined?
		if (geoNamesServerFailover == null
		// is it different from the one we are using?
				|| currentlyActiveServer.equals(geoNamesServerFailover)) {
			if (currentlyActiveServer.equals(geoNamesServerFailover)) {
				// failover server is not accessible, we throw exception
				// and switch back to main server.
				timeOfLastFailureMainServer = 0;
			}
			throw e;
		}
		timeOfLastFailureMainServer = System.currentTimeMillis();
		logger.info("trying to connect to failover server "
				+ geoNamesServerFailover);
		// try failover server
		URLConnection conn = null;
		if (proxy == null) {
			conn = new URL(geoNamesServerFailover + url).openConnection();
		} else {
			conn = new URL(geoNamesServerFailover + url).openConnection(proxy);
		}

		String userAgent = USER_AGENT + " failover from " + geoNamesServer;
		if (status != 0) {
			userAgent += " " + status;
		}
		conn.setRequestProperty("User-Agent", userAgent);
		InputStream in = conn.getInputStream();
		return in;
	}

	private static Element connectAndParse(String url)
			throws GeoNamesException, IOException, JDOMException {
		SAXBuilder parser = new SAXBuilder();
		Document doc = parser.build(connect(url));
		try {
			Element root = rootAndCheckException(doc);
			return root;
		} catch (GeoNamesException geoNamesException) {
			if (geoNamesException.getExceptionCode() == 13
					|| (geoNamesException.getMessage() != null && geoNamesException
							.getMessage()
							.indexOf(
									"canceling statement due to statement timeout") > -1)) {
				String currentlyActiveServer = getCurrentlyActiveServer();
				if (geoNamesServerFailover != null
						&& !currentlyActiveServer
								.equals(geoNamesServerFailover)) {
					timeOfLastFailureMainServer = System.currentTimeMillis();
					doc = parser.build(connect(url));
					Element root = rootAndCheckException(doc);
					return root;
				}
			}
			throw geoNamesException;
		}
	}

	private static Element rootAndCheckException(Document doc)
			throws GeoNamesException {
		Element root = doc.getRootElement();
		checkException(root);
		return root;
	}

	private static void checkException(Element root) throws GeoNamesException {
		Element message = root.getChild("status");
		if (message != null) {
			int code = 0;
			try {
				code = Integer.parseInt(message.getAttributeValue("value"));
			} catch (NumberFormatException numberFormatException) {
			}
			throw new GeoNamesException(code,
					message.getAttributeValue("message"));
		}
	}

	/**
	 * check whether we can parse an exception and throw it if we can
	 * 
	 * if the line starts with ERR: then we have a geonames exception.
	 * 
	 * @param line
	 * @throws GeoNamesException
	 */
	private static void checkException(String line) throws GeoNamesException {
		if (line.startsWith("ERR:")) {
			String[] terms = line.split(":");
			if (terms.length == 3) {
				throw new GeoNamesException(Integer.parseInt(terms[1]),
						terms[2]);
			}
			throw new GeoNamesException("unhandled exception");
		}
	}

	private static Toponym getToponymFromElement(Element toponymElement) {
		Toponym toponym = new Toponym();

		toponym.setName(toponymElement.getChildText("name"));
		toponym.setAlternateNames(toponymElement.getChildText("alternateNames"));
		toponym.setLatitude(Double.parseDouble(toponymElement
				.getChildText("lat")));
		toponym.setLongitude(Double.parseDouble(toponymElement
				.getChildText("lng")));

		String geonameId = toponymElement.getChildText("geonameId");
		if (geonameId != null) {
			toponym.setGeoNameId(Integer.parseInt(geonameId));
		}

		toponym.setContinentCode(toponymElement.getChildText("continentCode"));
		toponym.setCountryCode(toponymElement.getChildText("countryCode"));
		toponym.setCountryName(toponymElement.getChildText("countryName"));

		toponym.setFeatureClass(FeatureClass.fromValue(toponymElement
				.getChildText("fcl")));
		toponym.setFeatureCode(toponymElement.getChildText("fcode"));

		toponym.setFeatureClassName(toponymElement.getChildText("fclName"));
		toponym.setFeatureCodeName(toponymElement.getChildText("fCodeName"));

		String population = toponymElement.getChildText("population");
		if (population != null && !"".equals(population)) {
			toponym.setPopulation(Long.parseLong(population));
		}
		String elevation = toponymElement.getChildText("elevation");
		if (elevation != null && !"".equals(elevation)) {
			toponym.setElevation(Integer.parseInt(elevation));
		}

		toponym.setAdminCode1(toponymElement.getChildText("adminCode1"));
		toponym.setAdminName1(toponymElement.getChildText("adminName1"));
		toponym.setAdminCode2(toponymElement.getChildText("adminCode2"));
		toponym.setAdminName2(toponymElement.getChildText("adminName2"));
		toponym.setAdminCode3(toponymElement.getChildText("adminCode3"));
		toponym.setAdminName3(toponymElement.getChildText("adminName3"));
		toponym.setAdminCode4(toponymElement.getChildText("adminCode4"));
		toponym.setAdminName4(toponymElement.getChildText("adminName4"));
		toponym.setAdminCode5(toponymElement.getChildText("adminCode5"));
		toponym.setAdminName5(toponymElement.getChildText("adminName5"));

		Element timezoneElement = toponymElement.getChild("timezone");
		if (timezoneElement != null) {
			Timezone timezone = new Timezone();
			timezone.setTimezoneId(timezoneElement.getValue());
			timezone.setDstOffset(Double.parseDouble(timezoneElement
					.getAttributeValue("dstOffset")));
			timezone.setGmtOffset(Double.parseDouble(timezoneElement
					.getAttributeValue("gmtOffset")));
			toponym.setTimezone(timezone);
		}

		Element bboxElement = toponymElement.getChild("bbox");
		if (bboxElement != null) {
			BoundingBox boundingBox = new BoundingBox(
					Double.parseDouble(bboxElement.getChildText("west")),
					Double.parseDouble(bboxElement.getChildText("east")),
					Double.parseDouble(bboxElement.getChildText("south")),
					Double.parseDouble(bboxElement.getChildText("north")));
			toponym.setBoundingBox(boundingBox);
		}

		return toponym;
	}

	private static WikipediaArticle getWikipediaArticleFromElement(
			Element wikipediaArticleElement) {
		WikipediaArticle wikipediaArticle = new WikipediaArticle();
		wikipediaArticle.setLanguage(wikipediaArticleElement
				.getChildText("lang"));
		wikipediaArticle
				.setTitle(wikipediaArticleElement.getChildText("title"));
		wikipediaArticle.setSummary(wikipediaArticleElement
				.getChildText("summary"));
		wikipediaArticle.setFeature(wikipediaArticleElement
				.getChildText("feature"));
		wikipediaArticle.setWikipediaUrl(wikipediaArticleElement
				.getChildText("wikipediaUrl"));
		wikipediaArticle.setThumbnailImg(wikipediaArticleElement
				.getChildText("thumbnailImg"));

		wikipediaArticle.setLatitude(Double.parseDouble(wikipediaArticleElement
				.getChildText("lat")));
		wikipediaArticle.setLongitude(Double
				.parseDouble(wikipediaArticleElement.getChildText("lng")));

		wikipediaArticle.setRank(Integer.parseInt(wikipediaArticleElement
				.getChildText("rank")));

		String population = wikipediaArticleElement.getChildText("population");
		if (population != null && !"".equals(population)) {
			wikipediaArticle.setPopulation(Integer.parseInt(population));
		}

		String elevation = wikipediaArticleElement.getChildText("elevation");
		if (elevation != null && !"".equals(elevation)) {
			wikipediaArticle.setElevation(Integer.parseInt(elevation));
		}
		return wikipediaArticle;
	}

	private static TimeZone utc = TimeZone.getTimeZone("UTC");

	private static WeatherObservation getWeatherObservationFromElement(
			Element weatherObservationElement) throws ParseException {
		WeatherObservation weatherObservation = new WeatherObservation();
		weatherObservation.setObservation(weatherObservationElement
				.getChildText("observation"));
		SimpleDateFormat df = new SimpleDateFormat(DATEFMT);
		df.setTimeZone(utc);
		weatherObservation.setObservationTime(df
				.parse(weatherObservationElement
						.getChildText("observationTime")));
		weatherObservation.setStationName(weatherObservationElement
				.getChildText("stationName"));
		weatherObservation.setIcaoCode(weatherObservationElement
				.getChildText("ICAO"));
		weatherObservation.setCountryCode(weatherObservationElement
				.getChildText("countryCode"));
		String elevation = weatherObservationElement.getChildText("elevation");
		if (elevation != null && !"".equals(elevation)) {
			weatherObservation.setElevation(Integer.parseInt(elevation));
		}
		weatherObservation.setLatitude(Double
				.parseDouble(weatherObservationElement.getChildText("lat")));
		weatherObservation.setLongitude(Double
				.parseDouble(weatherObservationElement.getChildText("lng")));
		String temperature = weatherObservationElement
				.getChildText("temperature");
		if (temperature != null && !"".equals(temperature)) {
			weatherObservation.setTemperature(Double.parseDouble(temperature));
		}
		String dewPoint = weatherObservationElement.getChildText("dewPoint");
		if (dewPoint != null && !"".equals(dewPoint)) {
			weatherObservation.setDewPoint(Double.parseDouble(dewPoint));
		}
		String humidity = weatherObservationElement.getChildText("humidity");
		if (humidity != null && !"".equals(humidity)) {
			weatherObservation.setHumidity(Double.parseDouble(humidity));
		}
		weatherObservation.setClouds(weatherObservationElement
				.getChildText("clouds"));
		weatherObservation.setWeatherCondition(weatherObservationElement
				.getChildText("weatherCondition"));
		weatherObservation.setWindSpeed(weatherObservationElement
				.getChildText("windSpeed"));
		return weatherObservation;

	}

	/**
	 * returns a list of postal codes for the given parameters. This method is
	 * for convenience.
	 * 
	 * @param postalCode
	 * @param placeName
	 * @param countryCode
	 * @return
	 * @throws Exception
	 */
	public static List<PostalCode> postalCodeSearch(String postalCode,
			String placeName, String countryCode) throws Exception {
		PostalCodeSearchCriteria postalCodeSearchCriteria = new PostalCodeSearchCriteria();
		postalCodeSearchCriteria.setPostalCode(postalCode);
		postalCodeSearchCriteria.setPlaceName(placeName);
		postalCodeSearchCriteria.setCountryCode(countryCode);
		return postalCodeSearch(postalCodeSearchCriteria);
	}

	/**
	 * returns a list of postal codes for the given search criteria matching a
	 * full text search on the GeoNames postal codes database.
	 * 
	 * @param postalCodeSearchCriteria
	 * @return
	 * @throws Exception
	 */
	public static List<PostalCode> postalCodeSearch(
			PostalCodeSearchCriteria postalCodeSearchCriteria) throws Exception {
		List<PostalCode> postalCodes = new ArrayList<PostalCode>();

		String url = "/postalCodeSearch?";
		if (postalCodeSearchCriteria.getPostalCode() != null) {
			url = url
					+ "postalcode="
					+ URLEncoder.encode(
							postalCodeSearchCriteria.getPostalCode(), "UTF8");
		}
		if (postalCodeSearchCriteria.getPlaceName() != null) {
			if (!url.endsWith("&")) {
				url = url + "&";
			}
			url = url
					+ "placename="
					+ URLEncoder.encode(
							postalCodeSearchCriteria.getPlaceName(), "UTF8");
		}
		if (postalCodeSearchCriteria.getAdminCode1() != null) {
			url = url
					+ "&adminCode1="
					+ URLEncoder.encode(
							postalCodeSearchCriteria.getAdminCode1(), "UTF8");
		}

		if (postalCodeSearchCriteria.getCountryCode() != null) {
			if (!url.endsWith("&")) {
				url = url + "&";
			}
			url = url + "country=" + postalCodeSearchCriteria.getCountryCode();
		}
		if (postalCodeSearchCriteria.getCountryBias() != null) {
			if (!url.endsWith("&")) {
				url = url + "&";
			}
			url = url + "countryBias="
					+ postalCodeSearchCriteria.getCountryBias();
		}
		if (postalCodeSearchCriteria.getMaxRows() > 0) {
			url = url + "&maxRows=" + postalCodeSearchCriteria.getMaxRows();
		}
		if (postalCodeSearchCriteria.getStartRow() > 0) {
			url = url + "&startRow=" + postalCodeSearchCriteria.getStartRow();
		}
		if (postalCodeSearchCriteria.isOROperator()) {
			url = url + "&operator=OR";
		}
		if (postalCodeSearchCriteria.isReduced() != null) {
			url = url + "&isReduced="
					+ postalCodeSearchCriteria.isReduced().toString();
		}
		if (postalCodeSearchCriteria.getBoundingBox() != null) {
			url = url + "&east="
					+ postalCodeSearchCriteria.getBoundingBox().getEast();
			url = url + "&west="
					+ postalCodeSearchCriteria.getBoundingBox().getWest();
			url = url + "&north="
					+ postalCodeSearchCriteria.getBoundingBox().getNorth();
			url = url + "&south="
					+ postalCodeSearchCriteria.getBoundingBox().getSouth();
		}

		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("code")) {
			Element codeElement = (Element) obj;
			PostalCode code = getPostalCodeFromElement(codeElement);
			postalCodes.add(code);
		}

		return postalCodes;
	}

	/**
	 * returns a list of postal codes
	 * 
	 * @param postalCodeSearchCriteria
	 * @return
	 * @throws Exception
	 */
	public static List<PostalCode> findNearbyPostalCodes(
			PostalCodeSearchCriteria postalCodeSearchCriteria) throws Exception {

		List<PostalCode> postalCodes = new ArrayList<PostalCode>();

		String url = "/findNearbyPostalCodes?";
		if (postalCodeSearchCriteria.getPostalCode() != null) {
			url = url
					+ "&postalcode="
					+ URLEncoder.encode(
							postalCodeSearchCriteria.getPostalCode(), "UTF8");
		}
		if (postalCodeSearchCriteria.getPlaceName() != null) {
			url = url
					+ "&placename="
					+ URLEncoder.encode(
							postalCodeSearchCriteria.getPlaceName(), "UTF8");
		}
		if (postalCodeSearchCriteria.getCountryCode() != null) {
			url = url + "&country=" + postalCodeSearchCriteria.getCountryCode();
		}

		if (postalCodeSearchCriteria.getLatitude() != null) {
			url = url + "&lat=" + postalCodeSearchCriteria.getLatitude();
		}
		if (postalCodeSearchCriteria.getLongitude() != null) {
			url = url + "&lng=" + postalCodeSearchCriteria.getLongitude();
		}
		if (postalCodeSearchCriteria.getStyle() != null) {
			url = url + "&style=" + postalCodeSearchCriteria.getStyle();
		}
		if (postalCodeSearchCriteria.getMaxRows() > 0) {
			url = url + "&maxRows=" + postalCodeSearchCriteria.getMaxRows();
		}

		if (postalCodeSearchCriteria.getRadius() > 0) {
			url = url + "&radius=" + postalCodeSearchCriteria.getRadius();
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("code")) {
			Element codeElement = (Element) obj;
			PostalCode code = getPostalCodeFromElement(codeElement);
			if (codeElement.getChildText("distance") != null) {
				code.setDistance(Double.parseDouble(codeElement
						.getChildText("distance")));
			}
			postalCodes.add(code);
		}

		return postalCodes;
	}

	private static PostalCode getPostalCodeFromElement(Element codeElement)
			throws ParseException {
		PostalCode code = new PostalCode();
		code.setPostalCode(codeElement.getChildText("postalcode"));
		code.setPlaceName(codeElement.getChildText("name"));
		code.setCountryCode(codeElement.getChildText("countryCode"));

		code.setLatitude(Double.parseDouble(codeElement.getChildText("lat")));
		code.setLongitude(Double.parseDouble(codeElement.getChildText("lng")));

		code.setAdminName1(codeElement.getChildText("adminName1"));
		code.setAdminCode1(codeElement.getChildText("adminCode1"));
		code.setAdminName2(codeElement.getChildText("adminName2"));
		code.setAdminCode2(codeElement.getChildText("adminCode2"));
		code.setAdminName3(codeElement.getChildText("adminName3"));
		code.setAdminCode3(codeElement.getChildText("adminCode3"));
		return code;
	}

	/**
	 * convenience method for
	 * {@link #findNearbyPlaceName(double,double,double,int)}
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static List<Toponym> findNearbyPlaceName(double latitude,
			double longitude) throws IOException, Exception {
		return findNearbyPlaceName(latitude, longitude, 0, 0);
	}

	public static List<Toponym> findNearbyPlaceName(double latitude,
			double longitude, double radius, int maxRows) throws IOException,
			Exception {
		List<Toponym> places = new ArrayList<Toponym>();

		String url = "/findNearbyPlaceName?";

		url = url + "&lat=" + latitude;
		url = url + "&lng=" + longitude;
		if (radius > 0) {
			url = url + "&radius=" + radius;
		}
		if (maxRows > 0) {
			url = url + "&maxRows=" + maxRows;
		}
		url = addUserName(url);
		url = addDefaultStyle(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("geoname")) {
			Element toponymElement = (Element) obj;
			Toponym toponym = getToponymFromElement(toponymElement);
			places.add(toponym);
		}

		return places;
	}

	public static List<Toponym> findNearby(double latitude, double longitude,
			FeatureClass featureClass, String[] featureCodes)
			throws IOException, Exception {
		return findNearby(latitude, longitude, 0, featureClass, featureCodes,
				null, 0);
	}

	/* Overload function to allow backward compatibility */
	/**
	 * Based on the following inforamtion: Webservice Type : REST
	 * api.geonames.org/findNearbyWikipedia? Parameters : lang : language code
	 * (around 240 languages) (default = en) lat,lng, radius (in km), maxRows
	 * (default = 10) featureClass featureCode Example:
	 * http://api.geonames.org/findNearby?lat=47.3&lng=9
	 * 
	 * @param: latitude
	 * @param: longitude
	 * @param: radius
	 * @param: feature Class
	 * @param: feature Codes
	 * @param: language
	 * @param: maxRows
	 * @return: list of wikipedia articles
	 * @throws: Exception
	 */
	public static List<Toponym> findNearby(double latitude, double longitude,
			double radius, FeatureClass featureClass, String[] featureCodes,
			String language, int maxRows) throws IOException, Exception {
		List<Toponym> places = new ArrayList<Toponym>();

		String url = "/findNearby?";

		url += "&lat=" + latitude;
		url += "&lng=" + longitude;
		if (radius > 0) {
			url = url + "&radius=" + radius;
		}
		if (maxRows > 0) {
			url = url + "&maxRows=" + maxRows;
		}

		if (language != null) {
			url = url + "&lang=" + language;
		}

		if (featureClass != null) {
			url += "&featureClass=" + featureClass;
		}
		if (featureCodes != null && featureCodes.length > 0) {
			for (String featureCode : featureCodes) {
				url += "&featureCode=" + featureCode;
			}
		}

		url = addUserName(url);
		url = addDefaultStyle(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("geoname")) {
			Element toponymElement = (Element) obj;
			Toponym toponym = getToponymFromElement(toponymElement);
			places.add(toponym);
		}

		return places;
	}

	/**
	 * 
	 * @param geoNameId
	 * @param language
	 *            - optional
	 * @param style
	 *            - optional
	 * @return the toponym for the geoNameId
	 * @throws IOException
	 * @throws Exception
	 */
	public static Toponym get(int geoNameId, String language, String style)
			throws IOException, Exception {
		String url = "/get?";

		url += "geonameId=" + geoNameId;

		if (language != null) {
			url = url + "&lang=" + language;
		}

		if (style != null) {
			url = url + "&style=" + style;
		} else {
			url = addDefaultStyle(url);
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		Toponym toponym = getToponymFromElement(root);
		return toponym;
	}

	/**
	 * for US only
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static Address findNearestAddress(double latitude, double longitude)
			throws IOException, Exception {

		String url = "/findNearestAddress?";

		url = url + "&lat=" + latitude;
		url = url + "&lng=" + longitude;
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("address")) {
			Element codeElement = (Element) obj;
			Address address = new Address();
			address.setStreet(codeElement.getChildText("street"));
			address.setStreetNumber(codeElement.getChildText("streetNumber"));
			address.setMtfcc(codeElement.getChildText("mtfcc"));

			address.setPostalCode(codeElement.getChildText("postalcode"));
			address.setPlaceName(codeElement.getChildText("placename"));
			address.setCountryCode(codeElement.getChildText("countryCode"));

			address.setLatitude(Double.parseDouble(codeElement
					.getChildText("lat")));
			address.setLongitude(Double.parseDouble(codeElement
					.getChildText("lng")));

			address.setAdminName1(codeElement.getChildText("adminName1"));
			address.setAdminCode1(codeElement.getChildText("adminCode1"));
			address.setAdminName2(codeElement.getChildText("adminName2"));
			address.setAdminCode2(codeElement.getChildText("adminCode2"));

			address.setDistance(Double.parseDouble(codeElement
					.getChildText("distance")));

			return address;
		}

		return null;
	}

	public static Intersection findNearestIntersection(double latitude,
			double longitude) throws Exception {
		return findNearestIntersection(latitude, longitude, 0);
	}

	public static Intersection findNearestIntersection(double latitude,
			double longitude, double radius) throws Exception {

		String url = "/findNearestIntersection?";

		url = url + "&lat=" + latitude;
		url = url + "&lng=" + longitude;
		if (radius > 0) {
			url = url + "&radius=" + radius;
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("intersection")) {
			Element e = (Element) obj;
			Intersection intersection = new Intersection();
			intersection.setStreet1(e.getChildText("street1"));
			intersection.setStreet2(e.getChildText("street2"));
			intersection.setLatitude(Double.parseDouble(e.getChildText("lat")));
			intersection
					.setLongitude(Double.parseDouble(e.getChildText("lng")));
			intersection.setDistance(Double.parseDouble(e
					.getChildText("distance")));
			intersection.setPostalCode(e.getChildText("postalcode"));
			intersection.setPlaceName(e.getChildText("placename"));
			intersection.setCountryCode(e.getChildText("countryCode"));
			intersection.setAdminName2(e.getChildText("adminName2"));
			intersection.setAdminCode1(e.getChildText("adminCode1"));
			intersection.setAdminName1(e.getChildText("adminName1"));
			return intersection;
		}
		return null;
	}

	/**
	 * 
	 * @see <a * href=
	 *      "http://www.geonames.org/maps/reverse-geocoder.html#findNearbyStreets"
	 *      > web service documentation</a>
	 * 
	 * @param latitude
	 * @param longitude
	 * @param radius
	 * @return
	 * @throws Exception
	 */
	public static List<StreetSegment> findNearbyStreets(double latitude,
			double longitude, double radius) throws Exception {

		String url = "/findNearbyStreets?";

		url = url + "&lat=" + latitude;
		url = url + "&lng=" + longitude;
		if (radius > 0) {
			url = url + "&radius=" + radius;
		}
		url = addUserName(url);

		List<StreetSegment> segments = new ArrayList<StreetSegment>();

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("streetSegment")) {
			Element e = (Element) obj;
			StreetSegment streetSegment = new StreetSegment();
			String line = e.getChildText("line");
			String[] points = line.split(",");
			double[] latArray = new double[points.length];
			double[] lngArray = new double[points.length];
			for (int i = 0; i < points.length; i++) {
				String[] coords = points[i].split(" ");
				lngArray[i] = Double.parseDouble(coords[0]);
				latArray[i] = Double.parseDouble(coords[1]);
			}

			streetSegment.setCfcc(e.getChildText("cfcc"));
			streetSegment.setName(e.getChildText("name"));
			streetSegment.setFraddl(e.getChildText("fraddl"));
			streetSegment.setFraddr(e.getChildText("fraddr"));
			streetSegment.setToaddl(e.getChildText("toaddl"));
			streetSegment.setToaddr(e.getChildText("toaddr"));
			streetSegment.setPostalCode(e.getChildText("postalcode"));
			streetSegment.setPlaceName(e.getChildText("placename"));
			streetSegment.setCountryCode(e.getChildText("countryCode"));
			streetSegment.setAdminName2(e.getChildText("adminName2"));
			streetSegment.setAdminCode1(e.getChildText("adminCode1"));
			streetSegment.setAdminName1(e.getChildText("adminName1"));
			segments.add(streetSegment);
		}
		return segments;
	}

	public static List<StreetSegment> findNearbyStreetsOSM(double latitude,
			double longitude, double radius) throws Exception {

		String url = "/findNearbyStreetsOSM?";

		url = url + "&lat=" + latitude;
		url = url + "&lng=" + longitude;
		if (radius > 0) {
			url = url + "&radius=" + radius;
		}
		url = addUserName(url);

		List<StreetSegment> segments = new ArrayList<StreetSegment>();

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("streetSegment")) {
			Element e = (Element) obj;
			StreetSegment streetSegment = new StreetSegment();
			String line = e.getChildText("line");
			String[] points = line.split(",");
			double[] latArray = new double[points.length];
			double[] lngArray = new double[points.length];
			for (int i = 0; i < points.length; i++) {
				String[] coords = points[i].split(" ");
				lngArray[i] = Double.parseDouble(coords[0]);
				latArray[i] = Double.parseDouble(coords[1]);
			}

			streetSegment.setName(e.getChildText("name"));
			segments.add(streetSegment);
		}
		return segments;
	}
	
	/**
	 * Find the nearest address for a given lat/lng pair. Supports several countries.
	 * 
	 * See documentation for the list of supported countries:
	 * 
	 * 	 * @see <a href="http://www.geonames.org/maps/addresses.html#address">address
	 *      web service documentation</a>
	 *
	 *
	 * @param latitude
	 * @param longitude
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static Address address(double latitude, double longitude)
			throws IOException, Exception {

		String url = "/address?";

		url = url + "&lat=" + latitude;
		url = url + "&lng=" + longitude;
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("address")) {
			Element codeElement = (Element) obj;
			Address address = new Address();
			address.setStreet(codeElement.getChildText("street"));
			address.setStreetNumber(codeElement.getChildText("houseNumber"));

			address.setPostalCode(codeElement.getChildText("postalcode"));
			address.setPlaceName(codeElement.getChildText("locality"));
			address.setCountryCode(codeElement.getChildText("countryCode"));

			address.setLatitude(Double.parseDouble(codeElement
					.getChildText("lat")));
			address.setLongitude(Double.parseDouble(codeElement
					.getChildText("lng")));

			address.setAdminName1(codeElement.getChildText("adminName1"));
			address.setAdminCode1(codeElement.getChildText("adminCode1"));
			address.setAdminName2(codeElement.getChildText("adminName2"));
			address.setAdminCode2(codeElement.getChildText("adminCode2"));
			address.setAdminName3(codeElement.getChildText("adminName3"));
			address.setAdminCode3(codeElement.getChildText("adminCode3"));

			address.setDistance(Double.parseDouble(codeElement
					.getChildText("distance")));

			return address;
		}

		return null;
	}

	/**
	 * Returns location lat/lng and admin information for a given address.
	 * 
	 * See documentation for the list of supported countries:
	 * 
	 * 	 * @see <a href="http://www.geonames.org/maps/addresses.html#geoCodeAddress">geoCodeAddress
	 *      web service documentation</a>
	 * 
	 * @param q
	 * @param country
	 * @param postalcode
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static Address geoCodeAddress(String q, String country, String postalcode)
			throws IOException, Exception {

		String url = "/geoCodeAddress?";

		url = url + "&q=" + URLEncoder.encode(q, "UTF8");
		if (country != null && !country.isEmpty()) {
		url = url + "&country=" + country;
		}
		if (postalcode != null && !postalcode.isEmpty()) {
			url = url + "&postalcode=" + URLEncoder.encode(postalcode, "UTF8");			
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("address")) {
			Element codeElement = (Element) obj;
			Address address = new Address();
			address.setStreet(codeElement.getChildText("street"));
			address.setStreetNumber(codeElement.getChildText("houseNumber"));

			address.setPostalCode(codeElement.getChildText("postalcode"));
			address.setPlaceName(codeElement.getChildText("locality"));
			address.setCountryCode(codeElement.getChildText("countryCode"));

			address.setLatitude(Double.parseDouble(codeElement
					.getChildText("lat")));
			address.setLongitude(Double.parseDouble(codeElement
					.getChildText("lng")));

			address.setAdminName1(codeElement.getChildText("adminName1"));
			address.setAdminCode1(codeElement.getChildText("adminCode1"));
			address.setAdminName2(codeElement.getChildText("adminName2"));
			address.setAdminCode2(codeElement.getChildText("adminCode2"));
			address.setAdminName3(codeElement.getChildText("adminName3"));
			address.setAdminCode3(codeElement.getChildText("adminCode3"));

			return address;
		}

		return null;
	}
	/**
	 * convenience method for {@link #search(ToponymSearchCriteria)}
	 * 
	 * @see <a href="http://www.geonames.org/export/geonames-search.html">search
	 *      web service documentation</a>
	 * 
	 * @param q
	 * @param countryCode
	 * @param name
	 * @param featureCodes
	 * @param startRow
	 * @return
	 * @throws Exception
	 */
	public static ToponymSearchResult search(String q, String countryCode,
			String name, String[] featureCodes, int startRow) throws Exception {
		return search(q, countryCode, name, featureCodes, startRow, null, null,
				null);
	}

	/**
	 * convenience method for {@link #search(ToponymSearchCriteria)}
	 * 
	 * The string fields will be transparently utf8 encoded within the call.
	 * 
	 * @see <a href="http://www.geonames.org/export/geonames-search.html">search
	 *      web service documentation</a>
	 * 
	 * @param q
	 *            search over all fields
	 * @param countryCode
	 * @param name
	 *            search over name only
	 * @param featureCodes
	 * @param startRow
	 * @param language
	 * @param style
	 * @param exactName
	 * @return
	 * @throws Exception
	 */
	public static ToponymSearchResult search(String q, String countryCode,
			String name, String[] featureCodes, int startRow, String language,
			Style style, String exactName) throws Exception {
		ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
		searchCriteria.setQ(q);
		searchCriteria.setCountryCode(countryCode);
		searchCriteria.setName(name);
		searchCriteria.setFeatureCodes(featureCodes);
		searchCriteria.setStartRow(startRow);
		searchCriteria.setLanguage(language);
		searchCriteria.setStyle(style);
		searchCriteria.setNameEquals(exactName);
		return search(searchCriteria);
	}

	/**
	 * full text search on the GeoNames database.
	 * 
	 * This service gets the number of toponyms defined by the 'maxRows'
	 * parameter. The parameter 'style' determines which fields are returned by
	 * the service.
	 * 
	 * @see <a href="http://www.geonames.org/export/geonames-search.html">search
	 *      web service documentation</a>
	 * 
	 * <br>
	 * 
	 *      <pre>
	 * ToponymSearchCriteria searchCriteria = new ToponymSearchCriteria();
	 * searchCriteria.setQ(&quot;z&amp;uumlrich&quot;);
	 * ToponymSearchResult searchResult = WebService.search(searchCriteria);
	 * for (Toponym toponym : searchResult.toponyms) {
	 * 	System.out.println(toponym.getName() + &quot; &quot; + toponym.getCountryName());
	 * }
	 * </pre>
	 * 
	 * 
	 * @param searchCriteria
	 * @return
	 * @throws Exception
	 */
	public static ToponymSearchResult search(
			ToponymSearchCriteria searchCriteria) throws Exception {
		ToponymSearchResult searchResult = new ToponymSearchResult();

		String url = "/search?";

		if (searchCriteria.getQ() != null) {
			url = url + "q=" + URLEncoder.encode(searchCriteria.getQ(), "UTF8");
		}
		if (searchCriteria.getNameEquals() != null) {
			url = url + "&name_equals="
					+ URLEncoder.encode(searchCriteria.getNameEquals(), "UTF8");
		}
		if (searchCriteria.getNameStartsWith() != null) {
			url = url
					+ "&name_startsWith="
					+ URLEncoder.encode(searchCriteria.getNameStartsWith(),
							"UTF8");
		}

		if (searchCriteria.getName() != null) {
			url = url + "&name="
					+ URLEncoder.encode(searchCriteria.getName(), "UTF8");
		}

		if (searchCriteria.getTag() != null) {
			url = url + "&tag="
					+ URLEncoder.encode(searchCriteria.getTag(), "UTF8");
		}

		if (searchCriteria.getCountryCode() != null) {
			url = url + "&country=" + searchCriteria.getCountryCode();
		}
		if (searchCriteria.getCountryCodes() != null) {
			for (String countryCode : searchCriteria.getCountryCodes()) {
				url = url + "&country=" + countryCode;
			}
		}
		if (searchCriteria.getCountryBias() != null) {
			if (!url.endsWith("&")) {
				url = url + "&";
			}
			url = url + "countryBias=" + searchCriteria.getCountryBias();
		}
		if (searchCriteria.getContinentCode() != null) {
			url = url + "&continentCode=" + searchCriteria.getContinentCode();
		}

		if (searchCriteria.getAdminCode1() != null) {
			url = url + "&adminCode1="
					+ URLEncoder.encode(searchCriteria.getAdminCode1(), "UTF8");
		}
		if (searchCriteria.getAdminCode2() != null) {
			url = url + "&adminCode2="
					+ URLEncoder.encode(searchCriteria.getAdminCode2(), "UTF8");
		}
		if (searchCriteria.getAdminCode3() != null) {
			url = url + "&adminCode3="
					+ URLEncoder.encode(searchCriteria.getAdminCode3(), "UTF8");
		}
		if (searchCriteria.getAdminCode4() != null) {
			url = url + "&adminCode4="
					+ URLEncoder.encode(searchCriteria.getAdminCode4(), "UTF8");
		}

		if (searchCriteria.getLanguage() != null) {
			url = url + "&lang=" + searchCriteria.getLanguage();
		}

		if (searchCriteria.getFeatureClass() != null) {
			url = url + "&featureClass=" + searchCriteria.getFeatureClass();
		}

		if (searchCriteria.getFeatureCodes() != null) {
			for (String featureCode : searchCriteria.getFeatureCodes()) {
				url = url + "&fcode=" + featureCode;
			}
		}
		if (searchCriteria.getMaxRows() > 0) {
			url = url + "&maxRows=" + searchCriteria.getMaxRows();
		}
		if (searchCriteria.getStartRow() > 0) {
			url = url + "&startRow=" + searchCriteria.getStartRow();
		}
		if (searchCriteria.getFuzzy() != 1.0) {
			url = url + "&fuzzy=" + searchCriteria.getFuzzy();
		}

		if (searchCriteria.getBoundingBox() != null) {
			url = url + "&east=" + searchCriteria.getBoundingBox().getEast();
			url = url + "&west=" + searchCriteria.getBoundingBox().getWest();
			url = url + "&north=" + searchCriteria.getBoundingBox().getNorth();
			url = url + "&south=" + searchCriteria.getBoundingBox().getSouth();
		}

		if (searchCriteria.getStyle() != null) {
			url = url + "&style=" + searchCriteria.getStyle();
		} else {
			url = addDefaultStyle(url);
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		searchResult.totalResultsCount = Integer.parseInt(root
				.getChildText("totalResultsCount"));
		searchResult.setStyle(Style.valueOf(root.getAttributeValue("style")));

		for (Object obj : root.getChildren("geoname")) {
			Element toponymElement = (Element) obj;
			Toponym toponym = getToponymFromElement(toponymElement);
			toponym.setStyle(searchResult.getStyle());
			searchResult.toponyms.add(toponym);
		}

		return searchResult;
	}

	/**
	 * returns the children in the administrative hierarchy of a toponym. With
	 * default maxRows.
	 * 
	 * @param geonameId
	 * @param language
	 * @param style
	 * @return
	 * @throws Exception
	 */
	public static ToponymSearchResult children(int geonameId, String language,
			Style style) throws Exception {
		return children(geonameId, language, style, 0);
	}

	/**
	 * 
	 * @param geonameId
	 * @param language
	 * @param style
	 * @param maxRows
	 * @return
	 * @throws Exception
	 */
	public static ToponymSearchResult children(int geonameId, String language,
			Style style, int maxRows) throws Exception {

		ToponymSearchResult searchResult = new ToponymSearchResult();

		String url = "/children?";

		url = url + "geonameId=" + geonameId;

		if (language != null) {
			url = url + "&lang=" + language;
		}
		if (maxRows != 0) {
			url += "&maxRows=" + maxRows;
		}

		if (style != null) {
			url = url + "&style=" + style;
		} else {
			url = addDefaultStyle(url);
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		searchResult.totalResultsCount = Integer.parseInt(root
				.getChildText("totalResultsCount"));
		searchResult.setStyle(Style.valueOf(root.getAttributeValue("style")));

		for (Object obj : root.getChildren("geoname")) {
			Element toponymElement = (Element) obj;
			Toponym toponym = getToponymFromElement(toponymElement);
			searchResult.toponyms.add(toponym);
		}

		return searchResult;
	}

	/**
	 * returns the neighbours of a toponym.
	 * 
	 * @param geonameId
	 * @param language
	 * @param style
	 * @return
	 * @throws Exception
	 */
	public static ToponymSearchResult neighbours(int geonameId,
			String language, Style style) throws Exception {
		ToponymSearchResult searchResult = new ToponymSearchResult();

		String url = "/neighbours?";

		url = url + "geonameId=" + geonameId;

		if (language != null) {
			url = url + "&lang=" + language;
		}

		if (style != null) {
			url = url + "&style=" + style;
		} else {
			url = addDefaultStyle(url);
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		searchResult.totalResultsCount = Integer.parseInt(root
				.getChildText("totalResultsCount"));
		searchResult.setStyle(Style.valueOf(root.getAttributeValue("style")));

		for (Object obj : root.getChildren("geoname")) {
			Element toponymElement = (Element) obj;
			Toponym toponym = getToponymFromElement(toponymElement);
			searchResult.toponyms.add(toponym);
		}

		return searchResult;
	}

	/**
	 * returns the hierarchy for a geonameId
	 * 
	 * @see <a
	 *      href="http://www.geonames.org/export/place-hierarchy.html#hierarchy">Hierarchy
	 *      service description</a>
	 * 
	 * @param geonameId
	 * @param language
	 * @param style
	 * @return
	 * @throws Exception
	 */
	public static List<Toponym> hierarchy(int geonameId, String language,
			Style style) throws Exception {

		String url = "/hierarchy?";

		url = url + "geonameId=" + geonameId;

		if (language != null) {
			url = url + "&lang=" + language;
		}

		if (style != null) {
			url = url + "&style=" + style;
		} else {
			url = addDefaultStyle(url);
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		List<Toponym> toponyms = new ArrayList<Toponym>();
		for (Object obj : root.getChildren("geoname")) {
			Element toponymElement = (Element) obj;
			Toponym toponym = getToponymFromElement(toponymElement);
			toponyms.add(toponym);
		}

		return toponyms;
	}

	public static void saveTags(String[] tags, Toponym toponym,
			String username, String password) throws Exception {
		if (toponym.getGeoNameId() == 0) {
			throw new Error("no geonameid specified");
		}

		// FIXME proper url
		String url = "/servlet/geonames?srv=61";

		url = url + "&geonameId=" + toponym.getGeoNameId();
		url = addUserName(url);

		StringBuilder tagsCommaseparated = new StringBuilder();
		for (String tag : tags) {
			tagsCommaseparated.append(tag + ",");
		}
		url = url + "&tag=" + tagsCommaseparated;

		Element root = connectAndParse(url);
	}

	/**
	 * full text search on geolocated wikipedia articles.
	 * 
	 * @param q
	 * @param language
	 * @return
	 * @throws Exception
	 */
	public static List<WikipediaArticle> wikipediaSearch(String q,
			String language) throws Exception {
		List<WikipediaArticle> articles = new ArrayList<WikipediaArticle>();

		String url = "/wikipediaSearch?";

		url = url + "q=" + URLEncoder.encode(q, "UTF8");

		if (language != null) {
			url = url + "&lang=" + language;
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("entry")) {
			Element wikipediaArticleElement = (Element) obj;
			WikipediaArticle wikipediaArticle = getWikipediaArticleFromElement(wikipediaArticleElement);
			articles.add(wikipediaArticle);
		}

		return articles;
	}

	/**
	 * full text search on geolocated wikipedia articles.
	 * 
	 * @param title
	 * @param language
	 * @return
	 * @throws Exception
	 */
	public static List<WikipediaArticle> wikipediaSearchForTitle(String title,
			String language) throws Exception {
		List<WikipediaArticle> articles = new ArrayList<WikipediaArticle>();

		String url = "/wikipediaSearch?";

		url = url + "title=" + URLEncoder.encode(title, "UTF8");

		if (language != null) {
			url = url + "&lang=" + language;
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("entry")) {
			Element wikipediaArticleElement = (Element) obj;
			WikipediaArticle wikipediaArticle = getWikipediaArticleFromElement(wikipediaArticleElement);
			articles.add(wikipediaArticle);
		}

		return articles;
	}

	public static List<WikipediaArticle> findNearbyWikipedia(double latitude,
			double longitude, String language) throws Exception {
		return findNearbyWikipedia(latitude, longitude, 0, language, 0);
	}

	/* Overload function to allow backward compatibility */
	/**
	 * Based on the following inform: Webservice Type : REST
	 * api.geonames.org/findNearbyWikipedia? Parameters : lang : language code
	 * (around 240 languages) (default = en) lat,lng, radius (in km), maxRows
	 * (default = 5) Example:
	 * http://api.geonames.org/findNearbyWikipedia?lat=47&lng=9
	 * 
	 * @param: latitude
	 * @param: longitude
	 * @param: radius
	 * @param: language
	 * @param: maxRows
	 * @return: list of wikipedia articles
	 * @throws: Exception
	 */
	public static List<WikipediaArticle> findNearbyWikipedia(double latitude,
			double longitude, double radius, String language, int maxRows)
			throws Exception {

		List<WikipediaArticle> articles = new ArrayList<WikipediaArticle>();

		String url = "/findNearbyWikipedia?";

		url = url + "lat=" + latitude;
		url = url + "&lng=" + longitude;
		if (radius > 0) {
			url = url + "&radius=" + radius;
		}
		if (maxRows > 0) {
			url = url + "&maxRows=" + maxRows;
		}

		if (language != null) {
			url = url + "&lang=" + language;
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("entry")) {
			Element wikipediaArticleElement = (Element) obj;
			WikipediaArticle wikipediaArticle = getWikipediaArticleFromElement(wikipediaArticleElement);
			articles.add(wikipediaArticle);
		}

		return articles;
	}

	/**
	 * GTOPO30 is a global digital elevation model (DEM) with a horizontal grid
	 * spacing of 30 arc seconds (approximately 1 kilometer). GTOPO30 was
	 * derived from several raster and vector sources of topographic
	 * information.
	 * 
	 * @param latitude
	 * @param longitude
	 * @return a single number giving the elevation in meters according to
	 *         gtopo30, ocean areas have been masked as "no data" and have been
	 *         assigned a value of -9999
	 * @throws IOException
	 * @throws GeoNamesException 
	 */
	public static int gtopo30(double latitude, double longitude)
			throws IOException, GeoNamesException {
		String url = "/gtopo30?lat=" + latitude + "&lng=" + longitude;
		url = addUserName(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connect(url)));
		String gtopo30 = in.readLine();
		in.close();
		checkException(gtopo30);
		return Integer.parseInt(gtopo30);
	}

	/**
	 * Shuttle Radar Topography Mission (SRTM) elevation data. SRTM consisted of
	 * a specially modified radar system that flew onboard the Space Shuttle
	 * Endeavour during an 11-day mission in February of 2000. The dataset
	 * covers land areas between 60 degrees north and 56 degrees south. This web
	 * service is using SRTM3 data with data points located every 3-arc-second
	 * (approximately 90 meters) on a latitude/longitude grid.
	 * 
	 * @param latitude
	 * @param longitude
	 * @return elevation or -32768 if unknown
	 * @throws IOException
	 * @throws GeoNamesException 
	 */
	public static int srtm3(double latitude, double longitude)
			throws IOException, GeoNamesException {
		String url = "/srtm3?lat=" + latitude + "&lng=" + longitude;
		url = addUserName(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connect(url)));
		String srtm3 = in.readLine();
		in.close();
		checkException(srtm3);
		return Integer.parseInt(srtm3);
	}

	public static int[] srtm3(double[] latitude, double[] longitude)
			throws IOException {
		if (latitude.length != longitude.length) {
			throw new Error("number of lats and longs must be equal");
		}
		int[] elevation = new int[latitude.length];
		String lats = "";
		String lngs = "";
		for (int i = 0; i < elevation.length; i++) {
			lats += latitude[i] + ",";
			lngs += longitude[i] + ",";
		}
		String url = "/srtm3?lats=" + lats + "&lngs=" + lngs;
		url = addUserName(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connect(url)));
		for (int i = 0; i < elevation.length; i++) {
			String srtm3 = in.readLine();
			elevation[i] = Integer.parseInt(srtm3);
		}
		in.close();
		return elevation;
	}

	public static int astergdem(double latitude, double longitude)
			throws IOException, GeoNamesException {
		String url = "/astergdem?lat=" + latitude + "&lng=" + longitude;
		url = addUserName(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connect(url)));
		String astergdem = in.readLine();
		in.close();
		checkException(astergdem);
		return Integer.parseInt(astergdem);
	}

	public static int[] astergdem(double[] latitude, double[] longitude)
			throws IOException {
		if (latitude.length != longitude.length) {
			throw new Error("number of lats and longs must be equal");
		}
		int[] elevation = new int[latitude.length];
		String lats = "";
		String lngs = "";
		for (int i = 0; i < elevation.length; i++) {
			lats += latitude[i] + ",";
			lngs += longitude[i] + ",";
		}
		String url = "/astergdem?lats=" + lats + "&lngs=" + lngs;
		url = addUserName(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connect(url)));
		for (int i = 0; i < elevation.length; i++) {
			String astergdem = in.readLine();
			elevation[i] = Integer.parseInt(astergdem);
		}
		in.close();
		return elevation;
	}

	/**
	 * The iso country code of any given point. It is calling
	 * {@link #countryCode(double, double, double)} with radius=0.0
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 * @throws IOException
	 * @throws GeoNamesException
	 */
	public static String countryCode(double latitude, double longitude)
			throws IOException, GeoNamesException {
		return countryCode(latitude, longitude, 0);
	}

	/**
	 * The iso country code of any given point with radius for coastal areas.
	 * 
	 * @param latitude
	 * @param longitude
	 * @param radius
	 * 
	 * @return iso country code for the given latitude/longitude
	 * @throws IOException
	 * @throws GeoNamesException
	 */
	public static String countryCode(double latitude, double longitude,
			double radius) throws IOException, GeoNamesException {
		String url = "/countryCode?lat=" + latitude + "&lng=" + longitude;
		if (radius != 0) {
			url += "&radius=" + radius;
		}
		url = addUserName(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connect(url)));
		String cc = in.readLine();
		in.close();
		if (cc != null && cc.length() == 2) {
			return cc;
		}
		if (cc == null || cc.length() == 0) {
			// nothing found return null 
			return null;
		}
		// check whether we can parse an exception and throw it if we can
		checkException(cc);
		// something else was wrong, through generic exception
		throw new GeoNamesException("unhandled exception");
	}

	/**
	 * get the timezone for a given location
	 * 
	 * @param latitude
	 * @param longitude
	 * @return timezone at the given location
	 * @throws IOException
	 * @throws Exception
	 */
	public static Timezone timezone(double latitude, double longitude)
			throws IOException, Exception {

		String url = "/timezone?";
		double radius = 0;

		url = url + "&lat=" + latitude;
		url = url + "&lng=" + longitude;
		if (radius > 0) {
			url = url + "&radius=" + radius;
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("timezone")) {
			Element codeElement = (Element) obj;
			Timezone timezone = new Timezone();
			timezone.setTimezoneId(codeElement.getChildText("timezoneId"));
			timezone.setCountryCode(codeElement.getChildText("countryCode"));

			if (codeElement.getChildText("time") != null) {
				String minuteDateFmt = "yyyy-MM-dd HH:mm";
				SimpleDateFormat df = null;
				if (codeElement.getChildText("time").length() == minuteDateFmt
						.length()) {
					df = new SimpleDateFormat(minuteDateFmt);
				} else {
					df = new SimpleDateFormat(DATEFMT);
				}
				timezone.setTime(df.parse(codeElement.getChildText("time")));
				if (codeElement.getChildText("sunrise") != null) {
					timezone.setSunrise(df.parse(codeElement
							.getChildText("sunrise")));
				}
				if (codeElement.getChildText("sunset") != null) {
					timezone.setSunset(df.parse(codeElement
							.getChildText("sunset")));
				}
				timezone.setGmtOffset(Double.parseDouble(codeElement
						.getChildText("gmtOffset")));
				timezone.setDstOffset(Double.parseDouble(codeElement
						.getChildText("dstOffset")));
			}
			return timezone;
		}

		return null;
	}
	
	//FIXME  implement and test
	public static String ocean(double latitude, double longitude)
			throws IOException, Exception {

		String url = "/ocean?";
		double radius = 0;

		url = url + "&lat=" + latitude;
		url = url + "&lng=" + longitude;
		if (radius > 0) {
			url = url + "&radius=" + radius;
		}
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("ocean")) {
			Element oceanElement = (Element) obj;
			if (oceanElement != null) {
				return oceanElement.getChildText("name");				
			}
		}

		return null;
	}

	/**
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static WeatherObservation findNearByWeather(double latitude,
			double longitude) throws IOException, Exception {

		String url = "/findNearByWeatherXML?";

		url = url + "&lat=" + latitude;
		url = url + "&lng=" + longitude;
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("observation")) {
			Element weatherObservationElement = (Element) obj;
			WeatherObservation weatherObservation = getWeatherObservationFromElement(weatherObservationElement);
			return weatherObservation;
		}

		return null;
	}

	public static WeatherObservation weatherIcao(String icaoCode)
			throws IOException, Exception {

		String url = "/weatherIcaoXML?";

		url = url + "&ICAO=" + icaoCode;
		url = addUserName(url);

		Element root = connectAndParse(url);
		for (Object obj : root.getChildren("observation")) {
			Element weatherObservationElement = (Element) obj;
			WeatherObservation weatherObservation = getWeatherObservationFromElement(weatherObservationElement);
			return weatherObservation;
		}

		return null;
	}

	/**
	 * @return the geoNamesServer, default is http://api.geonames.org
	 */
	public static String getGeoNamesServer() {
		return geoNamesServer;
	}

	/**
	 * @return the geoNamesServerFailover
	 */
	public static String getGeoNamesServerFailover() {
		return geoNamesServerFailover;
	}

	/**
	 * sets the server name for the GeoNames server to be used for the requests.
	 * Default is api.geonames.org
	 * 
	 * @param geoNamesServer
	 *            the geonamesServer to set
	 */
	public static void setGeoNamesServer(String pGeoNamesServer) {
		if (pGeoNamesServer == null) {
			throw new Error();
		}
		pGeoNamesServer = pGeoNamesServer.trim().toLowerCase();
		// add default http protocol if it is missing
		if (!pGeoNamesServer.startsWith("http://")
				&& !pGeoNamesServer.startsWith("https://")) {
			pGeoNamesServer = "http://" + pGeoNamesServer;
		}
		WebService.geoNamesServer = pGeoNamesServer;
	}

	/**
	 * sets the default failover server for requests in case the main server is
	 * not accessible. Default is api.geonames.org<br>
	 * The failover server is only called if it is different from the main
	 * server.<br>
	 * The failover server is used for commercial GeoNames web service users.
	 * 
	 * @param geoNamesServerFailover
	 *            the geoNamesServerFailover to set
	 */
	public static void setGeoNamesServerFailover(String geoNamesServerFailover) {
		if (geoNamesServerFailover != null) {
			geoNamesServerFailover = geoNamesServerFailover.trim()
					.toLowerCase();
			if (!geoNamesServerFailover.startsWith("http://")
					&& !geoNamesServerFailover.startsWith("https://")) {
				geoNamesServerFailover = "http://" + geoNamesServerFailover;
			}
		}
		WebService.geoNamesServerFailover = geoNamesServerFailover;
	}

	/**
	 * @return the proxy
	 */
	public static Proxy getProxy() {
		return proxy;
	}

	/**
	 * @param proxy
	 *            the proxy to set
	 * 
	 *            If you are behind a proxy and cannot change the java system
	 *            properties, you can use this method to set a proxy. You define
	 *            it like this:
	 * 
	 *            <pre>
	 * <code>
	 *            java.net.SocketAddress sa = new java.net.InetSocketAddress("myproxyserver", 8080);
	 *            java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, sa);
	 *            </code>
	 * </pre>
	 */
	public static void setProxy(Proxy proxy) {
		WebService.proxy = proxy;
	}

	/**
	 * @return the userName
	 */
	public static String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name to be used for the requests. Needed to access the
	 * commercial GeoNames web services.
	 * 
	 * @param userName
	 *            the userName to set
	 */
	public static void setUserName(String userName) {
		WebService.userName = userName;
	}

	/**
	 * @return the token
	 */
	public static String getToken() {
		return token;
	}

	/**
	 * sets the token to be used to authenticate the requests. This is an
	 * optional parameter for the commercial version of the GeoNames web
	 * services.
	 * 
	 * @param token
	 *            the token to set
	 */
	public static void setToken(String token) {
		WebService.token = token;
	}

	/**
	 * @return the defaultStyle
	 */
	public static Style getDefaultStyle() {
		return defaultStyle;
	}

	/**
	 * @param defaultStyle
	 *            the defaultStyle to set
	 */
	public static void setDefaultStyle(Style defaultStyle) {
		WebService.defaultStyle = defaultStyle;
	}

	/**
	 * @return the readTimeOut
	 */
	public static int getReadTimeOut() {
		return readTimeOut;
	}

	/**
	 * @param readTimeOut
	 *            the readTimeOut to set
	 */
	public static void setReadTimeOut(int readTimeOut) {
		WebService.readTimeOut = readTimeOut;
	}

	/**
	 * @return the connectTimeOut
	 */
	public static int getConnectTimeOut() {
		return connectTimeOut;
	}

	/**
	 * @param connectTimeOut
	 *            the connectTimeOut to set
	 */
	public static void setConnectTimeOut(int connectTimeOut) {
		WebService.connectTimeOut = connectTimeOut;
	}

}
