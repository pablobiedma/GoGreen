package client.group12.vegetarianMeal;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class mealAPI {

    private List<Meal> mealList = new ArrayList<Meal>();

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    public void readAPI() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new URL("https://opendata.socrata.com/resource/8nz9-yn2p.json"));


        Iterator<JsonNode> elements = rootNode.elements();
        while(elements.hasNext()){
            JsonNode n = elements.next();
            String food = n.get("food").asText();
            int co2Node = n.get("grams_co2e_per_serving").asInt();
            int sizeNode = n.get("serving_size").asInt();

            mealList.add(new Meal(food, co2Node, sizeNode));
            elements.next();
        }

        for(int i = 0; i < mealList.size(); i++){
            System.out.println(mealList.get(i).getFood());
            System.out.println(mealList.get(i).getCo2());
            System.out.println(mealList.get(i).getServingSize() + "\n");
        }
    }
}
