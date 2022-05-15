package app.dataBase;

import app.servies.entities.Attack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataBaseAttack {

    @Autowired
    private DataSource src;

    public List<Attack> getAttacks() throws SQLException {
        List<Attack> list = new ArrayList<>();
        Connection connection = src.getConnection();

        String GET_ATTACKS = "{ call getAttacks() }";

        CallableStatement callableStatement = connection.prepareCall(GET_ATTACKS);

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            while (resultSet.next()) {
                Attack attack = new Attack();
                attack.setAttack_id(resultSet.getInt(1));
                attack.setAttackName(resultSet.getString(2));
                attack.setTemplate_id(resultSet.getInt(3));
                attack.setDate(resultSet.getString(4));
                list.add(attack);
            }
        }
        callableStatement.execute();
        connection.close();

        return list;
    }

    public void createAttack(Attack attack) throws SQLException {

        Connection connection = src.getConnection();

        String CREATE_ATTACK = "{ call createAttack(?, ?) }";

        CallableStatement callableStatement = connection.prepareCall(CREATE_ATTACK);

        callableStatement.setString("attack_name", attack.getAttackName());
        callableStatement.setInt("template_id", attack.getTemplate_id());

        callableStatement.execute();
        connection.close();

    }

    public int getLastCreateAttack() throws SQLException {

        Connection connection = src.getConnection();

        String GET_LAST_ATTACK = "{ call getLastCreateAttack() }";

        CallableStatement callableStatement = connection.prepareCall(GET_LAST_ATTACK);

        int id_last_attack = 0;
        try (ResultSet resultSet = callableStatement.executeQuery()) {
            if(resultSet.next()) {
                id_last_attack = resultSet.getInt(1);
            }
        }

        return id_last_attack;
    }

    public void createAttackUsers(int id_last_attack, int id_user) throws SQLException {

        Connection connection = src.getConnection();

        String CREATE_ATTACK_USERS = "{ call createAttackUsers(?, ?) }";

        CallableStatement callableStatement = connection.prepareCall(CREATE_ATTACK_USERS);

        callableStatement.setInt("attack_id", id_last_attack);
        callableStatement.setInt("user_id", id_user);

        callableStatement.execute();
        connection.close();

    }

    public void update1(int id_attack, int id_user) throws SQLException {

        Connection connection = src.getConnection();

        String UPDATE_ATTACK_USERS_1 = "{ call updateAttackUsers1(?, ?) }";

        CallableStatement callableStatement = connection.prepareCall(UPDATE_ATTACK_USERS_1);

        callableStatement.setInt("attack_id", id_attack);
        callableStatement.setInt("user_id", id_user);

        callableStatement.execute();
        connection.close();

    }

    public void update2(int id_attack, int id_user) throws SQLException {

        Connection connection = src.getConnection();

        String UPDATE_ATTACK_USERS_2 = "{ call updateAttackUsers2(?, ?) }";

        CallableStatement callableStatement = connection.prepareCall(UPDATE_ATTACK_USERS_2);

        callableStatement.setInt("attack_id", id_attack);
        callableStatement.setInt("user_id", id_user);

        callableStatement.execute();
        connection.close();

    }

    public Attack getAttackById(Integer id) throws SQLException {

        Connection connection = src.getConnection();

        String GET_ATTACK = "{ call getAttackById(?) }";

        CallableStatement callableStatement = connection.prepareCall(GET_ATTACK);
        callableStatement.setInt("attack_id", id);

        Attack attack = new Attack();

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            if(resultSet.next()) {
                attack.setAttack_id(resultSet.getInt(1));
                attack.setAttackName(resultSet.getString(2));
                //attack.setTemplate_id(resultSet.getInt(3));
                attack.setTemplate_name(resultSet.getString(3));
                attack.setDate(resultSet.getString(4));
                //добавить имя шаблона + имя пользователя
            }
        } catch (Exception e) {
            throw e;
        }

        connection.close();
        return attack;
    }

    public List<Attack> getAttacksUsersById(Integer id) throws SQLException {
        List<Attack> list = new ArrayList<>();
        Connection connection = src.getConnection();

        String GET_ATTACK = "{call getAttacksUsersById(?) }";

        CallableStatement callableStatement = connection.prepareCall(GET_ATTACK);
        callableStatement.setInt("attack_id", id);

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            while (resultSet.next()) {
                Attack attack = new Attack();
                attack.setUser_id(resultSet.getInt(2));
                attack.setSuccess_type1(resultSet.getString(3));
                attack.setSuccess_type2(resultSet.getString(4));
                attack.setName_first(resultSet.getString(5));
                attack.setName_last(resultSet.getString(6));
                list.add(attack);
            }
        }
        callableStatement.execute();
        connection.close();

        return list;
    }
}
