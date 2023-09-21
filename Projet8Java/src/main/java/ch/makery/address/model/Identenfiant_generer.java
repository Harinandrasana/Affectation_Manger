package ch.makery.address.model;

import ch.makery.address.model.DBConnexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Identenfiant_generer {
    public static int generer_Id(String tablename, String columntoSelect) throws SQLException {
        Connection con = null;
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        con = DBConnexion.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT " + columntoSelect + "  FROM " + tablename + " ORDER BY " + columntoSelect + " ASC");

        if (resultSet.next()) {
            return generer_Id(tablename, columntoSelect);
        } else {
            con.close();
            return randomNumber;
        }
    }
}
