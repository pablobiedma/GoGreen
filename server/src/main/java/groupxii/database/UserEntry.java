package groupxii.database;

import com.mongodb.DBObject;

import java.util.List;

public class UserEntry extends Entry {

    private int userId;
    private String username;
    private String password;
    private int points;
    private int badge;
    private int reducedCo2;
    private List<Integer> friendsId ;
    private List<MealEntry> eatenMeals ;

    /** Constructor for the UserEntry class.
     */
    public UserEntry(int userId, String username,String password,
                     int points,int badge, int reducedCo2,List<Integer> friendsId, List<MealEntry> eatenMeals) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.points = points;
        this.badge = badge;
        this.reducedCo2 = reducedCo2;
        this.friendsId = friendsId;
        this.eatenMeals = eatenMeals;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
    }

    public int getBadge() {
        return badge;
    }

    public int getReducedCo2() {
        return reducedCo2;
    }

    public List<Integer> getFriendsId() {
        return this.friendsId;
    }
    
    public List<MealEntry> getEatenMeals() {
        return this.eatenMeals;
    }

    /**
     * Translates into a MongoDB JSON object.
     */
    public final DBObject toDbObject() {
        return super.toBasicDbObject()
                .append("userId", this.userId)
                .append("username", this.username)
                .append("password",this.password)
                .append("points", this.points)
                .append("badge", this.badge)
                .append("reducedCo2", this.reducedCo2)
                .append("friendsId",this.friendsId)
                .append("eatenMeals",this.eatenMeals);
    }
}

