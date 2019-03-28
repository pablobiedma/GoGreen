package client.groupxii.controllers;

import client.groupxii.vegetarianmeal.SafeMeal;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;



public class VegetarianMealController implements Initializable {

    @FXML
    private ChoiceBox<String> cb = new ChoiceBox();

    @FXML
    private ChoiceBox<String> cb1 = new ChoiceBox();

    @FXML
    private Slider slider = new Slider();

    @FXML
    private Slider slider1 = new Slider();

    @FXML
    private ListView<String> eatenMealsListView = new ListView();

    private String goodFoodName = "";
    private String badFoodName = "";
    private String host = "http://localhost:8080/";
    private String foodNameListStr = "";
    private String eatenMealListStr = "";
    private SafeMeal safeMeal = new SafeMeal();
    private List<String> eatenMealListViewItems = new ArrayList<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            foodNameListStr = new Scanner(new URL(host + "mealNameList").openStream(),
                    "UTF-8").nextLine();
            eatenMealListStr = new Scanner(new URL(host + "eatenMealList").openStream(),
                    "UTF-8").nextLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        eatenMealListViewItems = Arrays.asList(eatenMealListStr.split(" - "));
        ObservableList<String> eatenMealsObservable = FXCollections.observableArrayList(eatenMealListViewItems);
        eatenMealsListView.getItems().addAll(eatenMealsObservable);
        List<String> items = Arrays.asList(foodNameListStr.split(", "));
        ObservableList<String> listObservable = FXCollections.observableArrayList(items);
        cb.getItems().addAll(listObservable);
        cb1.getItems().addAll(listObservable);
    }

    /**
     * updates the listview with all the items from the database.
     */
    @FXML
    public void updateListView() {
        try {
            eatenMealListStr = new Scanner(new URL(host + "eatenMealList").openStream(),
                    "UTF-8").nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        eatenMealListViewItems = Arrays.asList(eatenMealListStr.split(" - "));
        ObservableList<String> eatenMealsObservable = FXCollections.observableArrayList(eatenMealListViewItems);
        eatenMealsListView.getItems().addAll(eatenMealsObservable);
    }

    /**
     * Calculates the co2 reduced emmision when the user clicks the calculate button.
     * it also calculates the amount of points the user earned.
     * @param event mouse click
     * @throws Exception throws exception when something went wrong
     */
    @FXML
    public void safeMeal(MouseEvent event) throws Exception {
        badFoodName = cb1.getValue();
        goodFoodName = cb.getValue();
        int goodServingSize = (int) slider.getValue();
        int badServingSize = (int) slider1.getValue();
        safeMeal.safeMeal(goodFoodName, badFoodName, goodServingSize, badServingSize);
        updateListView();
    }
}
