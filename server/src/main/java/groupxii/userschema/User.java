package groupxii.userschema;

import java.util.List;

public class User {

    private String username;
    private int points;
//    private List<User> friendList;
    private int badge;
//    private List<Achievements> achievements;
    private int reducedCo2;

    public User( String username, int points,
                int badge, int reducedCo2) {
        this.username = username;
        this.points = points;
        this.badge = badge;
        this.reducedCo2 = reducedCo2;
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
}
