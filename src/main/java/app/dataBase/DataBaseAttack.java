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

        String GET_ATTACKS = "{call getAttacks() }"; //создать

        CallableStatement callableStatement = connection.prepareCall(GET_ATTACKS);

        try (ResultSet resultSet = callableStatement.executeQuery()) {
            while (resultSet.next()) {
                Attack attack = new Attack();
                attack.setAttack_id(resultSet.getInt(1));
                attack.setAttackName(resultSet.getString(2));
                attack.setTemplate_id(resultSet.getInt(3));
                attack.setDate(resultSet.getDate(4));
                list.add(attack);
            }
        }
        callableStatement.execute();
        connection.close();

        return list;
    }

    public void createAttack(Attack attack) throws SQLException {

        Connection connection = src.getConnection();

        String CREATE_ATTACK = "{call createAttack(?, ?, ?) }"; //создать

        CallableStatement callableStatement = connection.prepareCall(CREATE_ATTACK);

        callableStatement.setString("attack_name", attack.getAttackName());
        callableStatement.setInt("template_id", attack.getTemplate_id());
        callableStatement.setDate("date", (Date) attack.getDate());

        callableStatement.execute();
        connection.close();

    }

    //промежуточная функция получения id
    public int getLastCreateAttack() throws SQLException {

        Connection connection = src.getConnection();

        String GET_LAST_ATTACK = "{call getLastCreateAttack() }"; //создать

        CallableStatement callableStatement = connection.prepareCall(GET_LAST_ATTACK);

        int id_last_attack = 0;
        try (ResultSet resultSet = callableStatement.executeQuery()) {
            if(resultSet.next()) {
                id_last_attack = resultSet.getInt(1);
            }
        }

        return id_last_attack;
    }

    public void createAttackUsers(int id_last_attack, int id_user) throws SQLException { //переписать

        Connection connection = src.getConnection();

        String CREATE_ATTACK_USERS = "{call createAttackUsers(?, ?) }"; //создать

        CallableStatement callableStatement = connection.prepareCall(CREATE_ATTACK_USERS);
        callableStatement.setInt("attack_id", id_last_attack);
        callableStatement.setInt("user_id", id_user); //
        //callableStatement.setString("success_type1", attack.getSuccess_type1());
        //callableStatement.setString("success_type2", attack.getSuccess_type2());

        callableStatement.execute();
        connection.close();

    }

    public void update1(Attack attack) { //атака, где id_user и id_attack сделать TRUE в succes_1
    }

    public void update2(Attack attack) { //атака, где id_user и id_attack сделать TRUE в succes_2
    }
}
