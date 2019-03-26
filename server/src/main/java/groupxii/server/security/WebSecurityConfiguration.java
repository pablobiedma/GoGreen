package groupxii.server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//TODO imports (maybe done?) 

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationManager authenticationManager = new CustomAuthenticationManager();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO
        //Disable CSRF
        //Add the JWT Filter
        //Block protected endpoints
        /*
        http
            .csrf.disable() // Unecessary in REST
            */
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
