package groupxii.solarpanels;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PanelNameListTest {
    @Test
    public void setPanelList() {
        PanelNameList pl1 = new PanelNameList();
        PanelNameList pl2 = new PanelNameList();
        List<Panel> l1 = new ArrayList<>();
        List<Panel> l2 = new ArrayList<>();
        Panel p1 = new Panel("Polycrystalline",32,23,44);
        Panel p2 = new Panel("Monocrystalline",35,29, 50);
        //Panel p3 = new Panel("Thin-Film",26,34, 47);
        l1.add(0,p1);
        l1.add(1,p2);
        l2.add(0,p1);
        l2.add(1,p2);
        pl1.setPanelList(l1);
        pl2.setPanelList(l2);
        assertEquals(pl2.getPanelList(),pl1.getPanelList());
    }
    @Test
    public void getPanelList() {
        PanelNameList pl1 = new PanelNameList();
        Panel p1 = new Panel("Polycrystalline",32,23,44);
        Panel p2 = new Panel("Monocrystalline",35,29, 50);
        Panel p3 = new Panel("Thin-Film",26,34, 47);
        List<Panel> l = new ArrayList<>();
        l.add(0,p1);
        l.add(1,p2);
        l.add(2,p3);
        pl1.setPanelList(l);
        assertEquals(pl1.getPanelList(),l.subList(0,3));
    }
    @Test
    public void getPanelNameList() {
        PanelNameList pl1 = new PanelNameList();
        List<Panel> l = new ArrayList<>();
        Panel p1 = new Panel("Polycrystalline",32,23,44);
        Panel p2 = new Panel("Monocrystalline",35,29, 50);
        Panel p3 = new Panel("Thin-Film",26,34, 47);
        l.add(0, p1);
        l.add(1, p2);
        l.add(2, p3);
        pl1.setPanelList(l);
        List<String> name = new ArrayList<>();
        name.add(0, "Polycrystalline");
        name.add(1, "Monocrystalline");
        name.add(2, "Thin-Film");
        assertEquals(name.subList(0,3).toString(), "[" + pl1.getPanelNameList() + "]");
    }
}
