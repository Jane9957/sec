package app.dataBase;

import app.servies.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DataBaseProfile {

    @Autowired
    private DataSource src;

    public Profile getProfileById(Integer id) throws SQLException {
        Connection connection = src.getConnection();
        //String QUERY = "{ call dbo.getUser()}";
        String GET_CLIENT_PROFILE = "{ call getProfileById(?) }";//написать функцию
        CallableStatement callableStatement = connection.prepareCall(GET_CLIENT_PROFILE);
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

    /*public void createUser(RegistrationForm form) throws SQLException {
        Connection connection = src.getConnection();

        String REGISTRATION_QUERY = "{call toRegistr(?, ?, ?, ?, ?, ?, ?, ?, ?) }";

        CallableStatement callableStatement = connection.prepareCall(REGISTRATION_QUERY);
        callableStatement.setString("login", form.getLogin());
        callableStatement.setString("password", form.getPassword());
        callableStatement.setString("email", form.getEmail());
        //callableStatement.setLong(9, Long.valueOf(form.getPhone()));
        callableStatement.setString("phone", form.getPhone());
        callableStatement.setString("FirstName", form.getName_first());
        callableStatement.setString("MiddleName", form.getName_middle());
        callableStatement.setString("LastName", form.getName_last());
        callableStatement.setString("birthday", form.getBirthday());
        callableStatement.setInt("Company", form.getCompany());

        callableStatement.execute();
        connection.close();
    }*/

}
