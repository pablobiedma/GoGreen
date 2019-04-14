package groupxii.client.solarpanels;

import groupxii.client.connector.SolarPanelConnector;

import java.util.Arrays;
import java.util.List;

public class UsedPanelList {
    private List<String> panelList;

    public UsedPanelList() {
        panelList = Arrays.asList(SolarPanelConnector.retrieveUsedPanelList().split(" - "));
    }

    /**
     * Asks the connector to retrieve the used transport list and parses it.
     */
    public void setEatenMealList() {
        String usedPanelString = SolarPanelConnector.retrieveUsedPanelList();
        panelList = Arrays.asList(usedPanelString.split(" - "));
    }

    public List<String> getUsedPanelList() {
        return this.panelList;
    }
}
