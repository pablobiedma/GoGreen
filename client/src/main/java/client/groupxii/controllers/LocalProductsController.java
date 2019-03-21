package client.groupxii.controllers;

import client.groupxii.vegetarianmeal.EatenMealList;
import client.groupxii.vegetarianmeal.SafeMeal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class LocalProductsController {

    @FXML
    private Text textfield = new Text();

    @FXML
    private ListView<String> localShops = new ListView();

    private List<String> listViewItems = new ArrayList<String>();
    private ObservableList<String> listViewObservable;

    public void setListViewItems(List<String> listViewItems) {
        this.listViewItems = listViewItems;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList();

    }

    /**
     * updates the listview with all the items from the database.
     */
    @FXML
    public void updateListView() {
    }

}
