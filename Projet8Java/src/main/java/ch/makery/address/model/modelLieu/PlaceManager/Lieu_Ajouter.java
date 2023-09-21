package ch.makery.address.model.modelLieu.PlaceManager;

import ch.makery.address.model.DBConnexion;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lieu_Ajouter
{
    public static void ajouter(String idlieu, String design, String province)
    {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String insert = "INSERT INTO LIEU(idLieu, design, province) VALUES(?,?,?)";
        con = DBConnexion.getConnection();
        try{
            st = con.prepareStatement(insert);
            st.setString(1,idlieu);
            st.setString(2,design);
            st.setString(3,province);
            st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
