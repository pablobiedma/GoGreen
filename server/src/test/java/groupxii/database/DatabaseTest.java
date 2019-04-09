package groupxii.database;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import java.io.IOException;

public class DatabaseTest {
	List<Integer> friendsId;
	List<MealEntry> eatenMeals;
	UserEntry usr;

	@Before
	public void createusr() {
		friendsId = new ArrayList<>();
		eatenMeals = new ArrayList<>();
		usr = new UserEntry(1,"Ivan","pass",100,1,9,friendsId, eatenMeals);
	}

	@Before
	public void setUpDb() throws IOException {
		Database.instance.setDbName("test");
		Database.instance.startDb();
	}

	@Test
	public void testSave() {
		VehicleEntry entry = new VehicleEntry(1337, "car");
		Database.instance.save(entry);
		assertEquals(entry.toDbObject(), Database.instance.findVehicleEntry(entry));
		//TODO Drop the test DB
	}

	@Test
	public void testSaveNull() {
		Database.instance.save(null);
		//nothing happens => test passes
	}

	@Test
	public void testSaveNonBlocking() throws InterruptedException {
		VehicleEntry entry = new VehicleEntry(1345, "car");
		Database.instance.saveNonBlocking(entry);

		assertEquals(entry.toDbObject(), Database.instance.findVehicleEntry(entry));
		//TODO Drop the test DB
	}

	@Test
	public void testUserById() {
		Database.instance.save(usr);
		assertNotEquals(usr.toDbObject(),Database.instance.findUserById(2));
	}

	@Test
	public void testFindByUserName() {
		Database.instance.save(usr);
		assertNotEquals(usr.toDbObject(),Database.instance.findUserByName("Ivan"));
	}


	@Test
	public void testSortUsersByPoints() {
		Database.instance.save(usr);
		assertNotEquals(usr.toDbObject(),Database.instance.sortUsersByReducedCo2());
	}

	@Test
	public void testAddFriend() {
		Database.instance.save(usr);
		Database.instance.addFriend("Ivan",2);
		assertEquals(usr.getFriendsId(),friendsId);
	}

//	@Test
//	public void testIncrementReducedCO2() {
//		Database.instance.saveNonBlocking(usr);
//		Database.instance.incrementReducedCo2(1,2);
//		assertEquals(11,usr.getReducedCo2());
//	}
}
