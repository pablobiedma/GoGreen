package groupxii.server.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.io.IOException;
import java.util.stream.Collectors;

public class JwtGeneratingFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtGeneratingFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        setFilterProcessesUrl("/login"); //BAD
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
	String body = null;

	//Is there a better way for this?
	//TODO return BAD_REQUEST here
	if (!("POST".equalsIgnoreCase(request.getMethod())))
		throw new BadCredentialsException("Request must be POST");

	try {
		body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	} catch (IOException e) {
		//TODO return BAD REQUEST here
		throw new BadCredentialsException("Could not read request body");
	}

	JSONObject json = null;

	String username = null;
	String password = null;

	try {
		json = new JSONObject(body);
		username = json.getString("username");
		password = json.getString("password");
	} catch (JSONException e) {
		//TODO return BAD REQUEST here?
		throw new BadCredentialsException("Could not parse JSON");
	}

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain, Authentication authentication) {
        String username = authentication.getPrincipal().toString();
	//TODO figure out a good value for this
	int expirationTime = 86400000;
    	String jws = Jwts.builder()
		.setSubject(username)
		.signWith(Keys.hmacShaKeyFor(SecurityKey.instance.getKey()))
		.setHeaderParam("typ", "JWT")
		.setIssuer("goGreen-server")
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
		.compact();

        response.addHeader("Authorization", "Bearer " + jws);
    }
}
