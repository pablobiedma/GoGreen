package groupxii.transportation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VehicleData {

    List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Read the given data from the txt file.
     */
    public void readVehicleListData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(getClass().getClassLoader().getResource(
                "transportationList.txt"));

        Iterator<JsonNode> elements = rootNode.elements();
        while (elements.hasNext()) {
            JsonNode node = elements.next();
            String name = node.get("vehiclename").asText();
            int co2 = node.get("grams_co2_by_vehicle_per_km").asInt();
            String fuel = node.get("fuel").asText();
            int avgconsumption = node.get("average_consumption_liter/100km").asInt();
            vehicles.add(new Vehicle(name,co2,fuel,avgconsumption));
            //elements.next();
        }
    }
}
