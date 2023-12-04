package HAYE.demo.controller;

import HAYE.demo.data.RedirectData;
import HAYE.demo.data.Url;
import HAYE.demo.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class RedirectDataController {

    @Autowired
    private DBService dbService;
    @GetMapping("/myRedirect")
    public String viewUrls(Model model, @ModelAttribute("redirectId") String idUrl) {
        List<RedirectData> redirects = dbService.findUrlId(Long.parseLong(idUrl));
        model.addAttribute("reds", redirects);

        return "myredirect";
    }
}
