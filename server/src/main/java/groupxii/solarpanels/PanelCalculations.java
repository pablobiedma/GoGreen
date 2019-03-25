package groupxii.solarpanels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanelCalculations {
    private int totalco2perpaneltype;
    private String panel;
    private int co2;
    private int efficiencyrate;
    private int amount;
    private List<Panel> panelList = new ArrayList<Panel>();

    public void setPanelList(List<Panel> panelList) {
        this.panelList = panelList;
    }
    public List<Panel> getPanelList() {
        return panelList;
    }

    /**this is the first calculation that is done. the Chosen panel is looked up in the panelList and
     * then the private values are updated and the CO2 emission is calculated.
     */
    public int calculateCO2(String chosenPanel) throws IOException {
        for(int i = 0; i < panelList.size(); i++) {
            if(chosenPanel.equals(panelList.get(i).getPanelname())) {
                this.panel = panelList.get(i).getPanelname();
                this.co2 = panelList.get(i).getCo2();
                this.efficiencyrate = panelList.get(i).getEfficiencyrate();
                this.amount = panelList.get(i).getAmount();
                totalco2perpaneltype = co2 * amount;
            }
        }
        return totalco2perpaneltype;
    }

    /**
     *     this is the last calculation that is done, the points for the user are calculated.
     */
    public int calculatePoints() {
        return (int) this.totalco2perpaneltype * 5;
    }
}
