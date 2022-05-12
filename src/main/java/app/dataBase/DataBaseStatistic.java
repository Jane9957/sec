package app.dataBase;

import app.servies.entities.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DataBaseStatistic {

    @Autowired
    private DataSource src;

    public int getAttackTotal() throws SQLException {

        Connection connection = src.getConnection();
        String GET_ATTACK_TOTAL = "{ call getAttackTotal() }";
        CallableStatement callableStatement = connection.prepareCall(GET_ATTACK_TOTAL);

        Statistic statistic = new Statistic();

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            if(resultSet.next()) {
                statistic.setAttackTotal(resultSet.getInt(1));
            }
        }

        return statistic.getAttackTotal();
    }

    public int getAttackedUserTotal() throws SQLException {

        Connection connection = src.getConnection();
        String GET_ATTACKED_USER_TOTAL = "{ call getAttackedUserTotal() }";
        CallableStatement callableStatement = connection.prepareCall(GET_ATTACKED_USER_TOTAL);

        Statistic statistic = new Statistic();

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            if(resultSet.next()) {
                statistic.setAttackedUsersTotal(resultSet.getInt(1));
            }
        }

        return statistic.getAttackedUsersTotal();
    }

    public int getAttackedUserURL() throws SQLException {

        Connection connection = src.getConnection();
        String GET_ATTACKED_USER_URL = "{ call getAttackedUserURL() }";
        CallableStatement callableStatement = connection.prepareCall(GET_ATTACKED_USER_URL);

        Statistic statistic = new Statistic();

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            if(resultSet.next()) {
                statistic.setAttackedUsersURL(resultSet.getInt(1));
            }
        }

        return statistic.getAttackedUsersURL();
    }

    public int getAttackedUserForm() throws SQLException {

        Connection connection = src.getConnection();
        String GET_ATTACKED_USER_FORM = "{ call getAttackedUserForm() }";
        CallableStatement callableStatement = connection.prepareCall(GET_ATTACKED_USER_FORM);

        Statistic statistic = new Statistic();

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            if(resultSet.next()) {
                statistic.setAttackedUsersForm(resultSet.getInt(1));
            }
        }

        return statistic.getAttackedUsersForm();
    }

//количество users(TRUE)/users_total, date по id_attack

}
