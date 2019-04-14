package groupxii.client.connector;

public class TransportConnector {
    public static String retrieveTransportList() {
        String resource = "/vehicleNameList";
        return Connector.getRequest(resource);
    }

    /**
     * Calculate the co2 reduction of a vehicle.
     */
    public static String calculateCO2Reduction(String goodTransportName,
                                               String badTransportName ,
                                               int goodConsumption ,
                                               int badConsumption) {
        String resource = "/calculateTransport"
                + "?" + goodTransportName
                + "&" + badTransportName
                + "&" + goodConsumption
                + "&" + badConsumption;

        return Connector.getRequest(resource);
    }

    public static String retrieveUsedTransportList() {
        String resource = "/usedTransportList";
        return Connector.getRequest(resource);
    }


}
