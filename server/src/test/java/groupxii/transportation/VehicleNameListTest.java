package groupxii.transportation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VehicleNameListTest {


    @Test
    public void getVehicles() {
        VehicleNameList vehicleNameList = new VehicleNameList();
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle("car",77,"Diesel",9);
        Vehicle vehicle2 = new Vehicle("bike",0,"none",0);
        Vehicle vehicle3 = new Vehicle("metro",55,"Electric_Wires",6);
        vehicles.add(0,vehicle);
        vehicles.add(1,vehicle2);
        vehicles.add(2,vehicle3);
        vehicleNameList.setVehicles(vehicles);
        assertEquals(vehicleNameList.getVehicles(),vehicles.subList(0,3));


    }

    @Test
    public void setVehicles() {
        VehicleNameList vehicleNameList = new VehicleNameList();
        VehicleNameList vehicleNameList2 = new VehicleNameList();
        List<Vehicle> vehicles = new ArrayList<>();
        List<Vehicle> vehicles2 = new ArrayList<>();

        Vehicle vehicle = new Vehicle("car",77,"Diesel",9);
        Vehicle vehicle2 = new Vehicle("bike",0,"none",0);
        Vehicle vehicle3 = new Vehicle("metro",55,"Electric_Wires",6);
        vehicles.add(0,vehicle);
        vehicles.add(1,vehicle2);
        vehicles.add(2,vehicle3);
        vehicles2.add(0,vehicle);
        vehicles2.add(1,vehicle2);
        vehicles2.add(2,vehicle3);
        vehicleNameList.setVehicles(vehicles);
        vehicleNameList2.setVehicles(vehicles2);
        assertEquals(vehicleNameList.getVehicles(),vehicleNameList2.getVehicles());
    }

    @Test
    public void getVehicleNameList() {
        VehicleNameList vehicleNameList = new VehicleNameList();
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle("car",77,"Diesel",9);
        Vehicle vehicle2 = new Vehicle("bike",0,"none",0);
        Vehicle vehicle3 = new Vehicle("metro",55,"Electric_Wires",6);
        vehicles.add(0,vehicle);
        vehicles.add(1,vehicle2);
        vehicles.add(2,vehicle3);
        vehicleNameList.setVehicles(vehicles);
        List<String> name = new ArrayList<>();
        name.add(0,"car");
        name.add(1,"bike");
        name.add(2,"metro");
        assertEquals(name.subList(0,3).toString(),"["+vehicleNameList.getVehicleNameList() + "]");
    }
}
