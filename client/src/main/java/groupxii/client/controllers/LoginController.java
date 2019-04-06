package groupxii.client.controllers;

import groupxii.client.Main;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    public void loginButton(MouseEvent event) throws Exception {
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }

    @FXML
    public void signUpButton(MouseEvent event) {
        System.out.println("Signup");
    }
}
