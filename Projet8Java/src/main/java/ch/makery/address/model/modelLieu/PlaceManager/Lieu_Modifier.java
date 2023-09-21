package ch.makery.address.model.modelLieu.PlaceManager;

import ch.makery.address.model.DBConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lieu_Modifier {
    public static void modifier(String idlieu, String design, String province)
    {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String update = "UPDATE LIEU SET design = ?, province = ? WHERE idLieu = ?";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(update);
            st.setString(1,design);
            st.setString(2,province);
            st.setString(3,idlieu);
            st.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
