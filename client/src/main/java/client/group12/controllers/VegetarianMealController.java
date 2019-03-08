package client.group12.controllers;

import client.group12.vegetarianMeal.MealAPI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class VegetarianMealController {

    @FXML
    private ListView<String> mealList;
    @FXML
    private ListView<String> mealList2 = new ListView<String>();

    @FXML
    private ChoiceBox cb = new ChoiceBox();

    private String listItems = "";
    ObservableList<String> list;

    @FXML
    public void calculate(MouseEvent event) throws Exception {
    }

    @FXML
    public void badFoodName(MouseEvent event) throws Exception {
        MealAPI mealapi;
        mealapi = new MealAPI();
        mealapi.readAPI();
        String listItems = mealapi.toString();
        System.out.println(listItems);
        //list.addAll(listItems);
        //list = FXCollections.observableArrayList(listItems);
        //mealList.setItems(FXCollections.<String>observableArrayList(listItems));
        list = FXCollections.observableArrayList(listItems);
        mealList = new ListView<String>(list);
        mealList.setItems(list);
    }

    @FXML
    public void goodFoodName(MouseEvent event) throws Exception {
        //mealList2.setItems(list);
    }

    @FXML
    public void calculateCO2(MouseEvent event) throws Exception {

    }
}