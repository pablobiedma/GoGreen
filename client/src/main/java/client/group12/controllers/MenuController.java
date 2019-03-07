package client.group12.controllers;

import client.group12.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import client.group12.vegetarianMeal.MealAPI;

public class MenuController {

    @FXML
    public void btnVegetarianMeal(MouseEvent event) throws Exception{
        MealAPI mealapi = new MealAPI();
        mealapi.readAPI();
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnSolarPanels(MouseEvent event) throws Exception{
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnTransport(MouseEvent event) throws Exception{
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnComingSoon(MouseEvent event) throws Exception{
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnLeaderBoard(MouseEvent event) throws Exception{
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnLocalProducts(MouseEvent event) throws Exception{
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnTemperature(MouseEvent event) throws Exception{
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

}
