package miniprojekt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Miniprojekt {

    public static void main(String[] args) {
    //OPGAVE 7
        try {
            System.out.println("Opret karakter. ");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Indtast Karakter: ");
            String karakter = inLine.readLine();
            System.out.println("Intast semester: ");
            String semester = inLine.readLine();
            System.out.println("Indtast studienummer: ");
            String studieNr = inLine.readLine();
            System.out.println("Indtast cvrNr: ");
            String cvrNr = inLine.readLine();

            Connection minConnection;
            minConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://DESKTOP-Q2FFRF4\\SQLEXPRESS;databaseName=DAOS - 2.sem lektion 7 projekt;user=sa;password=123456789;");

            String sql = "insert into karakter values(?,?,?, ?) ";// preparedStatement
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();

            prestmt.setInt(1, Integer.parseInt(karakter));
            prestmt.setString(2, semester);
            prestmt.setInt(3, Integer.parseInt(studieNr));
            prestmt.setInt(4, Integer.parseInt(cvrNr));

            prestmt.executeUpdate();
            System.out.println("Karakter indsat.");

            prestmt.close();
            minConnection.close();
        } catch (SQLException e) {
//            System.out.println(e.getErrorCode());
//            System.out.println(e.getMessage());
            if (e.getErrorCode()==2627){
                System.out.println("Vælg venligst et andet id");
            }
            if (e.getErrorCode() == 8152){
                System.out.println("Vælg venligst et kortere semesternavn");
            }
            if (e.getErrorCode()==547){
                System.out.println("Foreign key constraint, tjek venligst om dine data er korrekte.");
            }

        }
        catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }

}

