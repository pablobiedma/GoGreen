package groupxii.transportation;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VehicleDataTest {

    @Test
    public void getVehicles() {
        VehicleData vehicleData = new VehicleData();
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle("car",77,"Diesel",9);
        Vehicle vehicle2 = new Vehicle("bike",0,"none",0);
        Vehicle vehicle3 = new Vehicle("metro",55,"Electric_Wires",6);
        vehicles.add(0,vehicle);
        vehicles.add(1,vehicle2);
        vehicles.add(2,vehicle3);
        vehicleData.setVehicles(vehicles);
        assertEquals(vehicleData.getVehicles(),vehicles.subList(0,3));

    }

    @Test
    public void setVehicles() {
        VehicleData vehicleData = new VehicleData();
        VehicleData vehicleData1 = new VehicleData();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Vehicle> vehicles1 = new ArrayList<>();
        Vehicle vehicle = new Vehicle("car",77,"Diesel",9);
        Vehicle vehicle2 = new Vehicle("bike",0,"none",0);
        Vehicle vehicle3 = new Vehicle("metro",55,"Electric_Wires",6);
        vehicles.add(0,vehicle);
        vehicles.add(1,vehicle2);
        vehicles.add(2,vehicle3);
        vehicles1.add(0,vehicle);
        vehicles1.add(1,vehicle2);
        vehicles1.add(2,vehicle3);
        vehicleData.setVehicles(vehicles);
        vehicleData1.setVehicles(vehicles1);
        vehicleData.setVehicles(vehicles1);
        assertEquals(vehicleData.getVehicles(),vehicleData1.getVehicles());

    }

    @Test
    public void readVehicleListData() throws IOException {
        VehicleData vehicleData = new VehicleData();
        vehicleData.readVehicleListData();
        assertNotNull(vehicleData.getVehicles());

    }
}
