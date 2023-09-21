package ch.makery.address.model.modelEmploye.EmployeManager;

import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelEmploye.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employe_Consulter {
    static Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    public static void nonAffecter_afficher(TableView<Employe> table) throws SQLException {
        ObservableList<Employe> data = FXCollections.observableArrayList();
        con = DBConnexion.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT *\n" +
                "FROM employe\n" +
                "LEFT JOIN affecter ON employe.numEmp = affecter.numEmp\n" +
                "WHERE affecter.numEmp IS NULL;");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String numEmp = resultSet.getString("numEmp");
            String civilite = resultSet.getString("civilite");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            String mail = resultSet.getString("mail");
            String poste = resultSet.getString("poste");
            String lieu = resultSet.getString("lieu");

            Employe employe = new Employe(numEmp, civilite, nom, prenom,mail,poste,lieu);
            data.add(employe);
        }
        table.setItems(data);
    }
}
