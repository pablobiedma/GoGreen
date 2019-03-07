package client.group12.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import client.group12.Main;

public class LoginController {

    @FXML
    public void loginButton(MouseEvent event) throws Exception{
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }

    @FXML
    public void signUpButton(MouseEvent event) {
        System.out.println("Signup");
    }
}
