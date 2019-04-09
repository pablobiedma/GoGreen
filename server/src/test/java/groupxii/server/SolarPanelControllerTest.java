package groupxii.server;

import groupxii.database.Database;
import groupxii.server.controllers.SolarPanelController;
import groupxii.solarpanels.CalculatedPanel;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class SolarPanelControllerTest {

    SolarPanelController solarPanelController;
    @Before
    public void createSPC() {
        try {
            Database.instance.startDb();
        } catch (IOException e) {
            assertTrue(false);
        }
        solarPanelController = new SolarPanelController();
    }

    @Test
    public void calculatePanelTest() {
        CalculatedPanel calculatedPanel = new CalculatedPanel("Monocrystalline", 44);
        CalculatedPanel calculatedPanel2 = solarPanelController.calculatePanel("Monocrystalline", 44);
        assertEquals(calculatedPanel.getReducedCO2(),calculatedPanel2.getReducedCO2());
    }

    @Test
    public void getNameList() {
        List<String> namelist = solarPanelController.getNameList();
        assertFalse(namelist.isEmpty());
    }



}
