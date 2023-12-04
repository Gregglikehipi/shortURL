package HAYE.demo.controller;

import HAYE.demo.data.Person;
import HAYE.demo.data.Url;
import HAYE.demo.data.UserRegistration;
import HAYE.demo.repos.UrlRepo;
import HAYE.demo.repos.UserRepo;
import HAYE.demo.service.DBService;
import HAYE.demo.spider.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MyUrlController {
    @Autowired
    private DBService dbService;
    @Autowired
    private UrlRepo urlRepo;

    @GetMapping("/myUrls")
    public String viewUrls(Model model) {
        List<Url> urlUser = dbService.getUserUrl("Gregg");
        model.addAttribute("urls", urlUser);

        return "myurl";
    }

    @PutMapping("/myUrls")
    public String urlChange(Model model, @ModelAttribute("putId") String urlId, @ModelAttribute("newDesc") String newDesc) {
        Optional<Url> url = urlRepo.findById(Long.parseLong(urlId));
        Url newUrl = url.get();
        newUrl.setDescription(newDesc);
        urlRepo.save(newUrl);

        List<Url> urlUser = dbService.getUserUrl("Gregg");
        model.addAttribute("urls", urlUser);
        return "myurl";
    }

    @PostMapping("/myUrls")
    public String addUrl(@ModelAttribute("fullUrl") String fullUrl, Model model) {
        Url newUrl = new Url();
        newUrl.setCount(0);
        newUrl.setFullUrl(fullUrl);
        urlRepo.save(newUrl);
        Url newNewUrl = dbService.findUrl(fullUrl);
        newNewUrl.setUserName("Gregg");
        newNewUrl.setSmallUrl(Convert.intToShort(newNewUrl.getId()));
        urlRepo.save(newNewUrl);
        List<Url> urlUser = dbService.getUserUrl("Gregg");
        model.addAttribute("urls", urlUser);

        return "myurl";
    }

    @DeleteMapping("/myUrls")
    public String deleteUrl(@ModelAttribute("deleteId") String deleteId, Model model) {
        System.out.println("Hi chat!");
        urlRepo.deleteById(Long.parseLong(deleteId));
        List<Url> urlUser = dbService.getUserUrl("Gregg");
        model.addAttribute("urls", urlUser);
        return "myurl";
    }
}
