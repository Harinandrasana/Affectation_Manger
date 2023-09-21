package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.DBConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Affectation_loadEmp {
    static Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    public static void charger(ComboBox<String> tNumEmp){
        con = DBConnexion.getConnection();
        try{
            ResultSet rs = con.createStatement().executeQuery("SELECT numemp FROM public.employe");
            ObservableList data = FXCollections.observableArrayList();
            while(rs.next()){
                data.add(new String(rs.getString(1)));
            }
            tNumEmp.setItems(data);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
