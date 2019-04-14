package groupxii.client.transportation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import groupxii.client.connector.TransportConnector;

import java.io.IOException;

public class Reducedco2 {
    /**
     * get the reduced CO2 of a transport.
     */
    public static String getReducedCo2(String goodVehicleType,
                                       int goodConsumption,
                                       String badVehicleType,
                                       int badConsumption) {
        String response = TransportConnector
                .calculateCO2Reduction(goodVehicleType, badVehicleType,
                        goodConsumption, badConsumption);
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode node = null;
        try {
            node = objectMapper.readTree(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = node.get("reducedCO2").asText();
        return result;
    }
}
