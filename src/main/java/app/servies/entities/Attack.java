package app.servies.entities;

public class Attack {

    private int attack_id;
    private String attackName;
    private int template_id;
    private String date;

    private int user_id;
    private String success_type1;
    private String success_type2;

    private String name_first;
    private String name_last;

    private String template_name;

    public String getTemplate_name() { return template_name; }
    public void setTemplate_name(String template_name) { this.template_name = template_name; }

    public String getName_first() { return name_first; }
    public void setName_first(String name_first) { this.name_first = name_first; }

    public String getName_last() { return name_last; }
    public void setName_last(String name_last) { this.name_last = name_last; }

    public int getAttack_id() { return attack_id; }
    public void setAttack_id(int attack_id) { this.attack_id = attack_id; }

    public String getAttackName() { return attackName; }
    public void setAttackName(String attackName) { this.attackName = attackName; }

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public int getTemplate_id() { return template_id; }
    public void setTemplate_id(int template_id) { this.template_id = template_id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getSuccess_type1() { return success_type1; }
    public void setSuccess_type1(String success_type1) { this.success_type1 = success_type1; }

    public String getSuccess_type2() { return success_type2; }
    public void setSuccess_type2(String success_type2) { this.success_type2 = success_type2; }

}
