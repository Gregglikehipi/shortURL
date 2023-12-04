package HAYE.demo.controller;

import org.springframework.stereotype.Controller;

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
    public String addUser(@ModelAttribute("userForm") UserRegistration userForm, BindingResult bindingResult) {


       // Authentication authentication =
               // new UsernamePasswordAuthenticationToken(userForm.getName(), userForm.getPass());

        //Authentication result = authenticationManager.authenticate(authentication);
       // SecurityContextHolder.getContext().setAuthentication(result);





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
