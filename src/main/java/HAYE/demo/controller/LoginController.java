package HAYE.demo.controller;

import HAYE.demo.data.UserRegistration;
import HAYE.demo.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    /*
    @Autowired
    private DBService dbService;

    @GetMapping("/login")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserRegistration());

        return "login";
    }


    @PostMapping("/login")
    public String addUser(BindingResult bindingResult) {

        return "redirect:/";
    }
*/

}
