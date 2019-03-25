package groupxii.userschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class GetUserData {

    private List<User> userList = new ArrayList<User>();

    public List<User> getUserList() {
        return userList;
    }

    /**
     * Read the data from the meallist.
     */
    public void readUserData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(getClass().getClassLoader().getResource(
                "userList.txt"));

        //iterates over all the elements in the JsonNode and stores the data we need
        Iterator<JsonNode> elements = rootNode.elements();
        while (elements.hasNext()) {
            JsonNode node = elements.next();
            String username = node.get("username").asText();
            int points = node.get("points").asInt();
            int badge = node.get("badge").asInt();
            int reducedCo2 = node.get("reducedCo2").asInt();

            userList.add(new User(username,points,badge,reducedCo2));
            elements.next();
        }
    }
}
