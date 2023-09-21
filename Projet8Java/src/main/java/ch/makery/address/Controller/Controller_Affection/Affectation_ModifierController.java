package ch.makery.address.Controller.Controller_Affection;

import ch.makery.address.model.AlertUtil;
import ch.makery.address.model.CloseWindow;
import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelAffectation.Affectation;
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
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Affectation_ModifierController implements Initializable {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    int numAffectation = 0;
    @FXML
    public TextField tAncientLieu;

    @FXML
    public DatePicker tDatePriseService;

    @FXML
    public TextField tNouveauLieu;

    @FXML
    private ComboBox<String> tNumEmp;

    @FXML
    private TextField tN;
    private Affectation affectation;

    @FXML
    public void updateAffecation(ActionEvent actionEvent) throws SQLException, IOException {
        Affectation_Modifier.modifier(tNumEmp.getValue(), tAncientLieu.getText(), tNouveauLieu.getText(), tDatePriseService, numAffectation);
        Affectation_email.envoyerEmail(tNumEmp.getValue());
        Affectation_pdf.generer(tNumEmp.getValue());
        Affectation_modifierEmploye.modifierEmploye(tNumEmp.getValue(),tNouveauLieu.getText());
        CloseWindow.closeWindow(actionEvent);
        AlertUtil.showAlert("Modification reussie");
    }

    private void loadNumEmp() {
        Affectation_loadEmp.charger(tNumEmp);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadNumEmp();
    }


    public void setData(Affectation affectation) {
        this.affectation = affectation;
        numAffectation = affectation.getNumAffectation();
        tN.setText(String.valueOf(numAffectation));
        tNumEmp.setValue(affectation.getNumEmp());
        tAncientLieu.setText(affectation.getAncientLieu());
        tNouveauLieu.setText(affectation.getNouveauLieu());
        tDatePriseService.setValue(LocalDate.parse(affectation.getDatePriseService()));

    }

    public void closeAction(ActionEvent actionEvent) {
        CloseWindow.closeWindow(actionEvent);
    }
}
