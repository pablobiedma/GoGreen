package client.groupxii.controllers;

import client.groupxii.solarpanel.SafePanel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.net.URL;
import java.util.*;

public class SolarPanelControllerDemo implements Initializable {

    @FXML
    private Button btnSolarPanel;

    @FXML
    private Slider amountOfSolarPanels;

    @FXML
    private ChoiceBox<String> chosenSolarPanel;

    @FXML
    private Text savedCo2;

    @FXML
    private ListView<String> usedpanelListview = new ListView<>();

    private String host = "http://localhost:8080/";
    private SafePanel safePanel = new SafePanel();
    private String panel = "";
    private String usedpanelListStr = "";
    private String usedpanelListStr2 = "";
    //private List<String> listViewItems = new ArrayList<String>();
    private List<String> usedpanelListitems = new ArrayList<String>();

    public SolarPanelControllerDemo() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            usedpanelListStr = new Scanner(new URL(host + "panelNameList").openStream(),
                    "UTF-8").nextLine();
            usedpanelListStr2 = new Scanner(new URL(host + "usedPanelList").openStream(),
                    "UTF-8").nextLine();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        usedpanelListitems = Arrays.asList(usedpanelListStr2.split(" - "));
        ObservableList<String> usedpanelsObservable  =
                FXCollections.observableArrayList(usedpanelListitems);
        usedpanelListview.setItems(usedpanelsObservable);
        List<String> items = Arrays.asList(usedpanelListStr.split(", "));
        ObservableList<String> listObservable = FXCollections.observableArrayList(items);
        chosenSolarPanel.getItems().addAll(listObservable);
    }


    /**
     *  updates the listview with all the items from the database.
     */
    @FXML
    public void updateListView() {
        try {
            usedpanelListStr2 = new Scanner(new URL(host + "usedPanelList").openStream(),
                    "UTF-8").nextLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        usedpanelListitems = Arrays.asList(usedpanelListStr2.split(" - "));
        ObservableList<String> usedPanelsObservable = FXCollections.observableArrayList(usedpanelListitems);
        usedpanelListview.setItems(usedPanelsObservable);

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
        updateListView();
    }
}
