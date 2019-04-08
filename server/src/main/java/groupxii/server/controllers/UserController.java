package groupxii.server.controllers;

import com.mongodb.DBObject;
import groupxii.database.Database;
import groupxii.database.UserEntry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    /** Receives data and creates a user entry in the user collection.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/saveUserData")
    public void saveUserData(@RequestParam(value = "username",
            defaultValue = "Unknown") String username,
                                  @RequestParam(value = "password",
                                          defaultValue = "Unknown")
                                          String password)  {
            UserEntry userEntry = new UserEntry(Database.instance.getUserCount() + 1,username,password,0,1,0,new ArrayList<>());
            Database.instance.save(userEntry);
    }

    /** Receives user's id and returns the list
     of his/her friends.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getFriends")
    public List<DBObject> getFriends(@RequestParam(value = "Id",
            defaultValue = "-1") int userId) {
            DBObject user =  Database.instance.findUserById(userId);
            List<Integer> list = (ArrayList<Integer>) user.get("friendsId");
            List<DBObject> friends = new ArrayList<>();
            for (int i = 0; i < list.size();i++) {
                DBObject friend =  Database.instance.findUserById(list.get(i));
                friends.add(friend);
            }
            return friends;
    }

    /** returns all users sorted by points.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/Leaderboard")
    public List<DBObject> leaderboard() {
            List<DBObject> users = Database.instance.sortUsersByReducedCo2();
        return users;
    }

    /** receives two id's and adds the second one as a friend to the first one.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/addFriend")
    public void addFriend(Principal principal,
                          @RequestParam(value = "newFriend" ,
                                      defaultValue = "Unknown") int friendsId) {
        String user = principal.getName();
        Database.instance.addFriend(user,friendsId);
    }

    //TODO make internal for features
    /** Increments reducedCO2 with some reducedCo2 dependant on the meal.
     */
//    @RequestMapping(method = RequestMethod.GET, value = "increaseReducedCO2")
//    public DBObject incReducedCO2(@RequestParam(value = "Id",defaultValue = "Unknown") int userId,
//                              @RequestParam(value = "ReducedCO2",
//                                      defaultValue = "Unknown") int reducedCo2) {
//        Database.instance.incrementReducedCo2(userId,reducedCo2);
//        DBObject user = Database.instance.findDocumentById(userId);
//        return user;
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/getReducedCo2OfUser")
    public String getReducedCo2OfUser(@RequestParam(value = "Id", defaultValue = "-1") int userId) {
        DBObject dbObject = Database.instance.findUserById(userId);
        String reducedCo2 = dbObject.get("reducedCo2").toString();
        return reducedCo2;
    }
}


