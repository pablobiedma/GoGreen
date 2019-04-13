package groupxii.client.connector;

import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.*;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Connector.class})

public class LoginConnectorTest {
	@Test
	public void test() {
		PowerMockito.mockStatic(Connector.class);
		PowerMockito.when(Connector.postRequest("/login", "credentials")).thenReturn("Token");

		//Why tf should I test the constructor of a class
		//that has only one static method?
		LoginConnector lc = new LoginConnector();
		assertEquals(lc.postCredentials("credentials"), "Token");
	}

}
