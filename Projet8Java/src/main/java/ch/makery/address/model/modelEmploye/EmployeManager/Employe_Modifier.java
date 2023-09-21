package ch.makery.address.model.modelEmploye.EmployeManager;

import ch.makery.address.model.DBConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Employe_Modifier {
    public static void modifier(String civilite,String nom,String prenom,String mail,String poste, String lieu, String numEmp)
    {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String update = "UPDATE EMPLOYE SET civilite = ?, Nom = ?, Prenom = ?, mail = ?, poste = ?, Lieu = ? WHERE numEmp = ?";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(update);
            st.setString(1, civilite);
            st.setString(2, nom);
            st.setString(3, prenom);
            st.setString(4, mail);
            st.setString(5, poste);
            st.setString(6, lieu);
            st.setString(7, numEmp);
            st.executeUpdate();
            //fermeture a revoir
            st.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
