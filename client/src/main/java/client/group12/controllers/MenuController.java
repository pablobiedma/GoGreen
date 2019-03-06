package client.group12.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import client.group12.vegetarianMeal.mealAPI;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    public void btnVegetarianMeal(MouseEvent event) throws Exception{
        mealAPI mealapi = new mealAPI();
        mealapi.readAPI();
    }

    public void loginButton(MouseEvent event) throws Exception{
        LoginController loginController = new LoginController();
        loginController.loginButton(event);
    }

}
