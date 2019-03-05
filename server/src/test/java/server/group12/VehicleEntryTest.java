package server.group12;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class VehicleEntryTest {
    @Test
    public void testVehicleEntryTestUserId() {
        VehicleEntry ve = new VehicleEntry(1, "car");
        assertEquals(1, ve.userId);
    }
    @Test
    public void testVehicleEntryVehicleType() {
        VehicleEntry ve = new VehicleEntry(1, "car");
        assertEquals("car", ve.vehicleType);
    }
}
