package groupxii.database;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DatabaseTest {
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

	@Test
	public void testConstructor() {
		Database db = new Database();
		assertEquals(db.getDbAddr(), "localhost");
		assertEquals(db.getDbPort(), 27017);
		assertEquals(db.getDbName(), "GoGreen");
	}

	@Test
	public void testNotRunning() {
		Database db = new Database();
		assertFalse(db.isRunning());
	}

	@Test
	public void testRunning() {
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
	public void testSave() {
		Database.instance.setDbName("test");
		Database.instance.startDb();
		VehicleEntry entry = new VehicleEntry(1337, "car");
		Database.instance.save(entry);
		assertEquals(entry.toDbObject(), Database.instance.findVehicleEntry(entry));
		//TODO Drop the test DB
	}

	@Test
	public void testSaveNonBlocking() {
		Database.instance.setDbName("test");
		Database.instance.startDb();
		VehicleEntry entry = new VehicleEntry(1337, "car");
		Database.instance.saveNonBlocking(entry);

		VehicleEntry timewaster = new VehicleEntry(1338, "bike");
		Database.instance.save(timewaster);

		assertEquals(entry.toDbObject(), Database.instance.findVehicleEntry(entry));
		//TODO Drop the test DB
	}
}
