package groupxii.server.controllers;

import groupxii.database.Database;
import groupxii.database.VehicleEntry;
import groupxii.server.Transportation;
import groupxii.transportation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* TransportationController - Use Spring Boot controller
 * to handle /transport requests
 */
@RestController
public class TransportationController {

    private final AtomicLong counter = new AtomicLong();
    private VehicleCalculations vehicleCalculations = new VehicleCalculations();
    private SaveVehicle saveVehicle = new SaveVehicle();
    private VehicleData vehicleData = new VehicleData();
    private List<Vehicle> vehicleList = new ArrayList<>();

    /**
     * Setter for the VehicleData.
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.GET, value = "/setVehicleData")
    public void setVehicleData() throws IOException {
        vehicleData.readPanelListData();
        this.vehicleList = vehicleData.getVehicles();
    }

    /**
     * This method will return the List of vehicles which are requested.
     * @return
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
     This method will transform the data from the vehicleList into one string, which then can be used
     by the client, so the choice boxes/list views in the GUI are able to show all the vehicle names.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/vehicleNameList")
    public String getNameList() {
        VehicleNameList vehicleNameList = new VehicleNameList();
        vehicleNameList.setVehicles(this.vehicleList);
        String vehicleNameListString = vehicleNameList.getVehicleNameList();
        return vehicleNameListString;
    }

    /**
     the client can send data to the server with the right values as parameter,
     then this method will store the data in the database.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/saveVehicleData")
    public void saveVehicleData(@RequestParam(value = "publictransport", defaultValue = "Unknown") String publictransport,
                                @RequestParam(value = "goodfuel", defaultValue = "Unknown") String goodfuel,
                                @RequestParam(value = "goodavgconsumption",defaultValue = "0") int goodavgconsumption,
                                @RequestParam(value = "car", defaultValue = "Unknown") String car,
                                @RequestParam(value = "badfuel", defaultValue = "Unknown") String badfuel,
                                @RequestParam(value = "badavgconsumption",defaultValue = "0") int badavgconsumption)
    throws IOException {
        int reducedco2 = getReducedCO2(publictransport,goodfuel,goodavgconsumption,car,badfuel,badavgconsumption);
        saveVehicle.setVehicles(this.vehicleList);
        saveVehicle.saveVehicleData(counter.incrementAndGet(),publictransport, car, reducedco2, goodfuel, badfuel,
                goodavgconsumption, badavgconsumption);
    }

    /**
     * get method for the reduced co2.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getReducedCO2")
    public int getReducedCO2(@RequestParam(value = "publictransport", defaultValue = "Unknown") String publictransport,
                             @RequestParam(value = "goodfuel", defaultValue = "Unknown") String goodfuel,
                             @RequestParam(value = "goodavgconsumption",defaultValue = "0") int goodavgconsumption,
                             @RequestParam(value = "car", defaultValue = "Unknown") String car,
                             @RequestParam(value = "badfuel", defaultValue = "Unknown") String badfuel,
                             @RequestParam(value = "badavgconsumption",defaultValue = "0") int badavgconsumption)throws IOException {
        vehicleCalculations.setVehicles(this.vehicleList);
        int reducedCO2 = vehicleCalculations.reducedCO2(car,badfuel,badavgconsumption,
                vehicleCalculations.calculateCO2(publictransport,goodfuel,goodavgconsumption));
        return reducedCO2;
    }


//    /**
//     * Creates the /transport endpoint which accepts vehicle
//     * as an argument and returns suggested alternative transportation method.
//     */
//    @RequestMapping(method = RequestMethod.GET, value = "/transport")
//    public Transportation transportation(@RequestParam(value = "vehicle",
//            defaultValue = "Unknown") String vehicleType) {
//        Transportation trans = new Transportation(counter.incrementAndGet(), vehicleType);
//        VehicleEntry entry = new VehicleEntry(counter.get(), vehicleType);
//
//        Database.instance.saveNonBlocking(entry);
//
//        return trans;
//    }
}
