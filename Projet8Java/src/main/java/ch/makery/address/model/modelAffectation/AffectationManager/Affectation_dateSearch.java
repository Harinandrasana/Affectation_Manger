package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelAffectation.Affectation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

import java.sql.*;
import java.time.LocalDate;

public class Affectation_dateSearch {
    static Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    public static void rechercher(LocalDate firstDate, LocalDate seconDate, TableView<Affectation> table) throws SQLException {
        ObservableList<Affectation> data = FXCollections.observableArrayList();
        con = DBConnexion.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM AFFECTER WHERE dateAffect BETWEEN ? AND ?");
        statement.setDate(1, Date.valueOf(firstDate));
        statement.setDate(2, Date.valueOf(seconDate));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer numAffectation = Integer.valueOf(resultSet.getString("numAffect"));
            String numEmp = resultSet.getString("numEmp");
            String ancienLieu = resultSet.getString("AncienLieu");
            String nouveauLieu = resultSet.getString("NouveauLieu");
            String dateAffectation = resultSet.getString("dateAffect");
            String datePriseService = resultSet.getString("datePriseService");

            Affectation  affectation = new Affectation(numAffectation,numEmp, ancienLieu, nouveauLieu, dateAffectation,datePriseService);
            data.add(affectation);
        }
        table.setItems(data);
    }
}
