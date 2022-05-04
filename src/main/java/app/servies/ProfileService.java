package app.servies;

import app.dataBase.DataBaseProfile;
import app.servies.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private DataBaseProfile dataBaseProfile;

    @Autowired
    private MailSevice mailSevice;

    /*public boolean activateProfile(String code) {

        Profile profile = dataBaseProfile.findByActivationCode(code);

        if (profile == null) {
            return false;
        }

        //profile.setActivationCode(null);


        return true;
    }*/

    public Profile getProfileById(String id) {
        Profile profile = new Profile();
        try {
            profile = dataBaseProfile.getProfileById(Integer.valueOf(id));

            /*profile.setActivationCode(UUID.randomUUID().toString());
            String message = String.format(
            "Hello, %s \n" +
                    "Visit next link: http://localhost:8080/activate/%s",
                    profile.getName_first(),
                    profile.getActivationCode()
            );
            mailSender.send(profile.getEmail(), "Activation Code", message);*/
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return profile;
    }

    public List<Profile> getProfiles() {
        List<Profile> profiles = new ArrayList<>();
        try {
            profiles = dataBaseProfile.getProfiles();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return profiles;
    }

    public void createUser(Profile profile) {
        try {
            dataBaseProfile.createUser(profile);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
