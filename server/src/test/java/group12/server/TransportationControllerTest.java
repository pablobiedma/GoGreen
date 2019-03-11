package server.group12;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TransportationControllerTest {
    @Test
    public void testTransportationControllerVehicle() {
        TransportationController tc = new TransportationController();
        Transportation trans = tc.transportation("bike");
        assertEquals("Good job!", trans.getVehicleSuggestion());
    }
}