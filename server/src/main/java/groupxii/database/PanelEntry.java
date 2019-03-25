package groupxii.database;

import com.mongodb.DBObject;

public class PanelEntry extends Entry {

    /**
     * Represents entries in the database which tracks
     * which solarpanel each request indicates.
     */
    private long userid;
    private String paneltype;
    private int efficiencyrate;
    private int reducedco2;
    private int amount;

    /**
     * Constructor of PanelEntry
     */
    public PanelEntry(long userid, String paneltype, int efficiencyrate, int reducedco2, int amount) {
        this.userid = userid;
        this.paneltype = paneltype;
        this.efficiencyrate = efficiencyrate;
        this.reducedco2 = reducedco2;
        this.amount = amount;
    }
    public long getUserid() {
        return  userid;
    }
    public String getPaneltype() {
        return paneltype;
    }
    public int getEfficiencyrate() {
        return  efficiencyrate;
    }
    public int getReducedco2() {
        return reducedco2;
    }
    public int getAmount() {
        return amount;
    }
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public void setPaneltype(String paneltype) {
        this.paneltype = paneltype;
    }
    public void setEfficiencyrate(int efficiencyrate) {
        this.efficiencyrate = efficiencyrate;
    }
    public void setReducedco2(int reducedco2) {
        this.reducedco2 = reducedco2;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    /**
     * Translates into a MongoDB JSON object.
     */
    public final DBObject toDbObject() {
        return super.toBasicDbObject()
                .append("userid", this.userid)
                .append("paneltype",this.paneltype)
                .append("efficiencyrate",this.efficiencyrate)
                .append("reducedco2", this.reducedco2)
                .append("amount",this.amount);

    }
}
