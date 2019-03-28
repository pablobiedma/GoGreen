package groupxii.server.security;

//TODO imports(maybe just Database?)

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;

/**
 * Verifies that the username exists in the database.
 */
public class UsernameAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication)
                                           throws AuthenticationException { 
	Object principal = authentication.getPrincipal();
	if (principal == null )
		throw new BadCredentialsException("Missing username");

        String username = principal.toString();


        //TODO fetch username from DB
        if (username.equals("user")) {
            return new UsernamePasswordAuthenticationToken(username, null);
        }
    
	throw new BadCredentialsException("Username verification failed");
    }
}
