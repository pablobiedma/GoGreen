package groupxii.client.connector;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;

import java.io.StringBufferInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpURLConnection.class, OpenConnection.class})
public class ConnectorTest {
	URL url;
	HttpURLConnection huc;

	@Before
	public void mock() throws Exception {

		PowerMockito.mockStatic(OpenConnection.class);

		huc = PowerMockito.mock(HttpURLConnection.class);
		PowerMockito.when(OpenConnection.openConnection(anyString())).thenReturn(huc);
	}

	@Test
	public void testConstructor() {
		Connector c = new Connector();
		//Nothing blows up => pass
	}

	@Test
	public void testGet() throws Exception {
		String resource = "/something";
		String body = "";

		PowerMockito.when(huc.getInputStream()).thenReturn(new StringBufferInputStream("You got it"));

		String result = Connector.getRequest(resource);

		assertEquals("You got it", result);
	}
}
