package opgave5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Opgave5 {
    public static void main(String[] args) {

        try {
            System.out.println("Opret Produkt: ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Indtast ProduktID: ");
            String produktID = inLine.readLine();
            System.out.print("Indtast produkt navn: ");
            String produktNavn = inLine.readLine();
            System.out.println("Indtast minimum antal");
            String minimumAntal = inLine.readLine();
            System.out.println("Intast antal på lager: ");
            String antalPålager= inLine.readLine();


            Connection minConnection;
            minConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-Q2FFRF4\\SQLEXPRESS;databaseName=DAOS - aarhus bryghus projekt;user=sa;password=123456789;");

            String sql = "insert into Produkt values(?,?,?,?) ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setString(1, produktID);
            prestmt.setString(2, produktNavn);
            prestmt.setString(3, minimumAntal);
            prestmt.setString(4, antalPålager);


            prestmt.executeUpdate();
            System.out.println("Produkt oprettet.");

            prestmt.close();
            minConnection.close();


        } catch (SQLException | IOException e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }
}
