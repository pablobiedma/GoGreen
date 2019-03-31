package groupxii.server.controllers;

import com.mongodb.DBObject;
import groupxii.database.Database;
import groupxii.database.UserEntry;
import groupxii.userschema.SaveUser;
import groupxii.userschema.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private List<User> userList = new ArrayList<>();
    private SaveUser saveUser = new SaveUser();
    private  int counter = 1;

    /** Receives data and creates a user entry in the user collection.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/saveUserData")
    public UserEntry saveUserData(@RequestParam(value = "username",
            defaultValue = "Unknown") String username,
                                  @RequestParam(value = "points",
                                          defaultValue = "Unknown") int points,
                                  @RequestParam(value = "badge",
                                          defaultValue = "Unknown") int badge,
                                  @RequestParam(value = "reducedCo2",
                                          defaultValue = "Unknown")
                                          int reducedCo2,
                                  @RequestParam(value = "friendsId",
                                          defaultValue = "Unknown")
                                          List<Integer> friendsId) throws IOException {
        saveUser.setUserList(this.userList);
        saveUser.saveUser(counter++, username, points,
                badge, reducedCo2, friendsId);
        return saveUser.getUserEntry();
    }

    /** Receives user's id and returns the list
     of his/her friends.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getFriends")
    public List<String> getFriends(@RequestParam(value = "Id",
            defaultValue = "Unknown") int userId) throws IOException {
            DBObject user =  Database.instance.findDocumentById(userId);
            List<Integer> list = (ArrayList<Integer>) user.get("friendsId");
            List<String> friends = new ArrayList<>();
            for (int i = 0; i < list.size();i++) {
                DBObject friend =  Database.instance.findDocumentById(list.get(i));
                String name = (String) friend.get("username");
                friends.add(name);
            }
            return friends;

    }

    /** returns all users sorted by points.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/Leaderboard")
    public List<DBObject> leaderboard() {
            List<DBObject> users = Database.instance.sortUsersByPoints();
            return users;
    }

    /** receives two id's and adds the second one as a friend to the first one.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addFriend")
    public void addFriend(@RequestParam(value = "Id", defaultValue = "Unknown") int userId,
                              @RequestParam(value = "newFriend" ,
                                      defaultValue = "Unknown") int friendsId) {
        Database.instance.addFriendId(friendsId,userId);
    }
}


