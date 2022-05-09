package app.servies;

import app.dataBase.DataBaseAttack;
import app.dataBase.DataBaseProfile;
import app.servies.entities.Attack;
import app.servies.entities.Profile;
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

    public void createAttack(Attack attack, List<String> ids) throws SQLException, MessagingException {

        //dataBaseAttack.createAttack(attack);
        //int id_last_attack = dataBaseAttack.getLastCreateAttack();

        for (int i = 0; i < ids.size(); i++) {
            int id_profile = Integer.parseInt(ids.get(i));
            //dataBaseAttack.createAttackUsers(id_last_attack, id_profile);

            ////ссылка id_last_attack + id_profile

            // email = getEmailByIdUser
            String email = "forgot_passs00@mail.ru";
            String subject = "Hello";

            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("id_profile", id_profile);
            //templateModel.put("id_template", attack.getTemplate_id());
            templateModel.put("id_template", id_profile);
            // добавить имя пользователя

            mailSevice.sendMessageUsingThymeleafTemplate(email, subject, templateModel);

        }
    }

    public void update1(Attack attack) {
        dataBaseAttack.update1(attack);

    }

    public void update2(Attack attack) {
        dataBaseAttack.update2(attack);
    }
}
