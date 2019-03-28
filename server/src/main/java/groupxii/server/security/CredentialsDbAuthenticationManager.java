package groupxii.server.security;

//TODO imports(Database, compare passwords, etc)

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;

public class CredentialsDbAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication)
                                           throws AuthenticationException { 
	Object principal = authentication.getPrincipal();
	Object credentials = authentication.getCredentials();
	if (principal == null )//|| credentials == null)
		throw new BadCredentialsException("Username or password are null");

        String username = principal.toString();
        String password = credentials.toString();


        //TODO fetch users from DB
        if (username.equals("user")) {
            ArrayList<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("USER"));
            return new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
        }
    
	throw new BadCredentialsException("Authentication failed");
    }
}
