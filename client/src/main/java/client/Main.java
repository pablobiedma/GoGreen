package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application{

    //this will start a stage (program window)
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //The FXML file (in which buttons/textviews/sizes etc. are declared) will be read and set as scene (the stuff inside the window of the program)
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI.fxml"));
        Scene scene = new Scene(root, 500, 400);

        //the title in the top-bar of the stage
        stage.setTitle("ECO Green Group 12");
        //puts the scene inside the stage and shows it.
        stage.setScene(scene);
        stage.show();
    }

}

