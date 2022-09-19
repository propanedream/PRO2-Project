package opgave1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectMedarbejdere {
    public static void main(String[] args) {
        try {
            Connection minConnection;
            minConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-Q2FFRF4\\SQLEXPRESS;databaseName=DAOS - 2.sem lektion 3;user=sa;password=123456789;");

//            Statement stmt = minConnection.createStatement();
            Statement stmt = minConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet res = stmt.executeQuery("Select * from Medarbejder");
//            while (res.next()){
//                System.out.println(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3)+ "\t" + res.getString(4));
//            }
            while (res.next()){
            System.out.println(res.relative(2));}

//            System.out.println(res.relative(1));
            res.close();
            stmt.close();
            minConnection.close();

        } catch (Exception e){
            System.out.println("Fejl:  " + e.getMessage());
        }
    }






}
