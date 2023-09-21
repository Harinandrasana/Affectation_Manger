package ch.makery.address.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {

    @FXML
    private StackPane contentArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        }
        catch (IOException e)
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    public void home(javafx.event.ActionEvent actionEvent) throws IOException
    {
        Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void place(ActionEvent actionEvent) throws IOException
    {
        Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/Place.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void Employe(ActionEvent actionEvent) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/Employes.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void Affecter(ActionEvent actionEvent) throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("/fxml/Affectation.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void closeWindows(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void resize(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        double initWidth = 0;
        double initHeight = 0;
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
            stage.setWidth(initWidth);
            stage.setHeight(initHeight);
        } else {
            stage.setFullScreen(true);
            stage.setX(bounds.getMinX());
            stage.setY(bounds.getMinY());
            stage.setWidth(bounds.getWidth());
            stage.setHeight(bounds.getHeight());
            initWidth = stage.getWidth();
            initHeight = stage.getHeight();
        }
    }
}
