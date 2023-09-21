package ch.makery.address.Controller.Controller_Lieu;

import ch.makery.address.model.AlertUtil;
import ch.makery.address.model.CloseWindow;
import ch.makery.address.model.modelLieu.PlaceManager.Lieu_Modifier;
import ch.makery.address.model.modelLieu.Place;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Place_ModifierController implements Initializable {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    @FXML
    private TextField tDesign;

    @FXML
    private TextField tIdlieu;

    @FXML
    private TextField tProvince;
    private Place place;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void modifyPlace(ActionEvent actionEvent) {
        Lieu_Modifier.modifier(tIdlieu.getText(),tDesign.getText(),tProvince.getText());
        CloseWindow.closeWindow(actionEvent);
        AlertUtil.showAlert("Modification reussie");
    }

    public void setData(Place place) {
        this.place = place;
        tIdlieu.setText(place.getIdLieu());
        tDesign.setText(place.getDesign());
        tProvince.setText(place.getProvince());
    }

    public void closeAction(ActionEvent actionEvent) {
        CloseWindow.closeWindow(actionEvent);
    }
}
