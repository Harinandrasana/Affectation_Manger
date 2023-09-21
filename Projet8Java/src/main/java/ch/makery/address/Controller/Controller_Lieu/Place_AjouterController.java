package ch.makery.address.Controller.Controller_Lieu;

import ch.makery.address.model.AlertUtil;
import ch.makery.address.model.CloseWindow;
import ch.makery.address.model.modelLieu.PlaceManager.Lieu_Afficher;
import ch.makery.address.model.modelLieu.PlaceManager.Lieu_Ajouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Place_AjouterController implements Initializable {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    private static Stage stage;

    @FXML
    private TextField tDesign;

    @FXML
    private TextField tIdlieu;

    @FXML
    private TextField tProvince;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void addPlace(ActionEvent actionEvent) {
        Lieu_Ajouter.ajouter(tIdlieu.getText(),tDesign.getText(),tProvince.getText());
        CloseWindow.closeWindow(actionEvent);
        AlertUtil.showAlert("Ajout reussie");
    }

    public void closeAction(ActionEvent actionEvent) {
        CloseWindow.closeWindow(actionEvent);
    }
}
