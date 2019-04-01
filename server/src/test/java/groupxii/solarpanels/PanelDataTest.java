package groupxii.solarpanels;


import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PanelDataTest {

    @Test
    public void getPanelList() {
        PanelData p = new PanelData();
        List<Panel> l = new ArrayList<>();
        Panel p1 = new Panel("Polycrystalline",32,23,44);
        Panel p2 = new Panel("Monocrystalline",35,29, 50);
        Panel p3 = new Panel("Thin-Film",26,34, 47);
        l.add(0,p1);
        l.add(1,p2);
        l.add(2,p3);
        p.setPanelList(l);
        assertEquals(l.subList(0,3), p.getPanelList());
    }

    @Test
    public void setPanelList() {
        PanelData pd1 = new PanelData();
        PanelData pd2 = new PanelData();
        List<Panel> l1 = new ArrayList<>();
        List<Panel> l2 = new ArrayList<>();
        Panel p1 = new Panel("Polycrystalline",32,23,44);
        Panel p2 = new Panel("Monocrystalline",35,29, 50);
        Panel p3 = new Panel("Thin-Film",26,34, 47);
        l1.add(0,p1);
        l1.add(1,p2);
        l2.add(0,p3);
        pd1.setPanelList(l1);
        pd2.setPanelList(l2);
        pd1.setPanelList(l2);
        assertEquals(pd1.getPanelList(),pd2.getPanelList());
    }

    @Test
    public void readPanelListData() throws IOException {
            PanelData pd = new PanelData();
            pd.readPanelListData();
            assertNotNull(pd.getPanelList());

    }

}
