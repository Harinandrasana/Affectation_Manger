package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelAffectation.Affectation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

import java.sql.*;
import java.time.LocalDate;

public class Affectation_daterecherche {
    public static void rechercher(DatePicker firstDate, DatePicker secondDate, TableView<Affectation> table) throws SQLException {
        Connection con = null;
        ResultSet rs = null;
        ObservableList<Affectation> data;
        data = FXCollections.observableArrayList();
        con = DBConnexion.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT * FROM AFFECTER WHERE dateAffect BETWEEN ? AND ?");
        statement.setDate(1, Date.valueOf(firstDate.getValue()));
        statement.setDate(2, Date.valueOf(secondDate.getValue()));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer numAffectation = Integer.valueOf(resultSet.getString("numAffect"));
            String numEmp = resultSet.getString("numEmp");
            String ancienLieu = resultSet.getString("AncienLieu");
            String nouveauLieu = resultSet.getString("NouveauLieu");
            String dateAffectation = resultSet.getString("dateAffect");
            String datePriseService = resultSet.getString("datePriseService");

            Affectation affectation = new Affectation(numAffectation, numEmp, ancienLieu, nouveauLieu, dateAffectation, datePriseService);
            data.add(affectation);
        }
        table.setItems(data);
    }
}
