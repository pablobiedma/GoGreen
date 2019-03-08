package client.group12.controllers;

import client.group12.vegetarianMeal.Calculations;
import client.group12.vegetarianMeal.MealAPI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class VegetarianMealController implements Initializable {

    @FXML
    private ChoiceBox<String> cb = new ChoiceBox();

    @FXML
    private ChoiceBox<String> cb1 = new ChoiceBox();

    @FXML
    private Slider slider = new Slider();

    private String goodFoodName = "";
    private String badFoodName = "";


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
        cb1.getItems().addAll(list);


    }

    @FXML
    public void badFoodName() {

    }

    @FXML
    public void goodFoodName(){

    }

    @FXML
    public void calculateCO2(MouseEvent event) throws Exception {
        badFoodName = cb1.getValue();
        goodFoodName = cb.getValue();
        System.out.println(goodFoodName + "    and   " + badFoodName);
        int servingSize = (int) slider.getValue();
        System.out.println(servingSize);
        Calculations calculation = new Calculations();
        double CO2GoodFood = calculation.calculateCO2(goodFoodName, servingSize);
        System.out.println(CO2GoodFood);
        int reducedCO2 = calculation.reducedCO2(badFoodName, servingSize, CO2GoodFood);
        int points = calculation.calculatePoints();
        //SEND POST REQUEST TO UPDATE THE DATABASE
        System.out.println("Reduced CO2: " + reducedCO2 + "   Amount of points earned: "+points);
    }
}