package opgave3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class SelectMedarbejdere {
    public static void main(String[] args) {
        try {
            System.out.println("find Telefon nummer");
            BufferedReader inLine = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Indtast Medarbejdernavn: ");
            String navn = inLine.readLine();


            Connection minConnection;
            minConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-Q2FFRF4\\SQLEXPRESS;databaseName=DAOS - 2.sem lektion 3;user=sa;password=123456789;");
            Statement stmt = minConnection.createStatement();


            String sql = "select mobil from Medarbejder where navn = (?)";
            PreparedStatement pestmt = minConnection.prepareStatement(sql);
            pestmt.clearParameters();

            pestmt.setString(1, navn);


            ResultSet res = pestmt.executeQuery();
            while (res.next()) {
                System.out.println(res.getInt(1));
            }


            pestmt.close();
            stmt.close();
            minConnection.close();
        } catch (Exception e) {
            System.out.println("fejl:  " + e.getMessage());
        }
    }


}
