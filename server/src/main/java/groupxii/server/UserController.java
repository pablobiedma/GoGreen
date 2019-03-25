package groupxii.server;

import groupxii.database.UserEntry;
import groupxii.userschema.GetUserData;
import groupxii.userschema.SaveUser;
import groupxii.userschema.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class UserController {

    private GetUserData userData = new GetUserData();
    private List<User> userList= new ArrayList<>();
    private SaveUser saveUser = new SaveUser();
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, value = "/saveUserData")
    public UserEntry saveUserData(@RequestParam(value = "username",
            defaultValue = "Unknown") String username,
                                  @RequestParam(value = "points",
                                          defaultValue = "Unknown") int points,
                                  @RequestParam(value = "badge",
                                          defaultValue = "Unknown") int badge,
                                  @RequestParam(value = "reducedCo2",
                                          defaultValue = "Unknown")
                                          int reducedCo2) throws IOException {
        saveUser.setUserList(this.userList);
        saveUser.saveUser(counter.incrementAndGet(), username,points,
                badge, reducedCo2);
        return saveUser.getUserEntry();
    }
}
