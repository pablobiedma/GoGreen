package client.groupxii.controllers;

import client.groupxii.Main;
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
        main.changeScene("VegetarianMeal.fxml", event);
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
        main.changeScene("VegetarianMeal.fxml", event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String reducedCo2 = "";
        try {
            reducedCo2 = new Scanner(new URL("http://localhost:8080/getReducedCo2OfUser?Id=" + userId).openStream(),"UTF-8").nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reducedCo2Text.setText(reducedCo2);
    }

    public Main getMain(){
        return this.main;
    }

}
