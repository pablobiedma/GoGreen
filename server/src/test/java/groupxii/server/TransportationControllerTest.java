package groupxii.server;

import groupxii.database.Database;
import groupxii.server.Transportation;
import groupxii.server.controllers.TransportationController;
import groupxii.transportation.CalculatedVehicle;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;


public class TransportationControllerTest {
	//TODO
	/*

    TransportationController tpc;
    @Before
    public void createVMC() {
        try {
            Database.instance.startDb();
        } catch (IOException e) {
            assertTrue(false);
        }
        tpc = new TransportationController();
    }

    @Test
    public void calculateMealTest() {
        CalculatedVehicle localCalculateVehicle = new CalculatedVehicle("bike", "car", 4, 8);
        CalculatedVehicle remoteCalculateVehicle = tpc.calculateVehicle("bike", 4, "car", 8);
        assertEquals(localCalculateVehicle.getReducedCO2(), remoteCalculateVehicle.getReducedCO2());
    }

    @Test
    public void getNameList() {
        List<String> nameList = tpc.getNameList();
        assertFalse(nameList.isEmpty());
    }
    */

}
