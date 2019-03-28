package groupxii.database;


import com.mongodb.DBObject;

public class UserEntry extends Entry {

    private long userId;
    private String username;
    private int points;
    private int badge;
    private int reducedCo2;

    public UserEntry(long userId, String username, int points,int badge, int reducedCo2) {
        this.userId = userId;
        this.username = username;
        this.points = points;
        this.badge = badge;
        this.reducedCo2 = reducedCo2;
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

    /**
     * Translates into a MongoDB JSON object.
     */
    public final DBObject toDbObject() {
        return super.toBasicDbObject()
                .append("userId", this.userId)
                .append("username", this.username)
                .append("points", this.points)
                .append("badge", this.badge)
                .append("reducedCo2", this.reducedCo2);
    }
}

