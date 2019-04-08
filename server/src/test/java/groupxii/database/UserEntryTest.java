package groupxii.database;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserEntryTest {
    List<Integer> friendsId;
    List<MealEntry> eatenMeals;
    UserEntry usr;
    @Before
    public void createusr() {
	    friendsId = new ArrayList<>();
	    eatenMeals = new ArrayList<>();
            usr = new UserEntry(1,"Ivan","pass",100,1,9,friendsId, eatenMeals);
    }

    @Test
    public void getUserId() {
        assertEquals(1,usr.getUserId());
    }

    @Test
    public void getUsername() {
        assertEquals("Ivan",usr.getUsername());
    }

    @Test
    public void getPoints() {
        assertEquals(100,usr.getPoints());
    }

    @Test
    public void getBadge() {
        assertEquals(1,usr.getBadge());
    }

    @Test
    public void getReducedCo2() {
        assertEquals(9,usr.getReducedCo2());
    }

    @Test
    public void getFriendsId() {
        assertEquals(friendsId,usr.getFriendsId());
    }

    @Test
    public void getEatenMealsTest() {
	    assertEquals(eatenMeals, usr.getEatenMeals());
    }
}
