package groupxii.server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

//TODO imports (maybe done?)  HAHAHAAHHAH

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    public WebSecurityConfiguration() {
	    super(false);
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
	    ArrayList<AuthenticationProvider> allCustomProviders = new ArrayList<>();
	    allCustomProviders.add(new UsernameAuthenticationProvider());
	    return new  ProviderManager(allCustomProviders);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //TODO
        http
	    .addFilterBefore(new JwtVerificationFilter(authenticationManager()), AnonymousAuthenticationFilter.class)
            .csrf().disable() // Unecessary in REST
	    .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	    .and()
	    .httpBasic().disable()
	    .addFilter(new JwtGeneratingFilter(new CredentialsDbAuthenticationManager()))
	    .authorizeRequests()
            .anyRequest().authenticated()
	    .antMatchers("/login").permitAll()
	    ;
    }

    /*
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    */
}
