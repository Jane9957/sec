package app.controllers;

import app.servies.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/main")
    public String getStatistics(Model model) {

        model.addAttribute("statistic", statisticService.getStatistic());

        Map<String, Float> graphURL;
        graphURL = statisticService.getPercentLast5AttacksURL();

        Map<String, Float> graphForm;
        graphForm = statisticService.getPercentLast5AttacksForm();

        Map<String, Integer> graphPie;
        graphPie = statisticService.getPieChart();

        model.addAttribute("chartDataURL", graphURL);
        model.addAttribute("chartDataForm", graphForm);
        model.addAttribute("chartDataPie", graphPie);

        return "main";
    }

}
