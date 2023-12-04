package HAYE.demo.controller;

import HAYE.demo.data.RedirectData;
import HAYE.demo.data.Url;
import HAYE.demo.repos.RedirectRepo;
import HAYE.demo.repos.UrlRepo;
import HAYE.demo.service.DBService;
import HAYE.demo.spider.HttpUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class RedirectController {
    @Autowired
    private RedirectRepo redirectRepo;

    @Autowired
    private UrlRepo urlRepo;

    @Autowired
    private DBService dbService;
    @GetMapping("/red/{id}")
    public RedirectView redirectTo(@PathVariable("id") String id, HttpServletRequest request) {
        RedirectData red = new RedirectData();
        red.setUrlId(Long.parseLong(id));
        String ip = HttpUtils.getRequestIP(request);
        red.setIp(ip);
        red.setUser_agent(request.getHeader("USER-AGENT"));
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        red.setDate(dateFormat.format(date));
        redirectRepo.save(red);


        Url url = dbService.findUrlShort(id);
        url.CountPlus();
        urlRepo.save(url);
        String youtubeUrl = url.getFullUrl();
        return new RedirectView(youtubeUrl);
    }
}
