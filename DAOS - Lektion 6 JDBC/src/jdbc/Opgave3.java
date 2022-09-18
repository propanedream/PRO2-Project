package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Opgave3{

    public static void main(String[] args) {

        try {
            System.out.println("Find mobil nummer: ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Intast navn: ");
            String navn = inLine.readLine();


            Connection minConnection;
            minConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-Q2FFRF4\\SQLExpress;databaseName=DAOS - Lektion 3;user=sa;password=123456789;");

            String sql = "select * from medarbejder where navn = '?' ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();


            prestmt.setString(1, navn);


            ResultSet res = prestmt.executeQuery();

            while (res.next()) {
                System.out.println(res.getString(1) );
            }
            res.close();

            prestmt.close();
            minConnection.close();

        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }

}
