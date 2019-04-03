package groupxii.client.vegetarianmeal;

import com.fasterxml.jackson.databind.ObjectMapper;
import groupxii.client.connector.Connector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Class that stores the meal list
 */
public class MealList {
    private List<String> mealList;

    public MealList() {
        mealList = new ArrayList<>();
    }

	/**
	 * Takes a json string array and parses it into MealList.
	 */
    public MealList(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
			//Does this has to be like this?
            this.mealList = mapper.
                readValue(
                        json,
                        mapper.getTypeFactory()
                                .constructCollectionType(List.class,
                                                         String.class));
        } catch (IOException e) {
            mealList = null;
            System.err.println(e.getMessage());
        }
    }

    public List<String> getMealList() {
        return this.mealList;
    }
}
