package groupxii.server;

import com.mongodb.DBObject;
import groupxii.database.Database;
import groupxii.database.UserEntry;
import groupxii.userschema.GetUserData;
import groupxii.userschema.SaveUser;
import groupxii.userschema.User;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {

    private GetUserData userData = new GetUserData();
    private List<User> userList = new ArrayList<>();
    private SaveUser saveUser = new SaveUser();
    private final AtomicLong counter = new AtomicLong();
    private UserEntry userEntry;

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
        saveUser.saveUser(counter.incrementAndGet(), username, points,
                badge, reducedCo2, friendsId);
        return saveUser.getUserEntry();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getFriends")
    public List<DBObject> getFriends(@RequestParam(value = "Id",
            defaultValue = "Unknown") long userId) throws IOException {
            DBObject a =  Database.instance.findDocumentById(userId);
            List<Integer> list = (ArrayList<Integer>) a.get("friendsId");
            List<DBObject> friends = new ArrayList<>();
            for(int i = 0; i < list.size();i++) {
                DBObject b = Database.instance.findDocumentById(list.get(i));
                friends.add(b);
            }
            return friends;
    }
}


