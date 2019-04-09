package groupxii.client.leaderboard;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonConverter {

    public String leaderboardToString(String jsonList) {
        List<String> jsonStringList = Arrays.asList(jsonList.split(","));
        List<DBObject> dbObjectList = new ArrayList<>();
        for (int j = 0; j < jsonStringList.size(); j++){
            dbObjectList.add((DBObject) JSON.parse(jsonStringList.get(j)));
        }
        String result = "";
        for (int i = 0; i < dbObjectList.size(); i++) {
            result  = result + dbObjectList.get(i).get("username").toString()
                    + " - " + dbObjectList.get(i).get("reducedCo2") + " CO2 Reduction, " + dbObjectList.get(i).get("userId") + ", ";
        }
        return result;
    }
}
