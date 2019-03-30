package groupxii.transportation;


import groupxii.database.VehicleEntry;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SaveVehicleTest {


    @Test
    public void setVehicles() {
        SaveVehicle saveVehicle = new SaveVehicle();
        SaveVehicle saveVehicle1 = new SaveVehicle();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Vehicle> vehicles1 = new ArrayList<>();
        Vehicle vehicle = new Vehicle("bike",0,"none",0);
        Vehicle vehicle2 = new Vehicle("car",68,"Petrol",7);
        vehicles.add(0,vehicle);
        vehicles.add(1,vehicle2);
        vehicles1.add(0,vehicle);
        vehicles1.add(1,vehicle2);
        saveVehicle.setVehicles(vehicles);
        saveVehicle1.setVehicles(vehicles1);
        assertEquals(saveVehicle.getVehicles(),saveVehicle1.getVehicles());
    }

    @Test
    public void getVehicles() {
        SaveVehicle pl1 = new SaveVehicle();
        Vehicle p1 = new Vehicle("car",66,"Petrol",6);
        Vehicle p2 = new Vehicle("bike",0,"none",0);
        Vehicle p3 = new Vehicle("metro",55,"Electric_wires",5);
        List<Vehicle> l = new ArrayList<>();
        l.add(0,p1);
        l.add(1,p2);
        l.add(2,p3);
        pl1.setVehicles(l);
        assertEquals(pl1.getVehicles(),l.subList(0,3));
    }

    @Test
    public void getVehicleEntry() {
        SaveVehicle saveVehicle = new SaveVehicle();
        VehicleEntry vehicleEntry = saveVehicle.getVehicleEntry();
        VehicleEntry vehicleEntry1 = saveVehicle.getVehicleEntry();
        assertEquals(vehicleEntry,vehicleEntry1);
    }

    @Test
    public void saveVehicleData() throws IOException {
        VehicleEntry ve = new VehicleEntry(1, "bike","car",40,"none","Diesel",4,8);
        SaveVehicle saveVehicle = new SaveVehicle();
        saveVehicle.saveVehicleData(3,"metro","car",40,"Electric_wires","Petrol",3,9);
        assertNotEquals(ve,saveVehicle.getVehicleEntry());
    }
}
