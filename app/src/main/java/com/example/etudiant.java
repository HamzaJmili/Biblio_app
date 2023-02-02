package com.example;

public class etudiant {
    private String cne ;
    private String nom_etudiant ;
    private String prenom_etudiant ;
    private String email_etudiant ;
    private String mdp_etudiant ;

    public etudiant(String cne, String nom_etudiant, String prenom_etudiant, String email_etudiant,String mdp_etudiant) {
        this.cne = cne;
        this.nom_etudiant = nom_etudiant;
        this.prenom_etudiant = prenom_etudiant;
        this.email_etudiant = email_etudiant;
        this.mdp_etudiant = mdp_etudiant;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }
    
    public String getPrenom_etudiant() {
        return prenom_etudiant;
    }

    public void setPrenom_etudiant(String prenom_etudiant) {
        this.prenom_etudiant = prenom_etudiant;
    }

    public String getEmail_etudiant() {
        return email_etudiant;
    }

    public void setEmail_etudiant(String email_etudiant) {
        this.email_etudiant = email_etudiant;
    }

    public String getMdp_etudiant() {
        return mdp_etudiant;
    }

    public void setMdp_etudiant(String mdp_etudiant) {
        this.mdp_etudiant = mdp_etudiant;
    }
    


}
