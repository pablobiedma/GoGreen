package client.groupxii.controllers;

import client.groupxii.solarpanel.SafePanel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
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

    @FXML
    private ListView<String> usedPanelsListView = new ListView();

    private String host = "http://localhost:8080/";
    private SafePanel safePanel = new SafePanel();
    private String panel = "";
    private String usedpanelListStr = "";
    private String usedpanelListStr2 = "";
    private List<String> usedPanelListViewItems = new ArrayList<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            usedpanelListStr = new Scanner(new URL(host + "panelNameList").openStream(),
                    "UTF-8").nextLine();
//            usedpanelListStr2 = new Scanner(new URL(host + "usedPanelList").openStream(),
//                    "UTF-8").nextLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//        usedPanelListViewItems = Arrays.asList(usedpanelListStr2.split(" - "));
//        ObservableList<String> usedPanelsObservable = FXCollections.observableArrayList(usedPanelListViewItems);
//        usedPanelsListView.setItems(usedPanelsObservable);
        List<String> usedpanelListitems = Arrays.asList(usedpanelListStr.split(", "));
        ObservableList<String> listObservable = FXCollections.observableArrayList(usedpanelListitems);
        chosenSolarPanel.getItems().addAll(listObservable);
    }

    /**
     * updates the listview with all the items from the database.
     */
    @FXML
    public void updateListView() {
        try {
            usedpanelListStr2 = new Scanner(new URL(host + "usedPanelList").openStream(),
                    "UTF-8").nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        usedPanelListViewItems = Arrays.asList(usedpanelListStr2.split(" - "));
        ObservableList<String> usedPanelsObservable = FXCollections.observableArrayList(usedPanelListViewItems);
        usedPanelsListView.setItems(usedPanelsObservable);
    }

    /**
     * Calculates the co2 reduced emission when the user clicks the calculate button.
     * it also calculates the amount of points the user earned.
     * @param event mouse click
     * @throws Exception throws exception when something went wrong
     */
    @FXML
    void safePanel(MouseEvent event) throws Exception {
        panel = chosenSolarPanel.getValue();
        int amount = (int) amountOfSolarPanels.getValue();
        safePanel.safePanel(panel,amount);
        updateListView();
    }
}
