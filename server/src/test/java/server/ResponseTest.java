package server.group12;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ResponseTest {
	@Test
	public void testReponse() {
		Response res = new Response();
		assertEquals(res.response(), "Hello ");
	}
}
