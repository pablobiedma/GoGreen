package groupxii.userschema;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getUsername() {
        User usr = new User("Ivan",100,1,2);
        assertEquals(usr.getUsername(),"Ivan");
    }

    @Test
    public void getPoints() {
        User usr = new User("Ivan",100,1,2);
        assertEquals(usr.getPoints(),100);
    }

    @Test
    public void getBadge() {
        User usr = new User("Ivan",100,1,2);
        assertEquals(usr.getBadge(),1);
    }

    @Test
    public void getReducedCo2() {
        User usr = new User("Ivan",100,1,2);
        assertEquals(usr.getReducedCo2(),2);
    }
}