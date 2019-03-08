package client.group12.controllers;

import client.group12.vegetarianMeal.Meal;
import client.group12.vegetarianMeal.MealAPI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class VegetarianMealController {

    @FXML
    private ListView<String> mealList = new ListView<String>();
    @FXML
    private ListView<String> mealList2 = new ListView<String>();

    private String listItems = "";
    ObservableList list = FXCollections.observableArrayList();

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
        list.add(listItems);
        mealList.getItems().addAll(list);
    }

    @FXML
    public void goodFoodName(MouseEvent event) throws Exception {
        mealList2.getItems().addAll(list);
    }

    @FXML
    public void calculateCO2(MouseEvent event) throws Exception {

    }
}