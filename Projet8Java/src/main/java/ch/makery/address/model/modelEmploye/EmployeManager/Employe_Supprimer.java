package ch.makery.address.model.modelEmploye.EmployeManager;

import ch.makery.address.model.DBConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Employe_Supprimer {
    public static void supprimer(String numEmp) {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String delete = "DELETE FROM EMPLOYE WHERE numEmp = ?";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(delete);
            st.setString(1, numEmp);
            st.executeUpdate();
            //fermeture a revoir
            st.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
