package client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    public void loginButton(MouseEvent event) throws Exception{
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Menu.fxml")), 900, 650);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void signUpButton(MouseEvent event) {
        System.out.println("Signup");
    }
}
