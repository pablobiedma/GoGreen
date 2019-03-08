package client.group12;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private Scene primaryScene;

    // This will start a stage (program window)
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // The FXML file (in which buttons/textviews/sizes etc. are declared) will be
        // read and set as scene (the stuff inside the window of the program)
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Login.fxml"));
        Scene scene = new Scene(root, 900, 650);
        this.primaryStage = stage;
        stage.setTitle("ECO Green | Group 12");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml, MouseEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent pane = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/"+fxml));
        Scene scene = stage.getScene();
        this.primaryScene = scene;
        scene.setRoot(pane);
    }

    public Scene getPrimaryScene(){
        return this.primaryScene;
    }

}

