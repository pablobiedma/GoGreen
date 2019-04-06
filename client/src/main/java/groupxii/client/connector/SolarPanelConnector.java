package groupxii.client.connector;

public class SolarPanelConnector {

    public static String retrievePanelList() {
        String resource = "/getPanelList";
        return Connector.getRequest(resource);
    }

    public static String calculateCO2Reduction(String paneltype,int amount) {
        String resource = "/calculatePanel"
                + "?" + paneltype
                + "&" + amount;

        return Connector.getRequest(resource);
    }

}
