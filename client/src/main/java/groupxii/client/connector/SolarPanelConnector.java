package groupxii.client.connector;

public class SolarPanelConnector {
    public static String retrievePanelList() {
        String resource = "/panelNameList";
        return Connector.getRequest(resource);
    }

    /**
     * calculate the reduced co2 of a list of panels.
     */
    public static String calculateCO2Reduction(String panel, int amount) {
        String resource = "/calculatePanel"
                + "?" + panel
                + "&" + amount;

        return Connector.getRequest(resource);
    }

    public static String retrieveUsedPanelList() {
        String resource = "/usedPanelList";
        return Connector.getRequest(resource);
    }
}
