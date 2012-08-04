package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DumpMetaData {

	public DumpMetaData(String connectionUrl) throws SQLException, ClassNotFoundException {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection conn = DriverManager.getConnection(connectionUrl);
		System.out.println("conn: " + conn);
		Statement s = conn.createStatement();
		DatabaseMetaData md = conn.getMetaData();
		
		// Discovery all table names in this database:
		List<String> tableNames = new ArrayList<String>(5);
		ResultSet table_rs = md.getTables(null, null, "%", new String[]{"TABLE"});
		while (table_rs.next()) {
			System.out.println("Table: " + table_rs.getString(3));
			tableNames.add(table_rs.getString(3));
		}
		
		// Loop over all tables printing column meta data and the first row:
		for (String tableName : tableNames) {
			System.out.println("\n\n** Processing table " + tableName + "\n");
			String query = "SELECT * from " + tableName;
			System.out.println(query);
			ResultSet rs = s.executeQuery(query);
			ResultSetMetaData table_meta = rs.getMetaData();
			int columnCount = table_meta.getColumnCount();
			System.out.println("\nColumn meta data for table:");
			List<String> columnNames = new ArrayList<String>(10);
			columnNames.add("");
			for (int col=1; col<=columnCount; col++) {
				System.out.println("Column " + col +  " name: " + table_meta.getColumnLabel(col));
				System.out.println("  column data type: " + table_meta.getColumnTypeName(col));
				columnNames.add(table_meta.getColumnLabel(col));
			}
			System.out.println("\nFirst row in table:");
			if (rs.next()) {
				for (int col=1; col<=columnCount; col++) {
					System.out.println("   " + columnNames.get(col) + ": " + rs.getString(col));
				}
			}
		}
	}
	
	
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		new DumpMetaData("jdbc:derby:test_database");

	}

}
