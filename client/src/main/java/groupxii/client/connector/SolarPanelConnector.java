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

    /**
     * Shortcut for /savePanelData.
     */
    public static String commitPanel(String panel, int amount) {
        String resource = "/savePanelData"
                + "?panel=" + panel + ""
                + "&amount=" + amount;

        return Connector.postRequest(resource);
    }
    public static String retrieveUsedPanelList() {
        String resource = "/getUsedPanelList";
        return Connector.getRequest(resource);
    }
}
