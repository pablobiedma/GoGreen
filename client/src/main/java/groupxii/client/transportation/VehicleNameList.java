package groupxii.client.transportation;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import groupxii.client.connector.TransportConnector;

/**
 * Class that stores the  list
 */
public class VehicleNameList {
    private List<String> vehicleNameList;

    /**
     * Asks the connector to retrieve the meal list and parses it
     */
    public VehicleNameList() {
        String json = TransportConnector.retrieveTransportList();
        vehicleNameList = Arrays.asList(json.split(","));
        //this.parseJson(json);
    }

    public VehicleNameList(String json) {
        this.parseJson(json);
    }

    private void parseJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {

            //Does this has to be like this? -p
            this.vehicleNameList = mapper.
                    readValue(
                            json,
                            mapper.getTypeFactory()
                                    .constructCollectionType(List.class,
                                            String.class));
        } catch (IOException e) {
            this.vehicleNameList = new ArrayList<>();
            System.err.println(e.getMessage());
        }
    }

    public List<String> getVehicleNameList() {
        return this.vehicleNameList;
    }
}
