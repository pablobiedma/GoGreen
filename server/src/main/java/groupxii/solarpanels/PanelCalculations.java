package groupxii.solarpanels;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanelCalculations {
    private int calculatedCO2;
    private String panel;
    private int co2;
    private int efficiencyrate;
    private int reducedCO2;
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
    public int calculateCO2(String chosenPanel, int chosenEfficiencyrate) throws IOException {
        for(int i = 0; i < panelList.size(); i++) {
            if(chosenPanel.equals(panelList.get(i).getPanelname())) {
                this.panel = panelList.get(i).getPanelname();
                this.co2 = panelList.get(i).getCo2();
                this.efficiencyrate = panelList.get(i).getEfficiencyrate();
                double co2factor = co2 / (efficiencyrate/100);
                calculatedCO2 = (int) co2factor * (chosenEfficiencyrate/100);
            }
        }
        return calculatedCO2;
    }

    /**this is the second calculation that is done, people also choose
     * a bad efficiency rate, so the reduced CO2 can be calculated.
     */
    public int reducedCO2(String badpanel, int chosenEfficiencyrate, int goodpanel) throws IOException {
        this.reducedCO2 =  calculateCO2(badpanel,chosenEfficiencyrate) - goodpanel;
        return this.reducedCO2;
    }

    /**
     *     this is the last calculation that is done, the points for the user are calculated.
     */
    public int calculatePoints() {
        return (int) this.reducedCO2 * 5;
    }
}
