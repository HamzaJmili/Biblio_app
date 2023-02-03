package com.example;

public class Etudiant extends User {
    private String cne ;
    
    public Etudiant(String cne,String nom_user, String prenom_user, String email_user, String mdp_user) {
        super(nom_user, prenom_user, email_user, mdp_user);
        this.cne=cne;
    }
    public String getCne() {
        return cne;
    }
    public void setCne(String cne) {
        this.cne = cne;
    }
}
