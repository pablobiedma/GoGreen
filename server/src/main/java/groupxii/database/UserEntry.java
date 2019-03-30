package groupxii.database;

import com.mongodb.DBObject;

import java.util.List;

public class UserEntry extends Entry {

    private long userId;
    private String username;
    private int points;
    private int badge;
    private int reducedCo2;
    private List<Integer> friendsId ;

    /** Constructor for the UserEntry class.
     */
    public UserEntry(long userId, String username,
                     int points,int badge, int reducedCo2,List<Integer> friendsId) {
        this.userId = userId;
        this.username = username;
        this.points = points;
        this.badge = badge;
        this.reducedCo2 = reducedCo2;
        this.friendsId = friendsId;
    }

    public long getUserId() {
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

    /**
     * Translates into a MongoDB JSON object.
     */
    public final DBObject toDbObject() {
        return super.toBasicDbObject()
                .append("userId", this.userId)
                .append("username", this.username)
                .append("points", this.points)
                .append("badge", this.badge)
                .append("reducedCo2", this.reducedCo2)
                .append("friendsId",this.friendsId);
    }
}

