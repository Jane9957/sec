package app.servies.entities;

import java.util.Date;

public class Attack {

    private int attack_id;
    private String attackName;
    private int template_id;
    private Date date;

    private int attack_id1;
    private int user_id;
    private String success_type1;
    private String success_type2;

    public int getAttack_id1() { return attack_id1; }
    public void setAttack_id1(int attack_id1) { this.attack_id1 = attack_id1; }

    public int getAttack_id() { return attack_id; }
    public void setAttack_id(int attack_id) { this.attack_id = attack_id; }

    public String getAttackName() { return attackName; }
    public void setAttackName(String attackName) { this.attackName = attackName; }

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public int getTemplate_id() { return template_id; }
    public void setTemplate_id(int template_id) { this.template_id = template_id; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getSuccess_type1() { return success_type1; }
    public void setSuccess_type1(String success_type1) { this.success_type1 = success_type1; }

    public String getSuccess_type2() { return success_type2; }
    public void setSuccess_type2(String success_type2) { this.success_type2 = success_type2; }

}
