package HAYE.demo.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        if () {
            System.out.print("I am also here");
            return new UsernamePasswordAuthenticationToken(name, pass, new ArrayList<>());
        } else {
            System.out.print("Bad");
            throw new BadCredentialsException("Invalid username or password");
        }
    }
    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
    }

}

/*
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    // Define your static user credentials
    private static final Map<String, String> USER_CREDENTIALS = new HashMap<>();

    static {
        USER_CREDENTIALS.put("Gregg", "123");
        USER_CREDENTIALS.put("Hipi", "123");
        USER_CREDENTIALS.put("Bob", "123");
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String pass = authentication.getCredentials().toString();
        System.out.print("I am here");

        if (USER_CREDENTIALS.containsKey(name) && USER_CREDENTIALS.get(name).equals(pass)) {
            System.out.print("I am also here");
            return new UsernamePasswordAuthenticationToken(name, pass, new ArrayList<>());
        } else {
            System.out.print("Bad");
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
    }
}

 */