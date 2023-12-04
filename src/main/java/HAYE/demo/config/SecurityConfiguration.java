package HAYE.demo.config;

import HAYE.demo.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                .anyRequest().permitAll());
        return http.build();
    }
    */

/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/registration").permitAll()
                        .requestMatchers("/red/*").permitAll()
                        .requestMatchers("/").permitAll()// Allow access to the login page
                        .anyRequest().authenticated()) // Require authentication for all other requests
                        .formLogin((form) -> form
                        .loginPage("/login") // Configure the login page URL
                        .defaultSuccessUrl("/")) // Redirect to the home page after successful login
                        .logout((logout) -> logout
                                .logoutUrl("/logout") // Configure the logout URL
                        );





    }
     */


    /*
    http
                                .authorizeRequests()
                                .requestMatchers("/login", "/registration", "/red/*", "/").permitAll()
                                .anyRequest().authenticated()
                                .and();

                        return http.build();
     */
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authentication -> {
            UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
            if (userDetails.getPassword().equals(authentication.getCredentials())) {
                return new UsernamePasswordAuthenticationToken(
                        userDetails.getUsername(),
                        userDetails.getPassword(),
                        userDetails.getAuthorities()
                );
            }
            throw new BadCredentialsException("Invalid username/password");
        };
    }



}