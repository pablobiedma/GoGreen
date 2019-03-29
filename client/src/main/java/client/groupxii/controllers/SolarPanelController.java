package client.groupxii.controllers;

import client.groupxii.solarpanel.SafePanel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.net.URL;
import java.util.*;

public class SolarPanelController implements Initializable {

    @FXML
    private Slider amountOfSolarPanels = new Slider();

    @FXML
    private ChoiceBox<String> chosenSolarPanel = new ChoiceBox<>();

    @FXML
    private Text savedCo2 = new Text();

    private String host = "http://localhost:8080/";
    private SafePanel safePanel = new SafePanel();
    private String panel = "";
    private String usedpanelListStr = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            usedpanelListStr = new Scanner(new URL(host + "panelNameList").openStream(),
                    "UTF-8").nextLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(usedpanelListStr);
        System.out.println("TEST");
        List<String> usedpanelListitems = Arrays.asList(usedpanelListStr.split(", "));
        ObservableList<String> listObservable = FXCollections.observableArrayList(usedpanelListitems);
        chosenSolarPanel.getItems().addAll(listObservable);
    }

    /**
     * Calculates the co2 reduced emission when the user clicks the calculate button.
     * it also calculates the amount of points the user earned.
     * @param event mouse click
     * @throws Exception throws exception when something went wrong
     */

    @FXML
    void safeMeal(MouseEvent event) throws IOException {
        panel = chosenSolarPanel.getValue();
        int amount = (int) amountOfSolarPanels.getValue();
        safePanel.safePanel(panel,amount);
    }
}
