package app.controllers;

import app.servies.MailSevice;
import app.servies.ProfileService;
import app.servies.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService service;

    @Autowired
    private MailSevice mailSevice;

    @GetMapping("/user_profile/{id}")
    public String getProfileById(Model model, @PathVariable String id) throws MalformedURLException {

        URL url = new URL("http://localhost:8080/user_profile/" + id);
        System.out.println("путь: " + url.getPath());
        model.addAttribute("profile", service.getProfileById(id));
        return "user_profile";
    }

    @GetMapping("/users")
    public String getProfilies(Model model) {

        model.addAttribute("profilies", service.getProfiles());
        return "/users";
    }

    @GetMapping("/user_create")
    public String createUser(Model model, Profile profile) {

        model.addAttribute("profile", profile);
        return "user_create";
    }

    @PostMapping("/user_create")
    public String createUserPost(Model model, @ModelAttribute("profile") Profile profile) {

        service.createUser(profile);
        return "redirect:/users";

    }

    /*@GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {

        //boolean isActivated = ProfileService.activateProfile(code);

        return "users";
    }*/


}
