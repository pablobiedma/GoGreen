package groupxii.database;

import com.mongodb.DBObject;

public class PanelEntry extends Entry {

    /**
     * Represents entries in the database which tracks
     * which solarpanel each request indicates.
     */
    private long userid;
    private String goodpanelname;
    private String badpanelname;
    private int goodefficiencyrate;
    private int badefficiencyrate;
    private int reducedco2;

    /**
     * Constructor of PanelEntry
     */
    public PanelEntry(long userid, String goodpanelname, String badpanelname, int goodefficiencyrate,
                      int badefficiencyrate, int reducedco2) {
        this.userid = userid;
        this.goodpanelname = goodpanelname;
        this.badpanelname = badpanelname;
        this.goodefficiencyrate = goodefficiencyrate;
        this.badefficiencyrate = badefficiencyrate;
        this.reducedco2 = reducedco2;
    }
    public long getUserid() {
        return  userid;
    }
    public String getGoodpanelname() {
        return goodpanelname;
    }
    public String getBadpanelname() { return badpanelname;}
    public int getGoodefficiencyrate() {
        return  goodefficiencyrate;
    }
    public int getBadefficiencyrate() {
        return badefficiencyrate;
    }
    public int getReducedco2() {
        return reducedco2;
    }
    public void setUserid(long userid) {
        this.userid = userid;
    }
    public void setGoodPanelname(String goodpanelname) {
        this.goodpanelname = goodpanelname;
    }
    public void setBadpanelname(String badpanelname) { this.badpanelname = badpanelname;}
    public void setGoodefficiencyrate(int goodefficiencyrate) {
        this.goodefficiencyrate = goodefficiencyrate;
    }
    public void setBadefficiencyrate(int badefficiencyrate) {
        this.badefficiencyrate = badefficiencyrate;
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
                .append("goodpanelname",this.goodpanelname)
                .append("badpanelname",this.badpanelname)
                .append("goodefficiencyrate",this.goodefficiencyrate)
                .append("badefficiencyrate",this.badefficiencyrate)
                .append("reducedco2", this.reducedco2);
    }
}
