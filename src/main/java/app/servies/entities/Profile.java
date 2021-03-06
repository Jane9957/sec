package app.servies.entities;

public class Profile {

    private int idProfile;
    private String name_first;
    private String name_middle;
    private String name_last;
    private String email;
    private String description;

    private int urlAttacks;
    private int formAttacks;
    private int totalAttacks;

    public int getIdProfile() {return idProfile;}
    public void setIdProfile(int idProfile) {this.idProfile = idProfile;}

    public String getName_first() {return name_first;}
    public void setName_first(String name_first) {this.name_first = name_first;}

    public String getName_middle() {return name_middle;}
    public void setName_middle(String name_middle) {this.name_middle = name_middle;}

    public String getName_last() {return name_last;}
    public void setName_last(String name_last) {this.name_last = name_last;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getDescription () {return description;}
    public void setDescription(String description) {this.description = description;}

    public int getUrlAttacks () {return urlAttacks;}
    public void setUrlAttacks(int urlAttacks) {this.urlAttacks = urlAttacks;}

    public int getFormAttacks () {return formAttacks;}
    public void setFormAttacks(int formAttacks) {this.formAttacks = formAttacks;}

    public int getTotalAttacks () {return totalAttacks;}
    public void setTotalAttacks(int totalAttacks) {this.totalAttacks = totalAttacks;}

}
