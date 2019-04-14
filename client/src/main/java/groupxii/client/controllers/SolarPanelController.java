package groupxii.client.controllers;

import groupxii.client.Main;
import groupxii.client.connector.SolarPanelConnector;
import groupxii.client.solarpanels.PanelNameList;
import groupxii.client.solarpanels.ReducedCO2;
import groupxii.client.solarpanels.UsedPanelList;
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
        chosenSolarPanel.setItems(observableList);
        updateListView();
    }

    /**
     * updates the listview with all the items from the database.
     */
    @FXML
    public void updateListView() {
        UsedPanelList usedPanelList = new UsedPanelList();
        usedPanelList.setUsedPanelList();
        ObservableList<String> usedPanelObservableList
                = FXCollections.observableArrayList(usedPanelList.getUsedPanelList());
        usedPanelsListView.setItems(usedPanelObservableList);
    }

    @FXML
    public void calculatePanel(MouseEvent event) {
        String panel = chosenSolarPanel.getValue();
        int amount = (int)amountOfSolarPanels.getValue();

        String result = ReducedCO2.getReducedCo2(panel, amount);
        savedCo2.setText("This will reduce " + result + " grams of CO2");

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

        SolarPanelConnector.commitPanel(panel, amount);
        //TODO update contoller to display result
        updateListView();
        savedCo2.setText("Enjoy using your panels :-)");
    }

    @FXML
    public void btnBack(MouseEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}
