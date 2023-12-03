package HAYE.demo.controller;

import HAYE.demo.data.Person;
import HAYE.demo.data.UserRegistration;
import HAYE.demo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserRegistration());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") UserRegistration userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPass().equals(userForm.getPassConfirmation())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        userRepo.save(new Person(userForm.getName(), userForm.getPass()));

        return "redirect:/";
    }
}
