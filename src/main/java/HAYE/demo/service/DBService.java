package HAYE.demo.service;

import HAYE.demo.data.Person;
import HAYE.demo.data.UserRegistration;
import HAYE.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private UserRepo userRepo;

    public boolean findUser(UserRegistration userForm)
    {
        var users = userRepo.findAll().iterator();
        while (users.hasNext())
        {
            Person user = users.next();
            if (user.getName().compareTo(userForm.getName()) == 0) {
                if (user.getPass().compareTo(userForm.getPass()) == 0)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    public <T> Collection<T>
    getCollectionFromIterable(Iterable<T> itr)
    {
        // Create an empty Collection to hold the result
        Collection<T> cltn = new ArrayList<T>();

        // Iterate through the iterable to
        // add each element into the collection
        for (T t : itr)
            cltn.add(t);

        // Return the converted collection
        return cltn;
    }
}
