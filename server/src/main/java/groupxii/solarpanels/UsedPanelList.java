package groupxii.solarpanels;

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

    public List<String> getUsedPanelList() {
        return usedPanelList;
    }

    /**
     * Reads the used panels from the database and adds them in the listview.
     */
    public void readDatabase() throws IOException {

        documents = (List<Document>) collection.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String paneltype = document.getString("paneltype");
            int reducedCo2 = document.getInteger("reducedCo2");
            int efficiencyrate = document.getInteger("efficiencyrate");
            int amount = document.getInteger("amount");

            usedPanelList.add(toString(paneltype,reducedCo2, efficiencyrate,
                    amount));
        }
    }

    /**
     * create strings of the used panels from the database.
     */
    public String toString(String paneltype,
                           int reducedCo2,int efficiencyrate, int amount) {
        String result = "You used " + paneltype + " with an amount of " + amount
                + " and with an efficiencyrate of " + efficiencyrate
                + "%, by doing so you reduced your carbon footprint with "
                + reducedCo2 + " grams of CO2";
        return result;
    }

}
