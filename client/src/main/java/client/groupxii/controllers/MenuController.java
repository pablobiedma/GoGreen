package client.groupxii.controllers;

import client.groupxii.Main;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class MenuController {

    /**
     * switches to the vegetarian meal feature.
     * @param event mouse click
     * @throws Exception throws IO Exception when something goes wrong
     */

    @FXML
    public void btnVegetarianMeal(MouseEvent event) throws Exception {
        //new Thread(new Threads()).start();
        VegetarianMealController vmc = new VegetarianMealController();
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);

    }

    /**
     * This method will change the scene to SolarPanels.
     */
    @FXML
    public void btnSolarPanels(MouseEvent event) throws Exception {
        SolarPanelController spc = new SolarPanelController();
        Main main = new Main();
        main.changeScene("SolarPanels.fxml", event);
    }

    @FXML
    public void btnTransport(MouseEvent event) throws Exception {
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnComingSoon(MouseEvent event) throws Exception {
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnLeaderBoard(MouseEvent event) throws Exception {
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnLocalProducts(MouseEvent event) throws Exception {
        Main main = new Main();
        main.changeScene("LocalProducts.fxml", event);
    }

    @FXML
    public void btnTemperature(MouseEvent event) throws Exception {
        Main main = new Main();
        main.changeScene("VegetarianMeal.fxml", event);
    }

}
