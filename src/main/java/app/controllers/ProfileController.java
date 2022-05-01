package app.controllers;

import app.servies.ProfileService;
import app.servies.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService service;

    @GetMapping("/user_profile/{id}")
    public String getClientById(Model model, @PathVariable String id) {
        /*String role = "ROLE_FACTORY";
        for(GrantedAuthority grantedAuthority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
            role = grantedAuthority.getAuthority();
        }*/
        Profile profile = service.getProfileById(id);
        model.addAttribute("profile", profile);
        //model.addAttribute("role", role);
        //model.addAttribute("owner", false);
        return "user_profile";
    }

}
