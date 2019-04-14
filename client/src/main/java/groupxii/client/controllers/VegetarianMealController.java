package groupxii.client.controllers;

import groupxii.client.Main;
import groupxii.client.connector.VegetarianMealConnector;
import groupxii.client.vegetarianmeal.ReducedCo2;
import groupxii.client.vegetarianmeal.MealList;
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

import java.util.*;



public class VegetarianMealController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBoxGoodFood = new ChoiceBox();

    @FXML
    private ChoiceBox<String> choiceBoxBadFood = new ChoiceBox();

    @FXML
    private Slider sliderGoodFood = new Slider();

    @FXML
    private Slider sliderBadFood = new Slider();

    @FXML
    private Text reducedCo2Text = new Text();

    @FXML
    private ListView<String> eatenMealsListView = new ListView();

    //private String goodFoodName = "";
    //private String badFoodName = "";
    //private String host = "http://localhost:8080/";
    //private String foodNameListStr = "";
    //private String eatenMealListStr = "";

    //private SafeMeal safeMeal = new SafeMeal();
    //private List<String> eatenMealListViewItems = new ArrayList<String>();

    //EatenMealList eatenMealList = new EatenMealList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*
        try {
            foodNameListStr = new Scanner(new URL(host + "mealNameList").openStream(),
                    "UTF-8").nextLine();
            eatenMealListStr = new Scanner(new URL(host + "eatenMealList").openStream(),
                    "UTF-8").nextLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        //eatenMealListViewItems = Arrays.asList(eatenMealListStr.split(" - "));
        //ObservableList<String> eatenMealsObservable
        // = FXCollections.observableArrayList(eatenMealListViewItems);
        //eatenMealsListView.setItems(eatenMealsObservable);

        MealList mealList = new MealList();
        ObservableList<String> listObservable
                = FXCollections.observableArrayList(mealList.getMealList());
        choiceBoxGoodFood.setItems(listObservable);
        choiceBoxBadFood.setItems(listObservable);
        //updateListView();
    }

    /**
     * updates the list view with all the items from the database.
     */

    @FXML
    public void updateListView() {
        //TODO this first commended-out part has to be fixed
        /*
        ObservableList<String> eatenMealObservableList
                = FXCollections.observableArrayList(eatenMealList.getEatenMealList());
        eatenMealsListView.setItems(eatenMealObservableList);
        */
        /*
        try {
            eatenMealListStr = new Scanner(new URL(host + "eatenMealList").openStream(),
                    "UTF-8").nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        eatenMealListViewItems = Arrays.asList(eatenMealListStr.split(" - "));
        ObservableList<String> eatenMealsObservable
        = FXCollections.observableArrayList(eatenMealListViewItems);
        eatenMealsListView.setItems(eatenMealsObservable);
        */

    }

    @FXML
    public void calculateMeal(MouseEvent event) {
        String goodFoodName = choiceBoxGoodFood.getValue();
        int goodServingSize = (int)sliderGoodFood.getValue();
        String badFoodName = choiceBoxBadFood.getValue();
        int badServingSize = (int)sliderBadFood.getValue();

		String result = ReducedCo2.getReducedCo2(
				goodFoodName,
				goodServingSize,
				badFoodName,
				badServingSize);
		reducedCo2Text.setText("This will reduce " + result + " grams of CO2");

    }

    /**
     * Calculates the co2 reduced emission when the user clicks the calculate button.
     * it also calculates the amount of points the user earned.
     * @param event mouse click
     * @throws Exception throws exception when something went wrong
     */
    @FXML
    public void safeMeal(MouseEvent event) throws Exception {
        String goodFoodName = choiceBoxGoodFood.getValue();
        int goodServingSize = (int)sliderGoodFood.getValue();
        String badFoodName = choiceBoxBadFood.getValue();
        int badServingSize = (int)sliderBadFood.getValue();

        VegetarianMealConnector.commitMeal(goodFoodName,
                        goodServingSize,
                        badFoodName,
                        badServingSize);
        //TODO update contoller to display result
        //updateListView();
        reducedCo2Text.setText("Enjoy your meal :-)");
    }

    @FXML
    public void btnBack(MouseEvent event) throws IOException {
        Main main = new Main();
        main.changeScene("Menu.fxml", event);
    }
}
