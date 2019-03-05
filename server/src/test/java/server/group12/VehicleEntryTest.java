package server.group12;

import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleEntryTest {

    @Test
    public void testConstructorId() {
        VehicleEntry car = new VehicleEntry(12,"car");
        assertEquals(12,car.userId);
    }
    @Test
    public void testConstructorVehicleType() {
        VehicleEntry car = new VehicleEntry(12,"car");
        assertEquals("car",car.vehicleType);
    }
}