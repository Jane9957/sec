package app.servies;

import app.dataBase.DataBaseProfile;
import app.servies.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private DataBaseProfile dataBaseProfile;

    public Profile getProfileById(String id) {
        Profile profile = new Profile();
        try {
            profile = dataBaseProfile.getProfileById(Integer.valueOf(id));
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
