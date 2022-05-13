package app.controllers;

import app.servies.AttackService;

import app.servies.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class HoneyController {

    @Autowired
    private AttackService attackService;

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/honey/{id_attack}/{id_user}")
    public String honey(Model model, @PathVariable String id_attack, @PathVariable String id_user) throws SQLException {

        model.addAttribute("id_attack", id_attack);
        model.addAttribute("id_user", id_user);

        attackService.update1(Integer.parseInt(id_attack), Integer.parseInt(id_user));

        return "honey";
    }

    @PostMapping("/honey/{id_attack}/{id_user}")
    public String honeyPost(@PathVariable String id_attack, @PathVariable String id_user) throws SQLException {

        attackService.update2(Integer.parseInt(id_attack), Integer.parseInt(id_user));

        return "redirect:/users"; //редирект на форму с памяткой

    }

    @GetMapping("/a") //убрать в mainController
    public String getPieChart(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("2016", 147);
        graphData.put("2017", 1256);
        graphData.put("2018", 3856);
        graphData.put("2019", 19807);

        Map<String, Float> graphURL;
        graphURL = statisticService.getPercentLast5AttacksURL();

    //добавить еще два графика js
        Map<String, Float> graphForm;
        graphForm = statisticService.getPercentLast5AttacksForm();

        Map<String, Integer> graphPie;
        graphPie = statisticService.getPieChart();

        model.addAttribute("chartDataURL", graphURL);
        model.addAttribute("chartDataForm", graphForm);
        model.addAttribute("chartDataPie", graphPie);

        return "a";
    }

}
