package client.vegetarianmeal;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.*;




public class Mealapi {

    private String result = "";

    private List<Meal> mealList = new ArrayList<Meal>();

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    /**
     * method which reads API to obtsin elements and place them in meallist.
     */
    public void readapi() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new URL("https://opendata.socrata.com/resource/8nz9-yn2p.json"));

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

        /*
        for(int i = 0; i < mealList.size(); i++){
            System.out.println(mealList.get(i).getFood());
            System.out.println(mealList.get(i).getCo2());
            System.out.println(mealList.get(i).getServingSize() + "\n");
        }
        */

    }

    /**
     * human-friendly  String representation of meallist.
     */
    public String toString() {
        for (int j = 0; j < mealList.size(); j++) {
            result = result + mealList.get(j).getFood() + ", ";
        }
        result = result.substring(0, result.length() - 2);
        //System.out.println("result: " + result);
        return result;
    }

}
