package groupxii.solarpanels;

public class Panel {

    private String panelname;
    private int co2;
    private int efficiencyrate;

    /**
     * This is a Solar panel
     * @param panelname the paneltype
     * @param co2 the amount of co2 reduced by the panel
     * @param efficiencyrate the rate of energy which is converted into
     *                       electricity(has to be in %)
     */
    public Panel(String panelname, int co2, int efficiencyrate){
        this.panelname = panelname;
        this.co2 = co2;
        this.efficiencyrate = efficiencyrate;
    }

    public String getPanelname() {
        return panelname;
    }

    public int getCo2() {
        return co2;
    }

    public int getEfficiencyrate() {
        return efficiencyrate;
    }

    public void  setPanelname(String panelname) {
        this.panelname = panelname;
    }

    public void  setCo2(int co2) {
        this.co2 = co2;
    }

    public void setEfficiencyrate(int efficiencyrate) {
        this.efficiencyrate = efficiencyrate;
    }
}
