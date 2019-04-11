package groupxii.database;



import org.junit.Before;
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

	List<Integer> friendsId;
	List<MealEntry> eatenMeals;
	UserEntry usr;
	String addr;
	String port;

	@Before
	public void createusr() {
		friendsId = new ArrayList<>();
		eatenMeals = new ArrayList<>();
		usr = new UserEntry(1,"Ivan","pass");
	}

	@Before
	public void setUpDb() throws IOException {
		addr = "localhost";
		port = "27017";
		Database.instance.setDbName("test");
		Database.instance.startDb();
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
