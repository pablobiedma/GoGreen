package groupxii.client.controllers;

import groupxii.client.Main;
import groupxii.client.TokenManager;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private TextField txtUsername = new TextField();

    @FXML
    private PasswordField txtPassword = new PasswordField();

    @FXML
    private Text errorMessage = new Text();

    @FXML
    public void loginButton(MouseEvent event) throws Exception {
		if(txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()){
		    errorMessage.setText("Please enter a username and/or password.");
        } else{
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            // Initializa TokenManager
            TokenManager.instance = new TokenManager(username, password);

            //TODO error checks

            Main main = new Main();
            main.changeScene("Menu.fxml", event);
        }
    }

    @FXML
    public void signUpButton(MouseEvent event) {
        System.out.println("Signup");
    }
}

