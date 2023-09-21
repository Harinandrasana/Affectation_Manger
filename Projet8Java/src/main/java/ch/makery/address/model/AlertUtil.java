package ch.makery.address.model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertUtil {
    public static void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
