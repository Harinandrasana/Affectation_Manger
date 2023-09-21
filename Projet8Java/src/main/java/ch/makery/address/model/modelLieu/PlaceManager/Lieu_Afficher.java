package ch.makery.address.model.modelLieu.PlaceManager;

import ch.makery.address.model.modelLieu.Place;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Lieu_Afficher {
    public static void afficher(TableView<Place> table, TableColumn<Place, String> colidLieu,TableColumn<Place, String> coldesign,TableColumn<Place, String> colprovince){
        ObservableList<Place> list = Lieu_gets.getPlaces();
        table.setItems((list));
        colidLieu.setCellValueFactory(new PropertyValueFactory<Place, String>("idLieu"));
        coldesign.setCellValueFactory(new PropertyValueFactory<Place, String>("design"));
        colprovince.setCellValueFactory(new PropertyValueFactory<Place, String>("province"));
    }
}
