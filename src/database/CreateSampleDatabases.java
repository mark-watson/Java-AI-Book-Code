package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.w3c.dom.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class CreateSampleDatabases {

	public static void main(String argv[]) {
		try {

			// open a database connection:
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection conn = DriverManager.getConnection("jdbc:derby:test_database;create=true");
			System.out.println("conn: " + conn);
			Statement s = conn.createStatement();
			
			// US STATES
			try { s.execute("drop table usstates"); } catch (Exception ignore) { }
			String sql2 = "create table usstates (name varchar(20), abbreviation char(2), industry varchar(200), agriculture varchar(200), population bigint)";
			System.out.println(sql2);
			s.execute(sql2);
            System.out.println("Created table usstates");

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File("test_data/xml/USstates.xml"));
            // normalize text representation
            doc.getDocumentElement().normalize();
			NodeList listOfStates = doc.getElementsByTagName("state");
			int totalStates = listOfStates.getLength();
			System.out.println("Total no of states : " + totalStates);

			for (int stateIndex = 0; stateIndex < totalStates; stateIndex++) {
				Node firstStateNode = listOfStates.item(stateIndex);
				if (firstStateNode.getNodeType() == Node.ELEMENT_NODE) {
					Element firstStateElement = (Element) firstStateNode;
					String name = firstStateElement.getAttribute("name").replaceAll("'", "");
					String abbreviation = firstStateElement.getAttribute("abbrev");
					String industry = firstStateElement.getAttribute("industry").replaceAll("'", "");
					String agriculture = firstStateElement.getAttribute("agriculture").replaceAll("'", "");
					long population = parseLong(firstStateElement
							.getAttribute("population"));
					String sql = "insert into usstates values ('"+name+"','"+abbreviation+"','"+industry+"','"+agriculture+"',"+population+")";
					System.out.println("\n"+sql+"\n");
					s.execute(sql);			
				}
			}

			// FACTBOOK
			try { s.execute("drop table factbook"); } catch (Exception ignore) { }
			sql2 = "create table factbook (name varchar(60), location varchar(150), export bigint, import bigint, debt bigint, aid bigint, unemployment_percent int, inflation_percent int)";
			System.out.println(sql2);
			s.execute(sql2);
            System.out.println("Created table factbook");
            
		    docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(new File(
					"test_data/xml/FactBook.xml"));
			// normalize text representation
			doc.getDocumentElement().normalize();
			System.out.println("Root element of XML document:  "
					+ doc.getDocumentElement().getNodeName());
			NodeList listOfCountrys = doc.getElementsByTagName("country");
			int totalCountrys = listOfCountrys.getLength();
			System.out.println("Total no of countries : " + totalCountrys);

			for (int countryIndex = 0; countryIndex < totalCountrys; countryIndex++) {
				Node firstCountryNode = listOfCountrys.item(countryIndex);
				if (firstCountryNode.getNodeType() == Node.ELEMENT_NODE) {
					Element firstCountryElement = (Element) firstCountryNode;
					String name = firstCountryElement.getAttribute("name").replaceAll("'", "");
					String location = firstCountryElement
							.getAttribute("location").replaceAll("'", "");
					if (location.length() > 150) location = location.substring(0,149);
					long population = parseLong(firstCountryElement
							.getAttribute("population"));
					long exports = (long)parseFloat(firstCountryElement
							.getAttribute("exports"));
					long imports = (long)parseFloat(firstCountryElement
							.getAttribute("imports"));
					long debt = (long)parseFloat(firstCountryElement
							.getAttribute("debt"));
					long aid = (long)parseFloat(firstCountryElement
							.getAttribute("aid"));
					long unemployment = (long)parseFloat(firstCountryElement
							.getAttribute("unemployment"));
					long inflation = (long)parseFloat(firstCountryElement
							.getAttribute("inflation"));

					System.out.println(name);
					System.out.println("  location: " + location);
					System.out.println("  population: " + population);
					System.out.println("  exports: " + exports);
					System.out.println("  imports: " + imports);
					System.out.println("  debt: " + debt);
					System.out.println("  aid: " + aid);
					System.out.println("  unemployment: " + unemployment);
					System.out.println("  inflation: " + inflation);
					String sql = "insert into factbook values ('"+name+"','"+location+"',"+exports+","+imports+","+debt+","+aid+","+unemployment+","+inflation+")";
					System.out.println("\n"+sql+"\n");
					s.execute(sql);
				}
			}
		} catch (Exception ex) {
			System.out.println("Error" + ex);
			ex.printStackTrace();
		}
	}

	private static float parseFloat(String s) {
		String orig = s;
		float ret = -1f;
		float scale = 1f;
		try {
			if (s.indexOf("million") > -1) scale = 1000000f;
			if (s.indexOf("billion") > -1) scale = 1000000000f;
			s = s.replaceAll("\\$", "");
			int index = s.indexOf("%");
			if (index > -1)
				s = s.substring(0, index);
			index = s.indexOf(" ");
			if (index > -1)
				s = s.substring(0, index);
			s = s.replaceAll(",", "");
			ret = Float.parseFloat(s);
		} catch (Exception ex) {
			//System.err.println("Error in parseFloat: " + ex + " for input: "
			//		+ orig + " current s: " + s);
		}
		return ret * scale;
	}

	private static long parseLong(String s) {
		String orig = s;
		long ret = -1;
		long scale = 1;
		try {
			if (s.indexOf("million") > -1) scale = 1000000;
			if (s.indexOf("billion") > -1) scale = 1000000000;
			s = s.replaceAll("\\$", "");
			int index = s.indexOf("%");
			if (index > -1)
				s = s.substring(0, index);
			index = s.indexOf(" ");
			if (index > -1)
				s = s.substring(0, index);
			s = s.replaceAll(",", "");
			ret = Integer.parseInt(s);
		} catch (Exception ex) {
			//System.err.println("Error in parseInt: " + ex + " for input: "
			//		+ orig + " current s: " + s);
		}
		return ret * scale;
	}
}
