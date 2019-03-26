package groupxii.solarpanels;


import groupxii.database.PanelEntry;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SavePanelTest {

  @Test
    public void setPanelList() {
      SavePanel pl1 = new SavePanel();
      SavePanel pl2 = new SavePanel();
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
      SavePanel pl1 = new SavePanel();
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
    public void savePanelData() throws IOException {
      PanelEntry p1 = new PanelEntry(1,"Polycrystalline",32,23,44);
      SavePanel savePanel = new SavePanel();
      savePanel.savePanelData(3,"Monocrystalline",35,29,50);
      assertNotEquals(savePanel.getPanelEntry(),p1);
  }
}
