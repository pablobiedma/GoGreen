package groupxii.vegetarianmeal;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetMealData {

    private List<Meal> mealList = new ArrayList<Meal>();

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    /**
     * Read the data from the meallist.
     */
    public void readMealListData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(getClass().getClassLoader().getResource(
                "mealList.txt"));

        //iterates over all the elements in the JsonNode and stores the data we need
        // (food name, co2 emmision per serving and the size of the serving)
        Iterator<JsonNode> elements = rootNode.elements();
        while (elements.hasNext()) {
            JsonNode node = elements.next();
            String food = node.get("food").asText();
            int co2Node = node.get("grams_co2e_per_serving").asInt();
            double sizeNode = node.get("serving_size").asInt();

            mealList.add(new Meal(food, co2Node, sizeNode));
            elements.next();
        }
    }
}
