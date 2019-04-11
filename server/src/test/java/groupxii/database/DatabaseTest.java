package groupxii.database;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Database.class})

public class DatabaseTest {
	@Rule
	ExpectedException thrown = ExpectedException.none();

	static List<Integer> friendsId;
	static List<MealEntry> eatenMeals;
	static UserEntry usr;
	static String addr;
	static String port;

	@BeforeClass
	public static void setUpDb() throws IOException {
		addr = "localhost";
		port = "27017";
		Database.instance.setDbName("test");
		Database.instance.startDb();

		friendsId = new ArrayList<>();
		eatenMeals = new ArrayList<>();

		usr = new UserEntry(1,"Ivan","pass");
		Database.instance.save(usr);
	}


	@Test
	public void testEnvVar() {
		PowerMockito.mockStatic(System.class);
		PowerMockito.when(System.getenv("DB_ADDRESS")).thenReturn(addr);
		PowerMockito.when(System.getenv("DB_PORT")).thenReturn(port);
		Database test = new Database();

		assertEquals(addr, test.getDbAddr());
		assertEquals(Integer.parseInt(port), test.getDbPort());
	}

	@Test
	public void testNoEnvPort() {
		PowerMockito.mockStatic(System.class);
		PowerMockito.when(System.getenv("DB_ADDRESS")).thenReturn(addr);
		PowerMockito.when(System.getenv("DB_PORT")).thenReturn(null);

		Database test = new Database();

		assertEquals(addr, test.getDbAddr());
		assertEquals(27017, test.getDbPort());
	}

	@Test
	public void testNoEnvAddr() {
		PowerMockito.mockStatic(System.class);
		PowerMockito.when(System.getenv("DB_ADDRESS")).thenReturn(null);
		PowerMockito.when(System.getenv("DB_PORT")).thenReturn(null);

		Database test = new Database();

		assertEquals("localhost", test.getDbAddr());
		assertEquals(Integer.parseInt(port), test.getDbPort());
	}

	@Test
	public void testBadEnvPort() {
		port = "PORT_IS_27017";
		PowerMockito.mockStatic(System.class);
		PowerMockito.when(System.getenv("DB_ADDRESS")).thenReturn(addr);
		PowerMockito.when(System.getenv("DB_PORT")).thenReturn(port);

		Database test = new Database();

		assertEquals(addr, test.getDbAddr());
		assertEquals(27017, test.getDbPort());
	}


	@Test
	public void testSave() {
		VehicleEntry entry = new VehicleEntry(1337, "car");
		Database.instance.save(entry);
		assertEquals(entry.toDbObject(), Database.instance.findVehicleEntry(entry));
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
	}

	@Test
	public void testUserByWrongId() {
		assertNotEquals(usr.toDbObject(),Database.instance.findUserById(2));
	}

	@Test
	public void testUserById() {
		assertEquals(usr.toDbObject(),Database.instance.findUserById(1));
	}

	@Test
	public void testFindByUserName() {
		assertEquals(usr.toDbObject(),Database.instance.findUserByName("Ivan"));
	}


	@Test
	public void testSortUsersByPoints() {
		assertNotEquals(usr.toDbObject(),Database.instance.sortUsersByReducedCo2());
	}

	@Test
	public void testAddFriend() {
		Database.instance.addFriend("Ivan",2);
		assertEquals(usr.getFriendsId(),friendsId);
	}

	/*
	@Test
	public void testIncrementReducedCO2() {
		Database.instance.save(usr);
		Database.instance.incrementReducedCo2(1,2);
		assertEquals(2, usr.getReducedCo2());
	}
	*/

	@Test
	public void testGetUserCount() {
		assertEquals(1, Database.instance.getUserCount());
	}

	@AfterClass
	public static void dropTestDb() {
		MongoClient mc;
		DB db;
		mc = new MongoClient(Database.instance.getDbAddr(),
				     Database.instance.getDbPort());
		db = mc.getDB("test");
		db.dropDatabase();
	}
}
