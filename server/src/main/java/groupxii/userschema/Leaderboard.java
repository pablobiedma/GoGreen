package groupxii.userschema;

import com.sun.tools.javac.util.List;

public class Leaderboard {

    private String type;
    private List<User> competitors;

    public Leaderboard(String type,List<User> competitors) {
        this.type = type;
        this.competitors = competitors;
    }

    public String getType() {
        return this.type;
    }

    public List<User> getCompetitors() {
        return this.competitors = competitors;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCompetitors(List<User> competitors) {
        this.competitors = competitors;
    }
}
