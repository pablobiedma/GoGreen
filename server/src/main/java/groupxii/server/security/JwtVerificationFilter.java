package groupxii.server.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtVerificationFilter extends BasicAuthenticationFilter{

	public JwtVerificationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
					FilterChain filterChain) throws IOException, ServletException {
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (token == null || !token.startsWith("Bearer ")) {//also not good
			filterChain.doFilter(request, response);
			return;
		}

		
		UsernamePasswordAuthenticationToken authentication = getAuthenticaion(token);
		if (authentication == null) {
			filterChain.doFilter(request, response);
			return;
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private UsernamePasswordAuthenticationToken getAuthenticaion(String jwsString) {
		Jws<Claims> jws;

		try {
			jws = Jwts.parser()
				.setSigningKey(SecurityKey.instance.getKey())
				.parseClaimsJws(jwsString.replace("Bearer ", ""));
			String username = new String(jws.getBody().getSubject());
			return new UsernamePasswordAuthenticationToken(username, null);
		} catch (JwtException e) {
			return null;
		}
	}
}
