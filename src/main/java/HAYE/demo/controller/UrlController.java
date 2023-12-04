package HAYE.demo.controller;

import HAYE.demo.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlController {

    @Autowired
    private DBService dbService;
    @GetMapping("/url")
    public String writeAllUrl(Model model) {

        model.addAttribute("urls", dbService.getAllUrl());

        return "url";
    }

}