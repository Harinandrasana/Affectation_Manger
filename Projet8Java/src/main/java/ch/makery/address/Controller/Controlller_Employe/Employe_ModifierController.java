package ch.makery.address.Controller.Controlller_Employe;

import ch.makery.address.model.AlertUtil;
import ch.makery.address.model.CloseWindow;
import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelEmploye.Employe;
import ch.makery.address.model.modelEmploye.EmployeManager.Employe_Modifier;
import ch.makery.address.model.modelEmploye.EmployeManager.Employe_loadLieu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Employe_ModifierController implements Initializable {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    @FXML
    private RadioButton radioButton1;

    @FXML
    private RadioButton radioButton2;

    @FXML
    private RadioButton radioButton3;

    @FXML
    private ComboBox<?> tLieu;

    @FXML
    private TextField tMail;

    @FXML
    private TextField tNom;

    @FXML
    private TextField tPoste;

    @FXML
    private TextField tPrenom;
    private Employe employe;

    public void setData(Employe employe) {
        this.employe = employe;
        if (employe.getCivilite() == "Mr") {
            radioButton1.setSelected(true);
        } else if (employe.getCivilite() == "Mlle") {
            radioButton2.setSelected(true);
        } else if(employe.getCivilite() == "Mme"){
            radioButton3.setSelected(true);
        }
        else{
            radioButton1.setSelected(true);
        }
        tNom.setText(employe.getNom());
        tPrenom.setText(employe.getPrenom());
        tMail.setText(employe.getMail());
        tPoste.setText(employe.getPoste());
        //tLieu.setValue(employe.getLieu());
    }

    private void loadPlace() {
        Employe_loadLieu.charger(tLieu);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPlace();
    }

    public void modifyEmploye(ActionEvent actionEvent) {
        String civilite = "";
        if (radioButton1.isSelected())
        {
            civilite =  radioButton1.getText();
        }
        else if (radioButton2.isSelected())
        {
            civilite =  radioButton2.getText();
        }
        else if (radioButton3.isSelected())
        {
            civilite =  radioButton3.getText();
        }
        else
        {
            System.out.println("No option selected");
        }
        Employe_Modifier.modifier(civilite, tNom.getText(), tPrenom.getText(), tMail.getText(), tPoste.getText(), (String) tLieu.getValue(),employe.getNumEmp());
        CloseWindow.closeWindow(actionEvent);
        AlertUtil.showAlert("Modification reussie");
        //EmployeeContoller.showEmployes();
    }

    public void closeAction(ActionEvent actionEvent) {
        CloseWindow.closeWindow(actionEvent);
    }
}
