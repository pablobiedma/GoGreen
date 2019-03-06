package client.group12.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import client.group12.vegetarianMeal.MealAPI;

public class MenuController {

    @FXML
    public void btnVegetarianMeal(MouseEvent event) throws Exception{
        MealAPI mealapi = new MealAPI();
        mealapi.readAPI();
    }

    @FXML
    public void loginButton(MouseEvent event) throws Exception{
        LoginController loginController = new LoginController();
        loginController.loginButton(event);
    }

}
