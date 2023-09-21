package ch.makery.address.Controller.Controlller_Employe;

import ch.makery.address.model.AddWindow;
import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelEmploye.*;
import ch.makery.address.model.modelEmploye.EmployeManager.Employe_Afficher;
import ch.makery.address.model.modelEmploye.EmployeManager.Employe_Consulter;
import ch.makery.address.model.modelEmploye.EmployeManager.Employe_Supprimer;
import ch.makery.address.model.modelEmploye.EmployeManager.Employe_rechercher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeContoller implements Initializable {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Employe, String> colLieu;

    @FXML
    private TableColumn<Employe, String> colMail;

    @FXML
    private TableColumn<Employe, String> colNom;

    @FXML
    private TableColumn<Employe, String> colPoste;

    @FXML
    private TableColumn<Employe, String> colPrenom;

    @FXML
    private TableColumn<Employe, String> colcivilite;

    @FXML
    private TableColumn<Employe, Integer> colnumEmp;

    @FXML
    private TableView<Employe> table;

    @FXML
    private TextField tsearch;

    String numEmp = "";

    private Employe employe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showEmployes();
    }

    public void showEmployes(){
        Employe_Afficher.afficher(colnumEmp, colcivilite, colNom, colPrenom, colLieu, colMail, colPoste, table);
    }

    @FXML
    void createEmploye(ActionEvent event) {
        AddWindow.openWindow("/fxml/Employe_ajouter.fxml");
    }

    @FXML
    void deleteEmploye (ActionEvent event){
        Employe employe = table.getSelectionModel().getSelectedItem();
        numEmp = employe.getNumEmp();
        Employe_Supprimer.supprimer(numEmp);
        showEmployes();
        }

    @FXML
    void updateEmploye (ActionEvent event){
        Employe emp = table.getSelectionModel().getSelectedItem();

        if (emp != null) {
            try {
                employe = new Employe(emp.getNumEmp(), emp.getCivilite(), emp.getNom(), emp.getPrenom(), emp.getMail(), emp.getPoste(),emp.getLieu());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Employe_modifier.fxml"));
                Parent root = loader.load();
                Employe_ModifierController modifController = loader.getController();
                modifController.setData(employe);
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Veuiller selectionner l'element à modifier");
        }
    }

    public void searchEmploye(ActionEvent actionEvent) throws SQLException {
        Employe_rechercher.searchEmploye(tsearch,table);
    }

    public void NonAffecShow(ActionEvent actionEvent) throws SQLException {
        Employe_Consulter.nonAffecter_afficher(table);
    }
}
