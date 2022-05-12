package app.servies.entities;

public class Statistic {

    private int AttackTotal;
    private int AttackedUsersTotal;
    private int AttackedUsersURL;
    private int AttackedUsersForm;

    public int getAttackTotal() { return AttackTotal; }
    public void setAttackTotal(int attackTotal) { AttackTotal = attackTotal; }

    public int getAttackedUsersTotal() { return AttackedUsersTotal; }
    public void setAttackedUsersTotal(int attackedUsersTotal) { AttackedUsersTotal = attackedUsersTotal; }

    public int getAttackedUsersURL() { return AttackedUsersURL; }
    public void setAttackedUsersURL(int attackedUsersURL) { AttackedUsersURL = attackedUsersURL; }

    public int getAttackedUsersForm() { return AttackedUsersForm; }
    public void setAttackedUsersForm(int attackedUsersForm) { AttackedUsersForm = attackedUsersForm; }
}
