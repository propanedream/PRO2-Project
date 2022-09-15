package JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectMedlemmer {
	
	public static void main(String[] args) {

		try {
			Connection minConnection;
			minConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-Q2FFRF4\\SQLEXPRESS;databaseName=DAOSA - 2.sem lektion 2;user=sa;password=123456789;");

			Statement stmt = minConnection.createStatement();

			ResultSet res = stmt.executeQuery("select * from Medlem");
			while (res.next()) {
				System.out.println(res.getString(1)+ "\t"  + res.getString(2) + " \t "  +res.getString(3) );
			}

			res.close();
			stmt.close();
			minConnection.close();

			// sql exception før generel exception, da sql exceptions er specifikke

		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}
}
