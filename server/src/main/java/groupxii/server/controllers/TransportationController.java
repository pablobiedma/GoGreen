package groupxii.server.controllers;

//import groupxii.database.Database;

import groupxii.database.VehicleEntry;
//import groupxii.server.Transportation;
import groupxii.transportation.SaveVehicle;
import groupxii.transportation.Vehicle;
import groupxii.transportation.VehicleCalculations;
import groupxii.transportation.VehicleData;
import groupxii.transportation.VehicleNameList;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TransportationController {

    private final AtomicLong counter = new AtomicLong();
    private VehicleCalculations vehicleCalculations = new VehicleCalculations();
    private SaveVehicle saveVehicle = new SaveVehicle();
    private VehicleData vehicleData = new VehicleData();
    private List<Vehicle> vehicleList = new ArrayList<>();
    private int reducedCo2Transportation = 0;

    /**
     * Setter for the VehicleData.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void setVehicleData() throws IOException {
        vehicleData.readVehicleListData();
        this.vehicleList = vehicleData.getVehicles();
    }

    /**
     * This method will return the List of vehicles which are requested.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getVehicleData")
    public List<Vehicle> getVehicleData() {
        return vehicleData.getVehicles();
    }

    /**
     * This method will return the vehicleEntry which is saved.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getVehicleEntry")
    public VehicleEntry getVehicleEntry() {
        return saveVehicle.getVehicleEntry();
    }

    /**
     * This method will transform the data from the vehicleList into one string,
     * which then can be used by the client, so the choice boxes/list views in
     * the GUI are able to show all the vehicle names.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/vehicleNameList")
    public String getNameList() {
        VehicleNameList vehicleNameList = new VehicleNameList();
        vehicleNameList.setVehicles(this.vehicleList);
        String vehicleNameListString = vehicleNameList.getVehicleNameList();
        return vehicleNameListString;
    }

    /**
     * the client can send data to the server with the right values as parameter,
     * then this method will store the data in the database.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/saveVehicleData")
    public void saveVehicleData(@RequestParam(value = "publictransport", defaultValue = "Unknown")
                                            String publictransport,
                                @RequestParam(value = "goodfuel", defaultValue = "Unknown")
                                        String goodfuel,
                                @RequestParam(value = "goodavgconsumption", defaultValue = "0")
                                            int goodavgconsumption,
                                @RequestParam(value = "car", defaultValue = "Unknown")
                                            String car,
                                @RequestParam(value = "badfuel", defaultValue = "Unknown")
                                            String badfuel,
                                @RequestParam(value = "badavgconsumption", defaultValue = "0")
                                            int badavgconsumption)
            throws IOException {
        int reducedco2 = vehicleCalculations.reducedCO2(car, badfuel, badavgconsumption,
                vehicleCalculations.calculateCO2(publictransport, goodfuel, goodavgconsumption));
        saveVehicle.setVehicles(this.vehicleList);
        saveVehicle.saveVehicleData(counter.incrementAndGet(), publictransport, car,
                reducedco2, goodfuel, badfuel, goodavgconsumption, badavgconsumption);
    }

    /**
     * get method for the reduced co2.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getReducedCO2")
    public String getReducedCO2(@RequestParam(value = "publictransport", defaultValue = "Unknown")
                                         String publictransport,
                             @RequestParam(value = "goodfuel", defaultValue = "Unknown")
                                     String goodfuel,
                             @RequestParam(value = "goodavgconsumption", defaultValue = "0")
                                         int goodavgconsumption,
                             @RequestParam(value = "car", defaultValue = "Unknown")
                                         String car,
                             @RequestParam(value = "badfuel", defaultValue = "Unknown")
                                         String badfuel,
                             @RequestParam(value = "badavgconsumption", defaultValue = "0")
                                         int badavgconsumption) throws IOException {
        vehicleCalculations.setVehicles(this.vehicleList);
        int reducedCO2 = vehicleCalculations.reducedCO2(car, badfuel, badavgconsumption,
                vehicleCalculations.calculateCO2(publictransport, goodfuel, goodavgconsumption));
        this.reducedCo2Transportation = reducedCO2;
        URL url = new URL("http://localhost:8080/increaseReducedCO2?Id=1&ReducedCO2=" + reducedCO2);
        String readLine;
        // opens a http connection with the URL.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // sets request method and properties.
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            //Reads in all the data from the request
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            // print result
            System.out.println(response.toString());
        }
        return "{\"reducedCO2\":\"" + reducedCO2 + "\"}";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getReducedCalculationTransportation")
    public int getReducedCalculationTransportation(){
        return reducedCo2Transportation;
    }



}
