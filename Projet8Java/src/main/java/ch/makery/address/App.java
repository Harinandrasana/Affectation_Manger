package ch.makery.address;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application
{
    double x,y;
    @Override
    public void start(Stage stage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed(mouseEvent ->
        {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(mouseEvent ->
        {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
        Scene scene = new Scene(root,1131,550);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}

