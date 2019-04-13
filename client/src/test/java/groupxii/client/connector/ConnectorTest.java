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

import java.io.ByteArrayOutputStream;
import java.io.StringBufferInputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpURLConnection.class, OpenConnection.class})
public class ConnectorTest {
	URL url;
	HttpURLConnection huc;
	String resource;

	OutputStream postedBody;

	@Before
	public void mock() throws Exception {
		resource = "/something";
		postedBody = new ByteArrayOutputStream();

		PowerMockito.mockStatic(OpenConnection.class);

		huc = PowerMockito.mock(HttpURLConnection.class);
		PowerMockito.when(OpenConnection.openConnection(anyString())).thenReturn(huc);
		PowerMockito.when(huc.getInputStream()).thenReturn(new StringBufferInputStream("You got it"));

		PowerMockito.when(huc.getOutputStream()).thenReturn(postedBody);
	}

	@Test
	public void testConstructor() {
		Connector c = new Connector();
		//Nothing blows up => pass
	}

	@Test
	public void testGet() throws Exception {
		String result = Connector.getRequest(resource);

		assertEquals("You got it", result);
	}

	@Test
	public void testPostNoBody() throws Exception {
		String result = Connector.postRequest(resource);
		assertEquals("You got it", result);
		assertEquals("", postedBody.toString());
	}

	@Test
	public void testPostBody() throws Exception {
		String body = "Hi";
		String result = Connector.postRequest(resource, body);
		assertEquals("You got it", result);
		assertEquals(body, postedBody.toString());
	}

	@Test
	public void testLogin() throws Exception {
		String body = "Credentials";
		PowerMockito.when(huc.getHeaderField("Authorization")).thenReturn("Token");

		String result = Connector.postRequest("/login", body);
		assertEquals("Token", result);
		assertEquals(body, postedBody.toString());
	}

}
