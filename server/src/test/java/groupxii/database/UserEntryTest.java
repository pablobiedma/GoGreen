package groupxii.database;

import com.mongodb.DBObject;

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
            usr = new UserEntry(1,"Ivan","pass");
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
        assertEquals(0,usr.getPoints());
    }

    @Test
    public void getBadge() {
        assertEquals(0,usr.getBadge());
    }

    @Test
    public void getReducedCo2() {
        assertEquals(0,usr.getReducedCo2());
    }

    @Test
    public void getFriendsId() {
        assertEquals(friendsId,usr.getFriendsId());
    }

    @Test
    public void getEatenMealsTest() {
	    assertEquals(eatenMeals, usr.getEatenMeals());
    }

    @Test
    public void testToDBObject() {
	    DBObject obj = usr.toDbObject();
	    assertTrue(obj.containsField("userId"));
	    assertTrue(obj.containsField("username"));
	    assertTrue(obj.containsField("password"));
	    assertTrue(obj.containsField("points"));
	    assertTrue(obj.containsField("badge"));
	    assertTrue(obj.containsField("reducedCo2"));
	    assertTrue(obj.containsField("friendsId"));
	    assertTrue(obj.containsField("eatenMeals"));
    }

    @Test
    public void testFromDBObject() {
	    DBObject obj = usr.toDbObject();
	    usr = new UserEntry(obj);
	    testToDBObject();
    }
}
