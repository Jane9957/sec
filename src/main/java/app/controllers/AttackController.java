package app.controllers;

import app.servies.AttackService;
import app.servies.ProfileService;
import app.servies.TemplateService;
import app.servies.entities.Attack;
import app.servies.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class AttackController {

    @Autowired
    private AttackService attackService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private TemplateService templateService;


    @GetMapping("/attacks")
    public String getAttacks(Model model) {

        model.addAttribute("attacks", attackService.getAttacks());
        return "attacks";
    }

    @GetMapping("/attack_profile/{id}")
    public String getAttackById(Model model, @PathVariable String id) {

        model.addAttribute("attack", attackService.getAttackById(id)); //одна атака
        model.addAttribute("attacks", attackService.getAttacksUsersById(id)); //много пользователей
        model.addAttribute("id_attack", id);
        return "attack_profile";
    }

    @GetMapping("/attack_create")
    public String createAttack(Model model, Attack attack) {

        List<Profile> profiles;
        profiles = profileService.getProfiles();
        model.addAttribute("profilies", profiles);

        //model.addAttribute("profilies", profileService.getProfiles());

        model.addAttribute("templates", templateService.getTemplates());
        model.addAttribute("attack", attack);
        return "attack_create";
    }

    @PostMapping("/attack_create")
    public String createAttackPost(@ModelAttribute("attack") Attack attack,
                                   @RequestParam(value = "ids") List<String> ids,
                                   @RequestParam(value = "rd") int rd)
            throws SQLException, MessagingException {

        attackService.createAttack(attack, ids, rd);

        return "redirect:/attack_create";
    }

}
