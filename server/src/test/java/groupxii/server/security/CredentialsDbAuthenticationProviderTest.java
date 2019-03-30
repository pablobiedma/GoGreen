package groupxii.server.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CredentialsDbAuthenticationProviderTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	CredentialsDbAuthenticationProvider cdap;
	@Before
	public void createap() {
		cdap = new CredentialsDbAuthenticationProvider();
	}

	@Test
	public void missingUsernameTest() {
		thrown.expect(InsufficientAuthenticationException.class);
		thrown.expectMessage("Username or password are null");
		Authentication missingUsername = new UsernamePasswordAuthenticationToken(null, "pass");

		cdap.authenticate(missingUsername);
	}

	@Test
	public void missingPasswordTest() {
		thrown.expect(InsufficientAuthenticationException.class);
		thrown.expectMessage("Username or password are null");
		Authentication missingPassword = new UsernamePasswordAuthenticationToken("0day", null);

		cdap.authenticate(missingPassword);
	}

	@Test
	public void testSupportTrue() {
		assertTrue(cdap.supports(UsernamePasswordAuthenticationToken.class));
	}

	@Test
	public void testSupportFalse() {
		assertFalse(cdap.supports(AnonymousAuthenticationToken.class));
	}

	// THE FOLLOWING TESTS ARE TEMP HACK
	
	@Test
	public void testUsername0day() {
		Authentication zeroDay = new UsernamePasswordAuthenticationToken("0day", "pass");
		cdap.authenticate(zeroDay);
		// No exception thrown -> test pass
	}

	@Test
	public void testUsername1day() {
		thrown.expect(BadCredentialsException.class);
		thrown.expectMessage("Authentication failed");
		Authentication firstDay = new UsernamePasswordAuthenticationToken("1day", "pass");
		cdap.authenticate(firstDay);
	}



}
