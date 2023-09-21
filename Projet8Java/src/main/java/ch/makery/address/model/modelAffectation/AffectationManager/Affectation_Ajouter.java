package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.DBConnexion;
import javafx.scene.control.DatePicker;

import java.sql.*;

public class Affectation_Ajouter {
    public static boolean ajouter(String numEmp, String ancienLieu, String nouveauLieu,DatePicker datePriseService)
    {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String insert = "INSERT INTO public.affecter(\n" +
                "\tnumemp, ancienlieu, nouveaulieu, datepriseservice)\n" +
                "\tVALUES (?, ?, ?, ?);";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(insert);
            st.setString(1, numEmp);
            st.setString(2, ancienLieu);
            st.setString(3, nouveauLieu);
            st.setDate(4, Date.valueOf(datePriseService.getValue()));
            st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
