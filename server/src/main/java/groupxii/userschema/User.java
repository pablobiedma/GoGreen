package groupxii.userschema;

import java.util.List;

public class User {

    private int id;
    private String username;
    private int points;
    private List<User> friendList;
    private int badge;
    private List<Achievements> achievements;
    private int reducedCo2;

    public User(int id, String username, int points, List<User> friendList,
                int badge, List<Achievements> achievements, int reducedCo2) {
        this.id = id;
        this.username = username;
        this.points = points;
        this.friendList = friendList;
        this.badge = badge;
        this.achievements = achievements;
        this.reducedCo2 = reducedCo2;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public int getBadge() {
        return badge;
    }

    public List<Achievements> getAchievements() {
        return achievements;
    }

    public int getReducedCo2() {
        return reducedCo2;
    }
}
