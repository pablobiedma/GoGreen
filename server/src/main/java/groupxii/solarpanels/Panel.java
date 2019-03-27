package groupxii.solarpanels;

public class Panel {

    private String panelname;
    private int co2;
    private int efficiencyrate;
    private int amount;

    /**
     * This is a Solar panel.
     * @param panelname the paneltype
     * @param co2 the amount of co2 reduced by the panel
     * @param efficiencyrate the rate of energy which is converted into
     *                       electricity(has to be in %)
     * @param amount the amount of panels of this paneltype
     */
    public Panel(String panelname, int co2, int efficiencyrate, int amount) {
        this.panelname = panelname;
        this.co2 = co2;
        this.efficiencyrate = efficiencyrate;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
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

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
