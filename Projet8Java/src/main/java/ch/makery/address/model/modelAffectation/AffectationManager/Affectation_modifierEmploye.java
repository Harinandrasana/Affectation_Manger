package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.DBConnexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Affectation_modifierEmploye {
    public static void modifierEmploye(String numEmp,String nouveauLieu)
    {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String update = "UPDATE EMPLOYE SET Lieu = ? WHERE numEmp = ?";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(update);
            st.setString(1, nouveauLieu);
            st.setString(2, numEmp);
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
