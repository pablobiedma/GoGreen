package groupxii.database;

import com.mongodb.DBObject;

public class PanelEntry extends Entry {

    /**
     * Represents entries in the database which tracks
     * which solarpanel each request indicates.
     */
    private long userid;
    private String panelA;
    private String panelB;
    private int highefficiencyrate;
    private int lowefficiencyrate;
    private int reducedco2;

    /**
     * Constructor of PanelEntry
     */
    public PanelEntry(long userid, String panelA, String panelB, int highefficiencyrate,
                      int lowefficiencyrate, int reducedco2) {
        this.userid = userid;
        this.panelA = panelA;
        this.panelB = panelB;
        this.highefficiencyrate = highefficiencyrate;
        this.lowefficiencyrate = lowefficiencyrate;
        this.reducedco2 = reducedco2;
    }
    public long getUserid() {
        return  userid;
    }
    public String getPanelA() {
        return panelA;
    }
    public String getPanelB() {
        return panelB;
    }
    public int getHighefficiencyrate() {
        return  highefficiencyrate;
    }
    public int getLowefficiencyrate() {
        return lowefficiencyrate;
    }
    public int getReducedco2() {
        return reducedco2;
    }
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public void setPanelA(String panelA) {
        this.panelA = panelA;
    }
    public void setPanelB(String panelB) {
        this.panelB = panelB;
    }
    public void setHighefficiencyrate(int highefficiencyrate) {
        this.highefficiencyrate = highefficiencyrate;
    }
    public void setLowefficiencyrate(int lowefficiencyrate) {
        this.lowefficiencyrate = lowefficiencyrate;
    }
    public void setReducedco2(int reducedco2) {
        this.reducedco2 = reducedco2;
    }
    /**
     * Translates into a MongoDB JSON object.
     */
    public final DBObject toDbObject() {
        return super.toBasicDbObject()
                .append("userid", this.userid)
                .append("goodpanelname",this.panelA)
                .append("badpanelname",this.panelB)
                .append("goodefficiencyrate",this.highefficiencyrate)
                .append("badefficiencyrate",this.lowefficiencyrate)
                .append("reducedco2", this.reducedco2);
    }
}
