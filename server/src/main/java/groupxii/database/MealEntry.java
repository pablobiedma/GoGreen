package groupxii.database;

import com.mongodb.DBObject;

public class MealEntry extends Entry{

/**
 * Represents entries in the database which tracks
 * which vehicle each request indicates.
 */
    private long userId;
    private String goodFoodName;
    private String badFoodName;
    private int goodCo2;
    private int badCo2;
    private int goodServingSize;
    private int badServingSize;
    private int reducedCo2;


    public void MealEntry(String goodFoodName, String badFoodName, int goodCo2, int badCo2, int goodServingSize, int badServingSize, int reducedCo2){
        this.badCo2 = badCo2;
        this.badFoodName = badFoodName;
        this.badServingSize = badServingSize;
        this.goodCo2 = goodCo2;
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

    public int getGoodCo2() {
        return goodCo2;
    }

    public int getBadCo2() {
        return badCo2;
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

    public void setGoodCo2(int goodCo2) {
        this.goodCo2 = goodCo2;
    }

    public void setBadCo2(int badCo2) {
        this.badCo2 = badCo2;
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
                .append("goodCo2", this.goodCo2)
                .append("goodServingSize", this.goodServingSize)
                .append("badFoodName", this.badFoodName)
                .append("badCo2", this.badCo2)
                .append("badServingSize", this.badServingSize)
                .append("reducedCo2", this.reducedCo2);
    }
}
