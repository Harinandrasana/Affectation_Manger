package ch.makery.address.model.modelEmploye.EmployeManager;

import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelEmploye.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employe_loadLieu {
    static Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    public static void charger(ComboBox<?> tLieu){
        con = DBConnexion.getConnection();
        try{
            ResultSet rs = con.createStatement().executeQuery("SELECT design FROM LIEU");
            ObservableList data = FXCollections.observableArrayList();
            while(rs.next()){
                data.add(new String(rs.getString(1)));
            }
            tLieu.setItems(data);
            //fermeture a revoir
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
