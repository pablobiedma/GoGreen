package groupxii.userschema;


public class User {

    private String username;
    private int points;
    private int badge;
    private int reducedCo2;

    /** Constructor for the User class.
     */
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
