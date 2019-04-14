package groupxii.client.transportation;

import groupxii.client.connector.TransportConnector;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that stores the used transport.
 */
public class UsedTransportList {
    private List<String> transportList;


    /**
     * Asks the connector to retrieve the eaten meal list and parses it.
     */
    public void setUsedTransportList() {
        transportList = new ArrayList<>();

        String usedTransportList = TransportConnector.retrieveUsedTransportList();

        JSONArray jsonArray = new JSONArray(usedTransportList);

        for (int i = 0; i < jsonArray.length(); i++ ) {
            JSONObject jsonEntry = (JSONObject)jsonArray.get(i);
            String entry = "Used a ";

            entry += jsonEntry.get("goodVehicleType").toString();
            entry += " and saved: ";
            entry += jsonEntry.get("reducedCo2").toString();
            entry += " of Co2!";

            transportList.add(entry);
        }
    }

    public List<String> getUsedTransportList() {
        return this.transportList;
    }
}
