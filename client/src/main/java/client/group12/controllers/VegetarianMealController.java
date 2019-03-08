package client.group12.controllers;

import client.group12.vegetarianMeal.MealAPI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class VegetarianMealController implements Initializable {

    @FXML
    private ListView<String> mealList;

    @FXML
    private ChoiceBox<String> cb = new ChoiceBox();

    @FXML
    public void calculate(MouseEvent event) throws Exception {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        MealAPI mealapi = new MealAPI();
        try {
            mealapi.readAPI();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String listItems = mealapi.toString();
        listItems.toLowerCase();
        List<String> items = Arrays.asList(listItems.split(", "));
        ObservableList<String> list = FXCollections.observableArrayList(items);
        cb.getItems().addAll(list);
    }

    public void badFoodName() throws IOException {

    }

    @FXML
    public void goodFoodName(){

    }

    @FXML
    public void calculateCO2(MouseEvent event) throws Exception {

    }
}