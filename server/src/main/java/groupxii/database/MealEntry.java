package groupxii.database;

import com.mongodb.DBObject;

public class MealEntry extends Entry {

    /**
     * Represents entries in the database which tracks
     * which meal each request indicates.
     */
    private long userId;
    private String goodFoodName;
    private String badFoodName;
    private int goodServingSize;
    private int badServingSize;
    private int reducedCo2;

    /**
     * Constructor of MealEntry.
     */
    public MealEntry(long userId, String goodFoodName, String badFoodName,
                     int goodServingSize, int badServingSize, int reducedCo2) {
        this.badFoodName = badFoodName;
        this.badServingSize = badServingSize;
        this.goodFoodName = goodFoodName;
        this.goodServingSize = goodServingSize;
        this.reducedCo2 = reducedCo2;
        this.userId = userId;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getGoodFoodName() {
        return goodFoodName;
    }

    public String getBadFoodName() {
        return badFoodName;
    }

    public int getGoodServingSize() {
        return goodServingSize;
    }

    public int getBadServingSize() {
        return badServingSize;
    }

    public int getReducedCo2() {
        return reducedCo2;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setGoodFoodName(String goodFoodName) {
        this.goodFoodName = goodFoodName;
    }

    public void setBadFoodName(String badFoodName) {
        this.badFoodName = badFoodName;
    }

    public void setGoodServingSize(int goodServingSize) {
        this.goodServingSize = goodServingSize;
    }

    public void setBadServingSize(int badServingSize) {
        this.badServingSize = badServingSize;
    }

    public void setReducedCo2(int reducedCo2) {
        this.reducedCo2 = reducedCo2;
    }

    /**
     * Translates into a MongoDB JSON object.
     */
    public final DBObject toDbObject() {
        return super.toBasicDbObject()
                .append("userId", this.userId)
                .append("goodFoodName", this.goodFoodName)
                .append("goodServingSize", this.goodServingSize)
                .append("badFoodName", this.badFoodName)
                .append("badServingSize", this.badServingSize)
                .append("reducedCo2", this.reducedCo2);
    }
}
