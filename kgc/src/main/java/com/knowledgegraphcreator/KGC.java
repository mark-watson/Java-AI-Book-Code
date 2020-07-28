package com.knowledgegraphcreator;

import com.markwatson.ner_dbpedia.TextToDbpediaUris;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Java implementation of Knowledge Graph Creator.
 *
 * Copyright 2020 Mark Watson. All Rights Reserved. Apache 2 license.
 *
 * For documentation see my book "Practical Artificial Intelligence Programming
 * With Java", chapter "Automatically Generating Data for Knowledge Graphs"
 * at https://leanpub.com/javaai that can be read free online.
 *
 */

public class KGC  {

	static String subjectUri = "<http://www.w3.org/1999/02/22-rdf-syntax-ns#/subject>";
	static String labelUri = "<http://www.w3.org/1999/02/22-rdf-syntax-ns#/label>";
	static String countryTypeUri = "<http://www.w3.org/2000/01/rdf-schema#country>";
	static String personTypeUri = "<http://www.w3.org/2000/01/rdf-schema#person>";
	static String companyTypeUri = "<http://www.w3.org/2000/01/rdf-schema#company>";
	static String cityTypeUri = "<http://www.w3.org/2000/01/rdf-schema#city>";

	static String broadcastNetworkTypeUri = "<http://www.w3.org/2000/01/rdf-schema#broadcastNetwork>";
	static String musicGroupTypeUri = "<http://www.w3.org/2000/01/rdf-schema#musicGroup>";
	static String politicalPartyTypeUri = "<http://www.w3.org/2000/01/rdf-schema#politicalParty>";
	static String tradeUnionTypeUri = "<http://www.w3.org/2000/01/rdf-schema#tradeUnion>";
	static String universityTypeUri = "<http://www.w3.org/2000/01/rdf-schema#university>";

	static String typeOfUri = "<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>";
	private KGC() { }
	public KGC(String directoryPath, String outputRdfPath) throws IOException {
		System.out.println("KGN");
		PrintStream out = new PrintStream(outputRdfPath);
		File dir = new File(directoryPath);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				System.out.println("child:" + child);
				if (child.toString().endsWith(".txt")) {
					// try to open the meta file with the same extension:
					String metaAbsolutePath = child.getAbsolutePath();
					File meta = new File(metaAbsolutePath.substring(0, metaAbsolutePath.length() - 4) + ".meta");
					System.out.println("meta:" + meta);
					String [] text_and_meta = readData(child.getAbsolutePath(), meta.getAbsolutePath());
					String metaData = "<" + text_and_meta[1].strip() + ">";
					TextToDbpediaUris kt = new TextToDbpediaUris(text_and_meta[0]);
					for (int i=0; i<kt.personNames.size(); i++) {
						out.println(metaData + " " + subjectUri + " " + kt.personUris.get(i) + " .");
						out.println(kt.personUris.get(i) + " " + labelUri + " \"" + kt.personNames.get(i) + "\" .");
						out.println(kt.personUris.get(i) + " " + typeOfUri + " " + personTypeUri + " .");
					}
					for (int i=0; i<kt.companyNames.size(); i++) {
						out.println(metaData + " " + subjectUri + " " + kt.companyUris.get(i) + " .");
						out.println(kt.companyUris.get(i) + " " + labelUri + " \"" + kt.companyNames.get(i) + "\" .");
						out.println(kt.companyUris.get(i) + " " + typeOfUri + " " + companyTypeUri + " .");
					}
					for (int i=0; i<kt.cityNames.size(); i++) {
						out.println(metaData + " " + subjectUri + " " + kt.cityUris.get(i) + " .");
						out.println(kt.cityUris.get(i) + " " + labelUri + " \"" + kt.cityNames.get(i) + "\" .");
						out.println(kt.cityUris.get(i) + " " + typeOfUri + " " + cityTypeUri + " .");
					}
					for (int i=0; i<kt.countryNames.size(); i++) {
						out.println(metaData + " " + subjectUri + " " + kt.countryUris.get(i) + " .");
						out.println(kt.countryUris.get(i) + " " + labelUri + " \"" + kt.countryNames.get(i) + "\" .");
						out.println(kt.countryUris.get(i) + " " + typeOfUri + " " + countryTypeUri + " .");
					}
					for (int i=0; i<kt.broadcastNetworkNames.size(); i++) {
						out.println(metaData + " " + subjectUri + " " + kt.broadcastNetworkUris.get(i) + " .");
						out.println(kt.broadcastNetworkUris.get(i) + " " + labelUri + " \"" + kt.broadcastNetworkNames.get(i) + "\" .");
						out.println(kt.broadcastNetworkUris.get(i) + " " + typeOfUri + " " + broadcastNetworkTypeUri + " .");
					}
					for (int i=0; i<kt.musicGroupNames.size(); i++) {
						out.println(metaData + " " + subjectUri + " " + kt.musicGroupUris.get(i) + " .");
						out.println(kt.musicGroupUris.get(i) + " " + labelUri + " \"" + kt.musicGroupNames.get(i) + "\" .");
						out.println(kt.musicGroupUris.get(i) + " " + typeOfUri + " " + musicGroupTypeUri + " .");
					}
					for (int i=0; i<kt.politicalPartyNames.size(); i++) {
						out.println(metaData + " " + subjectUri + " " + kt.politicalPartyUris.get(i) + " .");
						out.println(kt.politicalPartyUris.get(i) + " " + labelUri + " \"" + kt.politicalPartyNames.get(i) + "\" .");
						out.println(kt.politicalPartyUris.get(i) + " " + typeOfUri + " " + politicalPartyTypeUri + " .");
					}
					for (int i=0; i<kt.tradeUnionNames.size(); i++) {
						out.println(metaData + " " + subjectUri + " " + kt.tradeUnionUris.get(i) + " .");
						out.println(kt.tradeUnionUris.get(i) + " " + labelUri + " \"" + kt.tradeUnionNames.get(i) + "\" .");
						out.println(kt.tradeUnionUris.get(i) + " " + typeOfUri + " " + tradeUnionTypeUri + " .");
					}
					for (int i=0; i<kt.universityNames.size(); i++) {
						out.println(metaData + " " + subjectUri + " " + kt.universityUris.get(i) + " .");
						out.println(kt.universityUris.get(i) + " " + labelUri + " \"" + kt.universityNames.get(i) + "\" .");
						out.println(kt.universityUris.get(i) + " " + typeOfUri + " " + universityTypeUri + " .");
					}
				}
			}
		}
		out.close();
	}

	private String [] readData(String textPath, String metaPath) throws IOException {
		String text = Files.readString(Paths.get(textPath), StandardCharsets.UTF_8);
		String meta = Files.readString(Paths.get(metaPath), StandardCharsets.UTF_8);
		System.out.println("\n\n** text:\n\n" + text);
		return new String[] { text, meta };
	}

}
