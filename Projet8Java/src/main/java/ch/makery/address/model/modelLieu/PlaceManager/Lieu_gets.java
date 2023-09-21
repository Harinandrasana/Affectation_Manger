package ch.makery.address.model.modelLieu.PlaceManager;

import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelLieu.Place;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lieu_gets {
    public static ObservableList<Place> getPlaces(){
        ObservableList<Place> places = FXCollections.observableArrayList();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String query = "SELECT * FROM LIEU ORDER BY idLieu ASC";
        con = DBConnexion.getConnection();
        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()){
                Place lieu = new Place();
                lieu.setIdLieu(rs.getString("idLieu"));
                lieu.setDesign(rs.getString("design"));
                lieu.setProvince(rs.getString("province"));
                places.add(lieu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return places;
    }
}
