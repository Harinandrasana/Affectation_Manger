package ch.makery.address.Controller.Controller_Affection;

import ch.makery.address.model.AddWindow;
import ch.makery.address.model.modelAffectation.*;
import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelAffectation.AffectationManager.Affectation_Afficher;
import ch.makery.address.model.modelAffectation.AffectationManager.Affectation_Supprimer;
import ch.makery.address.model.modelAffectation.AffectationManager.Affectation_daterecherche;
import ch.makery.address.model.modelEmploye.Employe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AffectationController implements Initializable {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button dateSearch;

    @FXML
    private TableColumn<Affectation, String> colancientLieu;

    @FXML
    private TableColumn<Affectation, String> coldateAffectation;

    @FXML
    private TableColumn<Affectation, String> coldatePriseService;

    @FXML
    private TableColumn<Affectation, String> colnouveauLieu;

    @FXML
    private TableColumn<Affectation, Integer> colnumAffectation;

    @FXML
    private TableColumn<Affectation, String> colnumEmp;

    @FXML
    private TableColumn<Affectation, String> colNom;

    @FXML
    private TableColumn<Affectation, String> colPoste;

    @FXML
    private TableColumn<Affectation, String> colPrenom;

    @FXML
    private TextField searchField;

    @FXML
    private DatePicker firstDate;

    @FXML
    private DatePicker secondDate;

    @FXML
    private TableView<Affectation> table;
    int numAffectation = 0;

    private Affectation affectation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showAffectations();
    }

    public void showAffectations(){
        Affectation_Afficher.afficher( colnumAffectation, colnumEmp, colNom,colPrenom, colPoste, colancientLieu,  colnouveauLieu,  coldateAffectation, coldatePriseService,  table,  searchField);
    }

    @FXML
    void deleteAffectation (ActionEvent event){
        Affectation aiffectation = table.getSelectionModel().getSelectedItem();
        int numAffectation = aiffectation.getNumAffectation();
        boolean result = Affectation_Supprimer.supprimer(numAffectation);
        showAffectations();
        if(result)
        {
            System.out.println("supression reussie");
        }
        else
        {
            System.out.println("supression echec");
        }
    }

    @FXML
    void updateAffectation (ActionEvent event) {
        Affectation aiffectation = table.getSelectionModel().getSelectedItem();

        if (aiffectation != null) {
            try {
                affectation = new Affectation(aiffectation.getNumAffectation(), aiffectation.getNumEmp(), aiffectation.getAncientLieu(), aiffectation.getNouveauLieu(), aiffectation.getDateAffectation(), aiffectation.getDatePriseService());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Affectation_modifier.fxml"));
                Parent root = loader.load();
                Affectation_ModifierController affectationAjouterController = loader.getController();
                affectationAjouterController.setData(affectation);
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Veuiller selectionner l'element à modifier");
        }
    }

    public void searchBetweenDate(ActionEvent actionEvent) throws SQLException {
        Affectation_daterecherche.rechercher(firstDate,secondDate, table);
    }
    public void createAffectation(ActionEvent actionEvent) {
        AddWindow.openWindow("/fxml/Affectation_ajouter.fxml");
    }
}
