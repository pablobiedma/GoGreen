package groupxii.client.transportation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import groupxii.client.connector.TransportConnector;

import java.io.IOException;

public class ReducedCo2 {
    /**
     * Get the reduced CO2 of a transport?.
     * @return String with the reduced CO2 amount
     */
    public static String getReducedCo2(String goodTransport,
                                       int goodConsumption,
                                       String badTransport,
                                       int badConsumption) {
        String response = TransportConnector
                .calculateCO2Reduction(goodTransport,
                        badTransport,
                        goodConsumption,
                        badConsumption);
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
