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

	@Test
	public void testDbAddr() {
		Database db = new Database();
		db.setDbAddr("test");
		assertEquals(db.getDbAddr(), "test");
	}

	@Test
	public void testDbPort() {
		Database db = new Database();
		db.setDbPort(1234);
		assertEquals(db.getDbPort(), 1234);
	}

	@Test
	public void testDbName() {
		Database db = new Database();
		db.setDbName("testDB");
		assertEquals(db.getDbName(), "testDB");
	}

	/*
	@Test
	public void testConstructor() {
		Database db = new Database();
		assertEquals(db.getDbAddr(), "localhost");
		assertEquals(db.getDbPort(), 27017);
		assertEquals(db.getDbName(), "GoGreen");
	}
	*/

	@Test
	public void testNotRunning() {
		Database db = new Database();
		assertFalse(db.isRunning());
	}

	@Test
	public void testRunning() throws IOException {
		Database db = new Database();
		db.startDb();
		assertTrue(db.isRunning());
	}
	/*
	@Test
	public void testWrongHost() {
		Database db = new Database();
		db.setDbAddr("badhost");
		db.startDb();
		assertFalse(db.isRunning());
	}
	*/

	@Test
	public void testSave() throws IOException {
		Database.instance.setDbName("test");
		Database.instance.startDb();
		VehicleEntry entry = new VehicleEntry("bike", "car", 4,8);
		Database.instance.save(entry);
		assertEquals(entry.toDbObject(), Database.instance.findVehicleEntry(entry));
		//TODO Drop the test DB
	}

//	@Test
//	public void testSaveNonBlocking() {
//		Database.instance.setDbName("test");
//		Database.instance.startDb();
//		VehicleEntry entry = new VehicleEntry(1337, "car");
//		Database.instance.saveNonBlocking(entry);
//
//		assertEquals(entry.toDbObject(), Database.instance.findVehicleEntry(entry));
//		//TODO Drop the test DB
//	}


	@Test
	public void testSaveMeal() throws IOException{
		Database.instance.setDbName("test");
		Database.instance.startDb();
		MealEntry entry = new MealEntry("apple",10 , "pizza", 100);
		Database.instance.save(entry);
		assertEquals(entry.toDbObject(), Database.instance.findMealEntry(entry));
		//TODO Drop the test DB
	}

//	@Test
//	public void testSaveMealNonBlocking() throws IOException{
//		Database.instance.setDbName("test");
//		Database.instance.startDb();
//		MealEntry entry = new MealEntry( "apple",10, "pizza", 100 );
//		Database.instance.saveNonBlocking(entry);
//
//		assertEquals(entry.toDbObject(), Database.instance.findMealEntry(entry));
//		//TODO Drop the test DB
//	}

	@Test
	public void testSaveUser() throws IOException{
		Database.instance.setDbName("test");
		Database.instance.startDb();
		Database.instance.save(usr);
		assertEquals(usr.toDbObject(), Database.instance.findUserEntry(usr));
		//TODO Drop the test DB
	}

	@Test
	public void testSaveUserNonBlocking() throws IOException{
		Database.instance.setDbName("test");
		Database.instance.startDb();
		Database.instance.saveNonBlocking(usr);
		assertEquals(usr.toDbObject(), Database.instance.findUserEntry(usr));
		//TODO Drop the test DB
	}
	@Test
	public void testUserById() throws IOException{
		Database.instance.setDbName("test");
		Database.instance.startDb();
		Database.instance.saveNonBlocking(usr);
		assertNotEquals(usr.toDbObject(),Database.instance.findUserById(2));
	}

	@Test
	public void testFindByUserName() throws IOException{
		Database.instance.setDbName("test");
		Database.instance.startDb();
		Database.instance.saveNonBlocking(usr);
		assertNotEquals(usr.toDbObject(),Database.instance.findUserByName("Ivan"));
	}


	@Test
	public void testSortUsersByPoints() throws IOException{
		Database.instance.setDbName("test");
		Database.instance.startDb();
		Database.instance.saveNonBlocking(usr);
		assertNotEquals(usr.toDbObject(),Database.instance.sortUsersByReducedCo2());
	}

	@Test
	public void testAddFriend() throws IOException{
		Database.instance.setDbName("test");
		Database.instance.startDb();
		Database.instance.saveNonBlocking(usr);
		Database.instance.addFriend(1,2);
		assertEquals(usr.getFriendsId(),friendsId);
	}

//	@Test
//	public void testIncrementReducedCO2() throws IOException{
//		Database.instance.setDbName("test");
//		Database.instance.startDb();
//		Database.instance.saveNonBlocking(usr);
//		Database.instance.incrementReducedCo2(1,2);
//		assertEquals(11,usr.getReducedCo2());
//	}
}
