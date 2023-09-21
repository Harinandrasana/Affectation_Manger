package ch.makery.address.Controller.Controller_Lieu;

import ch.makery.address.model.AddWindow;
import ch.makery.address.model.modelLieu.Place;
import ch.makery.address.model.DBConnexion;
import ch.makery.address.model.modelLieu.PlaceManager.Lieu_Afficher;
import ch.makery.address.model.modelLieu.PlaceManager.Lieu_Ajouter;
import ch.makery.address.model.modelLieu.PlaceManager.Lieu_Supprimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PlaceController implements Initializable {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    private Place place;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Place, String> coldesign;

    @FXML
    private TableColumn<Place, String> colidLieu;

    @FXML
    private TableColumn<Place, String> colprovince;

    @FXML
    private TableView<Place> table;
    String idLieu = "";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showPlaces();
    }
    public void showPlaces(){
        Lieu_Afficher.afficher( table, colidLieu,coldesign, colprovince);
    }

    @FXML
    void createPlace(ActionEvent event) {

        AddWindow.openWindow("/fxml/Place_ajouter.fxml");
    }

    @FXML
    void deletePlace(ActionEvent event) {
        Place place = table.getSelectionModel().getSelectedItem();
        idLieu = place.getIdLieu();
        Lieu_Supprimer.supprimer(idLieu);
        showPlaces();
    }

    @FXML
    void updatePlace(ActionEvent event) {
        Place lieu = table.getSelectionModel().getSelectedItem();

        if (lieu != null) {
            try {
                place = new Place(lieu.getIdLieu(), lieu.getDesign(), lieu.getProvince());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Place_modifier.fxml"));
                Parent root = loader.load();
                Place_ModifierController modifController = loader.getController();
                modifController.setData(place);
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
}
