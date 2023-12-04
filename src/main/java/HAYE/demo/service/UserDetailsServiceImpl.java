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


        var hii = userRepo.findAll().iterator();
        while (hii.hasNext())
        {
            Person item = hii.next();
            System.out.println(item.getName());
            System.out.println(item.getId());
        }

        if ("Gregg".equals(username)) {
            return User.withUsername(username)
                    .password("{noop}123")
                    .roles("USER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}