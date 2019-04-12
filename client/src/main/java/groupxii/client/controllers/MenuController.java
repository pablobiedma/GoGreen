package groupxii.client.controllers;

import groupxii.client.Main;
import groupxii.client.connector.Connector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class MenuController implements Initializable {

    private Main main = new Main();
    private String userId = "1";

    @FXML
    private Text reducedCo2Text = new Text();

    /**
     * switches to the vegetarian meal feature.
     * @param event mouse click
     * @throws Exception throws IO Exception when something goes wrong
     */

    @FXML
    public void btnVegetarianMeal(MouseEvent event) throws Exception {
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnSolarPanels(MouseEvent event) throws Exception {
        main.changeScene("SolarPanels.fxml", event);
    }

    @FXML
    public void btnTransport(MouseEvent event) throws Exception {
        main.changeScene("Transportation.fxml", event);
    }

    @FXML
    public void btnComingSoon(MouseEvent event) throws Exception {
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @FXML
    public void btnLeaderBoard(MouseEvent event) throws Exception {
        main.changeScene("Leaderboard.fxml", event);
    }

    @FXML
    public void btnLocalProducts(MouseEvent event) throws Exception {
        main.changeScene("LocalProducts.fxml", event);
    }

    @FXML
    public void btnTemperature(MouseEvent event) throws Exception {
        main.changeScene("Temperature.fxml", event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String reducedCo2 = Connector.getRequest("/getReducedCo2OfUser?Id=" + userId);
        reducedCo2Text.setText(reducedCo2);
    }

}
