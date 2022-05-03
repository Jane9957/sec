package app.dataBase;

import app.servies.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataBaseProfile {

    @Autowired
    private DataSource src;

    public Profile getProfileById(Integer id) throws SQLException {
        Connection connection = src.getConnection();

        String GET_STAFF_PROFILE = "{ call getProfileById(?) }";

        CallableStatement callableStatement = connection.prepareCall(GET_STAFF_PROFILE);
        callableStatement.setInt("id", id);
        Profile profile = new Profile();

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            if(resultSet.next()) {
                profile.setName_first(resultSet.getString("name_first"));
                profile.setName_middle(resultSet.getString("name_middle"));
                profile.setName_last(resultSet.getString("name_last"));
                profile.setEmail(resultSet.getString("email"));
                profile.setDescription((resultSet.getString("description")));
                System.out.println(profile);
            }
        } catch (Exception e) {
            throw e;
        }
        connection.close();
        return profile;

    }

    public List<Profile> getProfiles() throws SQLException {
        List<Profile> list = new ArrayList<>();
        Connection connection = src.getConnection();

        String GET_STAFF_PROFILES = "{call getProfiles() }";

        CallableStatement callableStatement = connection.prepareCall(GET_STAFF_PROFILES);

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            while (resultSet.next()) {
                Profile profile = new Profile();
                profile.setIdProfile(resultSet.getInt(1));
                profile.setName_first(resultSet.getString(2));
                profile.setName_middle(resultSet.getString(3));
                profile.setName_last(resultSet.getString(4));
                profile.setEmail(resultSet.getString(5));
                profile.setDescription((resultSet.getString(6)));
                list.add(profile);
            }
        }
        callableStatement.execute();
        connection.close();

        return list;
    }

    public void createUser(Profile profile) throws SQLException {
        Connection connection = src.getConnection();

        String REGISTRATION_QUERY = "{call createUser(?, ?, ?, ?, ?) }";

        CallableStatement callableStatement = connection.prepareCall(REGISTRATION_QUERY);
        callableStatement.setString("name_first", profile.getName_first());
        callableStatement.setString("name_middle", profile.getName_middle());
        callableStatement.setString("name_last", profile.getName_last());
        callableStatement.setString("email", profile.getEmail());
        callableStatement.setString("description", profile.getDescription());

        callableStatement.execute();
        connection.close();
    }

    public Profile findByActivationCode(String code) {
        Profile profile = new Profile();
        return profile;
    }
}
