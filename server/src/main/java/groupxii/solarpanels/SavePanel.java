package groupxii.solarpanels;

import groupxii.database.Database;
import groupxii.database.PanelEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavePanel {

    private PanelEntry panelEntry;
    private List<Panel> panelList = new ArrayList<Panel>();

    public void setPanelList(List<Panel> panelList) {
        this.panelList = panelList;
    }
    public List<Panel> getPanelList() {
        return panelList;
    }
    public PanelEntry getPanelEntry() {
        return panelEntry;
    }

    /**
     * Save the existing solarPanel data
     */
    public void savePanelData(long userid, String paneltype, int efficiencyrate, int reducedco2 , int amount) throws IOException {
        PanelEntry entry = new PanelEntry(userid,paneltype, efficiencyrate, reducedco2, amount);
        Database.instance.saveNonBlocking(entry);
        this.panelEntry = entry;
    }
}
