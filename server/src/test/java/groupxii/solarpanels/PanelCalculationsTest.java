package groupxii.solarpanels;


import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class PanelCalculationsTest {
    @Test
    public void setPanelList() {
        PanelCalculations c1 = new PanelCalculations();
        PanelCalculations c2 = new PanelCalculations();
        List<Panel> l1 = new ArrayList<>();
        List<Panel> l2 = new ArrayList<>();
        Panel p1 = new Panel("Polycrystalline", 32, 23, 44);
        Panel p2 = new Panel("Monocrystalline", 35, 29, 50);
        Panel p3 = new Panel("Thin-Film", 26, 34, 47);
        l1.add(0,p1);
        l1.add(1,p2);
        l2.add(0,p3);
        c1.setPanelList(l1);
        c2.setPanelList(l2);
        c1.setPanelList(l2);
        assertEquals(c1.getPanelList(),c2.getPanelList());
    }

    @Test
    public void getPanelList() {
        PanelCalculations p = new PanelCalculations();
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
    public void calculateCO2() throws IOException {
        PanelCalculations c = new PanelCalculations();
        List<Panel> l = new ArrayList<>();
        Panel p1 = new Panel("Polycrystalline",32,23,44);
        Panel p2 = new Panel("Monocrystalline",35,29, 50);
        l.add(0,p1);
        l.add(1,p2);
        c.setPanelList(l);
        assertEquals(1750,c.calculateCO2("Monocrystalline"));
    }

    @Test
    public void calculatePoints() throws IOException {
        PanelCalculations c = new PanelCalculations();
        List<Panel> l = new ArrayList<>();
        Panel p1 = new Panel("Polycrystalline",32,23,44);
        Panel p2 = new Panel("Monocrystalline",35,29, 50);
        l.add(0,p1);
        l.add(1,p2);
        c.setPanelList(l);
        assertEquals(c.calculateCO2("Monocrystalline") *5,c.calculatePoints());
    }
}
