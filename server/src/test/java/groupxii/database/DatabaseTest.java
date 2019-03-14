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
}
