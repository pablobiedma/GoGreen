package groupxii.client.solarpanels;

import groupxii.client.connector.SolarPanelConnector;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UsedPanelList {
    private List<String> panelList;

    /**
     * Asks the connector to retrieve the used panel list and parses it.
     */
    public void setUsedPanelList() {
        panelList = new ArrayList<>();

        String usedPanelList = SolarPanelConnector.retrieveUsedPanelList();

        JSONArray jsonArray = new JSONArray(usedPanelList);

        for (int i = 0; i < jsonArray.length(); i++ ) {
            JSONObject jsonEntry = (JSONObject)jsonArray.get(i);
            String entry = "Used a ";

            entry += jsonEntry.get("panel").toString();
            entry += " and saved: ";
            entry += jsonEntry.get("reducedCo2").toString();
            entry += " of Co2!";

            panelList.add(entry);
        }
    }

    public List<String> getUsedPanelList() {
        return this.panelList;
    }
}
