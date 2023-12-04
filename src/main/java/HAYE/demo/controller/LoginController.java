package HAYE.demo.controller;

import HAYE.demo.config.CustomAuthenticationProvider;
import HAYE.demo.data.Person;
import HAYE.demo.data.UserRegistration;
import HAYE.demo.repos.UserRepo;
import HAYE.demo.service.DBService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @Autowired
    private DBService dbService;

    @GetMapping("/login")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserRegistration());

        return "login";
    }

    @PostMapping("/login")
    public String addUser(@ModelAttribute("userForm") UserRegistration userForm, BindingResult bindingResult) {

        /*
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(userForm.getName(), userForm.getPass());

        Authentication result = authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(result);
        */




        if (bindingResult.hasErrors()) {
            return "login";
        }
        if (!dbService.findUser(userForm)){
            return "login";
        }
        System.out.print("Good");


        return "redirect:/";
    }

    /*
    private void authenticateUserAndSetSession(Person user, HttpServletRequest request) {
        String username = user.getName();
        String password = user.getPass();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        // generate session if one doesn't exist
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

     */

}
