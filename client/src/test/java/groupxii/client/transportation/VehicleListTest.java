package groupxii.client.transportation;

import groupxii.client.connector.TransportConnector;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TransportConnector.class})

public class VehicleListTest {

    @Test
    public void getVehicleListTest() {
		PowerMockito.mockStatic(TransportConnector.class);
		PowerMockito.when(
						TransportConnector.retrieveTransportList())
					.thenReturn("[\"CAR\", \"BIKE\"]");

		VehicleNameList vl = new VehicleNameList();

		List<String> expected = new ArrayList<String>();
		expected.add("CAR");
		expected.add("BIKE");

		assertEquals(expected, vl.getVehicleNameList());
    }
}
