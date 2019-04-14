package groupxii.client.solarpanels;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import groupxii.client.connector.SolarPanelConnector;

import java.io.IOException;

public class ReducedCO2 {
    /**
     * get the reduced CO2 of a panelList.
     */
    public static String getReducedCo2(String panel, int amount) {
        String response = SolarPanelConnector
                .calculateCO2Reduction(panel, amount);
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
