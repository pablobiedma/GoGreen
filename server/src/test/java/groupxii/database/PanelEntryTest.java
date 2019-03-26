package groupxii.database;



import org.junit.Test;

import static org.junit.Assert.*;


public class PanelEntryTest {

    @Test
    public void getUserid() {
        PanelEntry p = new PanelEntry(1,"Monocrystalline",  39, 27, 40);
        assertEquals(1,p.getUserid());
    }
    @Test
    public void getPanelname() {
        PanelEntry p = new PanelEntry(1,"Monocrystalline",  39, 27, 40);
        assertEquals("Monocrystalline",p.getPaneltype());
    }

    @Test
    public void getReducedco2() {
        PanelEntry p = new PanelEntry(1,"Monocrystalline",  39, 27, 40);
        assertEquals(39,p.getReducedco2());
    }

    @Test
    public void getEfficiencyrate() {
        PanelEntry p = new PanelEntry(1,"Monocrystalline",  39, 27, 40);
        assertEquals(27,p.getEfficiencyrate());
    }

    @Test
    public void getAmount() {
        PanelEntry p = new PanelEntry(1,"Monocrystalline",  39, 27, 40);
        assertEquals(40,p.getAmount());
    }

    @Test
    public void setUserid() {
        PanelEntry p = new PanelEntry(1,"Monocrystalline",  39, 27, 40);
        PanelEntry p2 = new PanelEntry(3,"Monocrystalline",  39, 27, 40);
        p2.setUserid(1);
        assertEquals(p.getUserid(),p2.getUserid());
    }
    @Test
    public void setPanelname() {
        PanelEntry p = new PanelEntry(1,"Monocrystalline",  39, 27, 40);
        PanelEntry p2 = new PanelEntry(1,"Thin-Film",  39, 27, 40);
        p2.setPaneltype("Monocrystalline");
        assertEquals(p.getPaneltype(),p2.getPaneltype());
    }

    @Test
    public void setCo2() {
        PanelEntry p = new PanelEntry(1,"Monocrystalline",  39, 27, 40);
        PanelEntry p2 = new PanelEntry(1,"Monocrystalline",  50, 27, 40);
        p2.setReducedco2(39);
        assertEquals(p.getReducedco2(),p2.getReducedco2());
    }

    @Test
    public void setEfficiencyrate() {
        PanelEntry p = new PanelEntry(1,"Monocrystalline",  39, 27, 40);
        PanelEntry p2 = new PanelEntry(1,"Monocrystalline",  39, 30, 40);
        p2.setEfficiencyrate(27);
        assertEquals(p.getEfficiencyrate(),p2.getEfficiencyrate());
    }

    @Test
    public void setAmount() {
        PanelEntry p = new PanelEntry(1,"Monocrystalline",  39, 27, 40);
        PanelEntry p2 = new PanelEntry(1,"Monocrystalline",  39, 27, 41);
        p2.setAmount(40);
        assertEquals(p.getAmount(),p2.getAmount());
    }
}
