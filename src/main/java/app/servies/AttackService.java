package app.servies;

import app.dataBase.DataBaseAttack;
import app.dataBase.DataBaseProfile;
import app.dataBase.DataBaseTemplate;
import app.servies.entities.Attack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.*;

@Service
public class AttackService {

    @Autowired
    private DataBaseAttack dataBaseAttack;

    @Autowired
    private DataBaseProfile dataBaseProfile;

    @Autowired
    private DataBaseTemplate dataBaseTemplate;

    @Autowired
    private MailSevice mailSevice;

    public List<Attack> getAttacks() {
        List<Attack> attacks = new ArrayList<>();
        try {
            attacks = dataBaseAttack.getAttacks();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return attacks;
    }

    public void createAttack(Attack attack, List<String> ids, int rd) throws SQLException, MessagingException {

        attack.setTemplate_id(rd);
        dataBaseAttack.createAttack(attack);
        int id_last_attack = dataBaseAttack.getLastCreateAttack();

        for (int i = 0; i < ids.size(); i++) {
            Integer id_profile = Integer.parseInt(ids.get(i));

            dataBaseAttack.createAttackUsers(id_last_attack, id_profile);

            String email = dataBaseProfile.getProfileById(id_profile).getEmail();
            //String email = "forgot_passs00@mail.ru";

            String subject = dataBaseTemplate.getTemplateById(attack.getTemplate_id()).getSubject();
            //String subject = "Hello";

            String templateMail = "templateMail" + rd + ".html";

            //ссылка http://localhost:8080/template(rd)/(id_last_attack)/(id_profile)
            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("h", "http://localhost:8080/template");
            templateModel.put("id_template", rd);
            templateModel.put("id_last_attack", id_last_attack);
            templateModel.put("hh", "/");
            templateModel.put("id_profile", id_profile);
            //добавить имя пользователя

            // убрать коммент для полного функционала
            //mailSevice.sendMessageUsingThymeleafTemplate(email, subject, templateModel, templateMail);
        }
    }

    public void update1(int id_attack, int id_user) throws SQLException {
        dataBaseAttack.update1(id_attack, id_user);
    }

    public void update2(int id_attack, int id_user) throws SQLException {
        dataBaseAttack.update2(id_attack, id_user);
    }

    public Attack getAttackById(String id) {
        Attack attack = new Attack();
        try {
            attack = dataBaseAttack.getAttackById(Integer.valueOf(id));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return attack;
    }

    public List<Attack> getAttacksUsersById(String id) {
        List<Attack> attacks = new ArrayList<>();
        try {
            attacks = dataBaseAttack.getAttacksUsersById(Integer.valueOf(id));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return attacks;
    }
}
