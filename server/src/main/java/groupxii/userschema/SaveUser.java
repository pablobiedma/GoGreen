package groupxii.userschema;

import groupxii.database.Database;
import groupxii.database.UserEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveUser {

    private UserEntry userEntry;
    private List<User> userList = new ArrayList<User>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserEntry getUserEntry() {
        return userEntry;
    }

    /** This method saves an User as an entry in the database.
     */
    public void saveUser(long userId,String username,int points,int badge,
                         int reducedCo2,List<Integer> friendsId) throws IOException {
        UserEntry userEntry = new UserEntry(userId,username,points,badge,reducedCo2,friendsId);
        Database.instance.saveNonBlocking(userEntry);
        this.userEntry = userEntry;
    }
}
