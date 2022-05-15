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
import java.util.List;

@Service
public class DataBaseProfile {

    @Autowired
    private DataSource src;

    public Profile getProfileById(Integer id) throws SQLException {
        Connection connection = src.getConnection();

        String GET_STAFF_PROFILE = "{ call getProfileById(?) }";

        String GET_URL_ATTAKS_STAFF_PROFILE = "{ call getUrlByIdProfile(?) }";
        String GET_FORM_ATTAKS_STAFF_PROFILE = "{ call getFormByIdProfile(?) }";
        String GET_TOTAL_ATTAKS_STAFF_PROFILE = "{ call getTotalByIdProfile(?) }"; // лучше все переписать по отдкльным функциям, но потом (:

        CallableStatement callableStatement = connection.prepareCall(GET_STAFF_PROFILE);
        CallableStatement callableStatement1 = connection.prepareCall(GET_URL_ATTAKS_STAFF_PROFILE);
        CallableStatement callableStatement2 = connection.prepareCall(GET_FORM_ATTAKS_STAFF_PROFILE);
        CallableStatement callableStatement3 = connection.prepareCall(GET_TOTAL_ATTAKS_STAFF_PROFILE);

        callableStatement.setInt("id", id);
        callableStatement1.setInt("id", id);
        callableStatement2.setInt("id", id);
        callableStatement3.setInt("id", id);

        Profile profile = new Profile();

        try (ResultSet resultSet1 = callableStatement1.executeQuery()) {
            if(resultSet1.next()) {
                profile.setUrlAttacks(resultSet1.getInt(1));
            }
        }

        try (ResultSet resultSet2 = callableStatement2.executeQuery()) {
            if(resultSet2.next()) {
                profile.setFormAttacks(resultSet2.getInt(1));
            }
        }

        try (ResultSet resultSet3 = callableStatement3.executeQuery()) {
            if(resultSet3.next()) {
                profile.setTotalAttacks(resultSet3.getInt(1));
            }
        }

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            if(resultSet.next()) {
                profile.setIdProfile(resultSet.getInt(1));
                profile.setName_first(resultSet.getString(2));
                profile.setName_middle(resultSet.getString(3));
                profile.setName_last(resultSet.getString(4));
                profile.setEmail(resultSet.getString(5));
                profile.setDescription(resultSet.getString(6));
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

        String GET_STAFF_PROFILES = "{call getProfiles() }"; //добавить вывод доп полей для пользователей

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

}
