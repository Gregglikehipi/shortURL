package HAYE.demo.service;

import HAYE.demo.data.Person;
import HAYE.demo.data.RedirectData;
import HAYE.demo.data.Url;
import HAYE.demo.data.UserRegistration;
import HAYE.demo.repos.RedirectRepo;
import HAYE.demo.repos.UrlRepo;
import HAYE.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UrlRepo urlRepo;

    @Autowired
    private RedirectRepo redirectRepo;

    public Url findUrlShort(String shortUrl)
    {
        var urls = urlRepo.findAll().iterator();
        while (urls.hasNext())
        {
            Url url = urls.next();
            if (url.getSmallUrl().compareTo(shortUrl) == 0) {
                return url;
            }
        }
        return null;
    }

    public List<Url> getAllUrl() {
        List<Url> allUrl = new ArrayList<>();
        var urls = urlRepo.findAll().iterator();
        while (urls.hasNext())
        {
            Url item = urls.next();
            allUrl.add(item);
        }
        return allUrl;
    }

    public List<Url> getUserUrl(String name) {
        List<Url> allUrl = new ArrayList<>();
        var urls = urlRepo.findAll().iterator();
        while (urls.hasNext())
        {
            Url item = urls.next();
            if (name.compareTo(item.getUserName()) == 0)
                allUrl.add(item);
        }
        return allUrl;
    }

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

    public Url findUrl(String fullUrl)
    {
        var urls = urlRepo.findAll().iterator();
        while (urls.hasNext())
        {
            Url url = urls.next();
            if (url.getFullUrl().compareTo(fullUrl) == 0) {
                return url;
            }
        }
        return null;
    }

    public List<RedirectData> findUrlId(Long id)
    {
        List<RedirectData> allRed = new ArrayList<>();
        var reds = redirectRepo.findAll().iterator();
        while (reds.hasNext())
        {
            RedirectData item = reds.next();
            if (id.compareTo(item.getUrlId()) == 0)
                allRed.add(item);
        }
        return allRed;
    }

    public void DeleteUsers() {
        userRepo.deleteAll();
    }

    public void DeleteUrl() {
        urlRepo.deleteAll();
    }

}
