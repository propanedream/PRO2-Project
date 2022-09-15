package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Opgave2     {

    public static void main(String[] args) {
        Connection minConnection;

        try {

            minConnection = DriverManager
                    .getConnection("jdbc:sqlserver://DESKTOP-Q2FFRF4\\SQLExpress;databaseName=DAOS - Lektion 3;user=sa;password=123456789;");

            Statement stmt = minConnection.createStatement();

            ResultSet res = stmt.executeQuery("select *, m.mobil\n" +
                    "from Medarbejder M");
            while (res.next()) {
                System.out.println(res.getString(1) + "\t" + res.getString(2) + " \t " + res.getString(3)+ " \t " + res.getString(4));
            }

            res.close();
            stmt.close();
            if(!minConnection.isClosed()) {
                minConnection.close();
            }

        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}