package HAYE.demo.controller;

import HAYE.demo.data.Person;
import HAYE.demo.data.UserRegistration;
import HAYE.demo.repos.UserRepo;
import HAYE.demo.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String registration() {
        var hii = userRepo.findAll().iterator();
        while (hii.hasNext())
        {
            Person item = hii.next();
            System.out.println(item.getName());
        }
        System.out.print("hi");
        return "index";
    }

}
