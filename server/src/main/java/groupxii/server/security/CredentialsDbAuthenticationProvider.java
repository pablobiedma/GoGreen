package groupxii.server.security;

//TODO imports(Database, compare passwords, etc)

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.authentication.AuthenticationProvider;

import java.util.ArrayList;

public class CredentialsDbAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication)
                                           throws AuthenticationException { 
	Object principal = authentication.getPrincipal();
	Object credentials = authentication.getCredentials();
	if (principal == null || credentials == null)
		throw new BadCredentialsException("Username or password are null");

        String username = principal.toString();
        String password = credentials.toString();


        //TODO fetch users from DB
        if (username.equals("0day")) // VERY VERY BAD
            return new UsernamePasswordAuthenticationToken(username, password);
    
	throw new BadCredentialsException("Authentication failed");
    }

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(
		       UsernamePasswordAuthenticationToken.class);
	}
}
