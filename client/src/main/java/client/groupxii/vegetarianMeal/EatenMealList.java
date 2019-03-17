package client.groupxii.vegetarianMeal;

import client.groupxii.controllers.VegetarianMealController;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class EatenMealList {

    private List<String> eatenMealList = new ArrayList<String>();
    private List<Document> documents;

    public List<String> getEatenMealList() {
        return eatenMealList;
    }

    public void readDatabase() throws IOException {

        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase db = client.getDatabase("GoGreen");
        MongoCollection<Document> collection = db.getCollection("vegetarianMealCollection");

        documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        int i = 0;
        for(Document document : documents){
            Document meal = documents.get(i);
            String goodFoodName = meal.getString("goodFoodName");
            String badFoodName = meal.getString("badFoodName");
            int goodServingSize = meal.getInteger("goodServingSize");
            int badServingSize = meal.getInteger("badServingSize");
            int reducedCo2 = meal.getInteger("reducedCo2");
            i++;
        }
        i = 0;

        VegetarianMealController vegetarianMealController = new VegetarianMealController();
        for(int j = 0; j < documents.size(); j++){
            eatenMealList.add(toString(j));
        }
    }

    public String toString(int j) {
        String result = "You ate " + documents.get(j).get("goodServingSize") + " grams of " + documents.get(j).get("goodFoodName") +
                " instead of " + documents.get(j).get("badServingSize") + " grams of " + documents.get(j).get("badFoodName") +
                " bad food, with that you reduced your carbon footprint with " + documents.get(j).get("reducedCo2") + " grams of CO2";
        return result;
    }
}
