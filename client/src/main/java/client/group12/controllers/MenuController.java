package client.group12.controllers;

import client.group12.Main;
import client.group12.Threads;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MenuController extends Threads {

    @FXML
    public void btnVegetarianMeal(MouseEvent event) throws Exception{
        //new Thread(new Threads()).start();
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
        VegetarianMealController vmc = new VegetarianMealController();
        vmc.badFoodName(event);
        vmc.goodFoodName(event);
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
