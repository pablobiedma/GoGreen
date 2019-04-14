package groupxii.client.transportation;

import groupxii.client.connector.TransportConnector;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that stores the used transport.
 */
public class UsedTransportList {
    /**
     * Asks the connector to retrieve the taken transport list and parses it.
     */
    public static List<String> getUsedTransportList() {
		List<String> transportList = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(TransportConnector.retrieveUsedTransportList());

        for (int i = 0; i < jsonArray.length(); i++ ) {
            JSONObject jsonEntry = (JSONObject)jsonArray.get(i);
            String entry = "Took a ";

            entry += jsonEntry.get("goodTransportName").toString();
            entry += " and saved: ";
            entry += jsonEntry.get("reducedCo2").toString();
            entry += " of Co2!";

            transportList.add(entry);
        }

        return transportList;
    }
}
