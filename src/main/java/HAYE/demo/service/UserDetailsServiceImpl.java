package HAYE.demo.service;

import HAYE.demo.data.Person;
import HAYE.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var users = userRepo.findAll().iterator();
        while (users.hasNext())
        {
            Person item = users.next();
            if (item.getName().equals(username)) {
                return User.withUsername(username)
                        .password("{noop}" + item.getPass())
                        .roles("USER")
                        .build();
            }
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}