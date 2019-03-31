package groupxii.vegetarianmeal;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EatenMealList {

    private List<String> eatenMealList = new ArrayList<String>();
    private List<Document> documents;
    private MongoClient client = new MongoClient("localhost", 27017);
    private MongoDatabase db = client.getDatabase("GoGreen");
    private MongoCollection<Document> collection = db.getCollection("vegetarianMealCollection");

    public List<String> getEatenMealList() {
        return eatenMealList;
    }

    /**
     * Reads the eaten meals from the database and adds them in the listview.
     */
    public void readDatabase() throws IOException {

        documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String goodFoodName = document.getString("goodFoodName");
            String badFoodName = document.getString("badFoodName");
            int goodServingSize = document.getInteger("goodServingSize");
            int badServingSize = document.getInteger("badServingSize");
            int reducedCo2 = document.getInteger("reducedCo2");
            //System.out.println(toString(goodFoodName, badFoodName,
            // goodServingSize, badServingSize, reducedCo2));
            eatenMealList.add(toString(goodFoodName, badFoodName,
                    goodServingSize, badServingSize, reducedCo2));
        }
    }

    /**
     * create strings of the eaten meals from the database.
     */
    public String toString(String goodFoodName, String badFoodName,
                           int goodServingSize, int badServingSize, int reducedCo2) {
        String result = "You ate " + goodServingSize + " grams of " + goodFoodName
                + " instead of " + badServingSize + " grams of " + badFoodName
                + " , by doing so you reduced your carbon footprint with "
                + reducedCo2 + " grams of CO2";
        return result;
    }

    /**
     * reads the latest added meal from the database.
     * @return string from the latest meal
     */
    public String getLatestMeal() {
        Document document = collection.find().sort(new Document("_id", -1)).first();
        String result = toString(document.getString("goodFoodName"),
                document.getString("badFoodName"),
                document.getInteger("goodServingSize"), document.getInteger("badServingSize"),
                document.getInteger("reducedCo2"));
        return result;
    }
}
