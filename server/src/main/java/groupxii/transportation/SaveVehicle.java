package groupxii.transportation;

import groupxii.database.Database;
import groupxii.database.VehicleEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveVehicle {

    private VehicleEntry vehicleEntry;
    private List<Vehicle> vehicles = new ArrayList<>();

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public VehicleEntry getVehicleEntry() {
        return vehicleEntry;
    }

    /**
     * Save the existing Vehicle data.
     */
    public void saveVehicleData(long userid, String goodvehicletype, String badvehicletype,
                                int co2, String goodfuel, String badfuel,
                                int goodavgconsumption, int badavgconsumption) throws IOException {
        VehicleEntry vehicleEntry = new VehicleEntry(userid,goodvehicletype,
                badvehicletype,co2,goodfuel,badfuel,goodavgconsumption, badavgconsumption);
        Database.instance.saveNonBlocking(vehicleEntry);
        this.vehicleEntry = vehicleEntry;
    }
}
