package server.group12;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TransportationControllerTest {
	@Test
	public void testTransportationController() {
		TransportationController controller = new TransportationController();
		Transportation transportation = controller.transportation("car");
		assertEquals("At least use public transport!", transportation.getVehicleSuggestion());
	}
}
