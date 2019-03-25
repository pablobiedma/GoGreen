package groupxii.userschema;

import java.util.List;

public class Leaderboard {

    private List<User> competitors;

    public Leaderboard(List<User> competitors) {
        this.competitors = competitors;
    }

    public List<User> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<User> competitors) {
        this.competitors = competitors;
    }
}
