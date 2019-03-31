package groupxii.userschema;

import com.mongodb.DBObject;

import java.util.List;

public class JsonConverter {

    public String LeaderboardToString(List<DBObject> jsonList) {
        String result = "";
        for (int i = 0; i < jsonList.size(); i++){
            result  = result + jsonList.get(i).get("username").toString() + " - " + jsonList.get(i).get("reducedCo2") + ", ";
        }
        return result;
    }
}
