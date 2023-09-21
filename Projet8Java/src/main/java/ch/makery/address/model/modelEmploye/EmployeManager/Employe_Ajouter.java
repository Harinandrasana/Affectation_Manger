package ch.makery.address.model.modelEmploye.EmployeManager;

import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.Identenfiant_generer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employe_Ajouter {
    public static void ajouter(String numEmp,String civilite, String nom, String prenom, String mail, String poste, String lieu) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String insert = "INSERT INTO EMPLOYE(numEmp,civilite, Nom, Prenom, mail, poste, Lieu) VALUES(?,?,?,?,?,?,?)";
        con = DBConnexion.getConnection();
        try
        {
            st = con.prepareStatement(insert);
            st.setString(1, numEmp);
            st.setString(2, civilite);
            st.setString(3, nom);
            st.setString(4, prenom);
            st.setString(5, mail);
            st.setString(6, poste);
            st.setString(7, lieu);
            st.executeUpdate();
            //fermeture a revoir
            st.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
