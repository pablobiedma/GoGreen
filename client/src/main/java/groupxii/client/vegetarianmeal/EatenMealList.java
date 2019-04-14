package groupxii.client.vegetarianmeal;

import org.json.JSONArray;
import org.json.JSONObject;
import groupxii.client.connector.VegetarianMealConnector;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that stores the eaten meal list.
 */
//TODO
public class EatenMealList {
    private List<String> mealList;

    /**
     * Asks the connector to retrieve the eaten meal list and parses it.
     */
    public void setEatenMealList() {
		mealList = new ArrayList<>();

        String eatenMealList = VegetarianMealConnector.retrieveEatenMealList();

		JSONArray jsonArray = new JSONArray(eatenMealList);

		for (int i = 0; i < jsonArray.length(); i++ ) {
			JSONObject jsonEntry = (JSONObject)jsonArray.get(i);
			String entry = "Ate a ";

			entry += jsonEntry.get("goodFoodName").toString();
			entry += " and saved: ";
			entry += jsonEntry.get("reducedCo2").toString();
			entry += " of Co2!";

			mealList.add(entry);
		}
    }

    public List<String> getEatenMealList() {
        return this.mealList;
    }
}
