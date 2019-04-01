package client.groupxii.controllers;

import client.groupxii.Main;
import client.groupxii.vegetarianmeal.SafeMeal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
    private String userId = "1";

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
        ObservableList<String> eatenMealsObservable =
                FXCollections.observableArrayList(eatenMealListViewItems);
        eatenMealsListView.setItems(eatenMealsObservable);
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
        ObservableList<String> eatenMealsObservable =
                FXCollections.observableArrayList(eatenMealListViewItems);
        eatenMealsListView.setItems(eatenMealsObservable);
    }

    /**
     * Calculates the co2 reduced emmision when the user clicks the calculate button.
     * it also calculates the amount of points the user earned.
     * @param event mouse click
     * @throws Exception throws exception when something went wrong
     */
    @FXML
    public String safeMeal(MouseEvent event) throws Exception {
        badFoodName = cb1.getValue();
        goodFoodName = cb.getValue();
        int goodServingSize = (int) slider.getValue();
        int badServingSize = (int) slider1.getValue();
        safeMeal.safeMeal(goodFoodName, badFoodName, goodServingSize, badServingSize);
        updateListView();
        String reducedCo2 = new Scanner(new URL(host + "getReducedCo2").openStream()).nextLine();
        URL url = new URL(host + "increaseReducedCO2?Id=" + userId + "&ReducedCO2=" + reducedCo2);
        String readLine;
        // opens a http connection with the URL.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // sets request method and properties.
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            //Reads in all the data from the request
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            return "GET NOT WORKED";
        }
    }

    @FXML
    public void btnBack(MouseEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}

