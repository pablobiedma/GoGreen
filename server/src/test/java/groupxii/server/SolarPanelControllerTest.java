package groupxii.server;

import groupxii.database.PanelEntry;
import groupxii.server.controllers.SolarPanelController;
import groupxii.solarpanels.Panel;
import groupxii.solarpanels.UsedPanelList;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolarPanelControllerTest {

    SolarPanelController solarPanelController = new SolarPanelController();
    private List<String> usedPanelList;

    @Test
    public void setPanelData() throws IOException {
        solarPanelController.setPanelData();
        assertNotNull(solarPanelController.getPanelData());
    }
    @Test
    public void getPanelData() {
        solarPanelController.getPanelData();
        assertNotNull(solarPanelController.getPanelData());
    }
    @Test
    public void getNameList() throws IOException {
        solarPanelController.setPanelData();
        String nameList = solarPanelController.getNameList();
        assertTrue(nameList.contains("Monocrystalline"));
    }
    @Test
    public void savePanelData() throws IOException {
        solarPanelController.setPanelData();
        solarPanelController.savePanelData("Monocrystalline",  39,  40);
        PanelEntry p = solarPanelController.getPanelEntry();
        assertEquals(p.getEfficiencyrate(),39);
        assertEquals(p.getPaneltype(),"Monocrystalline");
        assertEquals(p.getAmount(),40);
    }
    @Test
    public void getReducedCO2() throws IOException {
        Panel p = new Panel("Monocrystalline",35,29, 50);
        List<Panel> panelList = new ArrayList<>();
        panelList.add(0,p);
        solarPanelController.setPanelData();
        assertEquals(solarPanelController.getReducedCO2("Monocrystalline"),1560);
    }
    @Test
    public void getPanelEntry() {
        PanelEntry p = solarPanelController.getPanelEntry();
        PanelEntry p2 = solarPanelController.getPanelEntry();
        assertEquals(p,p2);
    }
    @Test
    public void getUsedPanelList() throws IOException {
        UsedPanelList usedPanelListclass = new UsedPanelList();
        usedPanelListclass.readDatabase();
        String jsonReturn = "[";
        usedPanelList = usedPanelListclass.getUsedPanelList();
        for (int i = 0; i < usedPanelList.size(); i++ ) {
            jsonReturn += usedPanelList.get(i) + " - ";
        }
        jsonReturn+="]";
        assertEquals(jsonReturn,usedPanelListclass.getUsedPanelList().toString());
    }
}
