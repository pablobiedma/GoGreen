package groupxii.transportation;

import java.util.ArrayList;
import java.util.List;

public class VehicleNameList {
    String result = "";
    private List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Human-friendly String representation for vehicle names.
     */
    public String getVehicleNameList() {
        for (int i = 0; i < vehicles.size(); i++) {
            result = result + vehicles.get(i).getVehiclename() + ", ";
        }
        result = result.substring(0, result.length() - 2);
        System.out.println("result: " + result + "\n");
        return result;
    }
}
