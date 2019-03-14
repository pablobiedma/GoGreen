package groupxii.database;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
}
