package groupxii.userschema;

import groupxii.database.UserEntry;
import org.junit.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SaveUserTest {

    @Test
    public void getUserList() {
        SaveUser su1 = new SaveUser();
        SaveUser su2 = new SaveUser();
        List<User> l1 = new ArrayList<>();
        List<User> l2= new ArrayList<>();
        User u1 = new User("Ivan",100,1,2);
        User u2 = new User("Lazar",10,1,2);
        User u3 = new User("Ivan",1000,3,6);
        User u4 = new User("Ivan",1003,2,4);
        User u5 = new User("Ivan",1001,5,1);
        l1.add(0,u1);
        l1.add(1,u2);
        l1.add(2,u3);
        l2.add(0,u4);
        l2.add(1,u5);
        su1.setUserList(l1);
        su2.setUserList(l2);
        su1.setUserList(l2);
        assertEquals(su1.getUserList(),su2.getUserList());
    }

    @Test
    public void setUserList() {
        SaveUser sm = new SaveUser();
        List<User> l = new ArrayList<>();
        User u1 = new User("Ivan",100,1,2);
        User u2 = new User("Lazar",10,1,2);
        User u3 = new User("Ivan",1000,3,6);
        User u4 = new User("Ivan",1003,2,4);
        User u5 = new User("Ivan",1001,5,1);
        l.add(0,u1);
        l.add(1,u2);
        l.add(2,u3);
        l.add(3,u4);
        l.add(4,u5);
        sm.setUserList(l);
        assertEquals(l.subList(0,5),sm.getUserList());
    }

    @Test
    public void getUserEntry() throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(0,4);
        list.add(1,2);
        list.add(2,3);
        UserEntry m = new UserEntry(1,"Ivan",100,1,5, list);
        SaveUser sm = new SaveUser();
        sm.saveUser(3,"Ivan",100,1,5, list);
        assertNotEquals(sm.getUserEntry(),m);
    }

}