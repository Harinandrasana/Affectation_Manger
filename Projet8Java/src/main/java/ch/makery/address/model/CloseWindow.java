package ch.makery.address.model;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class CloseWindow {
    public static void closeWindow(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // Close the stage/window
        stage.close();
    }
}
