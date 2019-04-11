package groupxii.client.transportation;

import groupxii.client.connector.TransportConnector;

public class ReducedCO2 {

    public static String getReducedCO2(String goodTransportName, String badTransportName , int goodConsumption , int badConsumption, int SafeVehicle){
        String result = TransportConnector.calculateCO2Reduction(goodTransportName, badTransportName , goodConsumption ,badConsumption);
        return result;
    }
}
