package app.controllers;

import app.dataBase.DataBaseTemplate;
import app.servies.entities.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class TemplateController {

    @Autowired
    private DataBaseTemplate dataBaseTemplate;

    @GetMapping("/templates")
    public String getTemplates(Model model) throws SQLException {

        model.addAttribute("templates", dataBaseTemplate.getTemplates());
        return "/templates";
    }

    @GetMapping("/template_create")
    public String createTemplate(Model model, Template template) {

        model.addAttribute("template", template);
        return "template_create";
    }

    @PostMapping("/template_create")
    public String createUserPost(Model model, @ModelAttribute("template") Template template) throws SQLException {

        dataBaseTemplate.createTemplate(template);
        return "redirect:/templates";

    }

}
