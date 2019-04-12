package groupxii.client.vegetarianmeal;

import groupxii.client.connector.VegetarianMealConnector;

import java.util.Arrays;
import java.util.List;

/**
 * Class that stores the eaten meal list.
 */
public class EatenMealList {

    private List<String> mealList;

    public EatenMealList() {
        mealList = Arrays.asList(VegetarianMealConnector.retrieveEatenMealList().split(" - "));
    }

    /**
     * Asks the connector to retrieve the eaten meal list and parses it.
     */
    /*
    public void setEatenMealList() {
        String eatenMealStr = VegetarianMealConnector.retrieveEatenMealList();
        mealList = Arrays.asList(eatenMealStr.split(" - "));
    }
    */
    public List<String> getEatenMealList() {
        return this.mealList;
    }
}
