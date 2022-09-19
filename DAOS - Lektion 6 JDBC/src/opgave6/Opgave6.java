package opgave6;

import java.sql.*;

public class Opgave6 {
    public static void main(String[] args) throws SQLException {
        Connection minConnection;
        minConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-Q2FFRF4\\SQLExpress;databaseName=DAOS - Lektion 3;user=sa;password=123456789;");
        Statement stmt = minConnection.createStatement();
        ResultSet res = stmt.executeQuery("Select max(medarbejdernr) from medarbejder");
        int højeste = 0;
        while (res.next()){

        }








        String sql = "insert into medarbejder values (?,?,?,?)";
        PreparedStatement prestmt = minConnection.prepareStatement(sql);
        prestmt.clearParameters();



    }

}
