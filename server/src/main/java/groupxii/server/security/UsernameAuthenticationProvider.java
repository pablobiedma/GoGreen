package groupxii.server.security;

//TODO imports(maybe just Database?)

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Verifies that the username exists in the database.
 */
@Service
public class UsernameAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            throw new BadCredentialsException("Missing username");
        }

        String username = principal.toString();

        //TODO fetch username from DB
        if (username.equals("0day")) {
            ArrayList<GrantedAuthority> grantedAuthrities = new ArrayList<GrantedAuthority>();
            grantedAuthrities.add(new SimpleGrantedAuthority("USER"));
            return new UsernamePasswordAuthenticationToken(username, "null", grantedAuthrities);
        }

        throw new BadCredentialsException("Username verification failed");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
