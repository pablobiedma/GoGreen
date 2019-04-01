package groupxii.solarpanels;



import org.junit.Test;

import static org.junit.Assert.*;


public class PanelTest {
    @Test
    public void getPanelname() {
        Panel p = new Panel("Monocrystalline",  39, 27, 40);
        assertEquals("Monocrystalline",p.getPanelname());
    }

    @Test
    public void getCo2() {
        Panel p = new Panel("Monocrystalline",  39, 27, 40);
        assertEquals(39,p.getCo2());
    }

    @Test
    public void getEfficiencyrate() {
        Panel p = new Panel("Monocrystalline",  39, 27, 40);
        assertEquals(27,p.getEfficiencyrate());
    }

    @Test
    public void getAmount() {
        Panel p = new Panel("Monocrystalline",  39, 27, 40);
        assertEquals(40,p.getAmount());
    }

    @Test
    public void setPanelname() {
        Panel p = new Panel("Monocrystalline",  39, 27, 40);
        Panel p2 = new Panel("Thin-Film",  39, 27, 40);
        p2.setPanelname("Monocrystalline");
        assertEquals(p.getPanelname(),p2.getPanelname());
    }

    @Test
    public void setCo2() {
        Panel p = new Panel("Monocrystalline",  39, 27, 40);
        Panel p2 = new Panel("Monocrystalline",  50, 27, 40);
        p2.setCo2(39);
        assertEquals(p.getCo2(),p2.getCo2());
    }

    @Test
    public void setEfficiencyrate() {
        Panel p = new Panel("Monocrystalline",  39, 27, 40);
        Panel p2 = new Panel("Monocrystalline",  39, 30, 40);
        p2.setEfficiencyrate(27);
        assertEquals(p.getEfficiencyrate(),p2.getEfficiencyrate());
    }

    @Test
    public void setAmount() {
        Panel p = new Panel("Monocrystalline",  39, 27, 40);
        Panel p2 = new Panel("Monocrystalline",  39, 27, 41);
        p2.setAmount(40);
        assertEquals(p.getAmount(),p2.getAmount());
    }

}
