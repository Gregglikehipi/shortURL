package HAYE.demo.controller;

import HAYE.demo.data.Person;
import HAYE.demo.data.UserRegistration;
import HAYE.demo.repos.UserRepo;
import HAYE.demo.service.DBService;
import HAYE.demo.spider.HttpUtils;
import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private DBService dbService;
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/")
    public String menu(HttpServletRequest request, Principal principal) {

        System.out.print(principal.getName());
        var hii = userRepo.findAll().iterator();
        while (hii.hasNext())
        {
            Person item = hii.next();
            System.out.println(item.getName());
            System.out.println(item.getId());
        }

        /*
        var hii = userRepo.findAll().iterator();
        while (hii.hasNext())
        {
            Person item = hii.next();
            System.out.println(item.getName());
            System.out.println(item.getId());
        }
        Person jack = new Person();
        System.out.println(jack.getId());
        //dbService.DeleteUsers();
        //dbService.DeleteUrl();
        String ip = HttpUtils.getRequestIP(request);
        System.out.println(ip);
        System.out.println(request.getHeader("USER-AGENT"));
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        System.out.println(userAgent.getBrowser().getName() + " " + userAgent.getBrowserVersion() + " " + userAgent.getOperatingSystem().getName());
        */
        return "index";
    }

}
