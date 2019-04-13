package groupxii.client.controllers;

import groupxii.client.Main;
import groupxii.client.TokenManager;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class LoginController {
    @FXML
    public void loginButton(MouseEvent event) throws Exception {
		String username = "0day";
		String password = "pass";
		//TODO how do you read those?

		Thread loginDaemon = new Thread(new TokenManager(username, password));
		loginDaemon.setDaemon(true);
		loginDaemon.start();

        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }

    @FXML
    public void signUpButton(MouseEvent event) {
        System.out.println("Signup");
    }
}
