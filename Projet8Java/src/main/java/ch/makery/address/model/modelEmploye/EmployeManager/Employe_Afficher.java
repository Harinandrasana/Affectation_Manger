package ch.makery.address.model.modelEmploye.EmployeManager;

import ch.makery.address.model.modelEmploye.Employe;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Employe_Afficher {
    public static void afficher(TableColumn<Employe, Integer> colnumEmp, TableColumn<Employe, String> colcivilite, TableColumn<Employe,
            String> colNom, TableColumn<Employe, String> colPrenom, TableColumn<Employe, String> colLieu,
                                TableColumn<Employe, String> colMail, TableColumn<Employe, String> colPoste, TableView<Employe> table){
        ObservableList<Employe> list = Employe_gets.getEmployes();
        table.setItems((list));
        colnumEmp.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("numEmp"));
        colcivilite.setCellValueFactory(new PropertyValueFactory<Employe, String>("civilite"));
        colNom.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<Employe, String>("prenom"));
        colMail.setCellValueFactory(new PropertyValueFactory<Employe, String>("mail"));
        colPoste.setCellValueFactory(new PropertyValueFactory<Employe, String>("poste"));
        colLieu.setCellValueFactory(new PropertyValueFactory<Employe, String>("lieu"));
    }
}
