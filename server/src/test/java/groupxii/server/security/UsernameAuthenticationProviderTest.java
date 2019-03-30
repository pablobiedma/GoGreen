package groupxii.server.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UsernameAuthenticationProviderTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	UsernameAuthenticationProvider uap;
	@Before
	public void createuap() {
		uap = new UsernameAuthenticationProvider();
	}

	@Test
	public void missingUsernameTest() {
		thrown.expect(BadCredentialsException.class);
		thrown.expectMessage("Missing username");
		Authentication missingUsername = new UsernamePasswordAuthenticationToken(null, null);

		uap.authenticate(missingUsername);
	}

	@Test
	public void testSupportTrue() {
		assertTrue(uap.supports(UsernamePasswordAuthenticationToken.class));
	}

	@Test
	public void testSupportFalse() {
		assertFalse(uap.supports(AnonymousAuthenticationToken.class));
	}

	// THE FOLLOWING TESTS ARE TEMP HACK
	
	@Test
	public void testUsername0day() {
		Authentication zeroDay = new UsernamePasswordAuthenticationToken("0day", null);
		uap.authenticate(zeroDay);
		// No exception thrown -> test pass
	}

	@Test
	public void testUsername1day() {
		thrown.expect(BadCredentialsException.class);
		thrown.expectMessage("Username verification failed");
		Authentication firstDay = new UsernamePasswordAuthenticationToken("1day", null);
		uap.authenticate(firstDay);
	}



}
