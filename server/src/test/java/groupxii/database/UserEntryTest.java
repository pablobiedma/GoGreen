package groupxii.database;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserEntryTest {

    @Test
    public void getUserId() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals(usr.getUserId(),1);
    }

    @Test
    public void getUsername() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals(usr.getUsername(),"Ivan");
    }

    @Test
    public void getPoints() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals(usr.getPoints(),100);
    }

    @Test
    public void getBadge() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals(usr.getBadge(),1);
    }

    @Test
    public void getReducedCo2() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals(usr.getReducedCo2(),9);
    }

    @Test
    public void getFriendsId() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals(usr.getFriendsId(),list);
    }

    //not sure how to test that
//    @Test
//    public void toDbObject() {
//
//    }
}