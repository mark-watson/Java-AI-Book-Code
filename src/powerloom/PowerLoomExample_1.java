package powerloom;

import java.util.List;


public class PowerLoomExample_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Testing PowerLoom Wrapper Class");
		PowerLoomUtils plu = new PowerLoomUtils();
		plu.load("test_data/test.plm");
		plu.changeModule("BUSINESS");
		// Note: query strings broken over multiple lines
		// for better formatting in book example section:
		plu.assertProposition(
				"(and (company c1)" +
				"     (company-name c1 \"Moms Grocery\"))");
		plu.assertProposition(
				"(and (company c2)" +
				"     (company-name c2 \"IBM\"))");
		plu.assertProposition(
				"(and (company c3)" +
				"     (company-name c3 \"Apple\"))");
		List answers = plu.doQuery("all ?x (company ?x)");
		System.out.println(answers);
		answers = plu.doQuery(
				"all (?x ?name)" +
				"    (and" +
				"      (company ?x)" +
				"      (company-name ?x ?name))");
		System.out.println(answers);
		plu.createRelation("CEO", 2);
		plu.assertProposition(
				"(CEO \"Apple\" \"SteveJobs\")");
		answers = plu.doQuery(
				"all (?x ?name ?ceo)" +
				"    (and" +
				"      (company-name ?x ?name)" +
				"      (CEO ?name ?ceo))");
		System.out.println(answers);
	}

}
