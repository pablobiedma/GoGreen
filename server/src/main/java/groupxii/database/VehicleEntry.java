package groupxii.database;

import com.mongodb.DBObject;

/**
 * Represents entries in the database which tracks 
 * which vehicle each request indicates.
 */
public class VehicleEntry extends Entry {
    private long userId;
    private String goodvehicleType;
    private String badvehicleType;
    private int co2;
    private String goodfuel;
    private String badfuel;
    private int goodavgconsumption;
    private int badavgconsumption;

    /**
     * Creates VehicleEntry with a userid, vehicle type, co2 emission and type of fuel.
     */
    public VehicleEntry(long userId, String goodvehicleType, String badvehicletype,
                        int co2, String goodfuel, String badfuel, int goodavgconsumption,
                        int badavgconsumption) {
        super();
        this.userId = userId;
        this.goodvehicleType = goodvehicleType;
        this.badvehicleType = badvehicletype;
        this.co2 = co2;
        this.goodfuel = goodfuel;
        this.badfuel = badfuel;
        this.goodavgconsumption = goodavgconsumption;
        this.badavgconsumption = badavgconsumption;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getGoodVehicleType() {
        return goodvehicleType;
    }

    public void setGoodVehicleType(String goodvehicleType) {
        this.goodvehicleType = goodvehicleType;
    }

    public String getBadvehicleType() {
        return badvehicleType;
    }

    public void setBadvehicleType(String badvehicleType) {
        this.badvehicleType = badvehicleType;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public String getGoodFuel() {
        return goodfuel;
    }

    public void setGoodFuel(String goodfuel) {
        this.goodfuel = goodfuel;
    }

    public String getBadfuel() {
        return badfuel;
    }

    public void setBadfuel(String badfuel) {
        this.badfuel = badfuel;
    }

    public int getGoodAvgconsumption() {
        return goodavgconsumption;
    }

    public void setGoodAvgconsumption(int goodavgconsumption) {
        this.goodavgconsumption = goodavgconsumption;
    }

    public int getBadavgconsumption() {
        return badavgconsumption;
    }

    public void setBadavgconsumption(int badavgconsumption) {
        this.badavgconsumption = badavgconsumption;
    }

    /**
     * Translates into a MongoDB JSON object.
     */
    public final DBObject toDbObject() {
        return super.toBasicDbObject()
                .append("userId", this.userId)
                .append("goodvehicleType", this.goodvehicleType)
                .append("badvehicleType", this.badvehicleType)
                .append("co2", this.co2)
                .append("goodfuel", this.goodfuel)
                .append("badfuel", this.badfuel)
                .append("goodavgconsumption",this.goodavgconsumption)
                .append("badavgconsumption",this.badavgconsumption);
    }
}
