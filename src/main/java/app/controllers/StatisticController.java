package app.controllers;

import app.servies.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.MalformedURLException;

@Controller
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/main")
    public String getProfileById(Model model) {

        model.addAttribute("statistic", statisticService.getStatistic());
        return "main";
    }

}
