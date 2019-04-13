package groupxii.client;

import org.junit.Test;

public class TokenManagerTest {
	//TokenManager is ment to be a "blackbox" for security reasons
	//TODO boiler plate? dunno

	@Test
	public void constructorTest() {
		TokenManager tm = new TokenManager("usr", "password");
	}
}
