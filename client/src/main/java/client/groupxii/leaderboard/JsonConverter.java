package client.groupxii.leaderboard;

import com.mongodb.DBObject;

import java.util.List;

public class JsonConverter {

    public String leaderboardToString(List<DBObject> jsonList) {
        String result = "";
        for (int i = 0; i < jsonList.size(); i++) {
            result  = result + jsonList.get(i).get("username").toString()
                    + " - " + jsonList.get(i).get("reducedCo2") + " CO2 Reduction, " + jsonList.get(i).get("userId") + ", ";
        }
        return result;
    }
}
