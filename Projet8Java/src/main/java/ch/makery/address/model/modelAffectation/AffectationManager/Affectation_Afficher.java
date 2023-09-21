package ch.makery.address.model.modelAffectation.AffectationManager;

import ch.makery.address.model.modelAffectation.Affectation;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Affectation_Afficher {
    public static void afficher(TableColumn<Affectation, Integer> colnumAffectation, TableColumn<Affectation, String> colnumEmp, TableColumn<Affectation, String> colNom, TableColumn<Affectation, String> colPrenom, TableColumn<Affectation, String> colPoste, TableColumn<Affectation,
            String> colancientLieu, TableColumn<Affectation, String> colnouveauLieu, TableColumn<Affectation, String> coldateAffectation,
                                TableColumn<Affectation, String> coldatePriseService, TableView<Affectation> table, TextField searchField){
        ObservableList<Affectation> list = Affectaction_gets.getAffectations();
        table.setItems((list));
        colnumAffectation.setCellValueFactory(new PropertyValueFactory<Affectation, Integer>("numAffectation"));
        colnumEmp.setCellValueFactory(new PropertyValueFactory<Affectation, String>("numEmp"));
        colNom.setCellValueFactory(new PropertyValueFactory<Affectation,String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<Affectation,String>("prenom"));
        colPoste.setCellValueFactory(new PropertyValueFactory<Affectation, String>("poste"));
        colancientLieu.setCellValueFactory(new PropertyValueFactory<Affectation, String>("ancientLieu"));
        colnouveauLieu.setCellValueFactory(new PropertyValueFactory<Affectation, String>("nouveauLieu"));
        coldateAffectation.setCellValueFactory(new PropertyValueFactory<Affectation, String>("dateAffectation"));
        coldatePriseService.setCellValueFactory(new PropertyValueFactory<Affectation, String>("datePriseService"));

        FilteredList<Affectation> filterData = new FilteredList<>(list, b -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(affectation -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if(affectation.getNumEmp().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                }
                else {
                    return false;
                }
            });
        });
        SortedList<Affectation> sorteData = new SortedList<>(filterData);
        sorteData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sorteData);
    }
}
