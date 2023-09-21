package ch.makery.address.model.modelEmploye.EmployeManager;

import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelEmploye.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employe_gets {
    public static ObservableList<Employe> getEmployes(){
        ObservableList<Employe> employes = FXCollections.observableArrayList();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String query = "SELECT * FROM EMPLOYE ORDER BY numEmp ASC";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()){
                Employe employe = new Employe();
                employe.setNumEmp(rs.getString("numEmp"));
                employe.setCivilite(rs.getString("civilite"));
                employe.setNom(rs.getString("nom"));
                employe.setPrenom(rs.getString("prenom"));
                employe.setMail(rs.getString("mail"));
                employe.setPoste(rs.getString("poste"));
                employe.setLieu(rs.getString("lieu"));
                employes.add(employe);
            }
            //fermeture a revoir
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employes;
    }
}
