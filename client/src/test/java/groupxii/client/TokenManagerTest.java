package groupxii.client;

import org.junit.Test;

import static org.junit.Assert.*;

public class TokenManagerTest {
	//TokenManager is ment to be a "blackbox" for security reasons
	//TODO boiler plate? dunno

	@Test
	public void constructorTest() {
		//TokenManager tm = new TokenManager("usr", "password");
		//TODO pull mocking tools and assert that refreshToken is called
	}

	@Test
	public void getTokenTest() {
		//TokenManager tm = new TokenManager("usr", "password");
		//TODO mock Connector.postCredentials and assert that token properly set
	}
}
