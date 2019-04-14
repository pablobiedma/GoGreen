package groupxii.client.connector;

public class TransportConnector {
    /**
     * Shortcut for /vehicleNameList.
     */
    public static String retrieveTransportList() {
        String resource = "/vehicleNameList";
        return Connector.getRequest(resource);
    }

    /**
     * Shortcut for /calculateTransprot.
     */
    public static String calculateCO2Reduction(String goodTransportName,
                                               String badTransportName,
                                               int goodConsumption,
                                               int badConsumption) {
        String resource = "/calculateTransport"
                + "?goodVehicleType=" + goodTransportName
                + "&badVehicleType" + badTransportName
                + "&goodAvgConsumption" + goodConsumption
                + "&badAvgConsumption" + badConsumption;

        return Connector.getRequest(resource);
    }

    /**
     * Shortcut for /saveVehicleData.
     */
    public static String commitTransport(String goodVehicleType, int goodConsumption,
                                    String badVehicleType, int badConsumption) {
        String resource = "/saveVehicleData"
                + "?goodVehicleType=" + goodVehicleType + ""
                + "&goodConsumption=" + goodConsumption
                + "&badVehicleType=" + badVehicleType + ""
                + "&badServingSize=" + badConsumption;

        return Connector.postRequest(resource);
    }

    /**
     * Shortcut for /usedTransportList.
     */
    public static String retrieveUsedTransportList() {
        String resource = "/usedTransportList";
        return Connector.getRequest(resource);
    }
}
