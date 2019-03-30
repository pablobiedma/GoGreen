package groupxii.transportation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VehicleTest {

    @Test
    public void getVehiclename() {
        Vehicle vehicle = new Vehicle("car",68,"Petrol",7);
        assertEquals("car",vehicle.getVehiclename());
    }

    @Test
    public void getCo2() {
        Vehicle vehicle = new Vehicle("car",68,"Petrol",7);
        assertEquals(68,vehicle.getCo2());
    }

    @Test
    public void getFuel() {
        Vehicle vehicle = new Vehicle("car",68,"Petrol",7);
        assertEquals("Petrol",vehicle.getFuel());
    }

    @Test
    public void setVehiclename() {
        Vehicle vehicle = new Vehicle("car",68,"Petrol",7);
        Vehicle vehicle2 = new Vehicle("Bike",68,"Petrol",7);
        vehicle2.setVehiclename("car");
        assertEquals(vehicle.getVehiclename(),vehicle2.getVehiclename());
    }

    @Test
    public void setCo2() {
        Vehicle vehicle = new Vehicle("car",68,"Petrol",7);
        Vehicle vehicle2 = new Vehicle("car",74,"Petrol",7);
        vehicle2.setCo2(68);
        assertEquals(vehicle.getCo2(),vehicle2.getCo2());
    }

    @Test
    public void setFuel() {
        Vehicle vehicle = new Vehicle("car",68,"Petrol",7);
        Vehicle vehicle2 = new Vehicle("car",68,"Diesel",7);
        vehicle2.setFuel("Petrol");
        assertEquals(vehicle.getFuel(),vehicle2.getFuel());
    }

    @Test
    public void getAvgconsumption() {
        Vehicle vehicle = new Vehicle("car",68,"Petrol",7);
        assertEquals(7,vehicle.getAvgconsumption());
    }

    @Test
    public void setAvgconsumption() {
        Vehicle vehicle = new Vehicle("car",68,"Petrol",7);
        Vehicle vehicle2 = new Vehicle("car",68,"Petrol",10);
        vehicle2.setAvgconsumption(7);
        assertEquals(vehicle.getAvgconsumption(),vehicle2.getAvgconsumption());
    }
}
