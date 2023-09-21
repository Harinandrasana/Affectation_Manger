package ch.makery.address.model.modelLieu.PlaceManager;

import ch.makery.address.model.DBConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lieu_Supprimer {
    public static void supprimer(String idlieu) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String delete = "DELETE FROM LIEU WHERE idLieu = ?";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(delete);
            st.setString(1, idlieu);
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
