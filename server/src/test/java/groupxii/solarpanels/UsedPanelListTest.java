package groupxii.solarpanels;


import groupxii.database.PanelEntry;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UsedPanelListTest {

    private UsedPanelList usedPanelList = new UsedPanelList();

    @Test
    public void getUsedPanelList() throws IOException {
        SavePanel savePanel = new SavePanel();
        SavePanel savePanel2 = new SavePanel();
        savePanel.savePanelData(1, "Monocrystalline", 40, 50, 50);
        savePanel2.savePanelData(1, "Monocrystalline", 40, 50, 50);
        assertEquals(savePanel.getPanelList(),savePanel2.getPanelList());
    }

    @Test
    public void readDatabaseTest() throws IOException {
        //SavePanel savePanel2 = new SavePanel();
        usedPanelList.readDatabase();
        //System.out.println(usedPanelList.getUsedPanelList().toString());
        assertTrue(usedPanelList.getUsedPanelList().toString().contains("[]"));
    }


        @Test
        public void toStringTest() {
            assertTrue(usedPanelList.toString("Monocrystalline", 20, 20, 50).contains("You used Monocrystalline with an amount of 50 and with an efficiencyrate of 20%, by doing so you reduced your carbon footprint with 20 grams of CO2"));
        }

}
