package app.servies;

import app.dataBase.DataBaseProfile;
import app.servies.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

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

}
