package groupxii.server.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtGeneratingFilterTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private JwtGeneratingFilter jwtgen;

	private HttpServletRequest request;
	private HttpServletResponse response;
	String body;
	Reader bodyReader;
	BufferedReader reader;

	private void createReader(String text) {
		body = text;
		bodyReader = new StringReader(body);
		reader = new BufferedReader(bodyReader);
		try {
			when(request.getReader()).thenReturn(reader);
		} catch (IOException e) {
			// Java is shit language
		}
	}


	@Before
	public void createjwtgen() {
		List<AuthenticationProvider> allCustomProviders = new ArrayList<>();
		allCustomProviders.add(new UsernameAuthenticationProvider());
		AuthenticationManager authenticationManager = new ProviderManager(allCustomProviders);

		jwtgen = new JwtGeneratingFilter(authenticationManager);
		request = mock(HttpServletRequest.class);
		when(request.getProtocol()).thenReturn("HTTP/1.1");	
		when(request.getMethod()).thenReturn("POST");

		createReader("{\"username\":\"0day\", \"password\":\"pass\"}");
		

		response = mock(HttpServletResponse.class);
	}

	@Test
	public void testNonPostRequest() {
		thrown.expect(InsufficientAuthenticationException.class);
		thrown.expectMessage("Request must be POST");

		when(request.getMethod()).thenReturn("GET");

		jwtgen.attemptAuthentication(request, response);
	}

	@Test
	public void testBodyIOException() {
		thrown.expect(InsufficientAuthenticationException.class);
		thrown.expectMessage("Could not read request body");

		try {
			when(request.getReader()).thenThrow(IOException.class);
		} catch (IOException e) {
			// Java is shit language
		}

		jwtgen.attemptAuthentication(request, response);
	}

	@Test
	public void testEmptyRequestBody() {
		thrown.expect(InsufficientAuthenticationException.class);
		thrown.expectMessage("Could not parse JSON");

		createReader("");

		jwtgen.attemptAuthentication(request, response);
	}

	@Test
	public void succesfullAuthentication() {
		jwtgen.attemptAuthentication(request, response);
	}



}

/*
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

*/
