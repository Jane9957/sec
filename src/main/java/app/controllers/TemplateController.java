package app.controllers;

import app.servies.TemplateService;
import app.servies.entities.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping("/templates")
    public String getTemplates(Model model) {

        model.addAttribute("templates", templateService.getTemplates());
        return "/templates";
    }

    @GetMapping("/template_create")
    public String createTemplate(Model model, Template template) {

        model.addAttribute("template", template);
        return "template_create";
    }

    @PostMapping("/template_create")
    public String createUserPost(@ModelAttribute("template") Template template) {

        templateService.createTemplate(template);
        return "redirect:/templates";

    }

}
