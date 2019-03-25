package client.groupxii.solarpanel;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsedPanelList {
    private List<String> usedPanelList = new ArrayList<String>();
    private List<Document> documents;
    private MongoClient client = new MongoClient("localhost", 27017);
    private MongoDatabase db = client.getDatabase("GoGreen");
    private MongoCollection<Document> collection = db.getCollection("solarPanelCollection");

    public List<String> getEatenMealList() {
        return usedPanelList;
    }

    /**
     * Reads the used panels from the database and adds them in the listview.
     */
    public void readDatabase() throws IOException {

        documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String panelA = document.getString("panelA");
            String panelB = document.getString("panelB");
            int highefficiencyrate = document.getInteger("highefficiencyrate");
            int lowefficiencyrate = document.getInteger("lowefficiencyrate");
            int reducedCo2 = document.getInteger("reducedCo2");

            usedPanelList.add(toString(panelA, panelB,
                    highefficiencyrate, lowefficiencyrate, reducedCo2));
        }
    }

    /**
     * create strings of the used panels from the database.
     */
    public String toString(String panelA, String panelB,
                           int highefficiencyrate, int lowefficiencyrate, int reducedCo2) {
        String result = "You used " + panelA + " with " + highefficiencyrate
                + " instead of " + panelB + " with " + lowefficiencyrate
                + " , by doing so you reduced your carbon footprint with "
                + reducedCo2 + " grams of CO2";
        return result;
    }

    /**
     * reads the latest added panel from the database.
     * @return string from the latest meal
     */
    public String getLatestMeal() {
        Document document = collection.find().sort(new Document("_id", -1)).first();
        String result = toString(document.getString("panelA"),
                document.getString("panelB"),
                document.getInteger("highefficiencyrate"), document.getInteger("lowefficiencyrate"),
                document.getInteger("reducedCo2"));
        return result;
    }

}
