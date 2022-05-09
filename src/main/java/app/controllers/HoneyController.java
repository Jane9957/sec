package app.controllers;

import app.servies.AttackService;
import app.servies.entities.Attack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HoneyController {

    @Autowired
    private AttackService attackService;

    @GetMapping("/honey/{id}")
    public String honey(Model model, @PathVariable String id, Attack attack) {

        model.addAttribute("id_honey", id);

        attackService.update1(attack); //атака, где id_user и id_attack сделать TRUE в succes_1

        return "honey";
    }

    @PostMapping("/honey/{id}")
    public String honeyPost(@PathVariable String id, Attack attack) {

        System.out.println(id);
        attackService.update2(attack); //атака, где id_user и id_attack сделать TRUE в succes_2

        //URL url = new URL("http://localhost:8080/honey/" + id);
        //System.out.println("путь: " + url.getPath());

        return "redirect:/users"; //редирект на форму с памяткой

    }

}
