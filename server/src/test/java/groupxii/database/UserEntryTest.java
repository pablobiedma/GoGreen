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
        assertEquals(1,usr.getUserId());
    }

    @Test
    public void getUsername() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals("Ivan",usr.getUsername());
    }

    @Test
    public void getPoints() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals(100,usr.getPoints());
    }

    @Test
    public void getBadge() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals(1,usr.getBadge());
    }

    @Test
    public void getReducedCo2() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals(9,usr.getReducedCo2());
    }

    @Test
    public void getFriendsId() {
        List<Integer> list = new ArrayList<>();
        UserEntry usr = new UserEntry(1,"Ivan",100,1,9,list);
        assertEquals(list,usr.getFriendsId());
    }

    //not sure how to test that
//    @Test
//    public void toDbObject() {
//
//    }
}