package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelAffectation.Affectation;
import ch.makery.address.model.modelEmploye.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Affectaction_gets {
    public static ObservableList<Affectation> getAffectations(){
        ObservableList<Affectation> Affectations = FXCollections.observableArrayList();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String query = "SELECT affecter.numaffect, affecter.numEmp, affecter.ancienLieu,affecter.nouveaulieu, affecter.dateaffect, affecter.datepriseservice, employe.nom, employe.prenom, employe.poste\n" +
                "FROM public.affecter\n" +
                "LEFT JOIN public.employe ON employe.numEmp = affecter.numEmp\n" +
                "ORDER BY affecter.dateaffect ASC\n";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()){
                Affectation affectation = new Affectation();
                affectation.setNumAffectation(rs.getInt("numAffect"));
                affectation.setNumEmp(rs.getString("numEmp"));
                affectation.setAncientLieu(rs.getString("ancienLieu"));
                affectation.setNouveauLieu(rs.getString("nouveauLieu"));
                affectation.setDateAffectation(rs.getString("dateAffect"));
                affectation.setDatePriseService(rs.getString("datePriseService"));
                affectation.setNom(rs.getString("nom"));
                affectation.setPrenom(rs.getString("prenom"));
                affectation.setPoste(rs.getString("poste"));
                Affectations.add(affectation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Affectations;
    }
}
