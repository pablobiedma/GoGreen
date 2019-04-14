package groupxii.client.controllers;

import groupxii.client.Main;
import groupxii.client.connector.SolarPanelConnector;
import groupxii.client.solarpanels.PanelNameList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SolarPanelController implements Initializable {

    @FXML
    private Slider amountOfSolarPanels = new Slider();

    @FXML
    private ChoiceBox<String> chosenSolarPanel = new ChoiceBox<>();

    @FXML
    private Text savedCo2 = new Text();

    @FXML
    private ListView<String> usedPanelsListView = new ListView();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PanelNameList panelNameList = new PanelNameList();
        ObservableList<String> observableList =
                FXCollections.observableArrayList(panelNameList.getPanelList());
        chosenSolarPanel.getItems().addAll(observableList);
    }

    /**
     * updates the listview with all the items from the database.
     */
    @FXML
    public void updateListView() {

    }

    /**
     * Calculates the co2 reduced emission when the user clicks the calculate button.
     * it also calculates the amount of points the user earned.
     *
     * @param event mouse click
     * @throws Exception throws exception when something went wrong
     */
    @FXML
    void safePanel(MouseEvent event) throws Exception {
        String panel = chosenSolarPanel.getValue();
        int amount = (int) amountOfSolarPanels.getValue();
        String res = SolarPanelConnector.calculateCO2Reduction(panel, amount);
    }

    @FXML
    public void btnBack(MouseEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}
