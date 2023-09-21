package ch.makery.address.Controller.Controller_Affection;

import ch.makery.address.model.AlertUtil;
import ch.makery.address.model.CloseWindow;
import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelAffectation.AffectationManager.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Affectation_AjouterController implements Initializable {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    @FXML
    private TextField tAncientLieu;

    @FXML
    private DatePicker tDatePriseService;

    @FXML
    private TextField tNouveauLieu;

    @FXML
    private ComboBox<String> tNumEmp;
    private void loadNumEmp() {
        Affectation_loadEmp.charger(tNumEmp);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("entrer reussi");
        loadNumEmp();
    }
    @FXML
    public void createAffecation(ActionEvent actionEvent) throws SQLException, IOException {
        boolean result = Affectation_Ajouter.ajouter(tNumEmp.getValue(), tAncientLieu.getText(), tNouveauLieu.getText(), tDatePriseService);
        if(result){
            System.out.println("ajout reussie");
            Affectation_email.envoyerEmail(tNumEmp.getValue());
            Affectation_pdf.generer(tNumEmp.getValue());
            Affectation_modifierEmploye.modifierEmploye(tNumEmp.getValue(),tNouveauLieu.getText());
            CloseWindow.closeWindow(actionEvent);
            AlertUtil.showAlert("Ajout reussie");
        }
        else {
            System.out.println("echec de l'ajout");
            CloseWindow.closeWindow(actionEvent);
        }
    }

    public void closeAction(ActionEvent actionEvent) {
        CloseWindow.closeWindow(actionEvent);
    }
}
