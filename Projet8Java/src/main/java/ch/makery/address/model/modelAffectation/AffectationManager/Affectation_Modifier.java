package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.DBConnexion;
import javafx.scene.control.DatePicker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Affectation_Modifier {
    public static void modifier(String numEmp, String ancienLieu, String nouveauLieu, DatePicker datePriseService, int numAffectation)
    {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String selectQuery = "UPDATE public.affecter\n" +
                "\tSET numemp=?, ancienlieu=?, nouveaulieu=?, datepriseservice=?\n" +
                "\tWHERE numaffect=?";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(selectQuery);
            st.setString(1, numEmp);
            st.setString(2, ancienLieu);
            st.setString(3, nouveauLieu);
            st.setDate(4, Date.valueOf(datePriseService.getValue()));
            st.setInt(5, numAffectation);
            st.executeUpdate();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
