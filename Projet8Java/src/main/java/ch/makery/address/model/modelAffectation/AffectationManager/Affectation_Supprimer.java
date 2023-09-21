package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.DBConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Affectation_Supprimer {
    public static boolean supprimer(int numAffectation) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String delete = "DELETE FROM AFFECTER WHERE numAffect = ?";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(delete);
            st.setInt(1, numAffectation);
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
