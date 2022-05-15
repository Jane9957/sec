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

@Controller
public class HoneyController {

    @Autowired
    private AttackService attackService;

    //@GetMapping("/honey/{id_attack}/{id_user}")
    @GetMapping("/template{id_template}/{id_attack}/{id_user}")
    public String honey(Model model, @PathVariable String id_attack, @PathVariable String id_user, @PathVariable String id_template) throws SQLException {

        model.addAttribute("id_template", id_template);
        model.addAttribute("id_attack", id_attack);
        model.addAttribute("id_user", id_user);

        attackService.update1(Integer.parseInt(id_attack), Integer.parseInt(id_user));

        return "template" + id_template;
    }

    @PostMapping("/template{id_template}/{id_attack}/{id_user}")
    public String honeyPost(@PathVariable String id_attack, @PathVariable String id_user, @PathVariable String id_template) throws SQLException {

        attackService.update2(Integer.parseInt(id_attack), Integer.parseInt(id_user));

        return "redirect:/users"; // сделать редирект на форму с памяткой

    }

}
