package groupxii.client.leaderboard;

import groupxii.client.connector.LeaderBoardConnector;
import groupxii.client.connector.VegetarianMealConnector;

import java.util.Arrays;
import java.util.List;

public class LeaderboardList {

    private List<String> leaderboardList;

    /**
     * Asks the connector to retrieve the meal list and parses it
     */
    public LeaderboardList() {
        String json = LeaderBoardConnector.retrieveLeaderboard();
        this.parseJson(json);
    }
}
