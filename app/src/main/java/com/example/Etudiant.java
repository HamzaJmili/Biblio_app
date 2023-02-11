package com.example;

public class Etudiant extends User {
    private String cne ;
    private String filiere;
    
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    public Etudiant(String cne,String nom_user, String prenom_user, String email_user, String mdp_user) {
        super(nom_user, prenom_user, email_user, mdp_user);
        this.cne=cne;
    }
    public Etudiant(String cne,String nom_user, String prenom_user, String email_user, String mdp_user,String filiere) {
        super(nom_user, prenom_user, email_user, mdp_user);
        this.cne=cne;
        this.filiere=filiere;
    }
    public String getCne() {
        return cne;
    }
    public void setCne(String cne) {
        this.cne = cne;
    }
}
