package groupxii.transportation;

import org.junit.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VehicleCalculationsTest {


    @Test
    public void setVehicles() {
        VehicleCalculations vehicleCalculations = new VehicleCalculations();
        VehicleCalculations vehicleCalculations2 = new VehicleCalculations();
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
        vehicleCalculations.setVehicles(vehicles);
        vehicleCalculations2.setVehicles(vehicles2);
        assertEquals(vehicleCalculations.getVehicles(),vehicleCalculations2.getVehicles());
    }

    @Test
    public void getVehicles() {
        VehicleCalculations vehicleCalculations = new VehicleCalculations();
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle("car",77,"Diesel",9);
        Vehicle vehicle2 = new Vehicle("bike",0,"none",0);
        Vehicle vehicle3 = new Vehicle("metro",55,"Electric_Wires",6);
        vehicles.add(0,vehicle);
        vehicles.add(1,vehicle2);
        vehicles.add(2,vehicle3);
        vehicleCalculations.setVehicles(vehicles);
        assertEquals(vehicleCalculations.getVehicles(),vehicles.subList(0,3));
    }

    @Test
    public void calculateCO2() throws IOException {
        VehicleCalculations vehicleCalculations = new VehicleCalculations();
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle("car",77,"Diesel",9);
        Vehicle vehicle2 = new Vehicle("bike",0,"none",0);
        vehicles.add(0,vehicle);
        vehicles.add(1,vehicle2);
        vehicleCalculations.setVehicles(vehicles);
        assertEquals(72,vehicleCalculations.calculateCO2("car","Diesel",9));
    }

    @Test
    public void reducedCO2() throws IOException {
        VehicleCalculations vehicleCalculations = new VehicleCalculations();
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle("car",77,"Diesel",9);
        Vehicle vehicle2 = new Vehicle("motorbike",45,"Petrol",4);
        vehicles.add(0,vehicle);
        vehicles.add(1,vehicle2);
        vehicleCalculations.setVehicles(vehicles);
        assertEquals(28, vehicleCalculations.reducedCO2("car","Diesel",9,vehicleCalculations.calculateCO2("motorbike","Petrol",4)));
    }

    @Test
    public void calculatePoints() throws IOException {
        VehicleCalculations vehicleCalculations = new VehicleCalculations();
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = new Vehicle("car",77,"Diesel",9);
        Vehicle vehicle2 = new Vehicle("bike",0,"Petrol",4);
        vehicles.add(0,vehicle);
        vehicles.add(1,vehicle2);
        vehicleCalculations.setVehicles(vehicles);
        assertEquals(vehicleCalculations.reducedCO2("car","Diesel",9,vehicleCalculations.calculateCO2("bike","Petrol",4))*5,vehicleCalculations.CalculatePoints());
    }
}
